package action_strategy;

import java.util.Optional;

public enum StrategyPicker {
    OPTION_0,
    OPTION_1,
    OPTION_2,
    OPTION_3,
    OPTION_4,
    OPTION_5,
    OPTION_6,
    OPTION_7,
    OPTION_8,
    OPTION_9;

    public static StrategyPicker getTypeByOrdinal(int ordinal) {
        for (StrategyPicker t : StrategyPicker.values()) {
            if (t.ordinal() == ordinal) {
                return t;
            }
        }
        return null;
    }


    public static StrategyPicker getOptionFromScanner() {
        System.out.println("Input required:");
        int input = MyScanner.getInt();
        Optional<StrategyPicker> strategyPicker = Optional.ofNullable(StrategyPicker.getTypeByOrdinal(input));

        if (strategyPicker.isEmpty()) {
            System.out.print("Incorrect input. New ");
            return getOptionFromScanner();
        }

        return strategyPicker.get();
    }

}
