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
        Double givenResult = finUA.getAVGLeft();
        assertEquals(givenResult,calcResult);
        System.out.println ("calcResult = " + calcResult + "and givenResult = "+ givenResult);
    }

    @Step
    public void verifyCalculation_EUR_AVG_ASK(){
        Double calcResult = finUA.calcAVG_EURASK();
        Double givenResult = finUA.getAVGRight();
        assertEquals(givenResult,calcResult);
        System.out.println ("calcResult = " + calcResult + "and givenResult = "+ givenResult);
    }

    @Step
    public void verifyCalculation_EUR_MIN_BID(){
        Double calcResult = finUA.calcMIN_EURBID();
        Double givenResult = finUA.getMINLeft();
        assertEquals(givenResult,calcResult);
    }
    public void verifyCalculation_EUR_MIN_ASK(){
        Double calcResult = finUA.calcMIN_EURASK();
        Double givenResult = finUA.getMINRight();
        assertEquals(givenResult,calcResult);
    }



}

