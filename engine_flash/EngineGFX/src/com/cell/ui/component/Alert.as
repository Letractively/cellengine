package com.cell.ui.component
{
	import com.cell.gfx.CellSprite;
	import com.cell.ui.Anchor;
	import com.cell.ui.DialogGround;
	import com.cell.ui.ImageButton;
	import com.cell.ui.layout.UILayoutManager;
	import com.cell.ui.layout.UIRect;
	import com.cell.util.Util;
	
	import flash.display.DisplayObject;
	import flash.display.Sprite;
	import flash.events.Event;
	import flash.events.MouseEvent;
	import flash.text.TextField;
	import flash.text.TextFieldAutoSize;
	import flash.text.TextFieldType;
	import flash.text.TextFormat;

	public class Alert extends UIComponent
	{
		private var _borderSize	: int = 8;
		
		private var _cancel 	: DisplayObject;
		private var _ok 		: DisplayObject;
		
		private var _title 		: TextField;
		private var _text 		: TextField;
		
		public var closeOnOK : Boolean = true;
		
		public function Alert(
			htmlText:String,
			htmlTitle:String,
			text:String,
			title:String,
			hasCancel:Boolean=true,
			hasOK:Boolean=false,
			borderSize:int=8)
		{
			super(UILayoutManager.getInstance().createUI("com.cell.ui.component.Alert", this));
			
			this._borderSize   = UILayoutManager.getInstance().getProperty("com.cell.ui.component.Alert.borderSize", this);
			this.mouseChildren = true;
			this.mouseEnabled  = true;
			
			if (htmlTitle != null || title != null) {
				_title = new TextField();
				_title.mouseEnabled = false;
				_title.type = TextFieldType.DYNAMIC;
				_title.multiline = false;
				_title.autoSize = TextFieldAutoSize.CENTER;
				setText(_title, htmlTitle, title);
				addChild(_title);
			}
			
			_text = new TextField();
			_text.mouseEnabled = false;
			_text.type = TextFieldType.DYNAMIC;
			_text.multiline = true;
			setText(_text, htmlText, text);
			addChild(_text);
			
			if (hasOK) {
				_ok = UILayoutManager.getInstance().createButton("com.cell.ui.component.Alert.ok", this);
				_ok.addEventListener(MouseEvent.CLICK, onMouseClick);
				this.addChild(_ok);
			}
			if (hasCancel) {
				_cancel= UILayoutManager.getInstance().createButton("com.cell.ui.component.Alert.cancel", this);
				_cancel.addEventListener(MouseEvent.CLICK, onMouseClick);
				this.addChild(_cancel);
			}
			
			resize(300, 200, true);
		}
		
		private function setText(tf:TextField, html:String, text:String) : void
		{
			if (html) {
				tf.htmlText = html;
			} else {
				tf.text 	= text;
				tf.setTextFormat(UILayoutManager.getInstance().createTextFormat("com.cell.ui.component.Alert.text", this));
			}
		}
		
		override protected function resize(w:int, h:int, flush:Boolean) : Boolean
		{
			if (super.resize(w, h, flush))
			{
				var btnx : int = w  - _borderSize;
				var btny : int = h  - _borderSize;
				var btnh : int = 0;
				if (_ok != null) {
					_ok.x = btnx - _ok.width;
					_ok.y = btny - _ok.height;
					btnx -= (_ok.width + _borderSize);
					btnh = _ok.height;
				}
				if (_cancel != null) {
					_cancel.x = btnx - _cancel.width;
					_cancel.y = btny - _cancel.height;
					btnx -= (_cancel.width + _borderSize);
					btnh = _cancel.height;
				}
				
				var thh : int = 0;
				if (_title != null) {
					_title.x 		= _borderSize;
					_title.y 		= _borderSize;
					_title.width	= bg.width - _borderSize - _borderSize;
					thh = _title.height;
				}
				this._text.x 		= _borderSize;
				this._text.y 		= _borderSize + thh + _borderSize;
				this._text.width  	= bg.width - _borderSize - _borderSize;
				this._text.height 	= h - btnh - thh - _borderSize * 4;
				return true;
			}
			return false;
		}
		
		public function get btnOK() : DisplayObject
		{
			return _ok;
		}
		
		public function get btnCancel() : DisplayObject
		{
			return _cancel;
		}
		
		
		
		private function onMouseClick(e:MouseEvent) : void
		{
			if (e.currentTarget == _ok && closeOnOK) {
				parent.removeChild(this);
			} 
			else if (e.currentTarget == _cancel) {
				parent.removeChild(this);
			}
		}
		
		override protected function update(e:Event):void
		{
			
		}
		
		public static function showAlertText(text:String, 
											 title:String = null,
											 hasCancel:Boolean=true,
											 hasOK:Boolean=false) : Alert
		{
			var alert : Alert = new Alert(null, null, text, title, hasCancel, hasOK);
			
			alert.x = UILayoutManager.getInstance().ScreenWidth/2  - alert.bg.width/2;
			alert.y = UILayoutManager.getInstance().ScreenHeight/2 - alert.bg.height/2;
			
			DialogGround.showAsDialog(
				alert, 
				UILayoutManager.getInstance().getRoot());
			return alert;
		}
		
		public static function showAlertHtml(htmlText:String, 
										 htmlTitle:String = null,
										 hasCancel:Boolean=true,
										 hasOK:Boolean=false) : Alert
		{
			var alert : Alert = new Alert(htmlText, htmlTitle, null, null, hasCancel, hasOK);
			
			alert.x = UILayoutManager.getInstance().ScreenWidth/2  - alert.bg.width/2;
			alert.y = UILayoutManager.getInstance().ScreenHeight/2 - alert.bg.height/2;
			
			DialogGround.showAsDialog(
				alert, 
				UILayoutManager.getInstance().getRoot());
			return alert;
		}
		
	}
}