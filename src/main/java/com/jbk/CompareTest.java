package com.jbk;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.collect.Table.Cell;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import jxl.read.biff.BiffException;

public class CompareTest {

	public static void main(String[] args) throws BiffException, IOException, InterruptedException {

		ExtentHtmlReporter html = new ExtentHtmlReporter("extentreport.html");

		ExtentReports extent = new ExtentReports();

		extent.attachReporter(html);

		ExtentTest test1 = extent.createTest("Excel Table Compare to Web Table");

		Logger log = Logger.getLogger(CompareTest.class);

		PropertyConfigurator.configure("log4j.properties");

		FileInputStream fis = new FileInputStream("Excelsheet1.xls");
		Workbook wb = Workbook.getWorkbook(fis);

		Sheet sh = wb.getSheet("Sheet1");

		int rows = sh.getRows();
		int colm = sh.getColumns();

		WebDriver driver = new ChromeDriver();
	
		driver.get("file:///C:/Users/spthakre/Desktop/Offline%20Website/Offline%20Website/pages/examples/users.html");

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < colm; j++) {
				Cell cell = sh.getCell(j, i);
				String ExcelValue = ((Object) cell).getContents();

				test1.pass("the excel sheet value= " + ExcelValue);

				log.info("the excel sheet value= " + ExcelValue);

				String UserTableValue = driver
						.findElement(By.xpath("//table/tbody/tr[" + (i + 2) + "]/td[" + (j + 1) + "]")).getText();
				test1.pass("The usertable value= " + UserTableValue);

				log.info("The usertable value= " + UserTableValue);

				if (ExcelValue.equals(UserTableValue)) {
					test1.pass("TRUE The Excelsheet value = " + ExcelValue + " and Usertable value = " + UserTableValue+ " are matched");

					log.info("TRUE The Excelsheet value = " + ExcelValue + " and Usertable value = " + UserTableValue+ " are matched");
				} else {
					test1.fail("FALSE  The Excelsheet value = " + ExcelValue + " and Usertable value = " + UserTableValue+ " are not matched");

					log.info("FALSE  The Excelsheet value = " + ExcelValue + " and Usertable value = " + UserTableValue+ " are not matched");
				}

				
			}
		}
		driver.close();
		extent.flush();
	}

}
