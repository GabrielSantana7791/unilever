package com.unilever.request.etc;

public class Message {
	private String msg, type;
	
	public Message() {
		
	}
	
	public Message(String type, String msg) {
		this.type = type;
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	

}
