package action_strategy.admin_2.manage_branches;

import action_strategy.MyScanner;
import action_strategy.Strategy;
import action_strategy.StrategyCommons;
import hibernate.ProductRepositoryHibernate;


public class BranchRemoveStrategy implements Strategy {
    @Override
    public void algorithm() {
        ProductRepositoryHibernate repository = StrategyCommons.getProductRepositoryHibernate();
        System.out.println("<------------------------------------------->");
        System.out.println("<-- LIST OF AVAILABLE BRANCHES ------------->");
        repository.getListOfAllBranches().stream()
                .distinct()
                .forEach(System.out::println);
        System.out.println("Enter Branch postal code to remove:");
        String postalCode = MyScanner.getText();
        repository.removeBranch(postalCode);

        MyScanner.pressAnyKeyToContiunue();
        new ManageBranchesLogic().startAdminBranchManagementPanel();
    }
}
