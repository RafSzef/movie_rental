package movie_rental.manage_products;

import action_strategy.Strategy;

public class ProductChangeCategoryStrategy implements Strategy {
    @Override
    public void algorithm() {
        //TODO
        System.out.println("change product category method");
        new ManageProductLogic().startAdminProductManagementPanel();
    }
}
