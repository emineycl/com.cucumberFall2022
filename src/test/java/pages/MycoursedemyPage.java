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
    //Home Page > Log in > Login
    @FindBy(xpath = "//button[text()='Login']")
    public WebElement loginButton;
    //Home Page > cookies "Accept"
    @FindBy(xpath = "//*[text()='Accept']")
    public WebElement acceptCookies;
    //Home Page > Log in > Password box
    @FindBy(xpath = "//input[@id='login-password']")
    public WebElement passwordBox;
    //Home Page
    @FindBy (xpath = "//img[@src='https://qualitydemy.com/uploads/system/393645bf994114c23be28028a47a77a0.png']")
    public WebElement homePage;
  /*  @FindBy(xpath = "//a[text()='Log in']")
    public WebElement loginLinki;

    @FindBy(xpath = "//input[@id='login-email']")
    public WebElement emailKutusu;

    @FindBy(xpath = "//input[@id='login-password']")
    public WebElement passwordKutusu;

    @FindBy(xpath = "//button[text()='Login']")
    public WebElement loginButonu;


    @FindBy(xpath = "//*[text()='Accept']")
    public WebElement acceptCookies; */

    @FindBy(linkText = "My courses")
    public WebElement coursesLinki;
}