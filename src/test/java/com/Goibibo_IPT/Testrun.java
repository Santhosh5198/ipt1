package com.Goibibo_IPT;


import java.awt.Robot;


import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.base.Baseclass;
import com.pom.Pom;

public class Testrun extends Baseclass {
	Pom p = new Pom();
	
	
	@Test
	 public void browser() {
		browserlaunch("chrome");
		geturl("https://www.goibibo.com/");
		
	}
	

	@Test
	public void date() {
		clickonelement(p.getsp().getDeparture());
		clickonelement(p.getsp().getDate());
		clickonelement(p.getsp().getDone());
		String text = p.getsp().getSunday().getText();
		String actual ="Sunday";
		Assert.assertEquals(actual, text);
		clickonelement(p.getsp().getCancel());
		
	
		
		
	}
}
