package EPAM.steps;

import EPAM.pages.FinUA_CurrencyConverter;
import EPAM.steps.serenity.FinUa_EndUserSteps;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class FinUA_DefinitionStep {

    @Steps
    FinUa_EndUserSteps endUserStep;
    FinUA_CurrencyConverter curConverter_finUA;

    @Given("the user is on the finance.i.ua home page")
    public void givenTheUserIsOnTheFinanceIUAHomePage() {
        endUserStep.goToHomePage();
    }

    @When("the user click on 'EUR' button")
    public void whenUserSwitchToEURRates() {
        endUserStep.switchToEURRates();
    }

    @When("the user click on 'USD' button")
    public void whenUserSwitchToUSDRates() {
        endUserStep.switchToUSDRates();
    }

    @When("the user click on 'RUB' button")
    public void whenUserSwitchToRUBRates() {
        endUserStep.switchToUSDRates();
    }


    @Then("'USD' rates are shown")
    public void thenUSDExchangeratesAREShown() {
        endUserStep.checkThatUSDRatesIsSelected();
    }
    @When("'USD' rates are shown")
    public void whenUSDExchangeratesAREShown() {
        endUserStep.checkThatUSDRatesIsSelected();
    }
    @Then("'RUB' rates are shown")
    public void thenRUBExchangeratesAREShown() {
        endUserStep.checkThatRUBRatesIsSelected();
    }
    @When("'RUB' rates are shown")
    public void whenRUBExchangeratesAREShown() {
        endUserStep.checkThatRUBRatesIsSelected();
    }

    @Then("'EUR' rates are shown")
    public void thenEURExchangeratesAREShown() {
        endUserStep.checkThatEURRatesIsSelected();
    }

    @Then("calculated avg BID rate is equal to avg BID value from summary block")
    public void verifyCalculation_EUR_AVG_BID() {
        endUserStep.verifyCalculation_EUR_AVG_BID();
    }

    @Then("calculated avg ASK rate is equal to avg ASK value from summary block")
    public void verifyCalculation_EUR_AVG_ASK() {
        endUserStep.verifyCalculation_EUR_AVG_ASK();
    }

    @Then("minimum value of BID rate in bank's table is equal to minimum value of BID rate in summary table")
    public void verifyCalculation_EUR_MIN_BID() {
        endUserStep.verifyCalculation_EUR_MIN_BID();
    }

    @Then("minimum value of ASK rate in bank's table is equal to minimum value of ASK rate in summary table")
    public void verifyCalculation_EUR_MIN_ASK() {
        endUserStep.verifyCalculation_EUR_MIN_ASK();
    }

    @Then("maximum value of BID rate in bank's table is equal to maximum value of BID rate in summary table")
    public void verifyCalculation_EUR_MAX_BID() {
        endUserStep.verifyCalculation_EUR_MAX_BID();
    }

    @Then("maximum value of ASK rate in bank's table is equal to maximum value of ASK rate in summary table")
    public void verifyCalculation_EUR_MAX_ASK(){
    endUserStep.verifyCalculation_EUR_MAX_ASK();
    }

    @Then("optimal value of BID rate in summary table is equal to maximum value of BID rate in summary table")
    public void verifyCalculation_EUR_OPTM_BID() {
        endUserStep.verifyCalculation_EUR_OPTM_BID();
    }

    @Then("optimal value of ASK rate in summary table is equal to minimum value of ASK rate in summary table")
    public void verifyCalculation_EUR_OPTM_ASK() {
        endUserStep.verifyCalculation_EUR_OPTM_ASK();
    }

    @When("user click on CurrencyConverter link")
    public FinUA_CurrencyConverter goToCurrencyConverter(){
        return endUserStep.openCurrencyConverter();
    }

    @Then("user should see currency converter Page")
    public void currencyConverterIsOpened_ui(){
        endUserStep.checkThatCurrencyCalculatorIsOpened_UI();
    }
    @Then("url should be equal to 'http://finance.i.ua/converter/'")
    public void currencyConverterIsOpened_url(){
        endUserStep.checkThatCurrencyCalculatorIsOpened_URL();
    }


}
