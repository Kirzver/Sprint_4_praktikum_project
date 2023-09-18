package ru.yandex.praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import ru.yandex.praktikum.config.BeforeAndAfterBaseClass;
import ru.yandex.praktikum.pageObject.MainPage;

import static org.junit.Assert.assertEquals;

import static ru.yandex.praktikum.pageObject.constants.ConstantsMainPage.*;

@RunWith(Parameterized.class)
public class MainPageTest extends BeforeAndAfterBaseClass {
    private final By xpathQuestion;
    private final By xpathAnswer;
    private final String textAnswerExpected;

    public MainPageTest(By xpathQuestion, By xpathAnswer, String textAnswerExpected){
        this.xpathQuestion = xpathQuestion;
        this.xpathAnswer = xpathAnswer;
        this.textAnswerExpected = textAnswerExpected;
    }

    @Parameterized.Parameters
    public static Object[][] getXpathAndAnswers(){
        return new Object[][]{
                {XPATH_QUESTION_1, XPATH_ANSWER_1, ANSWER_1},
                {XPATH_QUESTION_2, XPATH_ANSWER_2, ANSWER_2},
                {XPATH_QUESTION_3, XPATH_ANSWER_3, ANSWER_3},
                {XPATH_QUESTION_4, XPATH_ANSWER_4, ANSWER_4},
                {XPATH_QUESTION_5, XPATH_ANSWER_5, ANSWER_5},
                {XPATH_QUESTION_6, XPATH_ANSWER_6, ANSWER_6},
                {XPATH_QUESTION_7, XPATH_ANSWER_7, ANSWER_7},
                {XPATH_QUESTION_8, XPATH_ANSWER_8, ANSWER_8},
        };
    }

    @Test
    public void checkAnswersOnBlogQuestionsInMainPage(){
        MainPage main = new MainPage(getDriver())
                .waitLoadMainPage()
                .findListQuestions()
                .clickOnQuestion(xpathQuestion)
                .waitLoadAnswer(xpathAnswer);
        String actualAnswerText = main.getAnswerText(xpathAnswer);
        assertEquals(textAnswerExpected, actualAnswerText);
    }

}
