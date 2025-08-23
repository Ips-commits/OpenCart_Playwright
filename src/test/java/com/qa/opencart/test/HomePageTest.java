package com.qa.opencart.test;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.Constants.AppConstants;
import com.qa.opencart.base.BaseTest;

public class HomePageTest extends BaseTest{
	
	@Test
	public void homePageTitleTest()
	{
		String actualTitle=homePage.getHomePageTitle();
		Assert.assertEquals(actualTitle,AppConstants.LOGIN_PAGE_TITLE);
	
	}
	@Test
	public void UrlTitleTest()
	{
		String actualUrl=homePage.getHomePageUrl();
		Assert.assertEquals(actualUrl,prop.getProperty("url"));	
	}
	@DataProvider
	public Object[][] getProductData()
	{
		return new Object[][]
				{
			{"Macbook"},
			{"iMac"},
			{"Samsung"}
				};
	}
	@Test(dataProvider="getProductData")
	public void HeaderTitleTest(String productName) throws InterruptedException
	{
		Thread.sleep(5000);
		String headerText=homePage.getsearchresult(productName);
		Assert.assertEquals(headerText, "Search - " + productName);
	}
		
	@AfterTest
	public void tearDown()
	{
		page.context().browser().close();
	}

}
