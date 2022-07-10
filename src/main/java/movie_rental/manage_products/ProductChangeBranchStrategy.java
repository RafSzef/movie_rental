package movie_rental.manage_products;

import action_strategy.Strategy;
import action_strategy.admin_2.manage_branches.ManageBranchesLogic;

public class ProductChangeBranchStrategy implements Strategy {
    @Override
    public void algorithm() {
        new ManageBranchesLogic().startAdminBranchManagementPanel();
    }
}
