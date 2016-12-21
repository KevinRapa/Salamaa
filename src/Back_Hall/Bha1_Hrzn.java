package Back_Hall;

import Super.Furniture;

public class Bha1_Hrzn extends Furniture {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Bha1_Hrzn() {
        super();
        this.searchable = false;
        this.description = "The floor of the hallway warps downwards paradoxically.\n"
                         + "You cannot see beyond perhaps twenty feet down the hallway,\n"
                         + "for the floor's curvature forms a horizon of sorts.";
        this.searchDialog = "The horizon is too abstract a concept to search.";
        this.addNameKeys("horizon");
/*----------------------------------------------------------------------------*/
    }
}
