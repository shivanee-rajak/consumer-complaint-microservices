
package com.dxctraining.complaintmgt.complaint.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.dxctraining.complaintmgt.complaint.entities.Complaint;
import com.dxctraining.complaintmgt.exception.ComplaintNotFoundException;

@Repository
public class ComplaintDaoImpl implements IComplaintDao{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Complaint findComplaintById(int id) {
		Complaint complaint =em.find(Complaint.class,id);
		if(complaint==null) {
			throw new ComplaintNotFoundException("Complaint not found for id=" +id);
		}
		return complaint;
	}

	@Override
	public Complaint add(Complaint complaint) {
		em.persist(complaint);
		return complaint;
	}

	@Override
	public Complaint remove(int id) {
		Complaint complaint=findComplaintById(id);
		em.remove(complaint);
		return complaint;
	}

	@Override
	public List<Complaint> allComplaints() {
		String jpaql = "from Complaint ";
		TypedQuery<Complaint> query = em.createQuery(jpaql, Complaint.class);
		List<Complaint> list = query.getResultList();
		return list;
	}

	@Override
	public List<Complaint> allComplaintsByConsumer(int consumerId){
		String jpaql = "from Complaint where consumerId=:consumer";
		TypedQuery<Complaint> query = em.createQuery(jpaql, Complaint.class);
		query.setParameter("consumer", consumerId);
		List<Complaint> list = query.getResultList();
		return list;
	}

}
