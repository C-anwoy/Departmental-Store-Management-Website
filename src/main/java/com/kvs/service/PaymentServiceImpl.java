package com.kvs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kvs.dao.PaymentDAO;
import com.kvs.entity.EPayment;

@Service
public class PaymentServiceImpl implements PaymentService {
	
	@Autowired
	private PaymentDAO paymentDao;

	@Override
	@Transactional
	public void savePayment(EPayment thePayment) {
		
		paymentDao.savePayment(thePayment);

	}

}
