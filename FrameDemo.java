import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FrameDemo {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new FirefoxDriver();
		driver.get("https://demo.guru99.com/test/guru99home/");
		driver.manage().window().maximize();
		
		String MainWindow = driver.getWindowHandle();
		
		WebElement YouTubeFrame = driver.findElement(By.xpath("//iframe[contains(@src,'youtube')]"));
	//  Frame find by using WebElement	
	    driver.switchTo().frame(YouTubeFrame);
	    
	//  Frame find by using Index    
	//	driver.switchTo().frame(7);
		Thread.sleep(2000);
		
		WebElement PlayBtn = driver.findElement(By.xpath("//button[@aria-label='Play']"));
		
		PlayBtn.click();
		
		Thread.sleep(2000);
		
		WebElement PauseBtn = driver.findElement(By.xpath("//button[@title='Pause (k)']"));
		PauseBtn.click();
	
		driver.switchTo().parentFrame();
	//	driver.switchTo().window(MainWindow);
		// Frame find by using Name or ID Attribute
		driver.switchTo().frame("a077aa5e");
		
		WebElement JmeterImg = driver.findElement(By.xpath("//img[@src='Jmeter720.png']"));
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", JmeterImg);
	//	JmeterImg.click();
	}

}
