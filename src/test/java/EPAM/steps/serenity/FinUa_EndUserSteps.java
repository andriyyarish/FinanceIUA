package EPAM.steps.serenity;

import EPAM.pages.FinUA_StartPage_BanksRatesTable;

import EPAM.pages.FinUA_CurrencyConverter;
import net.thucydides.core.steps.ScenarioSteps;

import net.thucydides.core.annotations.Step;
import org.apache.log4j.Logger;
import static org.hamcrest.MatcherAssert.assertThat;


import static org.hamcrest.Matchers.*;
import static org.junit.Assume.assumeThat;
import static org.junit.Assume.assumeTrue;

/**
 * Created by Andriy_Yarish on 2/22/2016.
 */
public class FinUa_EndUserSteps extends ScenarioSteps  {
    FinUA_StartPage_BanksRatesTable finUA_startPage_banksRatesTable;
    FinUA_CurrencyConverter finUA_currencyConverter;

    public static final Logger LOG = Logger.getLogger(FinUa_EndUserSteps.class);

    @Step
    public void goToHomePage() {
        finUA_startPage_banksRatesTable.open();
        getDriver().manage().window().maximize();
        LOG.info("Page is opened");
    }

    //switching of currency types
    @Step
    public void switchToEURRates(){
        finUA_startPage_banksRatesTable.switchCurrencyToEUR();
    }
    @Step
    public void switchToUSDRates(){
        // USD rates are shown by default but without /usd/ URL's end
        finUA_startPage_banksRatesTable.switchCurrencyToUSD();
    }
    @Step
    public void switchToRUBRates(){
        finUA_startPage_banksRatesTable.switchCurrencyToRUB();
    }
    // assertion after switching of currency type
    @Step
    public void checkThatEURRatesIsSelected(){
        assertThat("Currency type is not switched to EUR",true ,is(finUA_startPage_banksRatesTable.EUR_CurrencyIsSelected()));
        LOG.info("Currency type is switched to EUR");
    }
    @Step
    public void checkThatUSDRatesIsSelected(){
        assertThat("Currency type is not switched to USD",true,is(finUA_startPage_banksRatesTable.USD_CurrencyIsSelected()));
        LOG.info("Currency type is switched to EUR");
    }
    @Step
    public void checkThatRUBRatesIsSelected(){
        assertThat("Currency type is not switched to USD", finUA_startPage_banksRatesTable.RUB_CurencyIsSelected());
        LOG.info("Currency type is switched to EUR");
    }

    @Step
    public void verifyCalculation_EUR_AVG_BID(){
        Double calcResult = finUA_startPage_banksRatesTable.calcAVG_EURBID();
        Double actualResult = finUA_startPage_banksRatesTable.getAVG_BID();
        assertThat("Calculated value is not equal to the value from summary table",calcResult,is(actualResult));
        LOG.info("Calculated value is equal to the value from summary table." +
                " Calculated result = " + calcResult + " result from summary table = " + actualResult);
    }

    @Step
    public void verifyCalculation_EUR_AVG_ASK(){
        Double calcResult = finUA_startPage_banksRatesTable.calcAVG_EURASK();
        Double actualResult = finUA_startPage_banksRatesTable.getAVG_ASK();
        assertThat("Calculated value is not equal to the value from summary table",calcResult,is(actualResult));
        LOG.info("Calculated value is equal to the value from summary table." +
                " Calculated result = " + calcResult + " result from summary table = " + actualResult);
    }

    @Step
    public void verifyCalculation_EUR_MIN_BID(){
        Double calcResult = finUA_startPage_banksRatesTable.calcMIN_EURBID();
        Double actualResult = finUA_startPage_banksRatesTable.getMIN_BID();
        assertThat("Calculated value is not equal to the value from summary table",calcResult, is(actualResult));
        LOG.info("Calculated value is equal to the value from summary table." +
                " Calculated result = " + calcResult + " result from summary table = " + actualResult);
    }
    @Step
    public void verifyCalculation_EUR_MIN_ASK(){
        Double calcResult = finUA_startPage_banksRatesTable.calcMIN_EURASK();
        Double actualResult = finUA_startPage_banksRatesTable.getMIN_ASK();
        assertThat("Calculated value is not equal to the value from summary table",calcResult,is(actualResult));
        LOG.info("Calculated value is equal to the value from summary table." +
                " Calculated result = " + calcResult + " result from summary table = " + actualResult);
    }
    @Step
    public void verifyCalculation_EUR_MAX_BID(){
        Double calcResult = finUA_startPage_banksRatesTable.calcMAX_EURBID();
        Double actualResult = finUA_startPage_banksRatesTable.getMAX_BID();
        assertThat("Calculated value is not equal to the value from summary table",calcResult,equalTo(actualResult));
        LOG.info("Calculated value is equal to the value from summary table." +
                " Calculated result = " + calcResult + " result from summary table = " + actualResult);
    }
    @Step
    public void verifyCalculation_EUR_MAX_ASK(){
        Double calcResult = finUA_startPage_banksRatesTable.calcMAX_EURASK();
        Double actualResult = finUA_startPage_banksRatesTable.getMAX_ASK();
        assertThat("Calculated value is not equal to the value from summary table",calcResult,is(actualResult));
        LOG.info("Calculated value is equal to the value from summary table." +
                " Calculated result = " + calcResult + " result from summary table = " + actualResult);
    }
    @Step
    public void verifyCalculation_EUR_OPTM_BID(){
        Double maximumBID = finUA_startPage_banksRatesTable.calcMAX_EURBID();
        Double optimalBID = finUA_startPage_banksRatesTable.getOPTM_BID();
        assertThat("Calculated value is not equal to the value from summary table",maximumBID,is(optimalBID));
        LOG.info("Calculated value is equal to the value from summary table." +
                " Calculated result = " + maximumBID + " result from summary table = " + optimalBID);
    }
    @Step
    public void verifyCalculation_EUR_OPTM_ASK(){
        Double minimumASK = finUA_startPage_banksRatesTable.calcMIN_EURASK();
        Double optimalASK = finUA_startPage_banksRatesTable.getOPTM_ASK();
        assertThat("Calculated value is not equal to the value from summary table",minimumASK,is(optimalASK));
        LOG.info("Calculated value is equal to the value from summary table." +
                " Calculated result = " + minimumASK + " result from summary table = " + optimalASK);
    }

    @Step
    public FinUA_CurrencyConverter openCurrencyConverter(){
        return finUA_startPage_banksRatesTable.openCurrencyConverter();
    }
    @Step
    public void checkThatCurrencyCalculatorIsOpened_UI(){
        assertThat("Curency Converter Page is not opened, text is not visible", finUA_currencyConverter.checkThatCurrencyPageIsOpened());
    }
    @Step
    public void checkThatCurrencyCalculatorIsOpened_URL(){
        assertThat(getDriver().getCurrentUrl(),endsWith("/converter/"));
    }


}

