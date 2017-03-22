package com.otms.exercise.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.otms.exercise.business.IShipmentService;
import com.otms.exercise.dao.IShipmentDao;
import com.otms.exercise.domain.Shipment;
import com.otms.exercise.dto.ShipmentDto;
import com.otms.exercise.exception.APPServerException;
import com.otms.exercise.util.TransformDtoEntity;

@Repository
public class ShipmentServiceImpl implements IShipmentService {
	
	@Autowired
	private IShipmentDao dao;

	@Override
	@Transactional
	public ShipmentDto queryByShipNum(int shipNum) throws APPServerException {
		if(shipNum == 0){
			throw new APPServerException("The shipNum can not be 0 !");
		}
		Shipment shipment = dao.queryByShipNum(shipNum);
		ShipmentDto dto = null;
		if(shipment != null){
			dto = TransformDtoEntity.entity2Dto(shipment);
		}
		return dto;
	}

	@Override
	@Transactional
	public int addShipment(ShipmentDto shipmentDto) throws APPServerException {
		if(shipmentDto == null){
			throw new APPServerException("The parames can not be null !");
		}
		Shipment shipment = TransformDtoEntity.dto2Entity(shipmentDto);
		int i;
		try {
			i = dao.save(shipment);
		} catch (Exception e) {
			e.printStackTrace();
			throw new APPServerException("Fail to save shipment !");
		}
		return i;
	}

	@Override
	@Transactional
	public void updateShipment(ShipmentDto shipmentDto) throws APPServerException {
		if(shipmentDto == null){
			throw new APPServerException("The parames can not be null !");
		}
		Shipment shipment = TransformDtoEntity.dto2Entity(shipmentDto);
		if(shipment == null){
			throw new APPServerException("The order is not exist !");
		}
		try {
			dao.update(shipment);
		} catch (Exception e) {
			e.printStackTrace();
			throw new APPServerException("Fail to update shipment !");
		}
	}

	@Override
	@Transactional
	public void removeShipment(int shipNum) throws APPServerException {
		if(shipNum == 0){
			throw new APPServerException("The shipNum can not be 0 !");
		}
		Shipment shipment = dao.queryByShipNum(shipNum);
		if(shipment == null){
			throw new APPServerException("The order is not exist !");
		}
		dao.delete(shipment);
	}
}
