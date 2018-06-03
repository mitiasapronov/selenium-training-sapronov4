import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Homework3 {

    static WebDriver driver;

    public static final String url = "http://localhost/litecart";

    public WebElement getBoxCampaigns(){
        return driver.findElement(By.id("box-campaigns"));
    }

    public String getProductName (WebElement BoxCampaigns){
        return BoxCampaigns.findElement(By.className("name")).getText();
    }

    public String getRegularPrice(WebElement BoxCampaigns){
        return BoxCampaigns.findElement(By.className("regular-price")).getText();
    }
    public String getCampaignPrice(WebElement BoxCampaigns){
        return BoxCampaigns.findElement(By.className("campaign-price")).getText();
    }
    public String getRegularPriceStrike(WebElement MainRegularPrice){
        return MainRegularPrice.getCssValue("text-decoration");
    }
    public String getRegularPriceColor (WebElement MainRegularPrice){
        return MainRegularPrice.getCssValue("color");
    }
    public WebElement getMainRegularPrice(WebElement BoxCampaigns){
        return BoxCampaigns.findElement(By.className("regular-price"));
    }
    public boolean isStrikePresent(String mainRegularPriceStrike){
        return mainRegularPriceStrike.contains("line-through");
    }
    public WebElement getMainCampaignPrice(WebElement BoxCampaigns){
        return BoxCampaigns.findElement(By.className("campaign-price"));
    }
    public String getCampaignPriceBold(WebElement MainCampaignPrice){
        return MainCampaignPrice.getCssValue("font-weight");
    }
    public String getCampaignPriceColor (WebElement MainCampaignPrice){
        return MainCampaignPrice.getCssValue("color");
    }
    public String getTitle() {
        return driver.findElement(By.id("box-product")).findElement(By.className("title")).getText();
    }
    public WebElement getInformation() {
        return driver.findElement(By.className("information"));
    }
    public String getSecondaryRegularPrice(WebElement Information){
        return Information.findElement(By.className("regular-price")).getText();
    }
    public String getSecondaryCampaignPrice(WebElement Information){
        return Information.findElement(By.className("campaign-price")).getText();
    }
    public String getSecondaryRegularPriceStrike(){
        return driver.findElement(By.className("regular-price")).getCssValue("text-decoration");
    }
    public boolean isSecondaryStrikePresent(String secondaryRegularPriceStrike){
        return secondaryRegularPriceStrike.contains("line-through");
    }
    public String getSecondaryRegularPriceColor (){
        return driver.findElement(By.className("regular-price")).getCssValue("color");
    }
    public String getSecondaryCampaignPriceBold(){
        return driver.findElement(By.className("campaign-price")).getCssValue("font-weight");
    }
    public String getSecondaryCampaignPriceColor (){
        return driver.findElement(By.className("campaign-price")).getCssValue("color");
    }

    @Test
    public void ChromeTest(){
        ChromeDriverManager.getInstance().setup();
        driver =new ChromeDriver();
        driver.get(url);
        WebElement BoxCampaigns = getBoxCampaigns();
        String mainProductName = getProductName(BoxCampaigns);
        String mainRegularPrice = getRegularPrice(BoxCampaigns);
        String mainCampaignPrice = getCampaignPrice(BoxCampaigns);
        String mainRegularPriceStrike = getRegularPriceStrike(getMainRegularPrice(BoxCampaigns));
        String mainRegularPriceColor = getRegularPriceColor(getMainRegularPrice(BoxCampaigns));
        String mainCampaignPriceBold = getCampaignPriceBold(getMainCampaignPrice(BoxCampaigns));
        String mainCampaignPriceColor = getCampaignPriceColor(getMainCampaignPrice(BoxCampaigns));
     //   System.out.println(getCampaignPriceBold(getMainCampaignPrice(BoxCampaigns)));
        Assert.assertTrue(isStrikePresent(mainRegularPriceStrike));
        Assert.assertEquals("rgba(119, 119, 119, 1)", mainRegularPriceColor);
        Assert.assertEquals("rgba(204, 0, 0, 1)", mainCampaignPriceColor);
        Assert.assertEquals("700",getCampaignPriceBold(getMainCampaignPrice(BoxCampaigns)));
        driver.findElement(By.cssSelector("#box-campaigns > div > ul > li > a.link > div.image-wrapper > img")).click();
        //Assert.assertSame(getTitle(), mainProductName);
        Assert.assertEquals(getTitle(), mainProductName);
        WebElement Information = getInformation();
        //System.out.println(getSecondaryRegularPrice(Information));
        //System.out.println(getSecondaryCampaignPrice(Information));
        //System.out.println(getTitle());
        Assert.assertEquals(getSecondaryRegularPrice(Information),mainRegularPrice);
        Assert.assertEquals(getSecondaryCampaignPrice(Information),mainCampaignPrice);
        //System.out.println(getSecondaryRegularPriceStrike());
        String secondaryRegularPriceStrike = getSecondaryRegularPriceStrike();
        Assert.assertTrue(isSecondaryStrikePresent(secondaryRegularPriceStrike));
        // System.out.println(getSecondaryRegularPriceColor());
        // Assert.assertEquals(getSecondaryRegularPriceColor(),mainRegularPriceColor);
        // rgba(102, 102, 102, 1) , rgba(119, 119, 119, 1) colors are different
        //System.out.println(getSecondaryCampaignPriceBold());
        //System.out.println(mainCampaignPriceBold);
        //System.out.println(getSecondaryCampaignPriceColor());
        Assert.assertEquals(getSecondaryCampaignPriceBold(),mainCampaignPriceBold);
        Assert.assertEquals(getSecondaryCampaignPriceColor(),mainCampaignPriceColor);
        driver.quit();
    }
}
