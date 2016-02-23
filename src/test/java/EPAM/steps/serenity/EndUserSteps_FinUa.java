package EPAM.steps.serenity;

import EPAM.pages.FinUA_StartPage;

import net.thucydides.core.steps.ScenarioSteps;

import net.thucydides.core.annotations.Step;
import org.junit.Assume;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

/**
 * Created by Andriy_Yarish on 2/22/2016.
 */
public class EndUserSteps_FinUa extends ScenarioSteps {
    FinUA_StartPage finUA;

    @Step
    public void goToHomePage() {
        finUA.open();
    }

    @Step
    public void switchToEUERates(){
        finUA.switchCurrencyToEUR();
    }
    @Step
    public void checkThatEURRatesIsSelected(){
        Assume.assumeTrue(finUA.checkThatCurencyIsSelected());
    }

    @Step
    public void verifyCalculation_EUR_AVG_BID(){
        Double calcResult = finUA.calcAVG_EURBID();
        Double givenResult = finUA.getAVG_BID();
        assertEquals(givenResult,calcResult);
        System.out.println ("calcResult = " + calcResult + "and givenResult = "+ givenResult);
    }

    @Step
    public void verifyCalculation_EUR_AVG_ASK(){
        Double calcResult = finUA.calcAVG_EURASK();
        Double givenResult = finUA.getAVG_ASK();
        assertEquals(givenResult,calcResult);
        System.out.println ("calcResult = " + calcResult + "and givenResult = "+ givenResult);
    }

    @Step
    public void verifyCalculation_EUR_MIN_BID(){
        Double calcResult = finUA.calcMIN_EURBID();
        Double givenResult = finUA.getMIN_BID();
        assertEquals(givenResult,calcResult);
    }
    @Step
    public void verifyCalculation_EUR_MIN_ASK(){
        Double calcResult = finUA.calcMIN_EURASK();
        Double givenResult = finUA.getMIN_ASK();
        assertEquals(givenResult,calcResult);
    }
    @Step
    public void verifyCalculation_EUR_MAX_BID(){
        Double calcResult = finUA.calcMAX_EURBID();
        Double givenResult = finUA.getMAX_BID();
        assertEquals(givenResult,calcResult);
    }
    @Step
    public void verifyCalculation_EUR_MAX_ASK(){
        Double calcResult = finUA.calcMAX_EURASK();
        Double givenResult = finUA.getMAX_ASK();
        assertEquals(givenResult,calcResult);
    }


}

