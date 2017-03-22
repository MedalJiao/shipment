package com.otms.exercise.dto;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "shipment")
public class ShipmentDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private int shipNum;
	private String extNum;
//	private Timestamp createTime;
	private Date createTime;
	private String pickupLoc;
	private Date pickupTime;
	private Date pickupSla;
	private String delLoc;
	private Date delTime;
	private Date delSla;
	/**
	 * 1:Created 2:Released 3:Dispatched 4:Pickup 5:Delivered 6:Closed
	 */
	private int status;
	
	public ShipmentDto() {}

	public ShipmentDto(int shipNum, String extNum, Timestamp createTime, String pickupLoc, Date pickupTime, Date pickupSla,
			String delLoc, Date delTime, Date delSla, int status) {
		super();
		this.shipNum = shipNum;
		this.extNum = extNum;
		this.createTime = createTime;
		this.pickupLoc = pickupLoc;
		this.pickupTime = pickupTime;
		this.pickupSla = pickupSla;
		this.delLoc = delLoc;
		this.delTime = delTime;
		this.delSla = delSla;
		this.status = status;
	}

	public int getShipNum() {
		return shipNum;
	}

	public void setShipNum(int shipNum) {
		this.shipNum = shipNum;
	}

	public String getExtNum() {
		return extNum;
	}

	public void setExtNum(String extNum) {
		this.extNum = extNum;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getPickupLoc() {
		return pickupLoc;
	}

	public void setPickupLoc(String pickupLoc) {
		this.pickupLoc = pickupLoc;
	}

	public Date getPickupTime() {
		return pickupTime;
	}

	public void setPickupTime(Date pickupTime) {
		this.pickupTime = pickupTime;
	}

	public Date getPickupSla() {
		return pickupSla;
	}

	public void setPickupSla(Date pickupSla) {
		this.pickupSla = pickupSla;
	}

	public String getDelLoc() {
		return delLoc;
	}

	public void setDelLoc(String delLoc) {
		this.delLoc = delLoc;
	}

	public Date getDelTime() {
		return delTime;
	}

	public void setDelTime(Date delTime) {
		this.delTime = delTime;
	}

	public Date getDelSla() {
		return delSla;
	}

	public void setDelSla(Date delSla) {
		this.delSla = delSla;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
}
