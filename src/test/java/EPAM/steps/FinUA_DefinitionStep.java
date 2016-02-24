package EPAM.steps;

import EPAM.steps.serenity.FinUa_EndUserSteps;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class FinUA_DefinitionStep {

    @Steps
    FinUa_EndUserSteps steps_finUa;

    @Given("the user is on the finance.i.ua home page")
    public void givenTheUserIsOnTheFinanceIUAHomePage() {
        steps_finUa.goToHomePage();
    }

    @When("the user click on 'EUR' button")
    public void whenUserSwitchToEURRates() {
        steps_finUa.switchToEURRates();
    }

    @Then("'EUR' rates are shown")
    public void thenEURExchangeratesAREShown() {
        steps_finUa.checkThatEURRatesIsSelected();
    }

    @Then("calculated avg BID rate is equal to avg BID value from summary block")
    public void verifyCalculation_EUR_AVG_BID() {
        steps_finUa.verifyCalculation_EUR_AVG_BID();
    }

    @Then("calculated avg ASK rate is equal to avg ASK value from summary block")
    public void verifyCalculation_EUR_AVG_ASK() {
        steps_finUa.verifyCalculation_EUR_AVG_ASK();
    }

    @Then("minimum value of BID rate in bank's table is equal to minimum value of BID rate in summary table")
    public void verifyCalculation_EUR_MIN_BID() {
        steps_finUa.verifyCalculation_EUR_MIN_BID();
    }

    @Then("minimum value of ASK rate in bank's table is equal to minimum value of ASK rate in summary table")
    public void verifyCalculation_EUR_MIN_ASK() {
        steps_finUa.verifyCalculation_EUR_MIN_ASK();
    }

    @Then("maximum value of BID rate in bank's table is equal to maximum value of BID rate in summary table")
    public void verifyCalculation_EUR_MAX_BID() {
        steps_finUa.verifyCalculation_EUR_MAX_BID();
    }

    @Then("maximum value of ASK rate in bank's table is equal to maximum value of ASK rate in summary table")
    public void verifyCalculation_EUR_MAX_ASK(){
    steps_finUa.verifyCalculation_EUR_MAX_ASK();
    }

    @Then("optimal value of BID rate in summary table is equal to maximum value of BID rate in summary table")
    public void verifyCalculation_EUR_OPTM_BID() {
        steps_finUa.verifyCalculation_EUR_OPTM_BID();
    }

    @Then("optimal value of ASK rate in summary table is equal to minimum value of ASK rate in summary table")
    public void verifyCalculation_EUR_OPTM_ASK() {
        steps_finUa.verifyCalculation_EUR_OPTM_ASK();
    }

}
