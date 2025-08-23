package com.qa.opencart.base;

import java.util.Properties;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.microsoft.playwright.Page;
import com.qa.opencart.Pages.HomePage;
import com.qa.opencart.Pages.LoginPage;
import com.qa.opencart.factory.PlaywrightFactory;

public class BaseTest {
	
	PlaywrightFactory pf;
	protected Page page;
	protected HomePage homePage;
	public Properties prop;
	protected  LoginPage loginPage;
			
	@BeforeTest
	public void setup()
	{
		pf=new PlaywrightFactory();
		prop=pf.init_prop();
		page=pf.initBrowser(prop);
		homePage=new HomePage(page);
		homePage.navigateToLoginPage();
	}
	
	@AfterTest
	public void tearDown()
	{
		page.context().browser().close();
	}


}
