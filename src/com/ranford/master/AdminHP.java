package com.ranford.master;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminHP 
{
 @FindBy(xpath=".//*[@id='Table_01']/tbody/tr[2]/td/table/tbody/tr[2]/td/a/img")
 WebElement Branch;
 
 @FindBy (xpath=".//*[@id='Table_01']/tbody/tr[2]/td/table/tbody/tr[4]/td/a/img")
 WebElement Role;
 
 @FindBy (xpath=".//*[@id='Table_01']/tbody/tr[2]/td/table/tbody/tr[8]/td/a/img")
 WebElement Emp;
 
 @FindBy (xpath=".//*[@id='Table_02']/tbody/tr/td[3]/a/img")
 WebElement Lout;
 
 public void Br()
 {
	 Branch.click();
 }
 public void Rol()
 {
	 Role.click();
 }
 public void Employee()
 {
	 Emp.click();
 }
 public void Logout()
 {
	 Lout.click();
 }



}
