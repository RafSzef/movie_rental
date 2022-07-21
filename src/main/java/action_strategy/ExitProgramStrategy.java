package action_strategy;

public class ExitProgramStrategy implements Strategy {

    @Override
    public void algorithm() {
        System.out.println("Come back soon !");
        System.exit(3);
    }
}
