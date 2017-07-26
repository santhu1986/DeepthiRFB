package com.ranford.master;

import java.io.IOException;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class BaseNg {
 
	Lib Lb=new Lib();
	
  @BeforeTest
  public void beforeTest() throws IOException 
  {
  Lb.Login("Admin","Admin");
  }

  @AfterTest
  public void afterTest() 
  {
  Lb.Logout();
  }

  @BeforeSuite
  public void beforeSuite()
  {
  Lb.OpenApp("http://seoemirates.com/Build2/home.aspx");
  }

  @AfterSuite
  public void afterSuite()
  {
  Lb.Close();
  }

}
