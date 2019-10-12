package com.zhiyou.modelAccept;

public class pay_itemsAccept {
	private Integer pay_items_id;     // 收费项目主键
	private String  charge_item_name;  // 收费项目名称
	private String  name;             // 病人姓名
	private String  medical_record;    // 病例号
	private Double  receivable_money;     // 应收金额
	private Double  charge_money;     // 收费金额
	
	
	public Double getCharge_money() {
		return charge_money;
	}
	
	public void setCharge_money(Double charge_money) {
		this.charge_money = charge_money;
	}
	
	public Integer getPay_items_id() {
		return pay_items_id;
	}
	
	public void setPay_items_id(Integer pay_items_id) {
		this.pay_items_id = pay_items_id;
	}
	
	public String getCharge_item_name() {
		return charge_item_name;
	}
	
	public void setCharge_item_name(String charge_item_name) {
		this.charge_item_name = charge_item_name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getMedical_record() {
		return medical_record;
	}
	
	public void setMedical_record(String medical_record) {
		this.medical_record = medical_record;
	}
	
	public Double getReceivable_money() {
		return receivable_money;
	}
	
	public void setReceivable_money(Double receivable_money) {
		this.receivable_money = receivable_money;
	}
	@Override
	public String toString() {
		return "pay_itemsAccept [pay_items_id=" + pay_items_id + ", charge_item_name=" + charge_item_name + ", name="
				+ name + ", medical_record=" + medical_record + ", receivable_money=" + receivable_money
				+ ", charge_money=" + charge_money + "]";
	}
	
	
	
}
