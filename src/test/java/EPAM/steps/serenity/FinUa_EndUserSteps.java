package EPAM.steps.serenity;

import EPAM.pages.FinUA_StartPage;

import net.thucydides.core.steps.ScenarioSteps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.webdriver.SystemPropertiesConfiguration;
import org.junit.Assume;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.isEmptyOrNullString;
import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;
import static org.junit.Assume.assumeThat;
import static org.junit.Assume.assumeTrue;

/**
 * Created by Andriy_Yarish on 2/22/2016.
 */
public class FinUa_EndUserSteps extends ScenarioSteps  {
    FinUA_StartPage finUA;


    @Step
    public void goToHomePage() {
        finUA.open();
        getDriver().manage().window().maximize();
    }

    @Step
    public void switchToEURRates(){
        finUA.switchCurrencyToEUR();
    }
    @Step
    public void checkThatEURRatesIsSelected(){
        assertTrue("Currency type is not switched to EUR",finUA.checkThatCurencyIsSelected());
    }

    @Step
    public void verifyCalculation_EUR_AVG_BID(){
        Double calcResult = finUA.calcAVG_EURBID();
        Double actualResult = finUA.getAVG_BID();
        assertEquals("Calculated value is not equal to the value from summary table",calcResult,actualResult);
    }

    @Step
    public void verifyCalculation_EUR_AVG_ASK(){
        Double calcResult = finUA.calcAVG_EURASK();
        Double actualResult = finUA.getAVG_ASK();
        assertEquals("Calculated value is not equal to the value from summary table",calcResult,actualResult);
    }

    @Step
    public void verifyCalculation_EUR_MIN_BID(){
        Double calcResult = finUA.calcMIN_EURBID();
        Double actualResult = finUA.getMIN_BID();
        assertEquals("Calculated value is not equal to the value from summary table",calcResult,actualResult);
    }
    @Step
    public void verifyCalculation_EUR_MIN_ASK(){
        Double calcResult = finUA.calcMIN_EURASK();
        Double actualResult = finUA.getMIN_ASK();
        assertEquals("Calculated value is not equal to the value from summary table",calcResult,actualResult);
    }
    @Step
    public void verifyCalculation_EUR_MAX_BID(){
        Double calcResult = finUA.calcMAX_EURBID();
        Double actualResult = finUA.getMAX_BID();
        assertEquals("Calculated value is not equal to the value from summary table",calcResult,actualResult);
    }
    @Step
    public void verifyCalculation_EUR_MAX_ASK(){
        Double calcResult = finUA.calcMAX_EURASK();
        Double actualResult = finUA.getMAX_ASK();
        assertEquals("Calculated value is not equal to the value from summary table",calcResult,actualResult);
    }
    @Step
    public void verifyCalculation_EUR_OPTM_BID(){
        Double maximumBID = finUA.calcMAX_EURBID();
        Double optimalBID = finUA.getOPTM_BID();
        assertEquals("Calculated value is not equal to the value from summary table",maximumBID,optimalBID);
    }
    @Step
    public void verifyCalculation_EUR_OPTM_ASK(){
        Double minimumASK = finUA.calcMIN_EURASK();
        Double optimalASK = finUA.getOPTM_ASK();
        assertEquals("Calculated value is not equal to the value from summary table",minimumASK,optimalASK);
    }



}

