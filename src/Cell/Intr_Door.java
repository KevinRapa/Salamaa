package Cell;

import A_Super.Direction;
import Tunnels.Sew_Door;
/**
 * @author Kevin Rapa
 */
public class Intr_Door extends Sew_Door {
    // ========================================================================
    public Intr_Door () {
        super(Direction.EAST);
        
        this.description = "The metal door offers a view to the outside. You can\n"
                         + "see into a larger room with a pool in the center. A vortex\n"
                         + "of water in the pool spins a water wheel attached to a\n"
                         + "driveshaft going into the ceiling. You can see a door\n"
                         + "on the far opposite side and a small black grate in the\n"
                         + "room's corner. You can't see the source of the discomforting\n"
                         + "noise though.";

        this.addNameKeys("(?:small )?window");
    }
    // ========================================================================  
}


