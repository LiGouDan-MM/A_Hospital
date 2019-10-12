package com.zhiyou.modelAssocation;

public class A {
	private Integer id;
    private String medical_record;
    private Integer pay_items_id;
    private Double charge_money;// 收费金额
    private String charge_time;
    private String charge_item_name;
    private Double receivable_money;
    private Double balance;  //余额 
    private String cash_pledge; // 押金
    private Double total_cost; // 总花费
    
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	public String getCash_pledge() {
		return cash_pledge;
	}
	public void setCash_pledge(String cash_pledge) {
		this.cash_pledge = cash_pledge;
	}
	public Double getTotal_cost() {
		return total_cost;
	}
	public void setTotal_cost(Double total_cost) {
		this.total_cost = total_cost;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getMedical_record() {
		return medical_record;
	}
	public void setMedical_record(String medical_record) {
		this.medical_record = medical_record;
	}
	public Integer getPay_items_id() {
		return pay_items_id;
	}
	public void setPay_items_id(Integer pay_items_id) {
		this.pay_items_id = pay_items_id;
	}
	public Double getCharge_money() {
		return charge_money;
	}
	public void setCharge_money(Double charge_money) {
		this.charge_money = charge_money;
	}
	public String getCharge_time() {
		return charge_time;
	}
	public void setCharge_time(String charge_time) {
		this.charge_time = charge_time;
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
	@Override
	public String toString() {
		return "A [id=" + id + ", medical_record=" + medical_record + ", pay_items_id=" + pay_items_id
				+ ", charge_money=" + charge_money + ", charge_time=" + charge_time + ", charge_item_name="
				+ charge_item_name + ", receivable_money=" + receivable_money + ", balance=" + balance
				+ ", cash_pledge=" + cash_pledge + ", total_cost=" + total_cost + "]";
	}
	
    

}
