package scripts.testset1;

import dataprovider.Provider;
import org.testng.annotations.Test;
import pages.home.NetlifyHomePage;
import scripts.BaseTest;

public class NetlifySearchTest extends BaseTest {
    @Test(dataProviderClass = Provider.class, dataProvider = "netlifySearchKeywords", groups = {"test"})
    public void searchTest(String keyword) {
        new NetlifyHomePage().doASearch(keyword);
        new NetlifyHomePage().clearSearch();
    }
}
