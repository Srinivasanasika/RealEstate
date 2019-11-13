package com.training.pom;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPOMRealEstate {
	private WebDriver driver; 
	
	public LoginPOMRealEstate(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="user_login")
	private WebElement userName; 
	
	@FindBy(id="user_pass")
	private WebElement password;
	
	@FindBy(name="login")
	private WebElement loginBtn; 
	
	@FindBy(xpath="//*[@id=\"menu-posts\"]/a/div[3]")
	private WebElement mouseoverpost;
	
	@FindBy(xpath="//*[@id=\"menu-posts\"]/ul/li[4]/a")
	private WebElement categories;
	
	@FindBy(id="cb-select-550")
	private WebElement selectcheckbox;
	@FindBy(xpath="//*[@id=\"bulk-action-selector-top\"]/option[2]")
	private WebElement selecttop;
	@FindBy(id="doaction")
	private WebElement apply;
	
	
	
	
	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}
	
	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}
	
	public void clickLoginBtn() {
		this.loginBtn.click(); 
	}
	
	public void clickpost() {
		this.mouseoverpost.click();
		this.categories.click();
		this.selectcheckbox.click();
		this.selecttop.click();
		this.apply.click();
		WebElement message=driver.findElement(By.xpath("//*[@id=\"message\"]/p"));
		String str=message.getText();
		String strs="Categories deleted.";
		Assert.assertEquals(strs, str);
		
		
	}
	
}
