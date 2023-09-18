package ru.yandex.praktikum.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


public class AboutClientPage {

    private final WebDriver driver;
    //Текст заголовка
    private final By headerTitle = By.className("Order_Header__BZXOb");
    //Поле "Имя"
    private final By fieldName = By.xpath(".//input[@placeholder='* Имя']");
    //Поле "Фамилия"
    private final By fieldSurname = By.xpath(".//input[@placeholder='* Фамилия']");
    //Поле "Адрес"
    private final By fieldAddress = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    //Поле "Станция метро"
    private final By fieldStation = By.xpath(".//input[@class='select-search__input']");
    //Выпадающий список станций
    private final By listStation = By.xpath(".//div[@class='select-search__select']");
    //Поле "Телефон"
    private final By fieldPhoneNumber = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    //Кнопка "Далее"
    private final By buttonNext = By.xpath(".//button[text()='Далее']");

    public AboutClientPage (WebDriver driver){

        this.driver = driver;
    }

    //Метод ожидания загрузки страницы
    public AboutClientPage waitLoadAboutClientPage(){
        new WebDriverWait(driver, 3).until(driver -> (driver.findElement(headerTitle).getText() != null
                && !driver.findElement(headerTitle).getText().isEmpty()
        ));
        return this;
    }

    //Метод ввода имени
    public AboutClientPage setName(String name){
        driver.findElement(fieldName).sendKeys(name);
        return this;
    }
    //Метод ввода фамилии
    public AboutClientPage setSurname(String surname){
        driver.findElement(fieldSurname).sendKeys(surname);
        return this;
    }
    //Метод ввода адреса
    public AboutClientPage setAddress(String address){
        driver.findElement(fieldAddress).sendKeys(address);
        return this;
    }
    //Метод ввода станции метро
    public AboutClientPage setStation(String station){
        driver.findElement(fieldStation).click();
        driver.findElement(fieldStation).sendKeys(station);
        driver.findElement(listStation).click();
        return this;

    }
    //Метод ввода телефона
    public AboutClientPage setPhoneNumber(String phoneNumber){
        driver.findElement(fieldPhoneNumber).sendKeys(phoneNumber);
        return this;
    }
    //Метод клика на кнопку "Далее"
    public void clickButtonNext(){
        driver.findElement(buttonNext).click();
    }
}
