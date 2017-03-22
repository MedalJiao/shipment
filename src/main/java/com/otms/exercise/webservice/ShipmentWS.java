package com.otms.exercise.webservice;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;

import com.otms.exercise.business.IShipmentService;
import com.otms.exercise.common.ResponseXML;
import com.otms.exercise.common.ShipmentStatus;
import com.otms.exercise.common.ValidateRequestParms;
import com.otms.exercise.dto.ShipmentDto;
import com.otms.exercise.exception.APPServerException;
import com.otms.exercise.util.DateUtils;

@Path("/order")
public class ShipmentWS {
	
	@Autowired
	private IShipmentService shipmentService;
	
	@POST
	@Produces({MediaType.APPLICATION_JSON})
	@Path("/create")
	public String created(@FormParam("extNum")String extNum) throws Exception{
		//validate required params , extNum is required when create a order
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("extNum",extNum);
		try {
			ValidateRequestParms.validate(map);
		} catch (APPServerException e) {
			return new ResponseXML(false,e.getMessage(),-1).toJsonString();
		}
		//create ShipmentDto
		ShipmentDto dto = new ShipmentDto();
		dto.setExtNum(extNum);
		dto.setCreateTime(new Date());
		dto.setStatus(1);
		int i = shipmentService.addShipment(dto);
		return new ResponseXML(true," An order was created successfully !",i).toJsonString();
	}
	
	@POST
	@Produces({MediaType.APPLICATION_JSON})
	@Path("/release")
	public String release(@FormParam("shipNum")String shipNum) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("shipNum",shipNum);
		try {
			ValidateRequestParms.validate(map);
		} catch (APPServerException e) {
			return new ResponseXML(false,e.getMessage(),-1).toJsonString();
		}
		return this.update(shipNum,2,null);
	}
	
	@POST
	@Produces({MediaType.APPLICATION_JSON})
	@Path("/dispatch")
	public String dispatch(@FormParam("shipNum")String shipNum) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("shipNum",shipNum);
		try {
			ValidateRequestParms.validate(map);
		} catch (APPServerException e) {
			return new ResponseXML(false,e.getMessage(),-1).toJsonString();
		}
		return this.update(shipNum,3,null);
	}
	
	@POST
	@Produces({MediaType.APPLICATION_JSON})
	@Path("/pickup")
	public String pickup(@FormParam("shipNum")String shipNum , @FormParam("pickupLoc")String pickupLoc) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("shipNum",shipNum);
		map.put("pickupLoc",pickupLoc);
		try {
			ValidateRequestParms.validate(map);
		} catch (APPServerException e) {
			return new ResponseXML(false,e.getMessage(),-1).toJsonString();
		}
		return this.update(shipNum,4,pickupLoc);
	}
	
	@POST
	@Produces({MediaType.APPLICATION_JSON})
	@Path("/deliver")
	public String deliver(@FormParam("shipNum")String shipNum , @FormParam("delLoc")String delLoc) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("shipNum",shipNum);
		map.put("delLoc",delLoc);
		try {
			ValidateRequestParms.validate(map);
		} catch (APPServerException e) {
			return new ResponseXML(false,e.getMessage(),-1).toJsonString();
		}
		return this.update(shipNum,5,delLoc);
	}
	
	@POST
	@Produces({MediaType.APPLICATION_JSON})
	@Path("/close")
	public String close(@FormParam("shipNum")String shipNum) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("shipNum",shipNum);
		try {
			ValidateRequestParms.validate(map);
		} catch (APPServerException e) {
			return new ResponseXML(false,e.getMessage(),-1).toJsonString();
		}
		return this.update(shipNum,6,null);
	}
	
	public String update(String shipNum,int status,String location) throws Exception{
		int shipnum = Integer.parseInt(shipNum);
		ShipmentDto dto = shipmentService.queryByShipNum(shipnum);
		if(dto == null){
			return new ResponseXML(false,"The order is not exist !",shipNum).toJsonString();
		}
		int currentStatus = dto.getStatus();
		if(status>6 || status<1){
			return new ResponseXML(false,"Value of status is out of bounds !",shipNum).toJsonString();
		}
		if((status-currentStatus) == 1){
			if(status == 4){
				dto.setPickupTime(new Date());
				dto.setPickupSla(new Date());
			}
			if(status == 5){
				dto.setDelTime(new Date());
				dto.setDelSla(new Date());
			}
			dto.setStatus(status);
			shipmentService.updateShipment(dto);
		}else{
			return new ResponseXML(false,"Current status is "+ShipmentStatus.getName(currentStatus)+" , cannot be changed to "+ShipmentStatus.getName(status)+" !",shipNum).toJsonString();
		}
		return new ResponseXML(true,ShipmentStatus.getName(status)+" successed !",shipNum).toJsonString();
	}
		
	@GET
	@Consumes({MediaType.TEXT_PLAIN})
	@Produces({MediaType.TEXT_PLAIN})
	public String test(){
		return "test successed !";
	}
}
