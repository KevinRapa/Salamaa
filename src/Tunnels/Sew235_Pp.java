package Tunnels;

import static A_Main.NameConstants.PIECE_OF_PIPE;
import A_Super.Furniture;
/**
 * @author Kevin Rapa
 */
public class Sew235_Pp extends Furniture {
    // ========================================================================
    public Sew235_Pp (int room) {
        super();
        this.searchable = false;
        
        switch(room) {
            case 2:
                description = "The rusty metal pipe runs out the top of the console\n"
                            + "on the south wall, along the ceiling to the\n"
                            + "north side of the room, and along the length of\n"
                            + "the tunnel westward.";
                break;
            case 3:
                description = "The metal pipe is bracketed to the ceiling\n"
                            + "over the river below. It's very rusty from the\n"
                            + "apparent years of neglect.";
                break;
            case 5:
                description = "The rusty metal pipe runs around the bend along\n"
                            + "the ceiling and into the wall above the door to the west.";
                break;
        }

        this.searchDialog = "It doesn't seem to be hiding anything.";
        this.useDialog = "There's nothing missing from the pipe in this area!";

        this.addNameKeys("(?:large )?(?:rusty )?(?:metal )?pip(?:e|ing)");
        this.addUseKeys(PIECE_OF_PIPE);
    }
    // ======================================================================== 
}


