package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class MycoursedemyPage {
    public MycoursedemyPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//a[text()='Log in']")
    public WebElement loginLink;
    //Home Page > Log in > Email box
    @FindBy(xpath = "//input[@id='login-email']")
    public WebElement emailBox;

    //Home Page > cookies "Accept"
    @FindBy(xpath = "//*[text()='Accept']")
    public WebElement acceptCookies;
    //Home Page > Log in > Password box
    @FindBy(xpath = "//input[@id='login-password']")
    public WebElement passwordBox;

    @FindBy(xpath = "//button[text()='Login']")
    public WebElement loginButonu;

    @FindBy(linkText = "My courses")
    public WebElement coursesLinki;
}