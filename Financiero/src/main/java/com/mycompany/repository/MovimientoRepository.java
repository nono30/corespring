package com.mycompany.repository;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.mycompany.interceptor.Transactional;
import com.mycompany.model.Movimiento;

public class MovimientoRepository {

	private EntityManager manager;
	
	@Inject
	public MovimientoRepository(EntityManager manager){
		this.manager = manager;
	}
	
	public List<Movimiento> todos(){
		TypedQuery<Movimiento> query = 
				manager.createQuery("from Movimiento",
						Movimiento.class);
		return query.getResultList();
	}

	@Transactional
	public void agregar(Movimiento movimiento){

		this.manager.persist(movimiento);

	}
	
	
	
	
	
	
}