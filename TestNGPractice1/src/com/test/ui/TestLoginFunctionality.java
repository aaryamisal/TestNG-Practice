package com.test.ui;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;


public class TestLoginFunctionality {
	
	
	WebDriver driver;
	private String strUrl="https://kite.zerodha.com/";
	final String driverName="webdriver.chrome.driver";
	final String driverPath="C:\\Selenium_Support_Files\\chromedriver.exe";
	private String ExcelPath="C:\\Users\\Aarya\\Desktop\\AaryaVelocity\\Automation\\Test-case-template-xls.xls";
	//private String SheetName="Sheet2";
	ArrayList<TestData> lstTestData = new ArrayList<TestData>();

	
	@BeforeClass
	public void BeforeClass() throws EncryptedDocumentException, FileNotFoundException, IOException {
		
		//seting Chrome Driver Path and Opening Browser
		System.setProperty(driverName, driverPath);
		driver=new ChromeDriver();
		
		//Fetching Data from Excel Sheet (as per DDF)
		FileInputStream file = new FileInputStream(ExcelPath);
		Sheet dataSheet = WorkbookFactory.create(file).getSheet("Sheet2");
		
		int rows = dataSheet.getLastRowNum();// retuens index of row
		
		//Adding data to global Array List with will be used throughout class
		for (int i = 0; i <= rows ; i++) {
			TestData data= new TestData();
			data.TestCaseId=dataSheet.getRow(i).getCell(0).getStringCellValue();
			data.TestDataUserName=dataSheet.getRow(i).getCell(1).getStringCellValue();
			data.TestDataPassword=dataSheet.getRow(i).getCell(2).getStringCellValue();
			data.ExpectedResult=dataSheet.getRow(i).getCell(3).getStringCellValue();
			
			lstTestData.add(data);
		
		}
		// Verify that data has been pushed correctly to an arrayList 
//		for (TestData rowdata : lstTestData) {
//			
//			System.out.println(rowdata.TestCaseId);
//			System.out.println(rowdata.TestDataUserName);
//			System.out.println(rowdata.TestDataPassword);
//			System.out.println(rowdata.ExpectedResult);
//			
//			System.out.println();
//		}
	}
	
	@AfterClass
	public void AfterClass() throws InterruptedException {
		// Closing the browser Once all tests are finished
		Thread.sleep(3000);
		driver.quit();
	}

	@BeforeMethod
	public void BeforeTest() {
		// Navigating to same url before every test 
		driver.get(strUrl);
		
	}
	
	@AfterMethod   //not using in this program currently
	public void AfterTest() {
		//Reporter.log("Running after Method", true); 
	}
	
	@Test
	public void TC_Login_1() throws InterruptedException {
		
		//Arrange
		int rowIndex = 1;
		TestData TC1Data = lstTestData.get(rowIndex);
		
		//Act
		driver.findElement(By.xpath("//input[@id='userid']")).sendKeys(TC1Data.TestDataUserName);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(TC1Data.TestDataPassword);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(5000);
		
		String expectedBtnText=TC1Data.ExpectedResult;
		String actualBtnText = driver.findElement(By.xpath("//button[@type='submit' and contains(text(),'Continue')]")).getText();
		
		//Assert
		Assert.assertEquals(actualBtnText.trim(), expectedBtnText);
		
	}
	
	@Test
	public void TC_Login_2() throws InterruptedException {
		
		//Arrange
		int rowIndex = 2;
		TestData TC1Data = lstTestData.get(rowIndex);
		
		//Act
		driver.findElement(By.xpath("//input[@id='userid']")).sendKeys(TC1Data.TestDataUserName);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(TC1Data.TestDataPassword);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(5000);
		
		String expectedErrText=TC1Data.ExpectedResult;
		String actualErrText = driver.findElement(By.xpath("//p[@class='error text-center']")).getText();
		
		//Assert
		Assert.assertEquals(actualErrText.trim(), expectedErrText.trim());
		
	}
	
	@Test
	public void TC_Login_3() throws InterruptedException {
		
		//Arrange
		int rowIndex = 3;
		TestData TC1Data = lstTestData.get(rowIndex);
		
		//Act
		driver.findElement(By.xpath("//input[@id='userid']")).sendKeys(TC1Data.TestDataUserName);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(TC1Data.TestDataPassword);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(5000);
		
		String expectedErrText=TC1Data.ExpectedResult;
		String actualErrText = driver.findElement(By.xpath("//p[@class='error text-center']")).getText();
		
		//Assert
		Assert.assertEquals(actualErrText.trim(), expectedErrText.trim());
		
	}
	
	@Test
	public void TC_Login_4() throws InterruptedException {
		
		//Arrange
		int rowIndex = 4;
		TestData TC1Data = lstTestData.get(rowIndex);
		
		//Act
		driver.findElement(By.xpath("//input[@id='userid']")).sendKeys(TC1Data.TestDataUserName);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(TC1Data.TestDataPassword);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(5000);
		
		String expectedErrText=TC1Data.ExpectedResult;
		String actualErrText = driver.findElement(By.xpath("//p[@class='error text-center']")).getText();
		
		//Assert
		Assert.assertEquals(actualErrText.trim(), expectedErrText.trim());
		
	}
}
