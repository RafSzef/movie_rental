package action_strategy.admin_2.manage_directors;

import action_strategy.MyScanner;
import action_strategy.Strategy;
import action_strategy.StrategyCommons;
import hibernate.ProductRepositoryHibernate;
import tables.Director;

public class DirectorAddStrategy implements Strategy {
    @Override
    public void algorithm() {

        ProductRepositoryHibernate repository = StrategyCommons.getProductRepositoryHibernate();
        System.out.println("<------------------------------------------->");
        System.out.println("<-- LIST OF AVAILABLE DIRECTORS ------------->");

        repository.getListOfAllDirectors().stream()
                .distinct()
                .forEach(System.out::println);

        System.out.println("Enter Director details to add new director");
        Director newDirector = new Director();
        System.out.println("Enter first name:");
        newDirector.setFirstName(MyScanner.getText());
        System.out.println("Enter last name:");
        newDirector.setLastName(MyScanner.getText());

        repository.addDirector(newDirector);

        MyScanner.pressAnyKeyToContinue();
        new ManageDirectorLogic().startAdminDirectorsManagementPanel();
        System.out.println("Branch add method");
        new ManageDirectorLogic().startAdminDirectorsManagementPanel();
    }
}
