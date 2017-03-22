package com.otms.exercise.business;

import com.otms.exercise.dto.ShipmentDto;
import com.otms.exercise.exception.APPServerException;

public interface IShipmentService {
	
	public ShipmentDto queryByShipNum(int shipNum) throws APPServerException;
	public int addShipment(ShipmentDto shipmentDto) throws APPServerException;
	public void updateShipment(ShipmentDto shipmentDto) throws APPServerException;
	public void removeShipment(int shipNum) throws APPServerException;
	
}
