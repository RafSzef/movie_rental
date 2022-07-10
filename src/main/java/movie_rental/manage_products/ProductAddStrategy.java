package movie_rental.manage_products;

import action_strategy.MyScanner;
import action_strategy.Strategy;
import action_strategy.StrategyCommons;
import hibernate.ProductRepositoryHibernate;
import tables.*;

import javax.persistence.EntityManager;
import java.util.Optional;

public class ProductAddStrategy implements Strategy {

    ProductRepositoryHibernate REPOSITORY = StrategyCommons.getProductRepositoryHibernate();
    EntityManager entityManager = StrategyCommons.getInstance().getEntityManager();

    @Override
    public void algorithm() {
        REPOSITORY.getAllProducts().forEach(p -> entityManager.refresh(p));
        REPOSITORY.getListOfAllBranches().forEach(p -> entityManager.refresh(p));
        try {
            Product newProduct = new Product();
            Category newCategory = new Category();
            PegiCategory newPegiCategory = new PegiCategory();
            Carrier newCarrier = new Carrier();
            Branch newBranch = new Branch();

            newBranch = getBranch(newBranch);

            System.out.println("Enter product title:");
            newProduct.setTitle(MyScanner.getText());

            System.out.println("Enter product Category");
            newCategory.setTitle(MyScanner.getText());

            System.out.println("Enter product PEGI Category");
            newPegiCategory.setTitle(MyScanner.getText());

            System.out.println("Enter Carrier type");
            newCarrier.setDescription(MyScanner.getText());


            newProduct.setBranch(newBranch);
            newProduct.setCategory(newCategory);
            newProduct.setCarrier(newCarrier);
            newProduct.setPegiCategory(newPegiCategory);
            REPOSITORY.createProduct(newProduct);

            new ManageProductLogic().startAdminProductManagementPanel();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Branch getBranch(Branch newBranch) {
        System.out.println("Enter Product details to add new product");

        System.out.println("<-- SELECT BRANCH TO ADD PRODUCT ----------->");
        if (REPOSITORY.getListOfAllBranches().isEmpty()) {
            System.out.println("<-- NO BRANCHES AVAILABLE. ADD NEW BRANCH ?->");
            if (MyScanner.yesOrNo()) {
                newBranch = addBranch();
            } else new ManageProductLogic().startAdminProductManagementPanel();
        } else {
            selectBranch();
        }
        return newBranch;
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
        System.out.println("Enter Branch postal code:");
        String postalCode = MyScanner.getText();
        return Optional.of(REPOSITORY.getBranch(postalCode).get());
    }

    private Branch selectBranch() {
        System.out.println("<-- LIST OF AVAILABLE BRANCHES ------------->");
        REPOSITORY.getListOfAllBranches().stream()
                .distinct()
                .forEach(System.out::println);
        Optional<Branch> tmpBranch = branchSelector();
        return tmpBranch.orElseGet(this::selectBranch);
    }

}
