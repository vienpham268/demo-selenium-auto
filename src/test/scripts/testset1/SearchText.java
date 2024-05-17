package scripts.testset1;

import org.testng.annotations.Test;
import pages.home.SearchPage;
import pages.home.ToolQAPage;
import scripts.BaseTest;

public class SearchText extends BaseTest {
    @Test(groups = {"demo"})
    public void SearchText() {
        new ToolQAPage().Search();
        new SearchPage().VerifySearchingResult();
    }

}
