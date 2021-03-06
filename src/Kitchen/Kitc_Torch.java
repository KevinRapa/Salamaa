package Kitchen;

import A_Main.GUI;
import A_Main.Inventory;
import static A_Main.Names.HAND_TORCH;
import A_Super.Torch_Holder;
import A_Super.Item;
import A_Main.Player;
/**
 * Player must add a torch to this to light the room.
 * Begins empty.
 * @author Kevin Rapa
 */
public class Kitc_Torch extends Torch_Holder {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Kitc_Torch(Item torch) {
        super(torch);
        this.useDialog = "You slide the torch into the steel holder, lighting "
                       + "the room.";
        this.inv = new KitcHolderInventory();
    }
//-----------------------------------------------------------------------------
    @Override public String interact(String key) {
        if (key.equals("pull"))
            return super.interact(key);
        else if (this.inv.contains(TORCH.toString())) {
            if (this.inv.give(TORCH, Player.getInv())) {
                Player.describeRoom();
                return this.actDialog;
            }
            else
                return NOTHING;
        }
        else
            return "The holder is empty you bumbling oaf.";
    }
//-----------------------------------------------------------------------------  
    @Override public String useEvent(Item item) {
        if (this.inv.contains(TORCH.toString()))
            return "The holder already bears a torch you bumbling oaf.";
        else {
            Player.getInv().give(item, this.inv);
            return this.useDialog;
        }
    }    
//-----------------------------------------------------------------------------
/******************************************************************************/    
//-----------------------------------------------------------------------------
    private class KitcHolderInventory extends Inventory {  
    // CONSTRUCTOR -------------------------------------------------------------      
        public KitcHolderInventory() {
            super();
        }
    //-------------------------------------------------------------------------
        @Override public boolean add(Item item) { 
            if (item.toString().equals(HAND_TORCH) && this.size() == 0) {
                this.CONTENTS.add(item);
                Player.describeRoom();
                GUI.roomOut("Kitchen");
                return true;
            }
            GUI.out("The " + item + " doesn't fit in.");
            return false;
        }
    //-------------------------------------------------------------------------
        @Override public void remove(Item removeThis) {      
            this.CONTENTS.remove(removeThis);
            Player.describeRoom();
            GUI.roomOut("Pitch black room");
        }
    }
//-----------------------------------------------------------------------------
/******************************************************************************/    
//-----------------------------------------------------------------------------
}

