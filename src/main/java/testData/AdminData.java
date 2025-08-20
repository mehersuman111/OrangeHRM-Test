package testData;

import java.util.Arrays;
import java.util.List;

public interface AdminData {

    List<String> userMgmtRoleOptions = Arrays.asList("-- Select --", "Admin", "ESS");
    List<String> userMgmtStatusOptions = Arrays.asList("-- Select --", "Enabled", "Disabled");
    List<Object> addUserDivLabel = Arrays.asList("User Role","Employee Name","Status","Username","Password","Confirm Password");

}
