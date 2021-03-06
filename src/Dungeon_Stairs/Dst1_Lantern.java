package Dungeon_Stairs;

import A_Super.Furniture;
        
public class Dst1_Lantern extends Furniture {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Dst1_Lantern() {
        super();

        this.description = "The old oil lantern is still lit and gives off a dim "
                         + "luminescence.";
        this.actDialog = "The lantern is just out of your reach.";
        this.addActKeys(GETPATTERN);
        this.addNameKeys("(?:hanging )?(?:oil )?(?:lantern|light)");
    }
//-----------------------------------------------------------------------------
}
