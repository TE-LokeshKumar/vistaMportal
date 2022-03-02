package com.te.vistaMportal.servicee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.vistaMportal.dao.PaymentDAO;
import com.te.vistaMportal.exception.CustomException;
import com.te.vistaMportal.transaction_bean.Payments;

@Service
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	private PaymentDAO dao;

	@Override
	public Payments storeData(Payments payments) {

		System.out.println(payments.getPaymentDate());
		return dao.save(payments);
	}

	@Override
	public Payments getData(Integer paymentId) {
		/*
		 * Integer id = null; if (paymentId.equals(id)) { throw new
		 * Optional<CustomException("Id cant be null")>; }else
		 */
		
		if (dao.getById(paymentId).equals(null)) {
			throw new CustomException("Cant find the data please provide valid id");
		} else {
			return dao.getById (paymentId);
		}
	}

}
