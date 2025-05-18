import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;

import java.util.Optional;

public class TestWatcherExtension implements TestWatcher {
    @Override
    public void testSuccessful(ExtensionContext context) {
        System.out.println("Test successful: " + context.getDisplayName());
    }


    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        System.out.println("Test failed: " + context.getDisplayName());
        cause.printStackTrace();
    }


    @Override
    public void testAborted(ExtensionContext context, Throwable cause) {
        System.out.println("Test aborted: " + context.getDisplayName());

    }


    @Override
    public void testDisabled(ExtensionContext context, Optional<String> reason) {
        System.out.println("Test disabled: " + context.getDisplayName() + " with reason: " + reason.orElse("No reason"));

    }
}
