package ru.yandex.praktikum.pageObject.constants;

import org.openqa.selenium.By;

public class ConstantsMainPage {

    //Адерс главной страницы
    public static final String MAIN_PAGE = "https://qa-scooter.praktikum-services.ru/";

    //Ожидаемые ответы на вопросы
    public static final String ANSWER_1 = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
    public static final String ANSWER_2 = "Пока что у нас так: один заказ — один самокат. " +
            "Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
    public static final String ANSWER_3 = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в" +
            " течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы" +
            " привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
    public static final String ANSWER_4 = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
    public static final String ANSWER_5 = "Пока что нет! Но если что-то срочное — всегда можно позвонить в" +
            " поддержку по красивому номеру 1010.";
    public static final String ANSWER_6 = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь" +
            " суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
    public static final String ANSWER_7 = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки" +
            " тоже не попросим. Все же свои.";
    public static final String ANSWER_8 = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";

    //XPATH для вопросов
    public static final By XPATH_QUESTION_1 = By.xpath(".//div[@class='accordion__item'][1]");
    public static final By XPATH_QUESTION_2 = By.xpath(".//div[@class='accordion__item'][2]");
    public static final By XPATH_QUESTION_3 = By.xpath(".//div[@class='accordion__item'][3]");
    public static final By XPATH_QUESTION_4 = By.xpath(".//div[@class='accordion__item'][4]");
    public static final By XPATH_QUESTION_5 = By.xpath(".//div[@class='accordion__item'][5]");
    public static final By XPATH_QUESTION_6 = By.xpath(".//div[@class='accordion__item'][6]");
    public static final By XPATH_QUESTION_7 = By.xpath(".//div[@class='accordion__item'][7]");
    public static final By XPATH_QUESTION_8 = By.xpath(".//div[@class='accordion__item'][8]");

    //XPATH для ответов
    public static final By XPATH_ANSWER_1 = By.xpath(".//div[not(@hidden) and @id='accordion__panel-0']");
    public static final By XPATH_ANSWER_2 = By.xpath(".//div[not(@hidden) and @id='accordion__panel-1']");
    public static final By XPATH_ANSWER_3 = By.xpath(".//div[not(@hidden) and @id='accordion__panel-2']");
    public static final By XPATH_ANSWER_4 = By.xpath(".//div[not(@hidden) and @id='accordion__panel-3']");
    public static final By XPATH_ANSWER_5 = By.xpath(".//div[not(@hidden) and @id='accordion__panel-4']");
    public static final By XPATH_ANSWER_6 = By.xpath(".//div[not(@hidden) and @id='accordion__panel-5']");
    public static final By XPATH_ANSWER_7 = By.xpath(".//div[not(@hidden) and @id='accordion__panel-6']");
    public static final By XPATH_ANSWER_8 = By.xpath(".//div[not(@hidden) and @id='accordion__panel-7']");

}
