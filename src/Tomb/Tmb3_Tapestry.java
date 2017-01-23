package Tomb;

import A_Super.WallArt;
/**
 * @author Kevin Rapa
 */
public class Tmb3_Tapestry extends WallArt {
    // ========================================================================
    public Tmb3_Tapestry () {
        super();
        this.description = "The tapestry is mainly just superficial designs,\n"
                         + "though woven in the center is a hexagram inside\n"
                         + "of a circle.";

        this.addNameKeys("(?:small )?(?:hanging )?(?:torn |ripped )?tapestry");
    }
    // ========================================================================   
}


