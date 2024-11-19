package edu.odu.cs.cs330.items.creation;

import edu.odu.cs.cs330.items.Item;
import edu.odu.cs.cs330.items.Armour;

@SuppressWarnings({
    "PMD.AtLeastOneConstructor"
})
public class ArmourCreation implements ItemCreationStrategy {
    /**
     * Convenience wrapper to mirror the Rust new-returns-a-builder pattern.
     * Use "construct" since "new" is a reserved keyword in Java.
     */
    public static ArmourCreation construct() {
        return new ArmourCreation();
    }

    @Override
    public Item fromDefaults() {
        // Return a **Default** Armour
        return new Armour();
    }

    @Override
    public int requiredNumberOfValues() {
        // The number of tokens required to create an Armour instance
        return 7; // Assuming Armour requires: name, material, durability, defense, modifier, modifierLevel, element
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

        String name = tokens[0];
        String material = tokens[1];
        int durability = Integer.parseInt(tokens[2]);
        int defense = Integer.parseInt(tokens[3]);
        String modifier = tokens[4];
        int modifierLevel = Integer.parseInt(tokens[5]);
        String element = tokens[6];

        return new Armour(name, durability, defense, material, modifier, modifierLevel, element);
    }

    @SuppressWarnings({
        "PMD.LawOfDemeter",
        "PMD.LocalVariableCouldBeFinal",
        "PMD.OnlyOneReturn"
    })
    @Override
    public Item fromExisting(final Item original) {
        if (!(original instanceof Armour)) {
            return null;
        }

        Armour theOriginal = (Armour) original;

        return new Armour(
            theOriginal.getName(),
            theOriginal.getDurability(),
            theOriginal.getDefense(),
            theOriginal.getMaterial(),
            theOriginal.getModifier(),
            theOriginal.getModifierLevel(),
            theOriginal.getElement()
        );
    }
}
