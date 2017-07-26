package com.ranford.master;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RoleNg extends BaseNg
{
@Test(dataProvider="rdata")
	public void Role(String Rn,String Rd,String Rt)
	{
		Lb.Role(Rn,Rd,Rt);
	}

	@DataProvider
	
	public Object[][] rdata()
	{
	Object[][] Obj=new Object[3][3];
	
	Obj[0][0]="teller10";
	Obj[0][1]="teller";
	Obj[0][2]="E";
	
	Obj[1][0]="teller05";
	Obj[1][1]="teller";
	Obj[1][2]="E";
	
	Obj[2][0]="teller08";
	Obj[2][1]="teller";
	Obj[2][2]="E";
	
	return Obj;

	
	}
}
