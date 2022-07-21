package action_strategy.admin_2.manage_branches;

import action_strategy.MyScanner;
import action_strategy.Strategy;
import action_strategy.StrategyCommons;
import hibernate.ProductRepositoryHibernate;

public class BranchActivateStrategy implements Strategy {
    @Override
    public void algorithm() {
        ProductRepositoryHibernate repository = StrategyCommons.getProductRepositoryHibernate();
        System.out.println("<------------------------------------------->");
        System.out.println("<-- LIST OF AVAILABLE DEACTIVATED BRANCHES ->");
        repository.getListOfAllBranches().stream()
                .distinct()
                .filter(b -> !b.isActive())
                .forEach(System.out::println);
        System.out.println("Enter Branch postal code to activate:");
        String postalCode = MyScanner.getText();
        repository.activateBranch(postalCode);

        MyScanner.pressAnyKeyToContinue();
        new ManageBranchesLogic().startAdminBranchManagementPanel();
    }
}
