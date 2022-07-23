package action_strategy.admin_panel.admin_panel_2.manage_rents;

import action_strategy.Strategy;
import action_strategy.StrategyCommons;
import hibernate.ClientsRepositoryHibernate;

public class ShowAllClientRents implements Strategy {
    @Override
    public void algorithm() {
        ClientsRepositoryHibernate clientsRepositoryHibernate = StrategyCommons.getClientsRepositoryHibernate();


    }
}
