package com.comcast.crm.generic.baseClassutility;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PracticeBaseClass {
	
	public static void main(String[] args) {
		System.out.println("main method got executed");
		PracticeBaseClass pbc = new PracticeBaseClass();
		pbc.nonstaticmethod();
		pbc.nonstaticmethod1();
		PracticeBaseClass.staticmethod();
	}
	
	public void nonstaticmethod() {
		System.out.println("Non Static method got executed");
	}
	
	public void nonstaticmethod1() {
		System.out.println("Non Static method 1 got executed");
	}
	
	public static void staticmethod() {
		System.out.println("Static method got executed");
	}

	@BeforeSuite
	public void beforeSuite1() {
		Reporter.log("BeforeSuite 1 got executed", true);
	}
	
	@AfterSuite
	public void afterSuite1() {
		Reporter.log("Aftersuite 1 got exected", true);
	}
	
	@BeforeTest
	public void beforeTest1() {
		Reporter.log("BeforeTest 1 got executed", true);
	}
	
	@AfterTest
	public void afterTest1(){
		Reporter.log("AfterTest 1 got exected", true);
	}
	
	@BeforeClass
	public void beforeClass1(){
		Reporter.log("BeforeClass 1 got executed", true);
	}
	
	@AfterClass
	public void afterClass1() {
		Reporter.log("AfterClass 1 got exected", true);
	}
	
	@BeforeMethod
	public void beforeMethod1() {
		Reporter.log("BeforeMethod 1 got executed", true);
	}
	
	@AfterMethod
	public void afterMethod1() {
		Reporter.log("AfterMethod 1 got exected", true);
	}
	
	
	@Test
	public void Test2() {
		Reporter.log("Test 1 got exected", true);
	}
	
	@BeforeSuite
	public void beforeSuite() {
		Reporter.log("BeforeSuite got executed", true);
	}
	
	@AfterSuite
	public void afterSuite() {
		Reporter.log("Aftersuite got exected", true);
	}
	
	@BeforeTest
	public void beforeTest() {
		Reporter.log("BeforeTest got executed", true);
	}
	
	@AfterTest
	public void afterTest() {
		Reporter.log("AfterTest got exected", true);
	}
	
	@BeforeClass
	public void beforeClass() {
		Reporter.log("BeforeClass got executed", true);
	}
	
	@AfterClass
	public void afterClass() {
		Reporter.log("AfterClass got exected", true);
	}
	
	@BeforeMethod
	public void beforeMethod() {
		Reporter.log("BeforeMethod got executed", true);
	}
	
	@AfterMethod
	public void afterMethod() {
		Reporter.log("AfterMethod got exected", true);
	}
	
	
	@Test
	public void Test() {
		Reporter.log("Test 2 got exected", true);
	}
	
	
}
