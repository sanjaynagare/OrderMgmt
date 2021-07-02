package com.synechron.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Order_new")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_id")
	private int orderId;
	@Column(name = "order_name")
	private String orderName;
	@Column(name = "order_description")
	private String OrderDescription;
	@Column(name = "amount")
	private double amount;
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getOrderName() {
		return orderName;
	}
	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}
	public String getOrderDescription() {
		return OrderDescription;
	}
	public void setOrderDescription(String orderDescription) {
		OrderDescription = orderDescription;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", orderName=" + orderName + ", OrderDescription=" + OrderDescription
				+ ", amount=" + amount + "]";
	}

}
