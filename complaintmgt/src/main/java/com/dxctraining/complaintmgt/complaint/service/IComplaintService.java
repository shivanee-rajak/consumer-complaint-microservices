package com.dxctraining.complaintmgt.complaint.service;

import java.util.List;

import com.dxctraining.complaintmgt.complaint.entities.Complaint;


public interface IComplaintService {

	Complaint findComplaintById(int id);

	Complaint add(Complaint complaint);

	Complaint remove(int id);

	List<Complaint> allComplaints();

	public void validate(Object obj);
	
	List<Complaint> allComplaintsByConsumer(int consumerId);
}
