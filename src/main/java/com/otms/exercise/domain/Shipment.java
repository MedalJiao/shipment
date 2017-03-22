package com.otms.exercise.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="shipment")
@SequenceGenerator(name="seq_ship_num",sequenceName="seq_ship_num",allocationSize=1)
public class Shipment {
	
	private int shipNum;
	private String extNum;
	private Date createTime;
	private String pickupLoc;
	private Date pickupTime;
	private Date pickupSla;
	private String delLoc;
	private Date delTime;
	private Date delSla;
	private int status;
	
	public Shipment() {}
	
	public Shipment(int shipNum, String extNum, Date createTime, String pickupLoc, Date pickupTime, Date pickupSla,
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

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_ship_num")
	@Column(name="ship_num", nullable=false)
	public int getShipNum() {
		return shipNum;
	}
	public void setShipNum(int shipNum) {
		this.shipNum = shipNum;
	}
	
	@Column(name="ext_num", nullable=false)
	public String getExtNum() {
		return extNum;
	}
	public void setExtNum(String extNum) {
		this.extNum = extNum;
	}
	
	@Column(name="create_time", nullable=false)
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	@Column(name="pickup_loc")
	public String getPickupLoc() {
		return pickupLoc;
	}
	public void setPickupLoc(String pickupLoc) {
		this.pickupLoc = pickupLoc;
	}
	
	@Column(name="pickup_time")
	public Date getPickupTime() {
		return pickupTime;
	}
	public void setPickupTime(Date pickupTime) {
		this.pickupTime = pickupTime;
	}
	
	@Column(name="pickup_sla")
	public Date getPickupSla() {
		return pickupSla;
	}
	public void setPickupSla(Date pickupSla) {
		this.pickupSla = pickupSla;
	}
	
	@Column(name="del_loc")
	public String getDelLoc() {
		return delLoc;
	}
	public void setDelLoc(String delLoc) {
		this.delLoc = delLoc;
	}
	
	@Column(name="del_time")
	public Date getDelTime() {
		return delTime;
	}
	public void setDelTime(Date delTime) {
		this.delTime = delTime;
	}
	
	@Column(name="del_sla")
	public Date getDelSla() {
		return delSla;
	}
	public void setDelSla(Date delSla) {
		this.delSla = delSla;
	}
	
	@Column(name="status", nullable=false)
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "Shipment [shipNum=" + shipNum + ", extNum=" + extNum + ", createTime=" + createTime + ", pickupLoc="
				+ pickupLoc + ", pickupTime=" + pickupTime + ", pickupSla=" + pickupSla + ", delLoc=" + delLoc
				+ ", delTime=" + delTime + ", delSla=" + delSla + ", status=" + status + "]";
	}
	
}
