package action_strategy.admin_panel.admin_panel_2.manage_directors;

import action_strategy.Context;
import action_strategy.Strategy;
import action_strategy.StrategyPicker;
import action_strategy.admin_panel.admin_panel_2.ReturnToAdminPanelStrategy;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DirectorContext implements Context {
    @Override
    public Strategy operation(StrategyPicker strategyPicker) {

        switch (strategyPicker) {
            case OPTION_1:
                return new DirectorAddStrategy();
            case OPTION_2:
                return new DirectorRemoveStrategy();
            case OPTION_3:
                return new ReturnToAdminPanelStrategy();
            default: {
                log.info("Wrong - enter command again");
                return operation(StrategyPicker.getOptionFromScanner());
            }
        }
    }
}
