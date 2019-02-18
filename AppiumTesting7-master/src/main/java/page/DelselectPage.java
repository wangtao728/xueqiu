package page;

import org.openqa.selenium.By;

public class DelselectPage extends BasePage{
    public DelselectPage Delselect(){
        find(By.xpath("//*[@text='设自选']")).click();
        find(By.xpath("//*[@text='删除自选']")).click();
        find(By.id("action_back")).click();
        return this;
        }
    }
