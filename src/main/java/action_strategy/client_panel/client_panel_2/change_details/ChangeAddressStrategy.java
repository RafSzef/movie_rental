package action_strategy.client_panel.client_panel_2.change_details;

import action_strategy.Strategy;

public class ChangeAddressStrategy implements Strategy {
    @Override
    public void algorithm() {

        //TODO
        System.out.println("address change method");
        new ChangeDetailsPanelLogic().startChangeDetailsPanelPanel();
    }
}
