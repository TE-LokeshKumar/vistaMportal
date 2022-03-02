package com.te.vistaMportal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.te.vistaMportal.exception.CustomException;
import com.te.vistaMportal.servicee.PaymentService;
import com.te.vistaMportal.transaction_bean.BaseResponse;
import com.te.vistaMportal.transaction_bean.Payments;

@RestController
public class PaymentController {

	@Autowired
	private PaymentService service;

	/*
	 * @InitBinder public void InitBinder(WebDataBinder binder) { CustomDateEditor
	 * dateEditor = new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true);
	 * binder.registerCustomEditor(Date.class, dateEditor); }
	 */

	@RequestMapping(path = "/store", method = RequestMethod.POST)
	public ResponseEntity<BaseResponse> storeData(@RequestBody Payments payments) {
		BaseResponse response = new BaseResponse(false, service.storeData(payments));
		return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);

	}

	@GetMapping("/getdata")
	public ResponseEntity<BaseResponse> getData(@RequestParam Integer paymentId) {
		System.out.println(service.getData(paymentId));
		if (paymentId <= 0) {
			throw new CustomException("Id cant be less than 0 or 0");
		} else if (paymentId >= 0) {
			BaseResponse response = new BaseResponse(false, service.getData(paymentId));
			if (service.getData(paymentId).equals(null)) {
				throw new CustomException("Cant find the data please provide valid id");
			} else
				return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
		} else
			throw new CustomException("please provide valid id ");
	}
}
