package com.jbk.exception;

public class CustomExceptionResponse {
	
	private String path;
	private String timeStamp;
	private String msg;
	
	public CustomExceptionResponse() {
		
	}

	public CustomExceptionResponse(String path, String timeStamp, String msg) {
		super();
		this.path = path;
		this.timeStamp = timeStamp;
		this.msg = msg;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	

}
