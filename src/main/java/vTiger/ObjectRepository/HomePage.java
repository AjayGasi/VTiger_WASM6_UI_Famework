package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vTiger.GenericLibrary.WebDriverCommonLibrary;

public class HomePage extends WebDriverCommonLibrary
{
	// Declaration
	
	@FindBy(linkText = "Calendar") private WebElement CalendarLink;
	@FindBy(linkText = "Leads") private WebElement LeadsLink;
	@FindBy(linkText = "Organizations") private WebElement OrganizationsLink;
	@FindBy(linkText = "Contacts") private WebElement ContactsLink;
	@FindBy(linkText = "Opportunities") private WebElement OpportunitiesLink;
	@FindBy(linkText = "Products") private WebElement ProductsLink;
	@FindBy(linkText = "Documents") private WebElement DocumentsLink;
	@FindBy(linkText = "Email") private WebElement EmailLink;
	@FindBy(linkText = "Trouble Tickets") private WebElement TroubleTicketsLink;
	@FindBy(linkText = "Dashboard") private WebElement DashboardLink;
	@FindAll({@FindBy(linkText = "More"),@FindBy(xpath = "//img[@src='themes/softed/images/menuDnArrow.gif']")}) 
	private WebElement MoreLink;
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']") private WebElement AdministratorImg;
	@FindBy(linkText = "Sign Out") private WebElement SignOutLink;
	
	
	// Initialization
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}

	// Utilization
	
	public WebElement getCalendarLink() {
		return CalendarLink;
	}

	public WebElement getLeadsLink() {
		return LeadsLink;
	}

	public WebElement getOrganizationsLink() {
		return OrganizationsLink;
	}

	public WebElement getContactsLink() {
		return ContactsLink;
	}

	public WebElement getOpportunitiesLink() {
		return OpportunitiesLink;
	}

	public WebElement getProductsLink() {
		return ProductsLink;
	}

	public WebElement getDocumentsLink() {
		return DocumentsLink;
	}

	public WebElement getEmailLink() {
		return EmailLink;
	}

	public WebElement getTroubleTicketsLink() {
		return TroubleTicketsLink;
	}

	public WebElement getDashboardLink() {
		return DashboardLink;
	}

	public WebElement getMoreLink() {
		return MoreLink;
	}

	public WebElement getAdministratorImg() {
		return AdministratorImg;
	}

	public WebElement getSignOutLink() {
		return SignOutLink;
	}
	

	//Business Library
	
	/**
	 * This method will click on calendar
	 */
	
	public void clickCalendarLink()
	{
		CalendarLink.click();
	}
	
	/**
	 * This method will click on leads 
	 */
	
	public void clickLeadsLink()
	{
		LeadsLink.click();
	}
	
	/**
	 * This method will click on Organizations
	 */
	public void clickOrganizationsLink()
	{
		OrganizationsLink.click();
	}
	
	/**
	 * This method will click on contacts
	 */
	public void clickContactsLink()
	{
		ContactsLink.click();
	}
	
	/**
	 * This method will click on opportunities
	 */
	public void clickOpportunitiesLink()
	{
		OpportunitiesLink.click();
	}
	
	/**
	 * This method will click on products
	 */
	public void clickProductsLink()
	{
		ProductsLink.click();
	}
	
	/**
	 * This method will click on documents
	 */
	public void clickDocumentsLink()
	{
		DocumentsLink.click();
	}
	
	/**
	 * This method will click on email
	 */
	public void clickEmailLink()
	{
		EmailLink.click();
	}
	
	/**
	 * This method will click on Trouble tickets
	 */
	public void clickTroubleTicketsLink()
	{
		TroubleTicketsLink.click();
	}
	
	/**
	 * This method will click on dashboard
	 */
	public void clickDashboardLink()
	{
		DashboardLink.click();
	}
	
	/**
	 * This method will mouse hover to more link
	 * @param driver
	 */
	public void moveToMoreLink(WebDriver driver)
	{
		mouseHoverOn(driver, MoreLink );
	}
	
    /**
     * This method will perform sign out of application
     * @param driver
     */
	public void signOutOfApp(WebDriver driver)
	{
		mouseHoverOn(driver, AdministratorImg);
		SignOutLink.click();
	}
}
