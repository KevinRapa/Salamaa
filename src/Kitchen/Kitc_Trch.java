package Kitchen;

import A_Main.GUI;
import A_Super.Trch;
import A_Super.Item;
import A_Main.Player;
import A_Super.Hldr_Inv;
/**
 * Player must add a torch to this to light the room.
 * Begins empty.
 * @author Mantis Toboggan
 */
public class Kitc_Trch extends Trch {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Kitc_Trch() {
        super();
        this.useDialog = "You slide the torch into the steel holder, lighting\n"
                       + "the room.";
        this.inv = new KitcHldr_Inv();
    }
/*----------------------------------------------------------------------------*/
    @Override public String interact(String key) {
        String rep = this.actDialog;
        
        if (this.doesThisHaveIt("hand torch")) {
            this.inv.give(TORCH, Player.getInv());
            ((Kitc)Player.getRoomRef("KITC")).swtch();
        }
        else
            rep = "The holder is empty you bumbling oaf.";
        
        return rep;
    }
/*----------------------------------------------------------------------------*/  
    @Override public String useEvent(Item item) {
        String rep = this.useDialog;
        
        if (this.doesThisHaveIt("hand torch"))
            rep = "The holder already bears a torch you bumbling oaf.";
        
        else {
            Player.getInv().give(item, this.inv);
            ((Kitc)Player.getRoomRef("KITC")).swtch();
        }
        
        return rep;
    }
/*----------------------------------------------------------------------------*/
    /**
     * When a torch is added to or taken from this, the kitchen light is switched.
     * @author Kevin Rapa
     */
    private class KitcHldr_Inv extends Hldr_Inv {
    // CONSTRUCTOR ------------------------------------------------------------     
        public KitcHldr_Inv() {
            super();
        }
    /*------------------------------------------------------------------------*/
        @Override public boolean add(Item item) { 
            if (item.toString().matches("hand torch") && this.size() == 0) {
                this.CONTENTS.add(item);
                ((Kitc)Player.getRoomRef("KITC")).swtch();
                Player.describeRoom();
                return true;
            }
            GUI.out("The " + item + " doesn't fit in.");
            return false;
        }
    /*------------------------------------------------------------------------*/
        @Override public void remove(Item item) {
            this.CONTENTS.remove(item);
            Player.describeRoom();
            ((Kitc)Player.getRoomRef("KITC")).swtch();
        }
    /*------------------------------------------------------------------------*/
    }
}

