package action_strategy.client_2.search_panel;

import action_strategy.MyScanner;
import action_strategy.Strategy;
import action_strategy.StrategyCommons;
import hibernate.ProductRepositoryHibernate;
import lombok.extern.slf4j.Slf4j;
import tables.Product;

import java.util.List;
import java.util.Scanner;

@Slf4j
public class SearchByTittleStrategy implements Strategy {
    Scanner scanner = new Scanner(System.in);
    @Override
    public void algorithm() {

        System.out.println("Enter product name:");
        String title = MyScanner.getText();

        ProductRepositoryHibernate repository = StrategyCommons.getProductRepositoryHibernate();
        List<Product> resultList = repository.getListOfProductWithGivenTitle(title);
        if (resultList.isEmpty()){
            System.out.println("No product with given title. \nReturning to previous menu");
            new SearchPanelLogic().startAdminUserManagementPanel();
        }
        resultList.forEach(System.out::println);
        System.out.println("Do you want to rent this ?");
        if (MyScanner.yesOrNo()){
            //TODO Add rent method
            System.out.println("RENTING PRODUCT METHOD HERE");
        } else System.out.println("Returning to previous menu");
        new SearchPanelLogic().startAdminUserManagementPanel();
    }
}
