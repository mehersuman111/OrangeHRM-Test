package webTest.dashboard;

import framework.browserCofig.TestInit;
import org.testng.annotations.Test;

public class DashboardTest extends TestInit {
    @Test
    public void UI_Web_01_Test_DashboardScreen() {
        System.out.println("To verify all available details in the dashboard page");
        dashboardService.verifyAvailableDetailsInDashboardPage();
    }
}
