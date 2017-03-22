package com.otms.exercise.exception;

public class APPServerException extends RuntimeException {


	private static final long serialVersionUID = 1L;

	public APPServerException(String msg){
		super(msg);
	}
	
	public APPServerException(String eCode,String msg){
		super(getMsg(eCode,msg));
	}
	
	private static String getMsg(String code,String msg){
		return code+"@"+msg;
	}
	
}
