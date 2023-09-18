package ru.yandex.praktikum;


import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.yandex.praktikum.config.BeforeAndAfterBaseClass;
import ru.yandex.praktikum.pageObject.AboutClientPage;
import ru.yandex.praktikum.pageObject.AboutScooterRentPage;
import ru.yandex.praktikum.pageObject.ConfirmOrderPopUp;
import ru.yandex.praktikum.pageObject.MainPage;


@RunWith(Parameterized.class)
public class CreateOrderTest extends BeforeAndAfterBaseClass {
    private final String positionOrderButton;
    private final String name;
    private final String surName;
    private final String address;
    private final String station;
    private final String numberPhone;
    private final String date;
    private final int rentalDay;
    private final String color;

    public CreateOrderTest (String positionOrderButton, String name, String surName, String address,
                            String station, String numberPhone, String date, int rentalDay, String color){
        this.positionOrderButton = positionOrderButton;
        this.name = name;
        this.surName = surName;
        this.address = address;
        this.station = station;
        this.numberPhone = numberPhone;
        this.date = date;
        this.rentalDay = rentalDay;
        this.color = color;

    }
    @Parameterized.Parameters
    public static Object[][] getXpathAndAnswers(){
        return new Object[][]{
                {"button-corner","Олег","Алексеев","Ул. Пушкина, д. 29","Черкизовская","89992094329","24.08.2024",1,"black"},
                {"button-corner","Юля","Иванова","Проспект Большевиков, дом 302","Динамо","89992004148","11.01.2025",3,"grey"},
                {"button-center","Дмитрий","Жиглов","Ул. Некрасова, д. 399, кв. 55","ВДНХ","79211224500","21.11.2023",5,"black"},
                {"button-center","Кристина","Молоткова","Английская 3к2 кв 88","Полянка","89002012222","02.04.2027",7,"grey"},
        };
    }
    @Test
    public void test(){
        new MainPage(getDriver())
                .waitLoadMainPage()
                .clickOrderButton(positionOrderButton);

        new AboutClientPage(getDriver())
                .waitLoadAboutClientPage()
                .setName(name)
                .setSurname(surName)
                .setAddress(address)
                .setStation(station)
                .setPhoneNumber(numberPhone)
                .clickButtonNext();

       new AboutScooterRentPage(getDriver())
               .waitLoadAboutScooterPage()
               .setDate(date)
               .setRentalTime(rentalDay)
                .setColor(color)
               .clickButtonCreateOrder();

        ConfirmOrderPopUp confirmOrder = new ConfirmOrderPopUp(getDriver());
        confirmOrder.waitLoadConfirmOrderPopUp()
                    .clickButtonYes();
        Assert.assertThat(confirmOrder.getTextFromHeaderTitle(),
                CoreMatchers.containsString("Заказ оформлен"));



    }

}
