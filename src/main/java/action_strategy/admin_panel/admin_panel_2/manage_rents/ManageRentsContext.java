package action_strategy.admin_panel.admin_panel_2.manage_rents;

import action_strategy.Context;
import action_strategy.Strategy;
import action_strategy.StrategyPicker;
import action_strategy.admin_panel.admin_panel_2.ReturnToAdminPanelStrategy;
import action_strategy.admin_panel.admin_panel_2.manage_users.UserAddStrategy;
import action_strategy.admin_panel.admin_panel_2.manage_users.UserModifyStrategy;
import action_strategy.admin_panel.admin_panel_2.manage_users.UserRemoveStrategy;
import action_strategy.admin_panel.admin_panel_2.manage_users.UserToggleAdminStrategy;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ManageRentsContext implements Context {
    @Override
    public Strategy operation(StrategyPicker strategyPicker) {

        switch (strategyPicker) {
            case OPTION_1:
                return new ShowAllRentsStrategy();
            case OPTION_2:
                return new ShowAllClientRents() ;
            case OPTION_3:
                return new ReturnToAdminPanelStrategy();
            case OPTION_4:
                return new ReturnToAdminPanelStrategy();
            case OPTION_5:
                return new ReturnToAdminPanelStrategy();
            default: {
                log.info("Wrong - enter command again");
                return operation(StrategyPicker.getOptionFromScanner());
            }
        }
    }
}
