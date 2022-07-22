package action_strategy.client_panel.client_panel_2.search_panel;

import action_strategy.Strategy;
import action_strategy.StrategyPicker;

public class SearchPanelLogic {

    public void startAdminUserManagementPanel() {
        displayWelcomeMsg();
        userSearchPanelScreen();
    }

    private void userSearchPanelScreen() {
        optionPane();
        SearchPanelContext manageUsersContext = new SearchPanelContext();
        Strategy operation = manageUsersContext.operation(StrategyPicker.getOptionFromScanner());
        operation.algorithm();
    }

    private void displayWelcomeMsg() {
        System.out.println("<------------------------------------------->");
        System.out.println("-<------------ SEARCH AND RENT ------------->");
        System.out.println("<------------------------------------------->");
    }

    private void optionPane() {
        System.out.println("Select option:");
        System.out.println("<------------------------------------------->");
        System.out.println("<--SEARCH BY: ------------------------------>");
        System.out.println("1. Show all products!");
        System.out.println("2. Title");
        System.out.println("3. Director");
        System.out.println("4. Category");
        System.out.println("5. PEGI Category");
        System.out.println("6. Release year");
        System.out.println("7. Carrier type");
        System.out.println("8. Return to previous menu");
        System.out.println("<------------------------------------------->");
    }
}
