package com.acme.GenericLibrary;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ReportListeners implements ITestListener,IAutoconstant{

	public static ExtentReports extent;
	public static ExtentTest test;
	
	
	public void onTestStart(ITestResult result) {
		test=extent.createTest(result.getName());
		test.log(Status.INFO, result.getName()+" Method Started");
	}

	public void onTestSuccess(ITestResult result) {
		test=extent.createTest(result.getName());
		test.pass(MarkupHelper.createLabel(" case has PASSED", ExtentColor.GREEN));
	}

	public void onTestFailure(ITestResult result) {
		test=extent.createTest(result.getName());
		test.fail(MarkupHelper.createLabel(" case has FAILED because of following reasons: ", ExtentColor.RED));
		test.fail(result.getThrowable());
		WebDriverCommonLib wlib = new WebDriverCommonLib();
		test.addScreenCaptureFromPath(wlib.getpagescreeenshot(SCREENSHOT_PATH, result.getName()));
	}
	public void onTestSkipped(ITestResult result) {
		test=extent.createTest(result.getName());
		test.skip(MarkupHelper.createLabel(" case has SKIPPED because of following reasons: ", ExtentColor.PINK));
		test.skip(result.getThrowable());
	}

	public void onStart(ITestContext context) {
		ExtentSparkReporter spark = new ExtentSparkReporter("D:\\Qspiders Project\\Automation\\Project files\\Acme\\Reports\\Acme.html");
		//Customising report view
		spark.config().setDocumentTitle("Acme Reports");
		spark.config().setReportName("Extent Reports 5");
		spark.config().setTheme(Theme.DARK);
		
		extent = new ExtentReports();
		extent.attachReporter(spark);
		
		//setting system info
		extent.setSystemInfo("Author", "Mouli Nadipena");
		extent.setSystemInfo("OS", "Windows 11");
		extent.setSystemInfo("Browser", "Chrome");
		extent.setSystemInfo("TestRunner Name", context.getName());
		
	}

	public void onFinish(ITestContext context) {
		//Writing all logs into report
		extent.flush();
	}

}

	


