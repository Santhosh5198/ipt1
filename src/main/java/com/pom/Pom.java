package com.pom;

import com.base.Baseclass;

public class Pom extends Baseclass {
	
	
	private Signinpage sp;
	
	public Signinpage getsp() {
		sp = new Signinpage(driver);
		return sp;
	}
	
	

}
