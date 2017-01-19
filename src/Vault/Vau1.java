package Vault;

import A_Super.Room;
import A_Super.Direction;
import A_Super.Furniture;
/**
 * @author Kevin Rapa
 */
public class Vau1 extends Room {
    private final Furniture Vau1_Tbl;
// ============================================================================    
    public Vau1(String name, String ID, Furniture tbl) {
        super(name, ID);
        this.Vau1_Tbl = tbl;
        this.description= "You walk over to the north side of the chamber, before\n"
                        + "the marble table.";
    }
// ============================================================================
    @Override public String getBarrier(Direction dir) {
        if (dir == Direction.EAST || dir == Direction.WEST)
            return "The ceiling slopes down to the floor to the east and west.";
        else
            return bumpIntoWall();
    }
// ============================================================================
    @Override public String getDescription() {
        return this.Vau1_Tbl.containsItem("glowing chalice") ?
                this.description.concat(" Standing on the table is a glowing object.") :
                this.description;
    }
// ============================================================================   
}