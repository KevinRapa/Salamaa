package Iron_Hall;

import A_Super.Direction;
import A_Super.Room;
/**
 * Updates description whenever polearm is taken or removed from armor.
 * @author Kevin Rapa
 */
public class Iha2 extends Room{
    private boolean hasPolearm;
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Iha2(String name, String ID) {
        super(name, ID);
        this.hasPolearm = true;
    }
//-----------------------------------------------------------------------------  
    public void removePolearm() {
        this.hasPolearm = false;
    }
//-----------------------------------------------------------------------------
    public void addPolearm() {
        this.hasPolearm = true;
    }
//-----------------------------------------------------------------------------
    @Override public String getDescription() {
        if (this.hasPolearm)
            return super.getDescription();
        else
            return super.getDescription().replaceAll(" It holds a polearm in its gauntlet.", "");
    }
//-----------------------------------------------------------------------------
    @Override public String getBarrier(Direction dir) {
        if (dir == Direction.SOUTH)
            return "You should be getting out of here..."; // For end game.
        else
            return bumpIntoWall();
    } 
//-----------------------------------------------------------------------------    
}