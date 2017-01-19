package Vault;

import A_Super.Furniture;
/**
 * @author Kevin Rapa
 */
public class Vau_Clng extends Furniture {
    // ========================================================================
    public Vau_Clng () {
        super();
        this.searchable = false;
        
        this.description = "The ceiling is sandstone like the rest of the room.\n"
                         + "It arches only feet above your head and gradually\n"
                         + "slopes down on either side of you meeting the floor.";

        this.addNameKeys("(?:low )?(?:arched )?ceiling");
    }
    // ========================================================================    
}

