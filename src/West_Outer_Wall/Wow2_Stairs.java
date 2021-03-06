package West_Outer_Wall;

import A_Super.Item;
import A_Super.SearchableFurniture;

public class Wow2_Stairs extends SearchableFurniture {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Wow2_Stairs() {
        super();

        this.description = "The remnants of the stairs lie crumbled all over the "
                         + "floor.";
        this.searchDialog = "There's nothing among all these rocks but more rocks.";
        this.actDialog = "Don't be ridiculous. The stairs are crumbled down.";
        this.addNameKeys("staircase", "stairs", "steps");
        this.addActKeys(CLIMBPATTERN, "walk", "use");
        
        Item rock = new Item("rubble", "It's a chunk of the stairs, probably.", -15);
        this.inv.add(rock); this.inv.add(rock); this.inv.add(rock);
    }
//-----------------------------------------------------------------------------        
}

