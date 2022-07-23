package action_strategy.admin_panel;

import action_strategy.Strategy;
import action_strategy.admin_panel.admin_panel_2.manage_products.ManageProductLogic;
import action_strategy.admin_panel.admin_panel_2.manage_rents.ManageRentsLogic;

public class RentsOperationStrategy implements Strategy {
    @Override
    public void algorithm() {
        new ManageRentsLogic().startAdminRentsManagementPanel();
    }
}
