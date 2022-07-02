package action_strategy.admin_2.manage_products;

import action_strategy.MyScanner;
import action_strategy.Strategy;
import action_strategy.StrategyCommons;
import hibernate.ProductRepositoryHibernate;
import tables.*;

public class ProductAddStrategy implements Strategy {
    @Override
    public void algorithm() {
        ProductRepositoryHibernate repository = StrategyCommons.getProductRepositoryHibernate();

        System.out.println("Enter Product details to add new product");
        Product newProduct = new Product();
        Category newCategory = new Category();
        PegiCategory newPegiCategory = new PegiCategory();
        Carrier newCarrier = new Carrier();

        System.out.println("Enter product title:");
        newProduct.setTitle(MyScanner.getText());

        System.out.println("Enter product Category");
        newCategory.setTitle(MyScanner.getText());

        System.out.println("Enter product PEGI Category");
        newPegiCategory.setTitle(MyScanner.getText());

        System.out.println("Enter Carrier type");
        newCarrier.setDescription(MyScanner.getText());

        newProduct.setCategory(newCategory);
        newProduct.setCarrier(newCarrier);
        newProduct.setPegiCategory(newPegiCategory);
        repository.createProduct(newProduct);
//        TODO
//        System.out.println("Product adding method");
        new ManageProductLogic().startAdminProductManagementPanel();
    }
}
