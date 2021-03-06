package Parlor;

import A_Main.Id;
import A_Super.Door;
import A_Super.Item;
import A_Main.Player;
import static A_Main.Names.SACRED_FIRE;
import static A_Main.Names.WEAPON;
import A_Super.Direction;
/**
 * Has a magical ice ward over it. 
 * Player must use the sacred fire on this to break the ward.
 * 
 * @see Parlor.Par1_FirePlace
 * @author Kevin Rapa
 */
public class Par1_Door extends Door {
    private final Item ENCHNTBTTL_REF;
//-----------------------------------------------------------------------------    
    public Par1_Door(Item enchbttl, Direction dir) {
        super(dir);
        this.useDialog = "You throw the fire on the door. The fire "
                       + "then slowly fades away.";
        this.description = "It looks like a heavy wooden door.";
        
        this.ENCHNTBTTL_REF = enchbttl;
        this.addNameKeys("barrier");
        this.addUseKeys(SACRED_FIRE);
    }
//-----------------------------------------------------------------------------
    @Override public String getDescription() {
        if (! Player.getRoomObj(Id.PAR1).isAdjacent(Id.BHA3))
            return "The door has an odd pale-blue tint to it. As you approach, "
                 + "you feel a coldness. Upon closer inspection, you can see the "
                 + "blue tint pulsing.";
        else
            return this.description;
    }
//----------------------------------------------------------------------------- 
    @Override public String useEvent(Item item) {
        if (item.toString().equals(SACRED_FIRE)) {
            String rep = this.useDialog;

            if (! Player.getRoomObj(Id.PAR1).isAdjacent(Id.BHA3)) {
                Player.getRoomObj(Id.PAR1).addAdjacent(Id.BHA3);
                rep = "You cast the fire onto the door, to which it clings."
                    + " The fire begins to fade away along with the barrier.";
            }
            Player.getInv().remove(item);
            Player.getInv().add(ENCHNTBTTL_REF);

            return rep;
        }
        else if (item.getType().equals(WEAPON)) 
            return "The door is build too solidly and breaking it down is futile.";
        else
            return super.useDialog;
    }
//----------------------------------------------------------------------------- 
}

