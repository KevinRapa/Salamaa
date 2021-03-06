package Gallery;

import A_Main.Inventory;
import A_Super.Furniture;
import A_Super.Item;
import A_Main.Player;

public class Gal3_Rope extends Furniture {
    private boolean cut;
    private final int LDDR_ID;
/* CONSTRUCTOR ---------------------------------------------------------------*/        
    public Gal3_Rope(Furniture lddr) {
            super();
            this.cut = false;
            this.LDDR_ID = lddr.getID();
            
            this.actDialog = "You cut the rope. The ladder drops down into "
                    + "the room, giving access to the loft.";
            this.description = "The rope is tied to the ladder and hoists it up "
                             + "with a pulley. It feeds into a hole in the wall "
                             + "next to you. Above the hole, you see a switch.";
            this.searchDialog = "It's just an ordinary rope.";
            
            this.addActKeys("cut", "pull", "untie");
            this.addUseKeys("katana", "(?:silver|rusty|broken) sword", "(?:war|battle) ax");
            this.addNameKeys("rope");
    }
//-----------------------------------------------------------------------------    
    @Override public String getDescription() {
        return this.cut ? "The rope is now cut." : this.description;
    }
//----------------------------------------------------------------------------- 
    @Override public String interact(String key) { 
        if (! this.cut) {
            if (key.equals("cut")) {
                if (detectItem()) {
                    ((Gal3_Ladder)Player.getPos().getFurnRef(LDDR_ID)).lower();
                    this.cut = true;
                    Player.describeRoom();
                    return this.actDialog;
                }           
                else
                    return "You have nothing to cut the rope with.";
            }       
            else if (key.equals("pull")) 
                return "The rope doesn't budge.";  
            
            else 
                return "The knot in the rope is too high up to untie.";    
        }
        else
            return "The rope is cut already.";
    }
//-----------------------------------------------------------------------------
    @Override public String useEvent(Item item) {
        ((Gal3_Ladder)Player.getPos().getFurnRef(LDDR_ID)).lower();
        this.cut = true;
        
        return "You cut the rope with the " + item + ". "
             + "The ladder drops down into the room, "
             + "giving access to the loft.";
    }
//-----------------------------------------------------------------------------
    private boolean detectItem() {
        // Detects if you have a blade to cut the rope with.
        Item item = Player.getInv().get("katana|.+(?:sword|ax)");
        return (! item.equals(Inventory.NULL_ITEM));
    }
//-----------------------------------------------------------------------------
    public boolean isCut() {
        return this.cut;
    }
//-----------------------------------------------------------------------------
}
