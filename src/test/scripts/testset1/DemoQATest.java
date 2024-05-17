package scripts.testset1;

import enums.Option;
import org.testng.annotations.Test;
import pages.home.DemoQAPage;
import scripts.BaseTest;

public class DemoQATest extends BaseTest {
    @Test(groups = {"smoke"})
    public void DemoQATest() {
//        new DemoQAPage().hoverOnTooltip();
//        new DemoQAPage().verifyTooltip();
//        new DemoQAPage().dragAndDrop();
//        new DemoQAPage().switchToNewWindowTab();
        new DemoQAPage().switchToIFrame();
//        new DemoQAPage().selectItem(Option.OPTION2);
    }
}
