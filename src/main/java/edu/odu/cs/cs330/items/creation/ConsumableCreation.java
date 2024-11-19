package edu.odu.cs.cs330.items.creation;

import edu.odu.cs.cs330.items.Item;
import edu.odu.cs.cs330.items.Consumable;

@SuppressWarnings({
    "PMD.AtLeastOneConstructor"
})
public class ConsumableCreation implements ItemCreationStrategy {

    /**
     * Convenience wrapper to mirror the Rust new-returns-a-builder pattern.
     * Use "construct" since "new" is a reserved keyword in Java.
     */
    public static ConsumableCreation construct() {
        return new ConsumableCreation();
    }

    @Override
    public Item fromDefaults() {
        // Return a **Default** Consumable
        return new Consumable();
    }

    @Override
    public int requiredNumberOfValues() {
        // Consumable requires name, effect, and number of uses
        return 3;
    }

    @SuppressWarnings({
        "PMD.LawOfDemeter",
        "PMD.LocalVariableCouldBeFinal"
    })
    @Override
    public Item fromTokens(final String... tokens) {
        if (tokens.length != requiredNumberOfValues()) {
            throw new IllegalArgumentException(
                "Invalid number of tokens. Expected " + requiredNumberOfValues() + " tokens."
            );
        }

        // Parse tokens for Consumable fields
        String name = tokens[0];
        String effect = tokens[1];
        int numberOfUses = Integer.parseInt(tokens[2]);

        return new Consumable(name, effect, numberOfUses);
    }

    @SuppressWarnings({
        "PMD.LawOfDemeter",
        "PMD.LocalVariableCouldBeFinal",
        "PMD.OnlyOneReturn"
    })
    @Override
    public Item fromExisting(final Item original) {
        if (!(original instanceof Consumable)) {
            return null;
        }

        Consumable theOriginal = (Consumable) original;

        return new Consumable(
            theOriginal.getName(),
            theOriginal.getEffect(),
            theOriginal.getNumberOfUses()
        );
    }
}
