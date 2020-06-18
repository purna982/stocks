package com.purna.stocks.webservices.stock;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Stock implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@Column
	private String  status;
	@Column
	private String name;
	@Column
	private double bid;
	@Column
	private double ask;
	@Transient
	private double mid;
	@Column
	private Date eventTime;
	
	public Stock() {
		
	}
	
	public Stock(Integer id, String status, String name, double bid, double ask, Date eventTime) {
		super();
		this.id = id;
		this.status = status;
		this.name = name;
		this.bid = bid;
		this.ask = ask;
		this.eventTime = eventTime;
	}

	public Stock(String status, String name, double bid, double ask, Date eventTime) {
		this.status = status;
		this.name = name;
		this.bid = bid;
		this.ask = ask;
		this.eventTime = eventTime;
	}
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getBid() {
		return bid;
	}

	public void setBid(double bid) {
		this.bid = bid;
	}

	public double getAsk() {
		return ask;
	}

	public void setAsk(double ask) {
		this.ask = ask;
	}

	public Date getEventTime() {
		return eventTime;
	}

	public void setEventTime(Date eventTime) {
		this.eventTime = eventTime;
	}
	

	public double getMid() {
		return mid;
	}

	public void setMid(double mid) {
		this.mid = mid;
	}

	@Override
	public String toString() {
		return "Stock [id=" + id + ", status=" + status + ", name=" + name + ", bid=" + bid + ", ask=" + ask + ", mid="
				 + ", eventTime=" + eventTime + "]";
	}
	
	
	
	

}
