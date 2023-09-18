package ru.yandex.praktikum.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
    private final WebDriver driver;

    //Лого "Яндекс"
    private final By logoYandex = By.xpath(".//img[@alt='Yandex']");

    //Лого "Самокат"
    private final By logoScooter = By.xpath(".//img[@alt='Scooter']");

    // Текст в заголовке
    private final By headerTitle = By.xpath(".//div[@class='Home_Header__iJKdX']");

    //Кнопка "Заказать в углу"
    private final By buttonOrderInCorner = By.xpath(".//button[@class='Button_Button__ra12g']");

    //Кнопка "Заказать в центре"
    private final By buttonOrderInCenter = By.xpath(".//div[@class='Home_FinishButton__1_cWm']/button");

    // Разворачиваемый список с вопросами
    private final By listQuestions = By.xpath(".//div[@class='accordion']");


    public MainPage(WebDriver driver){

        this.driver = driver;
    }

    //Метод ожидания загрузки главной страницы
    public MainPage waitLoadMainPage(){
        new WebDriverWait(driver, 3).until(driver -> (driver.findElement(headerTitle).getText() != null
                && !driver.findElement(headerTitle).getText().isEmpty()
        ));
        return this;
    }
    //Метод прокрутки страницы до списка с вопросами
    public MainPage findListQuestions(){
        WebElement element = driver.findElement(listQuestions);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        return this;
    }
    //Метод клика на вопрос
    public MainPage clickOnQuestion(By xpathQuestion){

        driver.findElement(xpathQuestion).click();
        return this;
    }
    //Метод ожидания загрузки ответа
    public MainPage waitLoadAnswer(By xpathAnswer){
        new WebDriverWait(driver, 3).until(driver -> (driver.findElement((xpathAnswer)).getText() != null
                && !driver.findElement(xpathAnswer).getText().isEmpty()
        ));
        return this;
    }
    //Метод получения текста ответа
    public String getAnswerText(By xpathAnswer){
        return driver.findElement(xpathAnswer).getText();

    }
    //Метод нажатия на логотип самоката
    public void clickScooterLogo(){
        driver.findElement(logoScooter).click();
    }
    //Метод нажатия на логотип яндекса
    public void clickYandexLogo(){
        driver.findElement(logoYandex).click();
    }

    //Метод нажатия на кнопку "Заказать" в левом углу
    public void clickOnOrderButtonInCorner(){

        driver.findElement(buttonOrderInCorner).click();
        //return this;
    }
    //Метод прокрутки страницы и клику по кнопке "Заказать" в центре страницы
    public void findAndClickOrderButtonInCenter(){
        WebElement element = driver.findElement(buttonOrderInCenter);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(buttonOrderInCenter).click();

    }

    //Метод выбора кнопки "Заказать": в углу или по центру
    public void clickOrderButton(String buttonName){
        if(buttonName.equals("button-corner")){
            clickOnOrderButtonInCorner();
        }
        else if(buttonName.equals("button-center")){
            findAndClickOrderButtonInCenter();
        }
    }

}
