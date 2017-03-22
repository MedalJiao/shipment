package com.otms.exercise.common;

import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.mortbay.util.ajax.JSON;

@XmlRootElement
public class ResponseXML {
	
	@XmlElement
	private boolean success;
	@XmlElement
	private String message;
	@XmlElement
	private Object data;
	
	public ResponseXML() {}
	
	
	public ResponseXML(boolean success, String message, Object data) {
		super();
		this.success = success;
		this.message = message;
		this.data = data;
	}

	public boolean getSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public String toJsonString() {
        Map<String, Object> tmp = new HashMap<String, Object>();
        tmp.put("isSuccess", this.getSuccess());
        tmp.put("message", this.getMessage());
        tmp.put("affected shipNum", this.getData());
        return JSON.toString(tmp);
    }
}
