import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.DriverUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.openqa.selenium.By.*;

public class CheckProductTest extends TestRunner {

    private final DriverUtil driverUtil = getDriverUtil();


    By galaxy = cssSelector("#bc-cross-navigation > div > div > ul > li.bc-cross-navigation-item.swiper-slide.swiper-slide-next > a");
    By s23=cssSelector("#device > div.hubble-product__options-content > ul > li:nth-child(2) > div.s-option-box.hubble-pd-radio.js-radio-wrap.is-checked > label > span.s-label > span");
    By s512=cssSelector("#storage > div.hubble-product__options-content > ul > li:nth-child(3) > div.s-option-box.hubble-pd-radio.js-radio-wrap.is-checked > label > span.s-label > span");

    @Test
    public void selectProduct() {


        try {
            WebElement chooseGalaxy=driverUtil.findElement(galaxy);
           if(chooseGalaxy.getText().contains("Galaxy S23 | S23+")) {
               chooseGalaxy.click();
           }
            WebElement memoryItem=driverUtil.findElement(s512);
            boolean galaxyMemory = memoryItem.isEnabled();
            Assertions.assertTrue(galaxyMemory);
            boolean memoryGalaxy=memoryItem.getText().contains("512GB | 8GB\n" +
                    "44,97 € al mese per 30 mesi o\n" +
                    "1.349,00 €");
            Assertions.assertTrue(memoryGalaxy);


            WebElement modelItem=driverUtil.findElement(s23);
            boolean galaxyModel = modelItem.isEnabled();
            Assertions.assertTrue(galaxyModel);
            boolean modelGalaxy=modelItem.getText().contains("Galaxy S23+\n" +
                    "A partire da 44,97 € al mese per 30 mesi o\n" +
                    "1.349,00 €");
            Assertions.assertTrue(modelGalaxy);
        } catch (Exception ex) {
            System.out.println("element not found");
            Assertions.fail("Test not completed");
        }
    }
}