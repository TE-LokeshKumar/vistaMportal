package com.te.vistaMportal.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.te.vistaMportal.transaction_bean.Payments;

public interface PaymentDAO extends JpaRepository<Payments, Integer>{

}
