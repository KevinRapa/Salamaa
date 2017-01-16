package Lichs_Quarters;

import A_Super.Furniture;
/**
 * @author Kevin Rapa
 */
public class Lqu_Crpt extends Furniture {
    // ========================================================================
    public Lqu_Crpt () {
        super();
        this.searchable = false;
        
        this.description = "The lavender carpet covers much of the cold floor.";
        this.searchDialog = "You look under the carpet and find nothing.";

        this.addNameKeys("(?:lavender )?carpet");
    }
    // ========================================================================    
}


