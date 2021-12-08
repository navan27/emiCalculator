/*The following code has been written for the purpose of automation test at Brain Station 23 LTD
Author: Navan Tanjeem Hossain
Date: 08-12-2021
*/


package Appium.Calculator;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class emiCalculator {
	
	AndroidDriver<AndroidElement> driver;

	// Initializing Driver and the Desired Capabilities
	
	@BeforeClass
	public void initialize() throws MalformedURLException, InterruptedException 
	{
		File f = new File("src/main/java/Appium/Calculator");
		File fs = new File (f, "emi-calculator.apk");

		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");

		cap.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "3000"); // 

		driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		Thread.sleep(2000);
	}
	
	
	@Test (description = "Verify if for case1 monthly EMI matches", priority = 1)
	public void case1mEMI() throws InterruptedException
	{

		Thread.sleep(5000);

		driver.findElementByXPath("//android.widget.LinearLayout[@resource-id = 'com.continuum.emi.calculator:id/btnStart']").click();

		Thread.sleep(3000);

		driver.findElementByXPath("//android.widget.EditText[@resource-id = 'com.continuum.emi.calculator:id/etLoanAmount']").sendKeys("100000");
		driver.findElementByXPath("//android.widget.EditText[@resource-id = 'com.continuum.emi.calculator:id/etInterest']").sendKeys("9.0");
		driver.findElementByXPath("//android.widget.EditText[@text = 'Years']").sendKeys("2");
		driver.findElementByXPath("//android.widget.EditText[@resource-id = 'com.continuum.emi.calculator:id/etFee']").sendKeys("2.0");

		driver.findElementByXPath("//android.widget.Button[@resource-id = 'com.continuum.emi.calculator:id/btnCalculate']").click();
		driver.findElementByXPath("//android.widget.Button[@resource-id = 'com.continuum.emi.calculator:id/btnDetail']").click();

		Thread.sleep(2000);

		String expectedmEMI = "4,568";
		String originalmEMI = driver.findElementByXPath("//android.widget.TextView[@resource-id = 'com.continuum.emi.calculator:id/monthly_emi_result']").getText();
				
		Assert.assertEquals(originalmEMI, expectedmEMI);		
	}
	
	@Test (description = "Verify if for case1 Total Interest matches", priority = 2)
	public void case1tInterest() throws InterruptedException
	{
		String expectedtInterest = "9,643";
		String originaltInterest = driver.findElementByXPath("//android.widget.TextView[@resource-id = 'com.continuum.emi.calculator:id/total_interest_result']").getText();
				
		Assert.assertEquals(originaltInterest, expectedtInterest);		
	}
	
	@Test (description = "Verify if for case1 Processing Fee matches", priority = 3)
	public void case1tpFee() throws InterruptedException
	{
		String expectedttpFee = "2,000";
		String originalttpFee = driver.findElementByXPath("//android.widget.TextView[@resource-id = 'com.continuum.emi.calculator:id/processing_fee_result']").getText();
				
		Assert.assertEquals(originalttpFee, expectedttpFee);		
	}
	
	
	@Test (description = "Verify if for case1 Total Payment matches", priority = 4)
	public void case1tPayment() throws InterruptedException
	{
		String expectedtPayment = "109,643";
		String originaltPayment = driver.findElementByXPath("//android.widget.TextView[@resource-id = 'com.continuum.emi.calculator:id/total_payment_result']").getText();
				
		Assert.assertEquals(originaltPayment, expectedtPayment);		
	}
	
	
	// Now starting to test Case 2 -----------------------------------------------------------------------------------------
	
	@Test (description = "Verify if for case2 monthly EMI matches", priority = 5)
	public void case2mEMI() throws InterruptedException
	{

		driver.findElementByXPath("//android.widget.ImageView").click();
		
		Thread.sleep(2000);

		driver.findElementByXPath("//android.widget.Button[@resource-id = 'com.continuum.emi.calculator:id/btnReset']").click();
		
		Thread.sleep(2000);

		driver.findElementByXPath("//android.widget.EditText[@resource-id = 'com.continuum.emi.calculator:id/etLoanAmount']").sendKeys("325000");
		driver.findElementByXPath("//android.widget.EditText[@resource-id = 'com.continuum.emi.calculator:id/etInterest']").sendKeys("9.5");
		driver.findElementByXPath("//android.widget.EditText[@text = 'Years']").sendKeys("5");
		driver.findElementByXPath("//android.widget.EditText[@resource-id = 'com.continuum.emi.calculator:id/etFee']").sendKeys("1.5");

		driver.findElementByXPath("//android.widget.Button[@resource-id = 'com.continuum.emi.calculator:id/btnCalculate']").click();
		driver.findElementByXPath("//android.widget.Button[@resource-id = 'com.continuum.emi.calculator:id/btnDetail']").click();

		Thread.sleep(2000);

		String expectedmEMI = "6,826";
		String originalmEMI = driver.findElementByXPath("//android.widget.TextView[@resource-id = 'com.continuum.emi.calculator:id/monthly_emi_result']").getText();
				
		Assert.assertEquals(originalmEMI, expectedmEMI);		
	}
	
	@Test (description = "Verify if for case2 Total Interest matches", priority = 6)
	public void case2tInterest() throws InterruptedException
	{
		String expectedtInterest = "84,536";
		String originaltInterest = driver.findElementByXPath("//android.widget.TextView[@resource-id = 'com.continuum.emi.calculator:id/total_interest_result']").getText();
				
		Assert.assertEquals(originaltInterest, expectedtInterest);		
	}
	
	@Test (description = "Verify if for case2 Processing Fee matches", priority = 7)
	public void case2tpFee() throws InterruptedException
	{
		String expectedttpFee = "4,875";
		String originalttpFee = driver.findElementByXPath("//android.widget.TextView[@resource-id = 'com.continuum.emi.calculator:id/processing_fee_result']").getText();
				
		Assert.assertEquals(originalttpFee, expectedttpFee);		
	}
	
	
	@Test (description = "Verify if for case2 Total Payment matches", priority = 8)
	public void case2tPayment() throws InterruptedException
	{
		String expectedtPayment = "409,536";
		String originaltPayment = driver.findElementByXPath("//android.widget.TextView[@resource-id = 'com.continuum.emi.calculator:id/total_payment_result']").getText();
				
		Assert.assertEquals(originaltPayment, expectedtPayment);		
	}
	
	
	// Now starting to test Case 3 -----------------------------------------------------------------------------------------

	
	@Test (description = "Verify if for case3 monthly EMI matches", priority = 9)
	public void case3mEMI() throws InterruptedException
	{

		driver.findElementByXPath("//android.widget.ImageView").click();
		
		Thread.sleep(2000);

		driver.findElementByXPath("//android.widget.Button[@resource-id = 'com.continuum.emi.calculator:id/btnReset']").click();
		
		Thread.sleep(2000);

		driver.findElementByXPath("//android.widget.EditText[@resource-id = 'com.continuum.emi.calculator:id/etLoanAmount']").sendKeys("450000");
		driver.findElementByXPath("//android.widget.EditText[@resource-id = 'com.continuum.emi.calculator:id/etInterest']").sendKeys("11.0");
		driver.findElementByXPath("//android.widget.EditText[@text = 'Years']").sendKeys("7");
		driver.findElementByXPath("//android.widget.EditText[@resource-id = 'com.continuum.emi.calculator:id/etFee']").sendKeys("1.8");

		driver.findElementByXPath("//android.widget.Button[@resource-id = 'com.continuum.emi.calculator:id/btnCalculate']").click();
		driver.findElementByXPath("//android.widget.Button[@resource-id = 'com.continuum.emi.calculator:id/btnDetail']").click();

		Thread.sleep(2000);

		String expectedmEMI = "7,705";
		String originalmEMI = driver.findElementByXPath("//android.widget.TextView[@resource-id = 'com.continuum.emi.calculator:id/monthly_emi_result']").getText();
				
		Assert.assertEquals(originalmEMI, expectedmEMI);		
	}
	
	@Test (description = "Verify if for case3 Total Interest matches", priority = 10)
	public void case3tInterest() throws InterruptedException
	{
		String expectedtInterest = "197,228";
		String originaltInterest = driver.findElementByXPath("//android.widget.TextView[@resource-id = 'com.continuum.emi.calculator:id/total_interest_result']").getText();
				
		Assert.assertEquals(originaltInterest, expectedtInterest);		
	}
	
	@Test (description = "Verify if for case3 Processing Fee matches", priority = 11)
	public void case3tpFee() throws InterruptedException
	{
		String expectedttpFee = "8,100";
		String originalttpFee = driver.findElementByXPath("//android.widget.TextView[@resource-id = 'com.continuum.emi.calculator:id/processing_fee_result']").getText();
				
		Assert.assertEquals(originalttpFee, expectedttpFee);		
	}
	
	
	@Test (description = "Verify if for case3 Total Payment matches", priority = 12)
	public void case3tPayment() throws InterruptedException
	{
		String expectedtPayment = "647,228";
		String originaltPayment = driver.findElementByXPath("//android.widget.TextView[@resource-id = 'com.continuum.emi.calculator:id/total_payment_result']").getText();
				
		Assert.assertEquals(originaltPayment, expectedtPayment);		
	}	
	
	
	// Now starting to test Case 4 -----------------------------------------------------------------------------------------

	
	@Test (description = "Verify if for case4 monthly EMI matches", priority = 13)
	public void case4mEMI() throws InterruptedException
	{

		driver.findElementByXPath("//android.widget.ImageView").click();
		
		Thread.sleep(2000);

		driver.findElementByXPath("//android.widget.Button[@resource-id = 'com.continuum.emi.calculator:id/btnReset']").click();
		
		Thread.sleep(2000);

		driver.findElementByXPath("//android.widget.EditText[@resource-id = 'com.continuum.emi.calculator:id/etLoanAmount']").sendKeys("99000000");
		driver.findElementByXPath("//android.widget.EditText[@resource-id = 'com.continuum.emi.calculator:id/etInterest']").sendKeys("10.0");
		driver.findElementByXPath("//android.widget.EditText[@text = 'Years']").sendKeys("4");
		driver.findElementByXPath("//android.widget.EditText[@resource-id = 'com.continuum.emi.calculator:id/etFee']").sendKeys("1.25");

		driver.findElementByXPath("//android.widget.Button[@resource-id = 'com.continuum.emi.calculator:id/btnCalculate']").click();
		driver.findElementByXPath("//android.widget.Button[@resource-id = 'com.continuum.emi.calculator:id/btnDetail']").click();

		Thread.sleep(2000);

		String expectedmEMI = "2,510,896";
		String originalmEMI = driver.findElementByXPath("//android.widget.TextView[@resource-id = 'com.continuum.emi.calculator:id/monthly_emi_result']").getText();
				
		Assert.assertEquals(originalmEMI, expectedmEMI);		
	}
	
	@Test (description = "Verify if for case4 Total Interest matches", priority = 14)
	public void case4tInterest() throws InterruptedException
	{
		String expectedtInterest = "21,522,996";
		String originaltInterest = driver.findElementByXPath("//android.widget.TextView[@resource-id = 'com.continuum.emi.calculator:id/total_interest_result']").getText();
				
		Assert.assertEquals(originaltInterest, expectedtInterest);		
	}
	
	@Test (description = "Verify if for case4 Processing Fee matches", priority = 15)
	public void case4tpFee() throws InterruptedException
	{
		String expectedttpFee = "1,237,500";
		String originalttpFee = driver.findElementByXPath("//android.widget.TextView[@resource-id = 'com.continuum.emi.calculator:id/processing_fee_result']").getText();
				
		Assert.assertEquals(originalttpFee, expectedttpFee);		
	}
	
	
	@Test (description = "Verify if for case4 Total Payment matches", priority = 16)
	public void case4tPayment() throws InterruptedException
	{
		String expectedtPayment = "120,522,996";
		String originaltPayment = driver.findElementByXPath("//android.widget.TextView[@resource-id = 'com.continuum.emi.calculator:id/total_payment_result']").getText();
				
		Assert.assertEquals(originaltPayment, expectedtPayment);		
	}		
	
	
	
	// Now starting to test Case 5 -----------------------------------------------------------------------------------------

	
	@Test (description = "Verify if for case5 monthly EMI matches", priority = 17)
	public void case5mEMI() throws InterruptedException
	{

		driver.findElementByXPath("//android.widget.ImageView").click();
		
		Thread.sleep(2000);

		driver.findElementByXPath("//android.widget.Button[@resource-id = 'com.continuum.emi.calculator:id/btnReset']").click();
		
		Thread.sleep(2000);

		driver.findElementByXPath("//android.widget.EditText[@resource-id = 'com.continuum.emi.calculator:id/etLoanAmount']").sendKeys("50000");
		driver.findElementByXPath("//android.widget.EditText[@resource-id = 'com.continuum.emi.calculator:id/etInterest']").sendKeys("12.0");
		driver.findElementByXPath("//android.widget.EditText[@text = 'Years']").sendKeys("9");
		driver.findElementByXPath("//android.widget.EditText[@resource-id = 'com.continuum.emi.calculator:id/etFee']").sendKeys("2.2");

		driver.findElementByXPath("//android.widget.Button[@resource-id = 'com.continuum.emi.calculator:id/btnCalculate']").click();
		driver.findElementByXPath("//android.widget.Button[@resource-id = 'com.continuum.emi.calculator:id/btnDetail']").click();

		Thread.sleep(2000);

		String expectedmEMI = "759";
		String originalmEMI = driver.findElementByXPath("//android.widget.TextView[@resource-id = 'com.continuum.emi.calculator:id/monthly_emi_result']").getText();
				
		Assert.assertEquals(originalmEMI, expectedmEMI);		
	}
	
	@Test (description = "Verify if for case5 Total Interest matches", priority = 18)
	public void case5tInterest() throws InterruptedException
	{
		String expectedtInterest = "31,995";
		String originaltInterest = driver.findElementByXPath("//android.widget.TextView[@resource-id = 'com.continuum.emi.calculator:id/total_interest_result']").getText();
				
		Assert.assertEquals(originaltInterest, expectedtInterest);		
	}
	
	@Test (description = "Verify if for case5 Processing Fee matches", priority = 19)
	public void case5tpFee() throws InterruptedException
	{
		String expectedttpFee = "1,100";
		String originalttpFee = driver.findElementByXPath("//android.widget.TextView[@resource-id = 'com.continuum.emi.calculator:id/processing_fee_result']").getText();
				
		Assert.assertEquals(originalttpFee, expectedttpFee);		
	}
	
	
	@Test (description = "Verify if for case5 Total Payment matches", priority = 20)
	public void case5tPayment() throws InterruptedException
	{
		String expectedtPayment = "81,995";
		String originaltPayment = driver.findElementByXPath("//android.widget.TextView[@resource-id = 'com.continuum.emi.calculator:id/total_payment_result']").getText();
				
		Assert.assertEquals(originaltPayment, expectedtPayment);		
	}		
	
		
	
	
	
}
