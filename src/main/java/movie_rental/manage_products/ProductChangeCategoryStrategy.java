package movie_rental.manage_products;

import action_strategy.MyScanner;
import action_strategy.Strategy;
import action_strategy.StrategyCommons;
import hibernate.ProductRepositoryHibernate;
import tables.Category;

public class ProductChangeCategoryStrategy implements Strategy {
    @Override
    public void algorithm() {
        ProductRepositoryHibernate repository = StrategyCommons.getProductRepositoryHibernate();
        System.out.println("<------------------------------------------->");
        System.out.println("<-- LIST OF ALL PRODUCTS ------------------->");
        repository.getAllProducts().forEach(System.out::println);
        System.out.println("Enter Product id to change branch:");

        Integer productId = MyScanner.getInt();


        System.out.println("<------------------------------------------->");
        System.out.println("<-- LIST OF AVAILABLE CATEGORIES ----------->");
        repository.getListOfAllCategories().stream()
                .distinct()
                .forEach(System.out::println);

        System.out.println("Select new category id:");
        try {
            Integer categoryId = MyScanner.getInt();
            Category newCategory = repository.getCategoryById(categoryId).get();

            repository.changeProductCategory(productId, newCategory);
            MyScanner.pressAnyKeyToContinue();
        } catch (Exception e) {
            System.out.println("No category with given id");
        }

        new ManageProductLogic().startAdminProductManagementPanel();
    }
}
