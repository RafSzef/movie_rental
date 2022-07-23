package action_strategy.admin_panel.admin_panel_2.manage_rents;

import action_strategy.MyScanner;
import action_strategy.Strategy;
import action_strategy.StrategyCommons;
import hibernate.RentsRepositoryHibernate;

public class ShowAllRentsStrategy implements Strategy {
    @Override
    public void algorithm() {
        RentsRepositoryHibernate rentsRepositoryHibernate = StrategyCommons.getRentsRepositoryHibernate();

        System.out.println("<------------------------------------------->");
        System.out.println("<-- LIST OF ALL RENTS ---------------------->");
        rentsRepositoryHibernate.getAllRents().forEach(System.out::println);

        MyScanner.pressAnyKeyToContinue();
        new ManageRentsLogic().startAdminRentsManagementPanel();
    }
}
