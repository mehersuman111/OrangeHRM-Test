package services.dashboard;

import framework.browserCofig.TestInit;
import org.openqa.selenium.WebDriver;
import pageObjects.dashboard.DashboardScreen;

public class DashboardService extends DashboardScreen {
    private static DashboardService dashboardService;
    public DashboardService(WebDriver driver) {
        super(driver);
    }
    public static DashboardService getDashboardService() {
        if (dashboardService == null) {
            dashboardService = new DashboardService(TestInit.driver);
        }
        return dashboardService;
    }

    public DashboardService verifyAvailableDetailsInDashboardPage() {
            checkAvailableElement(dashboardHeader,"Dashboard header")
                    .checkAvailableElement(upgradeButton,"Upgrade button")
                    .checkAvailableElement(userDropdown,"User dropdown")
                    .checkAvailableElement(helpButton,"Help button")
                    .checkAvailableElement(dashboardMenu,"Dashboard menu", "is")
                    .checkAvailableElement(menuArrowButton,"Menu arrow button")
                    .checkAvailableElement(brandBanner,"Brand banner");
            return this;
    }
}