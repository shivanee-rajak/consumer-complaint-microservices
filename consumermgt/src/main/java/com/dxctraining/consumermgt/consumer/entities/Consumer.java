package com.dxctraining.consumermgt.consumer.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="consumers")
public class Consumer {

	@Id
	@GeneratedValue
	private int id;

	private String name;
	
	public Consumer() {
	}

	public Consumer(String name) {
		this.name=name;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		return id;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		Consumer that = (Consumer) obj;
		return this.id == that.id;
	}

}
