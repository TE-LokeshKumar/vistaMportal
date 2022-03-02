package com.te.vistaMportal.transaction_bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "payments")
public class Payments implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private Integer paymentId;

	private String orderId;

	private Date paymentDate;

	private double amount;

	private String serviceType;

	private String paymentBrand;

	private String paymentMethod;

	private String status;

}
