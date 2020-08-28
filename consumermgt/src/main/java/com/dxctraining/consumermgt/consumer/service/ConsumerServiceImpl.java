package com.dxctraining.consumermgt.consumer.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dxctraining.consumermgt.consumer.dao.IConsumerDao;
import com.dxctraining.consumermgt.consumer.entities.Consumer;
import com.dxctraining.consumermgt.exception.InvalidArgumentException;

@Transactional
@Service
public class ConsumerServiceImpl implements IConsumerService{

	@Autowired
	private IConsumerDao dao;
	
	@Override
	public Consumer findConsumerById(int id) {
		validate(id);
		Consumer consumer=dao.findConsumerById(id);
		return consumer;
	}

	@Override
	public Consumer add(Consumer consumer) {
		validate(consumer);
		dao.add(consumer);
		return consumer;
	}

	@Override
	public Consumer remove(int id) {
		validate(id);
		Consumer consumer=dao.remove(id);
		return consumer;
	}

	@Override
	public List<Consumer> allConsumers() {
		List<Consumer> all=dao.allConsumers();
		return all;
	}

	@Override
	public void validate(Object obj) {
		if(obj==null) {
			throw new InvalidArgumentException("Argument is null");
		}
		
	}

	
}
