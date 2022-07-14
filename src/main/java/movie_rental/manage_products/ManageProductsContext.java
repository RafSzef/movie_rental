package movie_rental.manage_products;

import action_strategy.Context;
import action_strategy.Strategy;
import action_strategy.StrategyPicker;
import action_strategy.admin_2.ReturnToAdminPanelStrategy;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ManageProductsContext implements Context {
    @Override
    public Strategy operation(StrategyPicker strategyPicker) {

        switch (strategyPicker) {
            case OPTION_1:
                return new ProductAddStrategy();
            case OPTION_2:
                return new ProductRemoveStrategy();
            case OPTION_3:
                return new ProductActivateStrategy();
            case OPTION_4:
                return new ProductChangeBranchStrategy();
            case OPTION_5:
                return new ProductChangeCategoryStrategy();
            case OPTION_6:
                return new ProductChangePegiCategoryStrategy();
            case OPTION_7:
                return new ReturnToAdminPanelStrategy();
            default: {
                log.info("Wrong - enter command again");
                return operation(StrategyPicker.getOptionFromScanner());
            }
        }
    }
}
