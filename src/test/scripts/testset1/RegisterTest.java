package scripts.testset1;

import dataprovider.Provider;
import dto.RegisterPaidTraining;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;
import pages.register.RegisterPage;
import scripts.BaseTest;

@Slf4j
public class RegisterTest extends BaseTest {
    @Test(dataProviderClass = Provider.class, dataProvider = "getData")
    public void registerPaidTraining(RegisterPaidTraining data) {
        new RegisterPage().tryToAssert();
    }
}
