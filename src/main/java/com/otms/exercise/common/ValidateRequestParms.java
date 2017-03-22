package com.otms.exercise.common;

import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.otms.exercise.exception.APPServerException;

public class ValidateRequestParms {
	
	public static void validate(Map<String,Object> parm) throws APPServerException{
		for(Map.Entry<String, Object> entry:parm.entrySet()){
			if(StringUtils.isEmpty(entry.getValue().toString())){
				throw new APPServerException(entry.getKey()+" is Required");
			}
		}
	}
}
