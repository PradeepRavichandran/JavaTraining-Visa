package com.visa.prj.entity;

import java.util.Date;

public class Message {

	private String sentdate;
	private String msgtext;
	private String sendername;
	private String receivername;
	public Message(String sendername, String receivername, String date, String msgtext) {
		super();
		this.sentdate = date;
		this.msgtext = msgtext;
		this.sendername = sendername;
		this.receivername = receivername;
	}
	public String getSentdate() {
		return sentdate;
	}
	public void setSentdate(String sentdate) {
		this.sentdate = sentdate;
	}
	public String getMsgtext() {
		return msgtext;
	}
	public void setMsgtext(String msgtext) {
		this.msgtext = msgtext;
	}
	public String getSendername() {
		return sendername;
	}
	public void setSendername(String sendername) {
		this.sendername = sendername;
	}
	public String getReceivername() {
		return receivername;
	}
	public void setReceivername(String receivername) {
		this.receivername = receivername;
	}
	
	
}
