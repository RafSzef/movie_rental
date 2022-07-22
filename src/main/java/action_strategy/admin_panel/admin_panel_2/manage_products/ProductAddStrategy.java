package action_strategy.admin_panel.admin_panel_2.manage_products;

import action_strategy.MyScanner;
import action_strategy.Strategy;
import action_strategy.StrategyCommons;
import hibernate.ProductRepositoryHibernate;
import tables.*;

import java.time.LocalDate;
import java.util.NoSuchElementException;
import java.util.Optional;

public class ProductAddStrategy implements Strategy {

    ProductRepositoryHibernate REPOSITORY = StrategyCommons.getProductRepositoryHibernate();

    @Override
    public void algorithm() {

        try {
            Product newProduct = new Product();
            Category newCategory = new Category();
            PegiCategory newPegiCategory = new PegiCategory();
            Carrier newCarrier = new Carrier();
            Director newDirector = new Director();

            Branch newBranch;
            newBranch = getBranch();

            System.out.println("Enter product title:");
            newProduct.setTitle(MyScanner.getText());

            LocalDate releaseDate = enterDate();

            System.out.println("Enter product Category");
            newCategory.setTitle(MyScanner.getText());

            System.out.println("Enter product PEGI Category");
            newPegiCategory.setTitle(MyScanner.getText());

            System.out.println("Enter Carrier type");
            newCarrier.setDescription(MyScanner.getText());


            System.out.println("Enter Director info:");
            System.out.println("-- First name:");
            newDirector.setFirstName(MyScanner.getText());
            System.out.println("-- Last name:");
            newDirector.setLastName(MyScanner.getText());

            newProduct.setReleaseDate(releaseDate);
            newProduct.setBranch(newBranch);
            newProduct.setDirector(newDirector);
            newProduct.setCategory(newCategory);
            newProduct.setCarrier(newCarrier);
            newProduct.setPegiCategory(newPegiCategory);
            REPOSITORY.createProduct(newProduct);

            new ManageProductLogic().startAdminProductManagementPanel();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private LocalDate enterDate() {
        try {
            System.out.println("Enter release date in YYYY-MM-DD format:");
            LocalDate releaseDate = LocalDate.parse(MyScanner.getText());
            return releaseDate;
        } catch (Exception e ){
            System.out.println("incorrect format.");
            return enterDate();
        }
    }

    private Branch getBranch() {
        System.out.println("Enter Product details to add new product");
        System.out.println("<-- SELECT BRANCH TO ADD PRODUCT ----------->");

        if (REPOSITORY.getListOfAllBranches().isEmpty()) {
            System.out.println("<-- NO BRANCHES AVAILABLE. ADD NEW BRANCH ?->");
            if (MyScanner.yesOrNo()) {
                return addBranch();
            } else new ManageProductLogic().startAdminProductManagementPanel();
        }

        return selectBranch();
    }

    private Branch addBranch() {

        Branch newBranch = new Branch();
        System.out.println("Enter name:");
        newBranch.setName(MyScanner.getText());
        System.out.println("Enter postal-Code:");
        newBranch.setPostalCode(MyScanner.getText());
        System.out.println("Enter address");
        newBranch.setAddress(MyScanner.getText());

        return REPOSITORY.addBranch(newBranch);
    }

    private Optional<Branch> branchSelector() {
        try {
            System.out.println("Enter Branch id:");
            Integer postalCode = MyScanner.getInt();
            return Optional.of(REPOSITORY.getBranch(postalCode).get());
        } catch (NoSuchElementException e) {
            System.out.println("No such branch");
            return branchSelector();
        }
    }

    private Branch selectBranch() {
        System.out.println("<-- LIST OF AVAILABLE BRANCHES ------------->");
        REPOSITORY.getListOfAllBranches().stream()
                .distinct()
                .forEach(System.out::println);
        Optional<Branch> tmpBranch = branchSelector();
        if (tmpBranch.isPresent()) {
            return tmpBranch.get();
        } else return branchSelector().get();
//        return tmpBranch.orElseGet(this::selectBranch);
    }

}
