package services.dashboard;

import org.openqa.selenium.WebDriver;
import pageObjects.dashboard.DashboardScreen;

public class DashboardService extends DashboardScreen {


    public DashboardService(WebDriver driver) {
        super(driver);
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