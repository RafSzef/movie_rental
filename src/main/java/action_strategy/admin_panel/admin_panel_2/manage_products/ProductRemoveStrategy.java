package action_strategy.admin_panel.admin_panel_2.manage_products;

import action_strategy.MyScanner;
import action_strategy.Strategy;
import action_strategy.StrategyCommons;
import hibernate.ProductRepositoryHibernate;

public class ProductRemoveStrategy implements Strategy {
    @Override
    public void algorithm() {
        ProductRepositoryHibernate repository = StrategyCommons.getProductRepositoryHibernate();
        System.out.println("<------------------------------------------->");
        System.out.println("<-- LIST OF ALL PRODUCTS ------------------->");
        repository.getAllActiveProducts().forEach(System.out::println);
        System.out.println("Enter Product id to remove:");
        Integer id = MyScanner.getInt();
        repository.deactivateProduct(id);
        new ManageProductLogic().startAdminProductManagementPanel();

    }
}
