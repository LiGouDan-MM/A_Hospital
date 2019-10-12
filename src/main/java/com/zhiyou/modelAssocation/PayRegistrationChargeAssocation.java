package com.zhiyou.modelAssocation;

import com.zhiyou.model.ChargeManager;
import com.zhiyou.model.RegistrationInfor;

public class PayRegistrationChargeAssocation {
	
	private Integer id;
    private String charge_item_name;
    private Double receivable_money;
    private ChargeManager chargeManager;
    private RegistrationInfor registrationInfor;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCharge_item_name() {
		return charge_item_name;
	}
	public void setCharge_item_name(String charge_item_name) {
		this.charge_item_name = charge_item_name;
	}
	public Double getReceivable_money() {
		return receivable_money;
	}
	public void setReceivable_money(Double receivable_money) {
		this.receivable_money = receivable_money;
	}
	public ChargeManager getChargeManager() {
		return chargeManager;
	}
	public void setChargeManager(ChargeManager chargeManager) {
		this.chargeManager = chargeManager;
	}
	public RegistrationInfor getRegistrationInfor() {
		return registrationInfor;
	}
	public void setRegistrationInfor(RegistrationInfor registrationInfor) {
		this.registrationInfor = registrationInfor;
	}
	@Override
	public String toString() {
		return "PayRegistrationChargeAssocation [id=" + id + ", charge_item_name=" + charge_item_name
				+ ", receivable_money=" + receivable_money + ", chargeManager=" + chargeManager + ", registrationInfor="
				+ registrationInfor + "]";
	}
    
    

}
