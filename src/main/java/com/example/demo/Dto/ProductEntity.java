package com.example.demo.Dto;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCT")
public class ProductEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID")
    private int id;
    @Basic
    @Column(name = "NAME")
    private String name;
    @Basic
    @Column(name = "PRICE")
    private Double price;
	public int getId() {
		// TODO Auto-generated method stub
		return id;
	}
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}
	public Double getPrice() {
		// TODO Auto-generated method stub
		return price;
	}
	public void setId(int id) {
		this.id = id;
		// TODO Auto-generated method stub
		
	}
	public void setName(String name) {
		this.name = name;
		// TODO Auto-generated method stub
		
	}
	public void setPrice(double price) {
		this.price = price;
		// TODO Auto-generated method stub
		
	}


}

