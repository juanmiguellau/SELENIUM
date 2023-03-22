import org.example.DriverUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.openqa.selenium.By.*;

public class CheckCartTest extends TestRunner{

    private final DriverUtil driverUtil = getDriverUtil();

    By galaxy = cssSelector("#bc-cross-navigation > div > div > ul > li.bc-cross-navigation-item.swiper-slide.swiper-slide-next > a");
    By totalPrice = cssSelector("#deviceSummary > div:nth-child(3) > span.hubble-product__summary-product-price.device-price-info");
    By modelCart=cssSelector("#deviceSummary > div:nth-child(1)");


    @Test
    public void checkCart() {

        try {

            WebElement chooseGalaxyCart=driverUtil.findElement(galaxy);
            if(chooseGalaxyCart.getText().contains("Galaxy S23 | S23+")) {
                chooseGalaxyCart.click();
            }

            WebElement priceTotal =driverUtil.findElement(totalPrice);
            Assertions.assertEquals("1.349,00 €",priceTotal.getText());

            WebElement modelPhone=driverUtil.findElement(modelCart);
            Assertions.assertEquals("Galaxy S23+",modelPhone.getText());

        } catch (Exception ex) {
            System.out.println("element not found");
            Assertions.fail("Test not completed");
        }
    }




}
