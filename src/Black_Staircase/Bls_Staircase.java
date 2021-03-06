package Black_Staircase;

import A_Super.Direction;
import A_Super.Staircase;
/**
 * @author Kevin Rapa
 */
public class Bls_Staircase extends Staircase {
    //-------------------------------------------------------------------------
    public Bls_Staircase (Direction dir, String dest) {
        super(dir, dest, 15);
        
        this.description = "The long curved staircase wraps around in a half circle "
                         + "and connects the atrium floor to its second story balcony. "
                         + "It is suspended from the ceiling by many black metal cables.";

        this.addNameKeys("(?:long )?(?:curved )?(?:suspended )?(?:black )?(?:iron )?(?:stair(?:s|case)|steps)");
    }
    //------------------------------------------------------------------------- 
}


