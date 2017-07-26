package com.ranford.master;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Keyword {

	
	public static void main(String[] args) throws IOException
	
	{
		Lib1 LB=new Lib1();
		 String Res=null;
		 String Kpath="E:\\deepthi\\Ranford Project Live\\src\\com\\ranford\\testdata\\keyword_data.xlsx";
		 String Kout="E:\\deepthi\\Ranford Project Live\\src\\com\\ranford\\results\\Res_Keyword.xlsx";
		 
		 FileInputStream fi=new FileInputStream(Kpath);
			
			XSSFWorkbook wb=new XSSFWorkbook(fi);

			XSSFSheet ws=wb.getSheet("TestCase");
			XSSFSheet ws1=wb.getSheet("TestSteps");
			
			
			int tcRc=ws.getLastRowNum();
	        System.out.println(tcRc);
	        
			int tsRc=ws1.getLastRowNum();
			System.out.println(tsRc);
			
			//test cases

			for (int i = 1; i <= tcRc; i++)
			{
				String exe=ws.getRow(i).getCell(2).getStringCellValue();
				if (exe.equalsIgnoreCase("Y"))
				{
					String tcId=ws.getRow(i).getCell(0).getStringCellValue();
					
					//test steps
					
					for (int j = 1; j <= tsRc ; j++) 
					{
						String tsTcid=ws1.getRow(j).getCell(0).getStringCellValue();
						
						if (tcId.equalsIgnoreCase(tsTcid))
						{
							String key=ws1.getRow(j).getCell(3).getStringCellValue();
							
							switch (key) 
							{
							case "RLanch":
								Res=LB.openApp("http://seoemirates.com/Build2/home.aspx");
								break;
							case "RLogin":
								Res=LB.AdmLgn("Admin","Admin");
								break;
							case "RLogout": 	
								LB.admlgt();
								break;
							case "RBranch":
									LB.branch();
								break;
							case "RRole":
								Res=LB.Role("Cashier56","E");
								break;
							case "RClose":
								LB.Appc();
								break;
							
							default:
								System.out.println("Pass a Valid Keyword");
								break;
							}

							//result updation in test steps sheet
							
							ws1.getRow(j).createCell(4).setCellValue(Res);
							
							//result updation in test case sheet
							
							if (!ws1.getRow(j).getCell(4).getStringCellValue().equalsIgnoreCase("Fail"))
							{
								ws.getRow(i).createCell(3).setCellValue(Res);
							}
							else
							{
								ws.getRow(i).createCell(3).setCellValue("Fail");
							}
							
							
						}
						
						
						
					}
					
				}
				else
				{
					ws.getRow(i).createCell(3).setCellValue("BLOCKED");
				}
			}
			FileOutputStream fo=new FileOutputStream(Kout);
			wb.write(fo);
			wb.close();

		}

	}

