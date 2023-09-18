package ru.yandex.praktikum.pageObject;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AboutScooterRentPage {
    private final WebDriver driver;

    //Текст заголовка
    private final By headerTitle = By.className("Order_Header__BZXOb");

    //Поле "Когда привезти самокат"
    private final By fieldDate = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    //Поле "Срок аренды"
    private final By fieldRentalTime = By.xpath(".//div[@class='Dropdown-control']");
    //Заготовка для выбора срока аренды в выпадающем списке
    private final String RentalTime = ".//div[@class='Dropdown-menu']/div[%s]";
    //Поле "Цвет самоката: Черный жемчуг"
    private final By checkBoxBlack = By.xpath(".//label[@for='black']");
    //Поле "Цвет самоката: Серая безысходность"
    private final By checkBoxGrey = By.xpath(".//label[@for='grey']");
    //Кнопка "Заказать"
    private final By buttonCreateOrder = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");


    public AboutScooterRentPage (WebDriver driver){

        this.driver = driver;
    }

    //Метод ожидания загрузки страницы
    public AboutScooterRentPage waitLoadAboutScooterPage() {
        new WebDriverWait(driver, 3).until(driver -> (driver.findElement(headerTitle).getText() != null
                && !driver.findElement(headerTitle).getText().isEmpty()
        ));
        return this;
    }
    //Метод ввода даты
    public AboutScooterRentPage setDate(String date){
        driver.findElement(fieldDate).sendKeys(date);
        driver.findElement(fieldDate).sendKeys(Keys.RETURN);

        return this;
    }
    //Метод выбора времени аренды
    public AboutScooterRentPage setRentalTime(int howDay){
        driver.findElement(fieldRentalTime).click();
        String xpathRentTime = String.format(RentalTime, howDay);
        driver.findElement(By.xpath(xpathRentTime)).click();
        return this;

    }
    //Метод выбора цвета
    public AboutScooterRentPage setColor(String color){
        if (color.equals("black")){
            driver.findElement(checkBoxBlack).click();
        }
        else if(color.equals("grey")){
            driver.findElement(checkBoxGrey).click();
        }
        return this;
    }
    //Клик по кнопке "Заказать"
    public void clickButtonCreateOrder(){
        driver.findElement(buttonCreateOrder).click();
    }
}
