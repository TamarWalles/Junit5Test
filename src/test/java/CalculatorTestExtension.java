import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.BeforeTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

    public class CalculatorTestExtension implements BeforeTestExecutionCallback, AfterTestExecutionCallback {

        @Override
        public void beforeTestExecution(ExtensionContext extensionContext) throws Exception {
            System.out.println(extensionContext.getDisplayName()+" before test execution");
        }
        @Override
        public void afterTestExecution(ExtensionContext extensionContext) throws Exception {
            System.out.println(extensionContext.getDisplayName()+" after test execution");
        }
}
