package scripts.testset1;

import org.testng.annotations.Test;
import pages.home.SWTestingTutorialPage;
import pages.home.ToolQAPage;
import scripts.BaseTest;

public class SWTestingTutorialTest extends BaseTest {
    @Test(groups = {"demo"})
    public void SWTestingTutorialTest() {
        new ToolQAPage().accessSWTestingPage();
        new SWTestingTutorialPage().verifySWTestingPage();
        new SWTestingTutorialPage().scrollToEndPage();
//        new SWTestingTutorialPage().directToFBPage();
//        new SWTestingTutorialPage().getFBAttribute();
    }
}
