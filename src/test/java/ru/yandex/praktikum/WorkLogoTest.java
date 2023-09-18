package ru.yandex.praktikum;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.praktikum.config.BeforeAndAfterBaseClass;
import ru.yandex.praktikum.pageObject.MainPage;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static ru.yandex.praktikum.pageObject.constants.ConstantsMainPage.MAIN_PAGE;

public class WorkLogoTest extends BeforeAndAfterBaseClass {

    @Test
    public void checkScooterLogo(){
        new MainPage(getDriver())
                .waitLoadMainPage()
                .clickScooterLogo();
        assertEquals(MAIN_PAGE,getDriver().getCurrentUrl());

    }

    @Test
    public void checkYandexLogo(){
        new MainPage(getDriver())
                .waitLoadMainPage()
                .clickYandexLogo();
        ArrayList<String> tabs = new ArrayList<String> (getDriver().getWindowHandles());
        getDriver().switchTo().window(tabs.get(1));
        new WebDriverWait(getDriver(), 3).until(driver ->
                (driver.findElement(By.xpath(".//div[text()='Новости']")).getText() != null
                && !driver.findElement(By.xpath(".//div[text()='Новости']")).getText().isEmpty()
        ));
        assertEquals("https://dzen.ru/?yredirect=true",getDriver().getCurrentUrl());
    }
}
