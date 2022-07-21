package action_strategy.login_panel;

import action_strategy.MyScanner;
import action_strategy.Strategy;
import action_strategy.StrategyCommons;
import action_strategy.admin_defining.AdminDefiningLogic;
import tables.Client;


public class LoginStrategy implements Strategy {

    @Override
    public void algorithm() {
        displayLoginPanel();

        System.out.println("Enter login:");
        String login = MyScanner.getText();

        System.out.println("Enter password:");
        String password = MyScanner.getText();

        try {
            Client client = StrategyCommons.getClientsRepositoryHibernate().authorization(login, password);
            StrategyCommons.setLoggedClient(client);

            boolean isAdmin = client.getAdmin() == 1;
            AdminDefiningLogic.getInstance().definePermission(isAdmin);
        } catch (NullPointerException e) {
            System.out.println("Wrong login or password. Try again ?");
            if (MyScanner.yesOrNo()) {
                algorithm();
            } else LoginLogic.getInstance().startLoginPanel();
        }
    }

    private void displayLoginPanel() {
        System.out.println("<------------------------------------------->");
        System.out.println("<--------------- LOGIN PANEL --------------->");
        System.out.println("<------------------------------------------->");
    }

}
