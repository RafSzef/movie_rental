package action_strategy.client_panel.client_panel_2.search_panel;

import action_strategy.Context;
import action_strategy.Strategy;
import action_strategy.StrategyPicker;
import action_strategy.client_panel.client_panel_2.ReturnToClientPanelStrategy;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SearchPanelContext implements Context {
    @Override
    public Strategy operation(StrategyPicker strategyPicker) {

        switch (strategyPicker) {
            case OPTION_1:
                return new ShowAllProductStrategy();
            case OPTION_2:
                return new SearchByTittleStrategy();
            case OPTION_3:
                return new SearchByDirectorStrategy();
            case OPTION_4:
                return new SearchByCategoryStrategy();
            case OPTION_5:
                return new SearchByPegiCategoryStrategy();
            case OPTION_6:
                return new SearchByReleaseYearStrategy();
            case OPTION_7:
                return new SearchByCarrierTypeStrategy();
            case OPTION_8:
                return new ReturnToClientPanelStrategy();
            default: {
                log.info("Wrong - enter command again");
                return operation(StrategyPicker.getOptionFromScanner());
            }
        }
    }
}
