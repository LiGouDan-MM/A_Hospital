package com.zhiyou.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou.mapper.PayItemsMapper;
import com.zhiyou.model.PayItems;
import com.zhiyou.modelAccept.pay_itemsAccept;
import com.zhiyou.modelAssocation.PayRegistrationChargeAssocation;

@Service
public class PayItemsServiceImpl implements PayItemsService {
    @Autowired
    private PayItemsMapper mapper;
    
	@Override
	public List<PayRegistrationChargeAssocation> findAll(pay_itemsAccept pIA) {
		return mapper.findAll(pIA);
	}

	@Override
	public int add(String charge_item_name, Double receivable_money) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("charge_item_name",charge_item_name );
		map.put("receivable_money", receivable_money);
		return mapper.add(map);
	}

	@Override
	public List<PayItems> findPay_Items() {
		return mapper.findPay_Items();
	}

	@Override
	public int addCharge_Manager(pay_itemsAccept pIAccept) {
		return mapper.addCharge_Manager(pIAccept);
	}

}
