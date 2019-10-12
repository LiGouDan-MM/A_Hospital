package com.zhiyou.mapper;

import java.util.List;
import java.util.Map;

import com.zhiyou.model.PayItems;
import com.zhiyou.modelAccept.pay_itemsAccept;
import com.zhiyou.modelAssocation.PayRegistrationChargeAssocation;

public interface PayItemsMapper {

	List<PayRegistrationChargeAssocation> findAll(pay_itemsAccept pIA);

	int add(Map<String, Object> map);

	List<PayItems> findPay_Items();

	int addCharge_Manager(pay_itemsAccept pIAccept);

}
