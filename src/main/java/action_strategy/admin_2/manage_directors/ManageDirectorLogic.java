package action_strategy.admin_2.manage_directors;

import action_strategy.Context;
import action_strategy.Strategy;
import action_strategy.StrategyPicker;

public class ManageDirectorLogic {

    public void startAdminDirectorsManagementPanel() {
        displayWelcomeMsg();
        adminDirectorsManagementScreen();
    }

    private void adminDirectorsManagementScreen() {
        optionPane();
        Context manageDirectorsContext = new DirectorContext();
        Strategy strategy = manageDirectorsContext.operation(StrategyPicker.getOptionFromScanner());
        strategy.algorithm();
    }

    private void displayWelcomeMsg() {
        System.out.println("<------------------------------------------->");
        System.out.println("<------ DIRECTORS MANAGEMENT PANEL --------->");
        System.out.println("<------------------------------------------->");
    }

    private void optionPane() {
        System.out.println("Select option:");
        System.out.println("<------------------------------------------->");
        System.out.println("1. Add director");
        System.out.println("2. Remove director");
        System.out.println("3. Return to previous menu");
        System.out.println("<------------------------------------------->");
    }
}
