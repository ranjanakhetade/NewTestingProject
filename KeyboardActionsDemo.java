import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class KeyboardActionsDemo {

	public static void main(String[] args) {
		
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(option);
		driver.get("https://demoqa.com/text-box");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		Actions act = new Actions(driver);
		
		WebElement UserName = driver.findElement(By.xpath("//input[@id='userName']"));
		act.sendKeys(UserName, "Ravi Nangre").perform();
		
		act.sendKeys(Keys.TAB).perform();
	//	act.keyDown(Keys.TAB).perform();
	//	act.keyUp(Keys.TAB).perform();
		
		act.sendKeys("ravinangre@gmail.com").perform();
		
		act.sendKeys(Keys.TAB).perform();
		act.sendKeys("At Post Lokhandi Sawargaon Tal Ambajogai Dist Beed Pin 431517").perform();
		
		act.keyDown(Keys.CONTROL).sendKeys("a").build().perform();
		
		act.keyUp(Keys.CONTROL).perform();
		
		act.keyDown(Keys.CONTROL).sendKeys("c").build().perform();
		
		act.keyUp(Keys.CONTROL).perform();
		
		act.sendKeys(Keys.TAB).perform();

		act.keyDown(Keys.CONTROL).sendKeys("v").build().perform();
		
		act.keyUp(Keys.CONTROL).perform();
		
		act.sendKeys(Keys.TAB).perform();

		act.sendKeys(Keys.ENTER).perform();
		
	}

}
