package action_strategy.admin_panel.admin_panel_2.manage_products;

import action_strategy.MyScanner;
import action_strategy.Strategy;
import action_strategy.StrategyCommons;
import hibernate.ProductRepositoryHibernate;

public class ProductActivateStrategy implements Strategy {
    @Override
    public void algorithm() {
        ProductRepositoryHibernate repository = StrategyCommons.getProductRepositoryHibernate();
        System.out.println("<------------------------------------------->");
        System.out.println("<-- LIST OF ALL PRODUCTS ------------------->");
        repository.getAllInactiveActiveProducts().forEach(System.out::println);
        System.out.println("Enter Product id to activate:");
        Integer id = MyScanner.getInt();
        repository.activateProduct(id);
        new ManageProductLogic().startAdminProductManagementPanel();

    }
}
