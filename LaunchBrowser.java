import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LaunchBrowser {

	public static void main(String[] args) {
		
		ChromeOptions option = new ChromeOptions();
        
		option.addArguments("--remote-allow-origins=*");
        option.addArguments("start-maximized");
        option.addArguments("--incognito");
        option.addArguments("--headless");
        option.addArguments("window-size=360,740");
		
        WebDriver driver = new ChromeDriver(option);
		
		String Google = "https://www.google.com";
		
		String Facebook = "https://www.facebook.com";
		
		driver.get(Google);
		
		driver.get("https://www.google.com");
		System.out.println("User successfully navigate to Google Page");
		
		driver.navigate().to(Facebook);
		System.out.println("User successfully navigate to Facebook Page");

		driver.navigate().back();
		
		driver.navigate().forward();
		
		
		driver.navigate().refresh();
		System.out.println("Page get Refreshed successfully");
		
	//	driver.close();
	}

}
