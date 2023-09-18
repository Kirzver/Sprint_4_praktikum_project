package ru.yandex.praktikum.config;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static ru.yandex.praktikum.pageObject.constants.ConstantsMainPage.MAIN_PAGE;

public abstract class BeforeAndAfterBaseClass {
    private WebDriver driver;
    @Before
    public void start() {
        driver = new ChromeDriver();
        driver.get(MAIN_PAGE);
    }

    public WebDriver getDriver(){
        return driver;
    }

    @After
    public void teardown(){
        driver.quit();
    }
}
