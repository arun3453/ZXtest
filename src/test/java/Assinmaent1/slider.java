package Assinmaent1;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class slider {

	public static WebDriver driver;
	public static Actions mov;
	public static JavascriptExecutor js;
	@BeforeClass
	private void start() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}
	@AfterClass
	private void end() {
		driver.close();
	}
	@BeforeMethod
	private void befmet() {
		Date d=new Date();
		System.out.println("=====" +d);
	}
	@AfterMethod
	private void aftmet(ITestResult r) {
		Date d=new Date();
		System.out.println("=====" +d);}

	@Test
	private void test1() throws InterruptedException, AWTException {

		driver.get("https://mui.com/material-ui/react-slider/");
		WebElement mo = driver.findElement(By.xpath("//h2[@id='continuous-sliders']"));
		WebElement slidbutton = driver.findElement(By.xpath("(//span[@class='MuiSlider-root MuiSlider-colorPrimary MuiSlider-sizeMedium css-exkjcx'])[1]"));

		js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)", mo);

		Thread.sleep(2000);
	    mov=new Actions(driver);
		mov.moveToElement(slidbutton).click(slidbutton).build().perform();
		Thread.sleep(1000);
		Robot r=new Robot();
		for(int i=0;i<5;i++) {
			Thread.sleep(1000);
			r.keyPress(KeyEvent.VK_RIGHT);
			Thread.sleep(1000);
			r.keyRelease(KeyEvent.VK_RIGHT);	
			System.out.println("test 1 done");

		}
		Thread.sleep(5000);

	}

	@Test
	private void test2() throws InterruptedException {
		driver.navigate().to("https://mui.com/material-ui/react-toggle-button/");
		WebElement siztext = driver.findElement(By.xpath("//h2[contains(text(),'Size')]"));
		WebElement centerbutt = driver.findElement(By.xpath("(//button[@value='center'])[2]"));
		WebElement rightbutt = driver.findElement(By.xpath("(//button[@value='right'])[2]"));
		WebElement justybutt = driver.findElement(By.xpath("(//button[@value='justify'])[2]"));

        js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)", siztext);
	    mov=new Actions(driver);
	    Thread.sleep(2000);
	    if(centerbutt.isEnabled()) {
		mov.moveToElement(centerbutt).click(centerbutt).build().perform();
		System.out.println("test 2 done");
	    }else {
	    	System.out.println("test 2 not done");
	    }
		Thread.sleep(2000);
		mov.moveToElement(rightbutt).click(rightbutt).build().perform();
		Thread.sleep(2000);
		mov.moveToElement(justybutt).click(justybutt).build().perform();
		
	}
	@Test
	private void test3() throws InterruptedException {
		driver.get("https://mui.com/material-ui/react-checkbox/");
		WebElement colour = driver.findElement(By.xpath("//h2[@id='color']"));
		WebElement checkb1 = driver.findElement(By.xpath("(//div[@id='demo-:Rtal6kud6:']//input[@class='PrivateSwitchBase-input css-1m9pwf3'])[1]"));
		WebElement checkb2 = driver.findElement(By.xpath("(//div[@id='demo-:Rtal6kud6:']//input[@class='PrivateSwitchBase-input css-1m9pwf3'])[2]"));
		WebElement checkb3 = driver.findElement(By.xpath("(//div[@id='demo-:Rtal6kud6:']//input[@class='PrivateSwitchBase-input css-1m9pwf3'])[3]"));
		WebElement checkb4 = driver.findElement(By.xpath("(//div[@id='demo-:Rtal6kud6:']//input[@class='PrivateSwitchBase-input css-1m9pwf3'])[4]"));
		WebElement checkb5 = driver.findElement(By.xpath("(//div[@id='demo-:Rtal6kud6:']//input[@class='PrivateSwitchBase-input css-1m9pwf3'])[5]"));
	    js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)", colour);
		Thread.sleep(2000);
		if(checkb1.isEnabled()) {
		checkb1.click();
		System.out.println("test3 done");
		}
		else {
			System.out.println("not select");
		}
		checkb2.click();
		checkb3.click();
		checkb4.click();
		checkb5.click();
		Thread.sleep(4000);
		
		
	}
	@Test
	private void test4() throws InterruptedException {
		driver.get("https://mui.com/material-ui/react-autocomplete/");
		
		WebElement playground = driver.findElement(By.xpath("//h3[text()='Playground']"));
		WebElement dropd2 = driver.findElement(By.xpath("(//div[@class='css-16bgbro'])[2]//input[@id='clear-on-escape']"));
		WebElement dropd3 = driver.findElement(By.xpath("(//div[@class='css-16bgbro'])[2]//input[@id='disable-clearable']"));

	    js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)", playground);

	    
	    Thread.sleep(2000);
	    mov.moveToElement(dropd2).click(dropd2).build().perform();
	    Thread.sleep(2000);
		WebElement  interstller = driver.findElement(By.xpath("//ul[@class='MuiAutocomplete-listbox css-ue1yok']//li[text()='Interstellar']"));
	    mov.moveToElement(interstller).click(interstller).sendKeys(Keys.ENTER).build().perform();
	    Thread.sleep(3000);
	    String text = dropd2.getAttribute("Value");
	    System.out.println(text);
	        
		
		Thread.sleep(2000);
	    mov.moveToElement(dropd3).click(dropd3).build().perform();
	    Thread.sleep(1000); 
		WebElement  dangal = driver.findElement(By.xpath("//ul[@class='MuiAutocomplete-listbox css-ue1yok']//li[text()='Dangal']"));	 
	    mov.moveToElement(dangal).doubleClick(dangal).sendKeys(Keys.ENTER).build().perform();
	    Thread.sleep(3000);
	    String text2 = dropd3.getAttribute("Value");
	    System.out.println(text2);
	    System.out.println("test 4 done");
	    

	    
	    
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
