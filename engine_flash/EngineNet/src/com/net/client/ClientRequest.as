package com.net.client
{
	import com.cell.util.Reference;
	
	internal class ClientRequest extends Reference
	{
		private var request 		: Message;
		private var package_num		: int;
		private var drop_timeout	: int;
		
		private var fresponse 		: Array;
		private var ftimeout 		: Array;
		
		private var sent_time		: Number;
		private var ping			: int;
		
		function ClientRequest(
			message 		: Message, 
			package_num		: int,
			drop_timeout 	: int, 
			response 		: Array,
			timeout 		: Array
		){
			this.request 		= message;
			this.package_num 	= package_num;
			this.drop_timeout	= drop_timeout;
			
			this.fresponse 		= response;
			this.ftimeout 		= timeout;
		}
		
		internal function getPacketNumber() : int
		{
			return this.package_num;
		}
		
		internal function send(client : Client) : void
		{
			this.sent_time = new Date().valueOf();
			client.getSession().sendRequest(package_num, this.request);
		}
		
		internal function isDrop() : Boolean {
			return (new Date().valueOf() - this.sent_time) > drop_timeout;
		}
		
		internal function onResponse(client:Client, protocol : Protocol) : void
		{
			this.ping = new Date().valueOf() - sent_time;
			this.set(protocol.getMessage());
			var event : ClientEvent = new ClientEvent(ClientEvent.MESSAGE_RESPONSE, client, 
				protocol.getChannelID(), this.request, protocol.getMessage(), null);
			for each (var response : Function in this.fresponse) {
				response.call(response, event);
			}
		}
		
		internal function onTimeout(client:Client) : void
		{
			var event : ClientEvent = new ClientEvent(ClientEvent.REQUEST_TIMEOUT, client, 
				0, this.request, null, null);
			for each (var timeout : Function in this.ftimeout) {
				timeout.call(timeout, event);
			}
		}
	}
}