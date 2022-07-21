package action_strategy.admin_panel;

import action_strategy.Strategy;
import movie_rental.manage_products.ManageProductLogic;

public class ProductOperationsStrategy implements Strategy {
    @Override
    public void algorithm() {

        new ManageProductLogic().startAdminProductManagementPanel();
    }
}
