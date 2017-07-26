package com.ranford.scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Basicscript {

	public static void main(String[] args) 
	{
      String Expval="Ranford Bank";
		
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
	    driver.get("http://seoemirates.com/Build2/home.aspx");
	    String Actval=driver.findElement(By.xpath(".//*[@id='Form1']/table/tbody/tr/td/table/tbody/tr[4]/td/table/tbody/tr[1]/td[4]/p/span")).getText();
	   if (Expval.equalsIgnoreCase(Actval))
	   {
		 System.out.println("Ranford home page is displayed");
	}
	   else
	   {
		   System.out.println("Ranford home page is not displayed");
	   }
	   
	   Expval="Welcome to Admin";
	    
	    driver.findElement(By.id("txtuId")).sendKeys("Admin");
	    driver.findElement(By.id("txtPword")).sendKeys("Admin");
	    driver.findElement(By.id("login")).click();
     Actval=driver.findElement(By.xpath("html/body/table/tbody/tr/td/table/tbody/tr[4]/td/table/tbody/tr[1]/td[4]/strong/font/font")).getText();
	
     if (Expval.equalsIgnoreCase(Actval))
	   {
		 System.out.println("Admin home page is displayed");
	}
	   else
	   {
		   System.out.println("Admin home page is not displayed");
	   }
	


     Expval="Sucessfully";
     
driver.findElement(By.xpath(".//*[@id='Table_01']/tbody/tr[2]/td/table/tbody/tr[4]/td/a/img")).click();
	    driver.findElement(By.id("btnRoles")).click();
	    driver.findElement(By.id("txtRname")).sendKeys("deepthi123");
	    driver.findElement(By.id("txtRDesc")).sendKeys("Admin1");
	    Select type = new Select (driver.findElement(By.id("lstRtypeN")));
	    type.selectByVisibleText("E");
	    driver.findElement(By.id("btninsert")).click();
	    Actval= driver.switchTo().alert().getText();
	    if (Actval.contains(Expval))
	    {
	    	System.out.println("Role created");
	    	    }
	    else
	    {
	    	System.out.println("Role already exists");
	    }

	    driver.switchTo().alert().accept();
	    
	    
   		}

	
}
