package Ancient_Archives;

import A_Main.AudioPlayer;
import static A_Main.NameConstants.SHOVEL;
import static A_Main.NameConstants.TROWEL;
import A_Super.Item;
/**
 * @author Kevin Rapa
 */
public class Aarc_Floor extends Aarc_Furniture {
    // ========================================================================
    public Aarc_Floor (Item... items) {
        super(items);
        
        this.description = "The floor is heavily damaged from the sinking of\n"
                         + "earth under the foundation. The floor bends and sinks\n"
                         + "in many places, and much of the furniture here has\n"
                         + "toppled over as a result. You stand on the only intact\n"
                         + "portion of the floor near the west door.";
        this.searchDialog = "You pick through the remains on the ground.";
        this.actDialog = "You dig a small hole in the ground, but find nothing of interest\n"
                       + "and kick the dirt back in the hole.";

        this.addUseKeys(SHOVEL, TROWEL);
        this.addNameKeys("floor", "ground", "sinkhole", "soil", 
                "(?:slightly raised )?(?:stone )?platform");
    }
    // ======================================================================== 
    @Override public String useEvent(Item item) {
        AudioPlayer.playEffect(34);
        return this.actDialog;
    }
    // ========================================================================  
}


