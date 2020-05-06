package pl.edu.wszib.homebudget.domain;

import java.util.Arrays;

public enum TransactionCategory {

    KID("Dzieci"),
    BILL("Rachunki"),
    SAVING("Oszczędności"),
    HOUSE("Dom / Mieszkanie"),
    CAR("Auto"),
    PET("Zwierzęta"),
    FOOD("Artykuły spożywcze"),
    CHEMICAL("Artykuły chemiczne"),
    HEALTH("Zdrowie"),
    CLOTH("Ubrania"),
    RECREATION("Rozrywka"),
    GIFT("Prezenty"),
    INCOME("Wpływy"),
    OTHER("Inne");


    private final String displayValue;

    TransactionCategory(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }

    public static pl.edu.wszib.homebudget.domain.TransactionCategory[] getSortedValue() {
        pl.edu.wszib.homebudget.domain.TransactionCategory[] values = pl.edu.wszib.homebudget.domain.TransactionCategory.values();
        Arrays.sort(values, (s1, s2) -> s1.getDisplayValue().compareTo(s2.getDisplayValue()));
        return values;
    }
}
