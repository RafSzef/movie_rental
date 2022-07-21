package action_strategy.admin_2.manage_branches;

import action_strategy.MyScanner;
import action_strategy.Strategy;
import action_strategy.StrategyCommons;
import hibernate.ProductRepositoryHibernate;
import tables.Branch;


public class BranchDeactivateStrategy implements Strategy {
    @Override
    public void algorithm() {
        ProductRepositoryHibernate repository = StrategyCommons.getProductRepositoryHibernate();
        System.out.println("<------------------------------------------->");
        System.out.println("<-- LIST OF AVAILABLE BRANCHES ------------->");
        repository.getListOfAllBranches().stream()
                .distinct()
                .filter(Branch::isActive)
                .forEach(System.out::println);
        System.out.println("Enter Branch postal code to deactivate:");
        String postalCode = MyScanner.getText();
        repository.deactivateBranch(postalCode);

        MyScanner.pressAnyKeyToContinue();
        new ManageBranchesLogic().startAdminBranchManagementPanel();
    }
}
