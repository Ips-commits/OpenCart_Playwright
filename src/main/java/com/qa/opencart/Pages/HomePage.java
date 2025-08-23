package com.qa.opencart.Pages;

import com.microsoft.playwright.Page;

public class HomePage {
	
	private Page page;
	
	//1.String Locators_Object Repo
	
	private String search = "input[name='search']";
	private String searchIcon = "div#search button";
	private String searchPageHeader = "div#content h1";
	private String loginLink = "a:text('Login')";
	private String myAccountLink = "a[title='My Account']";
	
	//2. page constructor
	
	public HomePage(Page page)
	{
		this.page=page;
	}
	
	//3. page actions/methods
	public String getHomePageTitle()
	{
		String title= page.title();
		System.out.print(title);
		return title;
	}
	public String getHomePageUrl()
	{
		String url=page.url();
		System.out.print(url);
		return url;
	}
	public String getsearchresult(String productName)
	{
		page.fill(search, productName);
		page.click(searchIcon);
		String header=page.textContent(searchPageHeader);
		System.out.println(header);
		return header;
	}
	
	public LoginPage navigateToLoginPage() 
	{
		page.click(myAccountLink);
		page.click(loginLink);
		return new LoginPage(page);
	}

}
