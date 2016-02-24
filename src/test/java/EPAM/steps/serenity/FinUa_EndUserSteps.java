package EPAM.steps.serenity;

import EPAM.pages.FinUA_StartPage;

import net.thucydides.core.steps.ScenarioSteps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.webdriver.SystemPropertiesConfiguration;
import org.apache.log4j.Logger;
import static org.hamcrest.MatcherAssert.assertThat;


import static org.hamcrest.Matchers.*;
import static org.junit.Assume.assumeThat;
import static org.junit.Assume.assumeTrue;

/**
 * Created by Andriy_Yarish on 2/22/2016.
 */
public class FinUa_EndUserSteps extends ScenarioSteps  {
    FinUA_StartPage finUA;
    public static final Logger LOG = Logger.getLogger(FinUa_EndUserSteps.class);

    @Step
    public void goToHomePage() {
        finUA.open();
        getDriver().manage().window().maximize();
        LOG.info("Page is opened");
    }
    //switching of currency types
    @Step
    public void switchToEURRates(){
        finUA.switchCurrencyToEUR();
    }
    @Step
    public void switchToUSDRates(){
        // USD rates are shown by default but without /usd/ URL's end
        finUA.switchCurrencyToUSD();
    }
    @Step
    public void switchToRUBRates(){
        finUA.switchCurrencyToRUB();
    }
    // assertion after switching of currency type
    @Step
    public void checkThatEURRatesIsSelected(){
        assertThat("Currency type is not switched to EUR",true ,is(finUA.EUR_CurrencyIsSelected()));
        LOG.info("Currency type is switched to EUR");
    }
    @Step
    public void checkThatUSDRatesIsSelected(){
        assertThat("Currency type is not switched to USD",true,is(finUA.USD_CurrencyIsSelected()));
        LOG.info("Currency type is switched to EUR");
    }
    @Step
    public void checkThatRUBRatesIsSelected(){
        assertThat("Currency type is not switched to USD",finUA.RUB_CurencyIsSelected());
        LOG.info("Currency type is switched to EUR");
    }

    @Step
    public void verifyCalculation_EUR_AVG_BID(){
        Double calcResult = finUA.calcAVG_EURBID();
        Double actualResult = finUA.getAVG_BID();
        assertThat("Calculated value is not equal to the value from summary table",calcResult,is(actualResult));
        LOG.info("Calculated value is equal to the value from summary table." +
                " Calculated result = " + calcResult + " result from summary table = " + actualResult);
    }

    @Step
    public void verifyCalculation_EUR_AVG_ASK(){
        Double calcResult = finUA.calcAVG_EURASK();
        Double actualResult = finUA.getAVG_ASK();
        assertThat("Calculated value is not equal to the value from summary table",calcResult,is(actualResult));
        LOG.info("Calculated value is equal to the value from summary table." +
                " Calculated result = " + calcResult + " result from summary table = " + actualResult);
    }

    @Step
    public void verifyCalculation_EUR_MIN_BID(){
        Double calcResult = finUA.calcMIN_EURBID();
        Double actualResult = finUA.getMIN_BID();
        assertThat("Calculated value is not equal to the value from summary table",calcResult, is(actualResult));
        LOG.info("Calculated value is equal to the value from summary table." +
                " Calculated result = " + calcResult + " result from summary table = " + actualResult);
    }
    @Step
    public void verifyCalculation_EUR_MIN_ASK(){
        Double calcResult = finUA.calcMIN_EURASK();
        Double actualResult = finUA.getMIN_ASK();
        assertThat("Calculated value is not equal to the value from summary table",calcResult,is(actualResult));
        LOG.info("Calculated value is equal to the value from summary table." +
                " Calculated result = " + calcResult + " result from summary table = " + actualResult);
    }
    @Step
    public void verifyCalculation_EUR_MAX_BID(){
        Double calcResult = finUA.calcMAX_EURBID();
        Double actualResult = finUA.getMAX_BID();
        assertThat("Calculated value is not equal to the value from summary table",calcResult,equalTo(actualResult));
        LOG.info("Calculated value is equal to the value from summary table." +
                " Calculated result = " + calcResult + " result from summary table = " + actualResult);
    }
    @Step
    public void verifyCalculation_EUR_MAX_ASK(){
        Double calcResult = finUA.calcMAX_EURASK();
        Double actualResult = finUA.getMAX_ASK();
        assertThat("Calculated value is not equal to the value from summary table",calcResult,is(actualResult));
        LOG.info("Calculated value is equal to the value from summary table." +
                " Calculated result = " + calcResult + " result from summary table = " + actualResult);
    }
    @Step
    public void verifyCalculation_EUR_OPTM_BID(){
        Double maximumBID = finUA.calcMAX_EURBID();
        Double optimalBID = finUA.getOPTM_BID();
        assertThat("Calculated value is not equal to the value from summary table",maximumBID,is(optimalBID));
        LOG.info("Calculated value is equal to the value from summary table." +
                " Calculated result = " + maximumBID + " result from summary table = " + optimalBID);
    }
    @Step
    public void verifyCalculation_EUR_OPTM_ASK(){
        Double minimumASK = finUA.calcMIN_EURASK();
        Double optimalASK = finUA.getOPTM_ASK();
        assertThat("Calculated value is not equal to the value from summary table",minimumASK,is(optimalASK));
        LOG.info("Calculated value is equal to the value from summary table." +
                " Calculated result = " + minimumASK + " result from summary table = " + optimalASK);
    }



}

