package Crypt;

import A_Super.Furniture;
/**
 * @author Kevin Rapa
 */
public class Cry_Lghts extends Furniture {
    // ========================================================================
    public Cry_Lghts () {
        super();
        this.searchable = false;
        
        this.description = "From the wall extend boney arms, palms up, holding\n"
                         + "small dishes. The surfaces of the dishes burn and give\n"
                         + "off the smell of brimstone.";
        this.actDialog = "You can't do that. They are attached to the wall.";

        this.addNameKeys("(?:boney )?arms", "(?:burning )?(?:platters?|dish(?:es)?)", 
                "torch(?:es)?", "protrusions?");
        this.addActKeys(GETKEYS);
    }
    // ========================================================================     
}


