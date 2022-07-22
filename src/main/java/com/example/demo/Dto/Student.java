package com.example.demo.Dto;

import java.util.List;

public class Student {
private Integer id;
private String name;
private Double weight;
private boolean haveCar;
private List<String> carType;
private Skill skill;
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public Double getWeight() {
	return weight;
}
public void setWeight(Double weight) {
	this.weight = weight;
}
public boolean isHaveCar() {
	return haveCar;
}
public void setHaveCar(boolean haveCar) {
	this.haveCar = haveCar;
}
public List<String> getCarType() {
	return carType;
}
public void setCarType(List<String> carType) {
	this.carType = carType;
}
public Skill getSkill() {
	return skill;
}
public void setSkill(Skill skill) {
	this.skill = skill;
}
}

