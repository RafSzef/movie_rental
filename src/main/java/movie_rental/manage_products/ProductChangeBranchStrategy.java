package movie_rental.manage_products;

import action_strategy.MyScanner;
import action_strategy.Strategy;
import action_strategy.StrategyCommons;
import hibernate.ProductRepositoryHibernate;
import tables.Branch;

public class ProductChangeBranchStrategy implements Strategy {
    @Override
    public void algorithm() {
        ProductRepositoryHibernate repository = StrategyCommons.getProductRepositoryHibernate();
        System.out.println("<------------------------------------------->");
        System.out.println("<-- LIST OF ALL PRODUCTS ------------------->");
        repository.getAllProducts().forEach(System.out::println);
        System.out.println("Enter Product id to change branch:");

        Integer productId = MyScanner.getInt();


        System.out.println("<------------------------------------------->");
        System.out.println("<-- LIST OF AVAILABLE BRANCHES ------------->");
        repository.getListOfAllBranches().stream()
                .distinct()
                .forEach(System.out::println);

        System.out.println("Select new Branch id:");
        try {
            Integer branchId = MyScanner.getInt();
            Branch newBranch = repository.getBranch(branchId).get();

            repository.changeProductBranch(productId, newBranch);
            MyScanner.pressAnyKeyToContinue();
        } catch (Exception e) {
            e.printStackTrace();
        }

        new ManageProductLogic().startAdminProductManagementPanel();
    }
}
