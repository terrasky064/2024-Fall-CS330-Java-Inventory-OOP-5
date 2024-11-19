package edu.odu.cs.cs330.items;

import java.util.Objects;

/**
 * This class represents one Consumable Item--as found in most video games.
 * This includes food.
 *
 * Consumable Items must be stackable.
 */
@SuppressWarnings({
    "PMD.BeanMembersShouldSerialize",
    "PMD.CloneMethodReturnTypeMustMatchClassName",
    "PMD.CloneThrowsCloneNotSupportedException",
    "PMD.LawOfDemeter",
    "PMD.OnlyOneReturn",
    "PMD.ProperCloneImplementation",
    "PMD.MethodArgumentCouldBeFinal",
    "PMD.LocalVariableCouldBeFinal"
})
public class Consumable implements Item {
    /**
     * Format used to generate a printable representation.
     */
    public static final String FMT_STR = String.join(
        "",
        "  Nme: %s%n",
        "  Eft: %s%n",
        "  Use: %d%n"
    );

    /**
     * The name...
     */
    protected final String name;

    /**
     * The effect "buff" or "debuff" that is received when using this item.
     */
    protected final String effect;

    /**
     * The number of times this item can be used.
     */
    protected final int uses;

    /**
     * Default to a Consumable Item with an empty name, no effect, and zero
     * uses.
     */
    public Consumable() {
        this("[Placeholder]", "", 0);
    }

    /**
     * Create a fully initialized Consumable.
     */
    public Consumable(String name, String effect, int uses) {
        this.name = name;
        this.effect = effect;
        this.uses = uses;
    }

    @Override
    public String getName() {
        return this.name;
    }

    /**
     * Retrieve the effect.
     *
     * @return the set effect (i.e., buff or debuff)
     */
    public String getEffect() {
        return this.effect;
    }

    /**
     * Retrieve the number of permitted uses.
     *
     * @return number of total uses
     */
    public int getNumberOfUses() {
        return this.uses;
    }

    @Override
    public boolean isStackable() {
        return true;
    }

    /**
     * Check for logical equivalence--based on name and effect.
     *
     * @param rhs object for which a comparison is desired
     */
    @Override
    public boolean equals(Object rhs) {
        if (!(rhs instanceof Consumable)) {
            return false;
        }

        Consumable rhsItem = (Consumable) rhs;

        return this.name.equals(rhsItem.name)
            && this.effect.equals(rhsItem.effect);
    }

    /**
     * Generate a hash code based on name and effect.
     */
    @Override
    public int hashCode() {
        return Objects.hash(this.name, this.effect);
    }

    /**
     * *Print* the Consumable Item.
     */
    @Override
    public String toString() {
        return String.format(FMT_STR, this.name, this.effect, this.uses);
    }
}
