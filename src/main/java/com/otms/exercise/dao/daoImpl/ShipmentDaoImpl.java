package com.otms.exercise.dao.daoImpl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.otms.exercise.dao.IShipmentDao;
import com.otms.exercise.domain.Shipment;

@Repository
public class ShipmentDaoImpl implements IShipmentDao {
	
	@PersistenceContext(unitName = "hibernatePersistence")
	private EntityManager em;
	
	@Override
	public int save(Shipment shipment) {
		em.persist(shipment);
		return shipment.getShipNum();
	}

	@Override
	public void update(Shipment shipment) {
		em.merge(shipment);
	}

	@Override
	public Shipment queryByShipNum(int shipNum) {
		return em.find(Shipment.class,shipNum);
	}

	@Override
	public Shipment queryByExtNum(String extNum) {
		return em.find(Shipment.class,extNum);
	}

	@Override
	public void delete(Shipment shipment) {
		em.remove(shipment);
	}

}
