package action_strategy.admin_2.manage_branches;

import action_strategy.MyScanner;
import action_strategy.Strategy;
import action_strategy.StrategyCommons;
import hibernate.ProductRepositoryHibernate;
import tables.Branch;

public class BranchAddStrategy implements Strategy {
    @Override
    public void algorithm() {

        ProductRepositoryHibernate repository = StrategyCommons.getProductRepositoryHibernate();
        System.out.println("<------------------------------------------->");
        System.out.println("<-- LIST OF AVAILABLE BRANCHES ------------->");

        repository.getListOfAllBranches().stream()
                .distinct()
                .forEach(System.out::println);

        System.out.println("Enter Branch details to add new branch");
        Branch newBranch = new Branch();
        System.out.println("Enter name:");
        newBranch.setName(MyScanner.getText());
        System.out.println("Enter postal-Code:");
        newBranch.setPostalCode(MyScanner.getText());
        System.out.println("Enter address");
        newBranch.setAddress(MyScanner.getText());
        System.out.println("Set active");
        newBranch.setActive(MyScanner.yesOrNo());

        try {
            repository.addBranch(newBranch);
        } catch(Exception e) {
            System.out.println("Could not add branch");
        }

        MyScanner.pressAnyKeyToContiunue();
        new ManageBranchesLogic().startAdminBranchManagementPanel();
        //TODO
        System.out.println("Branch add method");
        new ManageBranchesLogic().startAdminBranchManagementPanel();
    }
}
