package com.otms.exercise.util;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;

import com.otms.exercise.domain.Shipment;
import com.otms.exercise.dto.ShipmentDto;
import com.otms.exercise.exception.APPServerException;

public class TransformDtoEntity {
	
	public final static Shipment dto2Entity(ShipmentDto dto){
		Shipment entity = new Shipment();
		try {
			BeanUtils.copyProperties(dto,entity);
		} catch (BeansException e) {
			e.printStackTrace();
			throw new APPServerException("fail to transform dto to entity !");
		}
		return entity;
	}
	
	public final static ShipmentDto entity2Dto(Shipment entity){
		ShipmentDto dto = new ShipmentDto();
		try {
			BeanUtils.copyProperties(entity,dto);
		} catch (BeansException e) {
			e.printStackTrace();
			throw new APPServerException("fail to transform entity to dto !");
		}
		return dto;
	}
}
