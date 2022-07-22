package com.example.demo;

import java.io.Console;

import org.springframework.stereotype.Component;

@Component
public class TestComponent implements TestInertface  {

	@Override
	public String show() {
		// TODO Auto-generated method stub
//		System.console().;
		System.out.println("show");
		return "show";
	}

}
