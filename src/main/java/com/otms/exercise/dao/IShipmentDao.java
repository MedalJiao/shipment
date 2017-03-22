package com.otms.exercise.dao;

import com.otms.exercise.domain.Shipment;

public interface IShipmentDao {
	
	public int save(Shipment shipment);
	public void update(Shipment shipment);
	public Shipment queryByShipNum(int shipNum);
	public Shipment queryByExtNum(String extNum);
	public void delete(Shipment shipment);
}
