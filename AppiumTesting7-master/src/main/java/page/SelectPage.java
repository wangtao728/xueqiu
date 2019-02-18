package page;

import driver.Driver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

public class SelectPage extends BasePage {


    //添加自选
    public SelectPage addSelect(String keyword,String stockName){
        //点击搜索
        find(By.id("action_create_cube")).click();
        //输入搜索字段
        find(By.id("search_input_text")).sendKeys(keyword);
        find(By.xpath("//*[@text='" + stockName + "']/../..")).findElement(By.id("add_attention")).click();
        find(text("取消")).click();
        return new SelectPage();
    }
    //删除自选
    public DelselectPage gotoDelselectPage(String stockName){
        find(By.xpath("//*[@text='" + stockName + "']/../..")).click();
        return new DelselectPage();
    }
    //取消搜索
    public SelectPage cancle(){
        find(By.id("action_close")).click();
        return new SelectPage();
    }
    public ArrayList<String> getstockAll(){
        ArrayList<String> array=new ArrayList<String>();
        for(WebElement e: Driver.getCurrentDriver().findElements(By.id("portfolio_stockName"))){
            array.add(e.getText());
        }
        return array;

    }
}