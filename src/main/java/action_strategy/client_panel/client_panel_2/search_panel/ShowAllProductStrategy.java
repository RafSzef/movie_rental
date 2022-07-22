package action_strategy.client_panel.client_panel_2.search_panel;

import action_strategy.MyScanner;
import action_strategy.Strategy;
import action_strategy.StrategyCommons;
import hibernate.ProductRepositoryHibernate;
import hibernate.RentsRepositoryHibernate;
import tables.Client;
import tables.Product;
import tables.Rent;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Optional;

import static java.time.temporal.ChronoField.YEAR;

public class ShowAllProductStrategy implements Strategy {

    @Override
    public void algorithm() {
        try {
            ProductRepositoryHibernate repository = StrategyCommons.getProductRepositoryHibernate();
            RentsRepositoryHibernate rentsRepositoryHibernate = StrategyCommons.getRentsRepositoryHibernate();

            System.out.println("<------------------------------------------->");
            System.out.println("<-- LIST OF AVAILABLE PRODUCTS ------------->");
            repository.getAllProducts().stream()
                    .distinct()
                    .filter(p -> (p.getRentEndDate() == null) || (p.getRentEndDate().isBefore(LocalDate.now())))
                    .forEach(System.out::println);
            System.out.println("Enter product id to to rent for 3 days now:");
            Integer productId = MyScanner.getInt();

            Product product = repository.getProductById(productId).get();
            Client client = StrategyCommons.getClient();
            LocalDate startDate = LocalDate.now();
            LocalDate endDate = addTime(startDate, 3);
            product.setRentStartDate(startDate);
            product.setRentEndDate(endDate);

            System.out.println("end date set to : " +endDate);
            rentsRepositoryHibernate.createRent(product, Objects.requireNonNull(StrategyCommons.getClient()), startDate, endDate);
        } catch (Exception e) {
            System.out.println("ERR");
            e.printStackTrace();
        }

        MyScanner.pressAnyKeyToContinue();
        new SearchPanelLogic().startAdminUserManagementPanel();
    }

    private LocalDate addTime(LocalDate date, int days) {
        int year = date.getYear();
        int month = date.getMonthValue();
        int day = date.getDayOfMonth();
        int dom = day + days;

        if (dom > 0) {
            if (dom <= 28) {
                return LocalDate.of(year, month, dom);
            } else if (dom <= 59) { // 59th Jan is 28th Feb, 59th Feb is 31st Mar
                long monthLen = date.lengthOfMonth();
                if (dom <= monthLen) {
                    return LocalDate.of(year, month, (int) dom);
                } else if (month < 12) {
                    return LocalDate.of(year, month + 1, (int) (dom - monthLen));
                } else {
                    YEAR.checkValidValue(year + 1);
                    return LocalDate.of(year + 1, 1, (int) (dom - monthLen));
                }
            }
        }
        return LocalDate.of(1970, 1, 1);
    }
}

