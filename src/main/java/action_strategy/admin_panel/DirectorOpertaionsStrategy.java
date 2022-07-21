package action_strategy.admin_panel;

import action_strategy.Strategy;
import action_strategy.admin_2.manage_directors.ManageDirectorLogic;

public class DirectorOpertaionsStrategy implements Strategy {
    @Override
    public void algorithm() {
        new ManageDirectorLogic().startAdminDirectorsManagementPanel();
    }
}
