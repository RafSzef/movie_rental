package action_strategy.admin_panel.admin_panel_2.manage_rents;

import action_strategy.Strategy;
import action_strategy.StrategyPicker;

public class ManageRentsLogic {

    public void startAdminRentsManagementPanel() {
        displayWelcomeMsg();
        adminRentsManagementScreen();
    }

    private void adminRentsManagementScreen() {
        optionPane();
        ManageRentsContext manageUsersContext = new ManageRentsContext();
        Strategy operation = manageUsersContext.operation(StrategyPicker.getOptionFromScanner());
        operation.algorithm();
    }

    private void displayWelcomeMsg() {
        System.out.println("<------------------------------------------->");
        System.out.println("<---------- RENTS MANAGEMENT PANEL --------->");
        System.out.println("<------------------------------------------->");
    }

    private void optionPane() {
        System.out.println("Select option:");
        System.out.println("<------------------------------------------->");
        System.out.println("1. Show all rents");
        System.out.println("2. -");
        System.out.println("3. -");
        System.out.println("4. -");
        System.out.println("5. Return to previous menu");
        System.out.println("<------------------------------------------->");
    }
}
