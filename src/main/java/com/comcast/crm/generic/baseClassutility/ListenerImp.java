package com.comcast.crm.generic.baseClassutility;

/*
 * ListenerImplementation class:
 * Implements TestNG ITestListener to track test execution events like start, success, failure, skip, etc.
 */
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcost.crm.generic.webdriverutility.UtilityClassObject;

public class ListenerImp implements ITestListener, ISuiteListener{
	public static ExtentReports report;
	public static ExtentTest test;
	
	
	/*Executes before the test suite starts*/
	@Override
	public void onStart(ISuite suite) {
		System.out.println("Report config");
		//spark report config
		ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReports/report.html");
		spark.config().setDocumentTitle("CRM Test Suite Results");
		spark.config().setReportName("CRM report");
		spark.config().setTheme(Theme.DARK);
		
		//Add environment info
		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS","Windows-10");
		report.setSystemInfo("Browser","Chrome");
	}

	
	/*Executes after the test suite finishes*/
	@Override
	public void onFinish(ISuite suite) {
		System.out.println("Report backup");
		report.flush();
		
	}
	
	/*Executes when a test method starts*/
	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("===>"+result.getMethod().getMethodName()+">===START====");
		test = report.createTest(result.getMethod().getMethodName());
		test.log(Status.INFO,result.getMethod().getMethodName()+"===>Started<====");
		UtilityClassObject.setTest(test);
		test = report.createTest("CreateContactTest");
	}
	
	/*Executes when a test method passes*/
	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("===>"+result.getMethod().getMethodName()+">===END====");
		UtilityClassObject.getTest().log(Status.PASS,result.getMethod().getMethodName()+"===>Completed<====");
	}
	
	/*Executes when a test method fails*/
	@Override
	public void onTestFailure(ITestResult result) {
		String testName = result.getMethod().getMethodName();
		String time = new Date().toString().replace(" ", "_").replace(":","_");
		TakesScreenshot eDriver = (TakesScreenshot)BaseClass.sdriver;
		String filepath= eDriver.getScreenshotAs(OutputType.BASE64);
		
		UtilityClassObject.getTest().addScreenCaptureFromBase64String(filepath, testName+"_"+time);
		UtilityClassObject.getTest().log(Status.FAIL,result.getMethod().getMethodName()+"===>Failed<====");
		
	}

	
	
	
	

}