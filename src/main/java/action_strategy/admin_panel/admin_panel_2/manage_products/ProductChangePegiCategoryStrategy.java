package action_strategy.admin_panel.admin_panel_2.manage_products;

import action_strategy.MyScanner;
import action_strategy.Strategy;
import action_strategy.StrategyCommons;
import hibernate.ProductRepositoryHibernate;
import tables.PegiCategory;

public class ProductChangePegiCategoryStrategy implements Strategy {
    @Override
    public void algorithm() {
        ProductRepositoryHibernate repository = StrategyCommons.getProductRepositoryHibernate();
        System.out.println("<------------------------------------------->");
        System.out.println("<-- LIST OF ALL PRODUCTS ------------------->");
        repository.getAllProducts().forEach(System.out::println);
        System.out.println("Enter Product id to change branch:");

        Integer productId = MyScanner.getInt();


        System.out.println("<------------------------------------------->");
        System.out.println("<-- LIST OF AVAILABLE PEGI CATEGORIES ------>");
        repository.getListOfAllPegiCategories().stream()
                .distinct()
                .forEach(System.out::println);

        System.out.println("Select new PEGI category id:");
        try {
            Integer categoryId = MyScanner.getInt();
            PegiCategory newCategory = repository.getPegiCategoryById(categoryId).get();

            repository.changePegiProductCategory(productId, newCategory);
            MyScanner.pressAnyKeyToContinue();
        } catch (Exception e) {
            System.out.println("No PEGI category with given id");
        }

        new ManageProductLogic().startAdminProductManagementPanel();
    }
}
