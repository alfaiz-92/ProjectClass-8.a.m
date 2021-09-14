package org.hexa;

import java.util.Date;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Sample {

	static WebDriver driver;
	JavascriptExecutor js = (JavascriptExecutor) driver;

	@BeforeClass
	public static void launchBrowser() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.get("https://adactinhotelapp.com/");
	}

	@BeforeMethod
	public void StartTimeOfTest() {
		Date d = new Date();
		System.out.println(d);
		System.out.println("Test Start");

	}

	@AfterMethod
	public void testEnd() {
		System.out.println("Test End");
		Date d = new Date();
		System.out.println(d);

	}

	@Test

	public void loginPages() throws InterruptedException {

		WebElement txtUsr = driver.findElement(By.name("username"));
		txtUsr.sendKeys("appletech");

		WebElement txtPass = driver.findElement(By.name("password"));

		txtPass.sendKeys("5M16UT");
		WebElement btnLogin = driver.findElement(By.name("login"));
		btnLogin.click();
	}

	@Test(priority = 3)
	public void searchingPage() {

		WebElement drpLocationSelector = driver.findElement(By.name("location"));
		Select select = new Select(drpLocationSelector);
		select.selectByValue("Paris");

		WebElement drpHotelSelector = driver.findElement(By.name("hotels"));
		Select select1 = new Select(drpHotelSelector);
		select1.selectByValue("Hotel Hervey");

		WebElement roomType = driver.findElement(By.name("room_type"));
		Select select2 = new Select(roomType);
		select2.selectByValue("Deluxe");

		WebElement roomNos = driver.findElement(By.name("room_nos"));
		Select select3 = new Select(roomNos);
		select3.selectByValue("4");

		WebElement datePicin = driver.findElement(By.name("datepick_in"));
		datePicin.sendKeys("19/08/2021");

		WebElement datePickOut = driver.findElement(By.name("datepick_out"));
		datePickOut.sendKeys("22/08/2021");
		WebElement adultRoom = driver.findElement(By.name("adult_room"));
		Select select4 = new Select(adultRoom);
		select4.selectByValue("3");

		WebElement childRoom = driver.findElement(By.name("child_room"));
		Select select5 = new Select(childRoom);
		select5.selectByValue("4");

		WebElement searchBtn = driver.findElement(By.name("Submit"));
		searchBtn.click();

		WebElement rd_Btn = driver.findElement(By.name("radiobutton_0"));
		rd_Btn.click();

		WebElement continue_Btn = driver.findElement(By.name("continue"));
		continue_Btn.click();
	}

	@Test(priority = 4)
	private void confirmationPage() {

		WebElement fst_Name = driver.findElement(By.name("first_name"));
		fst_Name.sendKeys("Mohamed");
		WebElement lst_Name = driver.findElement(By.name("last_name"));
		lst_Name.sendKeys("Alfaiz");
		WebElement address = driver.findElement(By.name("address"));
		address.sendKeys("No:01,Majestic nagar pondicherry");
		WebElement card_Number = driver.findElement(By.name("cc_num"));
		card_Number.sendKeys("2323434565656567");
		WebElement card_Type = driver.findElement(By.name("cc_type"));
		Select ccType = new Select(card_Type);
		ccType.selectByValue("VISA");
		WebElement cardExpiryDate = driver.findElement(By.name("cc_exp_month"));
		Select ccExpiryDate = new Select(cardExpiryDate);
		ccExpiryDate.selectByValue("2");
		WebElement cardExpiryYear = driver.findElement(By.name("cc_exp_year"));
		Select ccExpiryYear = new Select(cardExpiryYear);
		ccExpiryYear.selectByValue("2022");

		WebElement cvv = driver.findElement(By.name("cc_cvv"));
		cvv.sendKeys("454");

		WebElement submit = driver.findElement(By.name("book_now"));
		submit.click();

		WebElement scrollDown = driver.findElement(By.name("order_no"));
		js.executeScript("arguments[0].scrollIntoView(true)", scrollDown);
	}

	@Test(priority = 5)
	private void orderId() {
		WebElement orderNumber = driver.findElement(By.id("order_no"));
		String text = orderNumber.getAttribute("value");
		System.out.println("Order ID:" + text);
	}

	@AfterClass
	private void closingBrowser1() {
		driver.quit();
	}

}
