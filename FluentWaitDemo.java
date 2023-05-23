import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class FluentWaitDemo {

	public static void main(String[] args) {
		
		ChromeOptions option = new ChromeOptions();
        
		option.addArguments("--remote-allow-origins=*");
        option.addArguments("--incognito");
      
		WebDriver driver = new ChromeDriver(option);
		driver.get("https://demoqa.com/dynamic-properties");
		driver.manage().window().maximize();
		
		
		// Fluent Wait (Explicit Wait)
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(60))
				.pollingEvery(Duration.ofSeconds(10))
				.ignoring(TimeoutException.class);
		
		WebElement EnableAfterBtn = driver.findElement(By.xpath("//button[@id='enableAfter']"));
		WebElement ColourChangeBtn = driver.findElement(By.xpath("//button[@id='colorChange']"));
		
		System.out.println("Enable After Button is Before Enabled "+EnableAfterBtn.isEnabled());
		System.out.println("Colour Change Button Colour CSS Value " +ColourChangeBtn.getCssValue("color"));

	//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='visibleAfter']")));
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='visibleAfter1']"))).isDisplayed();
		
		
		System.out.println("Enable After Button is After Enabled "+EnableAfterBtn.isEnabled());
		System.out.println("Colour Change Button Colour After 5 Seconds CSS Value " +ColourChangeBtn.getCssValue("color"));
		
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("alert('Welcome to Utkarshaa Academy')");
		wait.until(ExpectedConditions.alertIsPresent()).accept();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Radio Button']"))).isDisplayed();
		WebElement RadioBtn = driver.findElement(By.xpath("//span[text()='Radio Button']"));
		RadioBtn.isDisplayed();
	}

}
