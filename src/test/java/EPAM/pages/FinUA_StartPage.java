package EPAM.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.TreeSet;

@DefaultUrl("http://finance.i.ua/")

public class FinUA_StartPage extends PageObject {

    // currency switchers
    @FindBy (xpath = "//a[@href='/eur/']/../..") private WebElement typeOfCurrency_USD;
    @FindBy (xpath = "//a[@href='/eur/']/../..") private WebElement typeOfCurrency_EUR;

    // elements from Summary table
    @FindBy(xpath = "//td[em[contains(text(),'Максимальный')]]/following-sibling::*[1]") private WebElement maxBID;
    @FindBy(xpath = "//td[em[contains(text(),'Максимальный')]]/following-sibling::*[2]") private WebElement maxASK;
    @FindBy(xpath = "//td[em[contains(text(),'Минимальный')]]/following-sibling::*[1]") private WebElement minBID;
    @FindBy(xpath = "//td[em[contains(text(),'Минимальный')]]/following-sibling::*[2]") private WebElement minASK;
    @FindBy(xpath = "//td[em[contains(text(),'Средний')]]/following-sibling::*[1]") private WebElement avgBID;
    @FindBy(xpath = "//td[em[contains(text(),'Средний')]]/following-sibling::*[2]") private WebElement avgASK;
    @FindBy(xpath = "//td[em[contains(text(),'Оптимальный')]]/following-sibling::*[1]") private WebElement optmlBID;  // should be equal to maxBID
    @FindBy(xpath = "//td[em[contains(text(),'Оптимальный')]]/following-sibling::*[2]") private WebElement optmlASK; // should be equal to minASK

    //List of bank's rates
    @FindBy(xpath = "//tr[th[contains(text(),'Сводка')]]/preceding-sibling::tr/td[2]") private List<WebElement> ratesBIDValueList;
    @FindBy(xpath = "//tr[th[contains(text(),'Сводка')]]/preceding-sibling::tr/td[3]") private List<WebElement> ratesASKValueList;




    public void switchCurrencyToEUR() {
        typeOfCurrency_EUR.click();
    }

    public boolean  checkThatCurencyIsSelected(){
        typeOfCurrency_EUR.click();
        if (typeOfCurrency_EUR.getCssValue("class").equals(new String("current"))) {
            System.out.println(typeOfCurrency_EUR.getCssValue("class"));
            return true;
        }
        else
            return false;
    }

    // count AVG value
    private Double countAVG (List<WebElement> list){
        int ammountOfRows = 1;
        Double sum = null;

        for (WebElement el: list) {
            sum += Double.parseDouble(el.getText());
            ammountOfRows ++;
        }
        return sum/ammountOfRows;
    }


    public Double calcAVG_EURBID(){
        return countAVG(ratesBIDValueList);
    }

    public Double calcAVG_EURASK(){
        return countAVG(ratesASKValueList);
    }

    public Double calcMIN_EURBID(){
        TreeSet <Double> ratesSet = null ;
        for (WebElement el: ratesBIDValueList){
            ratesSet.add(Double.parseDouble(el.getText()));
        }
        return ratesSet.first();
    }
    public Double calcMIN_EURASK(){
        TreeSet <Double> ratesSet = null ;
        for (WebElement el: ratesASKValueList){
            ratesSet.add(Double.parseDouble(el.getText()));
        }
        return ratesSet.last();
    }
    public Double calcMAX_EURBID(){
        TreeSet <Double> ratesSet = null ;
        for (WebElement el: ratesBIDValueList){
            ratesSet.add(Double.parseDouble(el.getText()));
        }
        return ratesSet.last();
    }
    public Double calcMAX_EURASK(){
        TreeSet <Double> ratesSet = null ;
        for (WebElement el: ratesASKValueList){
            ratesSet.add(Double.parseDouble(el.getText()));
        }
        return ratesSet.last();
    }





    // get values from summary table
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
}
