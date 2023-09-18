package ru.yandex.praktikum.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ConfirmOrderPopUp {
    private final WebDriver driver;

    //Текст заголовка подтверждения заказа
    private final By headerTitle= By.xpath(".//div[@class='Order_ModalHeader__3FDaJ']");

    //Кнопка "Да"
    private final By buttonYes = By.xpath(".//button[text()='Да']");

    public ConfirmOrderPopUp(WebDriver driver) {

        this.driver = driver;
    }

    //Метод ожидания загрузки страницы
    public ConfirmOrderPopUp waitLoadConfirmOrderPopUp() {
        new WebDriverWait(driver, 3).until(driver -> (driver.findElement(headerTitle).getText() != null
                && !driver.findElement(headerTitle).getText().isEmpty()
        ));
        return this;
    }
    //Метод нажатия на кнопку "Да"
    public void clickButtonYes(){
        driver.findElement(buttonYes).click();
    }

    //Получить текст-заголовка после оформления заказа
    public String getTextFromHeaderTitle(){
        return driver.findElement(headerTitle).getText();
    }
}
