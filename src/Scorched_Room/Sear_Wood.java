package Scorched_Room;

import A_Super.Furniture;
        
public class Sear_Wood extends Furniture {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Sear_Wood(String NAME) {
        super();

        this.description = "Bits of burnt wood are littered everywhere.";
        this.searchDialog = "It's all just burnt wood.";
        this.addNameKeys("(?:bits of )?(?:burnt )?wood");
    }
/*----------------------------------------------------------------------------*/
}
