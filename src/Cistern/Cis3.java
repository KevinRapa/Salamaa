package Cistern;

import A_Super.Direction;
import Tunnels.Dungeon_Tunnel;
/**
 * Superficial.
 * @author Kevin Rapa
 */
public class Cis3 extends Dungeon_Tunnel {
// ============================================================================    
    public Cis3(String name, String ID) {
        super(name, ID);
    }
// ============================================================================
    @Override public String getBarrier(Direction dir) {
        if (dir == Direction.WEST)
            return WATER_THAT_WAY;
        else
            return bumpIntoWall();
    }
// ============================================================================
}