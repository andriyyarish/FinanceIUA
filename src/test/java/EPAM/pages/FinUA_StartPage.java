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
    @FindBy(xpath = "//td[em[contains(text(),'Максимальный')]]/following-sibling::*[1]") private WebElement maxLeft;
    @FindBy(xpath = "//td[em[contains(text(),'Максимальный')]]/following-sibling::*[2]") private WebElement maxRight;
    @FindBy(xpath = "//td[em[contains(text(),'Минимальный')]]/following-sibling::*[1]") private WebElement minLeft;
    @FindBy(xpath = "//td[em[contains(text(),'Минимальный')]]/following-sibling::*[2]") private WebElement minRight;
    @FindBy(xpath = "//td[em[contains(text(),'Средний')]]/following-sibling::*[1]") private WebElement avgLeft;
    @FindBy(xpath = "//td[em[contains(text(),'Средний')]]/following-sibling::*[2]") private WebElement avgRight;
    @FindBy(xpath = "//td[em[contains(text(),'Оптимальный')]]/following-sibling::*[1]") private WebElement optLeft;  // should be equal to maxLeft
    @FindBy(xpath = "//td[em[contains(text(),'Оптимальный')]]/following-sibling::*[2]") private WebElement optRight; // should be equal to minRight

    //List of bank's rates
    @FindBy(xpath = "//tr[th[contains(text(),'Сводка')]]/preceding-sibling::tr/td[2]") private List<WebElement> ratesLeftValueList;
    @FindBy(xpath = "//tr[th[contains(text(),'Сводка')]]/preceding-sibling::tr/td[3]") private List<WebElement> ratesRightValueList;




    public void switchCurrencyToEUR() {
        typeOfCurrency_EUR.click();
    }

    public boolean  checkThatCurencyIsSelected(){
        if (typeOfCurrency_EUR.getCssValue("class")=="current") {
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
        return countAVG(ratesLeftValueList);
    }

    public Double calcAVG_EURASK(){
        return countAVG(ratesRightValueList);
    }
    public Double calcMIN_EURBID(){
        TreeSet <Double> ratesSet = null ;
        for (WebElement el: ratesLeftValueList){
            ratesSet.add(Double.parseDouble(el.getText()));
        }
        return ratesSet.first();
    }
    public Double calcMIN_EURASK(){
        TreeSet <Double> ratesSet = null ;
        for (WebElement el: ratesRightValueList){
            ratesSet.add(Double.parseDouble(el.getText()));
        }
        return ratesSet.last();
    }
    public Double calcMAX_EURBID(){
        TreeSet <Double> ratesSet = null ;
        for (WebElement el: ratesLeftValueList){
            ratesSet.add(Double.parseDouble(el.getText()));
        }
        return ratesSet.last();
    }
    public Double calcMAX_EURASK(){
        TreeSet <Double> ratesSet = null ;
        for (WebElement el: ratesRightValueList){
            ratesSet.add(Double.parseDouble(el.getText()));
        }
        return ratesSet.last();
    }





    // get values from summary table
    public Double getAVGLeft() {
        return  Double.parseDouble(avgLeft.getText());
    }
    public Double getAVGRight() {
        return  Double.parseDouble(avgRight.getText());
    }
    public Double getMINLeft(){
        return Double.parseDouble(minLeft.getText());
    }
    public Double getMINRight(){
        return Double.parseDouble(minRight.getText());
    }
    public Double getMAXLeft(){
        return Double.parseDouble(maxLeft.getText());
    }
    public Double getMAXRight(){
        return Double.parseDouble(maxRight.getText());
    }
}
