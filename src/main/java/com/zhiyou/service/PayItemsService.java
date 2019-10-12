package com.zhiyou.service;

import java.util.List;

import com.zhiyou.model.PayItems;
import com.zhiyou.modelAccept.pay_itemsAccept;
import com.zhiyou.modelAssocation.PayRegistrationChargeAssocation;

public interface PayItemsService {

	List<PayRegistrationChargeAssocation> findAll(pay_itemsAccept pIA);

	int add(String charge_item_name, Double receivable_money);

	List<PayItems> findPay_Items();

	int addCharge_Manager(pay_itemsAccept pIAccept);

}
