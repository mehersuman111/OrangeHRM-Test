package services.myInfo.personalDetails;

import org.openqa.selenium.WebDriver;
import pageObjects.myInfo.PersonalDetailsTab;

public class PersonalDetailsService extends PersonalDetailsTab {
    public PersonalDetailsService(WebDriver driver) {
        super(driver);
    }
    public PersonalDetailsService NavigateToPersonalDetailsTab() {
        clickOnButton(myInfoMenu,"My Info Menu button")
                .clickOnButton(personalDetails,"Personal Details Tab")
                .checkAppearanceOfElement(personalDetailsHeder,"Personal Details Tab Header");
        return this;
    }
    public PersonalDetailsService checkNationalityOptions() {
        clickOnButton(nationalityDDf,"Nationality dropdown field button")
                .getElementSource(nationalityDDf,"div");
        return this;
    }
}