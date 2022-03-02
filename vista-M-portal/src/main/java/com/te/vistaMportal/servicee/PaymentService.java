package com.te.vistaMportal.servicee;

import com.te.vistaMportal.transaction_bean.Payments;

public interface PaymentService {

	public Payments storeData(Payments payments);

	public Payments getData(Integer paymentId);

}
