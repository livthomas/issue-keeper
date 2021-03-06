package qa.tools.ikeeper.action;

import org.junit.Assume;
import qa.tools.ikeeper.IssueDetails;
import qa.tools.ikeeper.IssueStatus;

public class Skip implements IAction {

    @Override
    public boolean canRunTest(IssueDetails details) {
        return (details.getStatus() == IssueStatus.CLOSED || details.getStatus() == IssueStatus.ON_QA || details
                .getStatus() == IssueStatus.VERIFIED || details.getStatus() == IssueStatus.UNKNOWN);
    }

    @Override
    public void fail(String testName, IssueDetails details) {
        String message = ActionMessage.generate(testName, details, "is skipped");
        Assume.assumeTrue(message, false);
    }

}
