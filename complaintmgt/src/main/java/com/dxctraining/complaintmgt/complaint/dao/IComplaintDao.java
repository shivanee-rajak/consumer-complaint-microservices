package com.dxctraining.complaintmgt.complaint.dao;

import java.util.List;

import com.dxctraining.complaintmgt.complaint.entities.Complaint;

public interface IComplaintDao {

	Complaint findComplaintById(int id);

	Complaint add(Complaint complaint);

	Complaint remove(int id);

	List<Complaint> allComplaints();
	
	List<Complaint> allComplaintsByConsumer(int consumerId);

}
