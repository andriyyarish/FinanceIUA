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
public class EndUserSteps_FinUa extends ScenarioSteps  {
    FinUA_StartPage finUA;


    @Step
    public void goToHomePage() {
        finUA.open();
        getDriver().manage().window().maximize();
    }

    @Step
    public void switchToEUERates(){
        finUA.switchCurrencyToEUR();
    }
    @Step
    public void checkThatEURRatesIsSelected(){
        assumeThat(true,is(finUA.checkThatCurencyIsSelected()));
    }

    @Step
    public void verifyCalculation_EUR_AVG_BID(){
        Double calcResult = finUA.calcAVG_EURBID();
        Double givenResult = finUA.getAVG_BID();
        assumeThat(calcResult,is(givenResult));
    }

    @Step
    public void verifyCalculation_EUR_AVG_ASK(){
        Double calcResult = finUA.calcAVG_EURASK();
        Double givenResult = finUA.getAVG_ASK();
        assumeThat(givenResult,is(calcResult));
    }

    @Step
    public void verifyCalculation_EUR_MIN_BID(){
        Double calcResult = finUA.calcMIN_EURBID();
        Double givenResult = finUA.getMIN_BID();
        assumeThat(givenResult,is(calcResult));
    }
    @Step
    public void verifyCalculation_EUR_MIN_ASK(){
        Double calcResult = finUA.calcMIN_EURASK();
        Double givenResult = finUA.getMIN_ASK();
        assumeThat(givenResult,is(calcResult));
    }
    @Step
    public void verifyCalculation_EUR_MAX_BID(){
        Double calcResult = finUA.calcMAX_EURBID();
        Double givenResult = finUA.getMAX_BID();
        assumeThat(givenResult,is(calcResult));
    }
    @Step
    public void verifyCalculation_EUR_MAX_ASK(){
        Double calcResult = finUA.calcMAX_EURASK();
        Double givenResult = finUA.getMAX_ASK();
        assumeThat(givenResult,is(calcResult));
    }
    @Step
    public void verifyCalculation_EUR_OPTM_BID(){
        Double maximumBID = finUA.calcMAX_EURBID();
        Double optimalBID = finUA.getOPTM_BID();
        assumeTrue("Maximum BID should be equal Optimal BID",maximumBID.equals(optimalBID));

    }
    @Step
    public void verifyCalculation_EUR_OPTM_ASK(){
        Double minimumASK = finUA.calcMIN_EURASK();
        Double optimalASK = finUA.getOPTM_ASK();
        assumeTrue("Minimum Ask should be equal Optimal ASK",minimumASK.equals(optimalASK));
    }



}

