package listener;

import asserts.CustomSoftAssert;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

import java.util.ArrayList;

public class MethodListener implements IInvokedMethodListener {
    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        if (method.isTestMethod()) {
            if (CustomSoftAssert.throwableList.size() > 0) {
                testResult.setStatus(ITestResult.FAILURE);
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("\n");
                for (Throwable throwable:CustomSoftAssert.throwableList){
                    stringBuilder.append(throwable).append("\n");
                }
                testResult.setThrowable(new Throwable(stringBuilder.toString()));
                CustomSoftAssert.throwableList = new ArrayList<>();
            }
        }
    }
}
