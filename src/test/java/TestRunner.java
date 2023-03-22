import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.DriverUtil;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.openqa.selenium.By.*;

public class TestRunner {

    private static ChromeDriver chromeDriver;
    private static DriverUtil driverUtil;
    private static final String URL = "https://www.google.com/";



    @BeforeAll
    public static void beforeAll() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        chromeDriver = new ChromeDriver(options);
        driverUtil = new DriverUtil(chromeDriver);

    }
    By searchBox=cssSelector("body > div.L3eUgb > div.o3j99.ikrT4e.om7nvf > form > div:nth-child(1) > div.A8SBwf > div.RNNXgb > div > div.a4bIc > input");
    By cookie=className("truste-button1");
    By accetta=cssSelector("#L2AGLb > div");
    By main=id("res");
    By mainClass=className("v7W49e");

    @BeforeEach
    public void beforeEach() {
        chromeDriver.get(URL);
        driverUtil.findElement(accetta).click();
        driverUtil.findElement(searchBox).sendKeys("samsung s23\n");

        WebElement element = driverUtil.findElement(main);
        List<WebElement> listSamsung =element.findElements(mainClass);
        for (WebElement samsungList:listSamsung ) {
            if(samsungList.getText().contains("https://www.samsung.com/it/smartphones/galaxy-s23/buy")) {
                    samsungList.click();
            }  
        }
       WebElement aCookie=driverUtil.findElement(cookie);
       if (aCookie.getText().contains("Accetta i Cookie")) {
           aCookie.click();
           System.out.println("clicked");
       }
    }

    @AfterAll
    public static void afterAll() {
        //chromeDriver.close();

    }


    public static DriverUtil getDriverUtil() {
        return driverUtil;
    }
}









