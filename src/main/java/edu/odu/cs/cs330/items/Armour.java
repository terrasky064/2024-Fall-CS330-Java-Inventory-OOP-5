package edu.odu.cs.cs330.items;

import java.util.Objects;

/**
 * This class represents one piece of armour--as found in most video games.
 * This includes boots and helmets.
 *
 * Armour may not be stacked.
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
public class Armour extends Equippable implements Item
{
    /**
     * Format used to generate a printable representation.
     */
    public static final String FMT_STR = String.join(
        System.lineSeparator(),
        "  Nme: %s",
        "  Dur: %s",
        "  Def: %d",
        "  Mtl: %s",
        "  Mdr: %s (Lvl %d)",
        "  Emt: %s",
        ""
    );
    protected String name;
    protected int durability;
    protected int defense;
    protected String material;
    protected String modifier;
    protected int modifierLevel;
    protected String element;

    /**
     * The amount of damage that can be negated.
     */
    

    /**
     * Default to armour with a defense of zero.
     */
    public Armour()
    {
        super();
        this.defense = 0;
    }

    /**
     * Create a fully initialized Armour.
     */
    public Armour(String nme, int dur, int def, String mtl, String mdr, int lvl, String emt)
    {
        super(nme, dur, mtl, mdr, lvl, emt);
        this.defense = def;
    }

    /**
     * Retrieve armour defense.
     *
     * @return total defense provided
     */
    public int getDefense()
    {
        return this.defense;
    }

    /**
     * Check for logical equivalence--based on name, material, modifier,
     * modifierLevel, element, and defense.
     *
     * @param rhs object for which a comparison is desired
     */
    @Override
    public boolean equals(Object rhs)
    {
        if (!(rhs instanceof Armour)) {
            return false;
        }

        Armour rhsItem = (Armour) rhs;

        return this.getName().equals(rhsItem.getName())
           
            && this.getDefense() == rhsItem.getDefense()
            && this.getMaterial().equals(rhsItem.getMaterial())
            && this.getModifier().equals(rhsItem.getModifier())
            && this.getModifierLevel() == rhsItem.getModifierLevel()
            && this.getElement().equals(rhsItem.getElement());
    }

    /**
     * Compute hashCode based on name, material, modifier, modifierLevel,
     * element, and defense.
     */
    @Override
    public int hashCode()
    {
        return Objects.hash(
            this.getName(),
            this.getDefense(),
            this.getMaterial(),
            this.getModifier(),
            this.getModifierLevel(),
            this.getElement()
        );
    }

    /**
     * *Print* one Armour.
     */
    @Override
    public String toString()
    {
        return String.format(
            FMT_STR,
            this.getName(),
            this.getDurability(),
            this.defense,
            this.getMaterial(),
            this.getModifier(),
            this.getModifierLevel(),
            this.getElement()
        );
    }
}
