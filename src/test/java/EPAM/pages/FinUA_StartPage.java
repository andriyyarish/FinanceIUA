package EPAM.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebElement;

import java.text.DecimalFormat;
import java.util.List;
import java.util.TreeSet;

@DefaultUrl("http://finance.i.ua/")

public class FinUA_StartPage extends PageObject {

    // currency switchers
    @FindBy (xpath = "//a[@href='/eur/']/../..") private WebElementFacade typeOfCurrency_USD;
    @FindBy (xpath = "//a[@href='/eur/']/../..") private WebElementFacade typeOfCurrency_EUR;

    // elements from Summary table
    @FindBy(xpath = "//td[em[contains(text(),'Максимальний')]]/following-sibling::*[1]",timeoutInSeconds="6")
    private WebElement maxBID;
    @FindBy(xpath = "//td[em[contains(text(),'Максимальний')]]/following-sibling::*[2]",timeoutInSeconds="6")
    private WebElement maxASK;
    @FindBy(xpath = "//td[em[contains(text(),'Минимальный')]]/following-sibling::*[1]")
    private WebElementFacade minBID;
    @FindBy(xpath = "//td[em[contains(text(),'Минимальный')]]/following-sibling::*[2]")
    private WebElementFacade minASK;
    @FindBy(xpath = "//td[em[contains(text(),'Средний')]]/following-sibling::*[1]")
    private WebElementFacade avgBID;
    @FindBy(xpath = "//td[em[contains(text(),'Средний')]]/following-sibling::*[2]")
    private WebElementFacade avgASK;
    @FindBy(xpath = "//td[em[contains(text(),'Оптимальний')]]/following-sibling::*[1]")
    private WebElementFacade optmBID;  // should be equal to maxBID
    @FindBy(xpath = "//td[em[contains(text(),'Оптимальний')]]/following-sibling::*[2]")
    private WebElementFacade optmASK; // should be equal to minASK

    //List of bank's rates
    @FindBy(xpath = "//tr[th[contains(text(),'Сводка')]]/preceding-sibling::tr[not (@class)='expired']/td[2]")
    private List<WebElement> ratesBIDValueList; //[not (@class)='expired']
    @FindBy(xpath = "//tr[th[contains(text(),'Сводка')]]/preceding-sibling::tr[not (@class)='expired']/td[3]")
    private List<WebElement> ratesASKValueList; //[not (@class)='expired']

    // switch currency type
    public void switchCurrencyToEUR() {
        typeOfCurrency_EUR.click();
    }

    public boolean  checkThatCurencyIsSelected() {
        if (getDriver().getCurrentUrl().endsWith("eur/"))
            return true;
         else
            return false;
    }
    // calc AVG value
    private Double countAVG (List<WebElement> list){
        int ammountOfRows = 0;
        Double sum = 0.0;
        DecimalFormat df = new DecimalFormat("#.####");
        for (WebElement el: list) {
            sum += Double.parseDouble(el.getText());
            ammountOfRows ++;
        }
        return Double.valueOf(df.format(sum/ammountOfRows));
    }
    public Double calcAVG_EURBID(){
        return countAVG(ratesBIDValueList);
    }
    public Double calcAVG_EURASK(){
        return countAVG(ratesASKValueList);
    }

    // select minimum and maximum from bank's rates table
    public Double calcMIN_EURBID(){
        TreeSet <Double> ratesSet = new TreeSet<Double>() ;
        for (WebElement el: ratesBIDValueList){
            ratesSet.add(Double.parseDouble(el.getText()));
        }
        return ratesSet.first();
    }
    public Double calcMIN_EURASK(){
        TreeSet <Double> ratesSet = new TreeSet<Double>() ;
        for (WebElement el: ratesASKValueList){
            ratesSet.add(Double.parseDouble(el.getText()));
        }
        return ratesSet.first();
    }
    public Double calcMAX_EURBID(){
        TreeSet <Double> ratesSet = new TreeSet<Double>() ;
        for (WebElement el: ratesBIDValueList){
            ratesSet.add(Double.parseDouble(el.getText()));
        }
        return ratesSet.last();
    }
    public Double calcMAX_EURASK(){
        TreeSet <Double> ratesSet = new TreeSet<Double>() ;
        for (WebElement el: ratesASKValueList){
            ratesSet.add(Double.parseDouble(el.getText()));
        }
        return ratesSet.last();
    }


    // getters for retrieve values from summary table
    public Double getAVG_BID() {
        return  Double.parseDouble(avgBID.getText());
    }
    public Double getAVG_ASK() {
        return  Double.parseDouble(avgASK.getText());
    }
    public Double getMIN_BID(){
        return Double.parseDouble(minBID.getText());
    }
    public Double getMIN_ASK(){
        return Double.parseDouble(minASK.getText());
    }

    public Double getMAX_BID(){
        return Double.parseDouble(maxBID.getText());
    }

    public Double getMAX_ASK(){
        return Double.parseDouble(maxASK.getText());
    }

    public Double getOPTM_BID(){
        return Double.parseDouble(optmBID.getText());
    }
    public Double getOPTM_ASK(){
        return Double.parseDouble(optmASK.getText());
    }
}
