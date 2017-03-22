package com.otms.exercise.common;

public enum ShipmentStatus {
	
	created("created",1),
	released("released",2),
	dispatched("dispatched",3),
	pickup("pickup",4),
	delivered("delivered",5),
	closed("closed",6);
	
	private String name;
	private int num;

	private ShipmentStatus(String str,int num){
		this.name=str;
		this.num=num;
	}
	
	public static String getName(int num){
		for(ShipmentStatus ss:ShipmentStatus.values()){
			if(ss.getNum() == num){
				return ss.name;
			}
		}
		return null;
	}
	
	public static int getNum(String name){
		for(ShipmentStatus ss:ShipmentStatus.values()){
			if(ss.getName() == name){
				return ss.num;
			}
		}
		return 0;
	}
	
	
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
