package movie_rental.manage_products;

import action_strategy.Strategy;

public class ProductRemoveStrategy implements Strategy {
    @Override
    public void algorithm() {
        //TODO
        System.out.println("Product remove method");
        new ManageProductLogic().startAdminProductManagementPanel();

    }
}
