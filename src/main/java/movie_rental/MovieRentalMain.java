package movie_rental;

import action_strategy.login_panel.LoginLogic;

public class MovieRentalMain {

    public static void main(String[] args) {
        LoginLogic.getInstance().startLoginPanel();
    }
}
