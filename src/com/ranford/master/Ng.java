package com.ranford.master;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Ng 
{
	 public static WebDriver driver;
	 public static String Expval,Actval;
	 public static Properties Pr;
	 public static FileInputStream Fis;
	
  @Test(priority=0)
	 public void OpenApp()
{
	
	Expval="Ranford Bank";
	
  driver = new FirefoxDriver();
	driver.manage().window().maximize();
    driver.get("http://seoemirates.com/Build2/home.aspx");
    String Actval=driver.findElement(By.xpath(".//*[@id='Form1']/table/tbody/tr/td/table/tbody/tr[4]/td/table/tbody/tr[1]/td[4]/p/span")).getText();
   if (Expval.equalsIgnoreCase(Actval))
   {
	 System.out.println("Ranford home page is displayed");
	// return "Pass";
}
   else
   {
	   System.out.println("Ranford home page is not displayed");
	 //  return "Fail";
   }

}
  
@Test(priority=1)
public void Login() throws IOException
{
	Pr=new Properties();
	Fis=new FileInputStream("E:\\deepthi\\Ranford Project Live\\src\\com\\ranford\\properties\\Rep.properties");
	Pr.load(Fis);
	
	Expval="Welcome to Admin";
    
    driver.findElement(By.id(Pr.getProperty("Un"))).sendKeys("Admin");
    driver.findElement(By.id(Pr.getProperty("Pwd"))).sendKeys("Admin");
    driver.findElement(By.id(Pr.getProperty("Lgn"))).click();
 Actval=driver.findElement(By.xpath("html/body/table/tbody/tr/td/table/tbody/tr[4]/td/table/tbody/tr[1]/td[4]/strong/font/font")).getText();

 if (Expval.equalsIgnoreCase(Actval))
   {
	 System.out.println("Admin home page is displayed");
}
   else
   {
	   System.out.println("Admin home page is not displayed");
   }


}
@Test(priority=2)
public void Role()
{
	Expval="Sucessfully";
    Sleeper.sleepTightInSeconds(5);
	driver.findElement(By.xpath(Pr.getProperty("RBtn"))).click();
		    driver.findElement(By.id(Pr.getProperty("NRBtn"))).click();
		    driver.findElement(By.id(Pr.getProperty("RN"))).sendKeys("managerabc");
		    driver.findElement(By.id(Pr.getProperty("Rdes"))).sendKeys("manager");
		    Select type = new Select (driver.findElement(By.id(Pr.getProperty("Rtype"))));
		    type.selectByVisibleText("E");
		    driver.findElement(By.id(Pr.getProperty("BtnIns"))).click();
		    Actval= driver.switchTo().alert().getText();
		    driver.switchTo().alert().accept();
		    driver.findElement(By.xpath((Pr.getProperty("HBt")))).click();
		    if (Actval.contains(Expval))
		    {
		    	System.out.println("Role created");
		    	//return Actval;
		    	    }
		    else
		    {
		    	System.out.println("Role already exists");
		    //	return Actval;
		    }

		    
		    
		    
	   		}
@Test(priority=3)
public void Logout()
{
	Sleeper.sleepTightInSeconds(5);
	driver.findElement(By.xpath(".//*[@id='Table_02']/tbody/tr/td[3]/a/img")).click();
}
@Test(priority=4,enabled=false)
public void Close()
{
	driver.close();
}
}
