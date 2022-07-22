package action_strategy.admin_panel.admin_panel_2.manage_directors;

import action_strategy.MyScanner;
import action_strategy.Strategy;
import action_strategy.StrategyCommons;
import hibernate.ProductRepositoryHibernate;
import tables.Director;


public class DirectorRemoveStrategy implements Strategy {
    @Override
    public void algorithm() {
        ProductRepositoryHibernate repository = StrategyCommons.getProductRepositoryHibernate();

        System.out.println("<------------------------------------------->");
        System.out.println("<-- LIST OF AVAILABLE DIRECTORS ------------>");
        repository.getListOfAllDirectors().stream()
                .distinct()
                .forEach(System.out::println);

        System.out.println("To remove enter");
        System.out.println("-- First name:");
        String firstName = MyScanner.getText();
        System.out.println("-- Last name:");
        String lastName = MyScanner.getText();

        System.out.println("Removing " +firstName + " " + lastName);
        Director toRemove = new Director();
        toRemove.setFirstName(firstName);
        toRemove.setLastName(lastName);

        repository.removeDirector(toRemove);

        MyScanner.pressAnyKeyToContinue();
        new ManageDirectorLogic().startAdminDirectorsManagementPanel();
    }
}
