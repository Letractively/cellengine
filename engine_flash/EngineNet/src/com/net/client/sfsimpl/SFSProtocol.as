package com.net.client.sfsimpl
{
	import com.cell.net.io.MutualMessage;
	import com.net.client.Protocol;

	public class SFSProtocol implements Protocol
	{
		
		protected var		protocol 			: int ;
//		protected var  		session_id 			: Number;
		protected var		packet_number 		: int;
		protected var 		channel_id 			: int;
//		protected var 		channel_session_id 	: Number;
		protected var 		sent_time 			: Date;
		protected var 		received_time 		: Date;
		protected var 		message 			: MutualMessage;
		
		
		public function SFSProtocol()
		{
		}
		
		function setProtocol(protocol : int) : void {
			this.protocol = protocol;
		}
//		function setSessionID(s1 : int) : void {
//			this.session_id = s1;
//		}
		function setPacketNumber(packet_number : int) : void {
			this.packet_number = packet_number;
		}
		function setChannelID(channel_id : int) : void {
			this.channel_id = channel_id;
		}
//		function setChannelSessionID(s1 : int) : void {
//			this.channel_session_id = s1;
//		}
		function setSentTime(sent_time : Date) : void {
			this.sent_time = sent_time;
		}
		function setReceivedTime(received_time : Date) : void {
			this.received_time = received_time;
		}
		function setMessage(message : MutualMessage) : void {
			this.message = message;
		}
		
		/**消息类型*/
		public function		getProtocol() : int {
			return this.protocol;
		}
		
//		/**该链接对于服务器的唯一ID*/
//		public function  		getSessionID() : Number {
//			return this.session_id;
//		}
		
		/**匹配Request和Response的值，如果为0，则代表为Notify*/
		public function		getPacketNumber() : int {
			return this.packet_number;
		}
		
		/**频道ID<br>
		 * 仅PROTOCOL_CHANNEL_*类型的消息有效*/
		public function 		getChannelID() : int {
			return this.channel_id;
		}
		
//		/**频道发送者的SessionID<br>
//		 * 仅PROTOCOL_CHANNEL_*类型的消息有效*/
//		public function 		getChannelSessionID() : Number{
//			return this.channel_session_id;
//		}
		
		/**发送时间*/
		public function 		getSentTime(): Date {
			return this.sent_time;
		}
		
		/**接收时间*/
		public function 		getReceivedTime():Date {
			return this.received_time;
		}
		
		/**包含的消息*/
		public function 		getMessage() : MutualMessage {
			return this.message;
		}
	}
}