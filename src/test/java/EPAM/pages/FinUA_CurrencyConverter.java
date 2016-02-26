package EPAM.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("http://finance.i.ua/converter/")
public class FinUA_CurrencyConverter extends PageObject {

    @FindBy(xpath = "//span[contains(text(),'прод')]")
    private WebElementFacade sellCurrencyButton;

    @FindBy(xpath = "//span[contains(text(),'куп')]")
    private WebElementFacade buyCurrencyButton;

    @FindBy(xpath = "//td[contains(text(),'Сумму')]/following-sibling::td[1]/input")
    private WebElementFacade ammountTextBox;

    @FindBy(xpath = "//td[contains(text(),'Сумму')]/following-sibling::td[1]/select")
    private WebElementFacade currencyTypeDDL;

    @FindBy(xpath = "//h1[contains(text(),'Конвертер валют')]") WebElementFacade currencyCalculatorHeader;

    public boolean checkThatCurrencyPageIsOpened(){
       return currencyCalculatorHeader.isVisible() ;
    }
    public void enterValueIntoAmountField(CharSequence val){
        withAction().click(ammountTextBox).sendKeys(ammountTextBox,val).build().perform();
    }




}
