package Gallery;

import A_Main.AudioPlayer;
import A_Main.GUI;
import A_Main.Id;
import A_Super.Item;
import A_Super.Furniture;
import A_Main.Inventory;
import A_Main.Names;
import A_Main.Player;
/**
 * One of four elements of the light machine puzzle in the gallery.
 * Foci must be added to this in the correct order while the statue is holding
 * the funny orb in order to raise the statue to the next level.
 * 
 * @see Gallery.Gal_LightMachine
 * @see Gallery.Gal2_Statue
 * @author Kevin Rapa
 */
public class Gal1_Dragon extends Gal_LightMachine {
    private final int GAL2_STAT_ID;
    private final boolean[] EYES = {false, false};
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Gal1_Dragon(Furniture stat, Item yellowFocus) {
        super();
        this.searchDialog = "The only place to search is the dragon's mouth.";
        this.turnOffDialog = "The light in the dragon's mouth shuts off.";
        this.description = "The room's most prominent piece is this detailed "
                         + "dark green dragon statue. It looks original to east "
                         + "Asia. Its serpent-like body twists around and it stares "
                         + "menacingly ";
        this.GAL2_STAT_ID = stat.getID();
        addNameKeys("snake-like dragon(?: statue)?", "(?:dragon|statue)", "(?:dragon's |statue's )?mouth");
        this.inv = new Drgn_Inv(yellowFocus);    
    }
//-----------------------------------------------------------------------------    
    @Override public String getDescription() {
        if (this.isOn) 
            return description.concat("with its two eyes lit. A light from within "
                                    + "the dragon shines brightly through its mouth.");
        else if (EYES[0] && ! EYES[1]) 
            return description.concat("at the statue in the central chamber. "
                                    + "Its left eye glows brightly from an unknown source.");
        else if (! EYES[0] && EYES[1]) 
            return description.concat("at the statue in the central chamber. "
                                    + "Its right eye glows brightly from an unknown source.");
        else
            return description.concat("with cold eyes at the statue in the central chamber. "
                    + "Careful inspection reveals two wires coming out the back. One leads "
                    + "behind the screen, the other behind the scroll.");
    }
//-----------------------------------------------------------------------------    
    public String switchEye(int i) {
        // 0 is left, 1 is right
        EYES[i] = ! EYES[i];
        String eye = (i == 0) ? "left" : "right";
        
        String rep = EYES[i] ? "The dragon's " + eye + " eye lights up. " :
                               "The glow in the dragon's " + eye + " eye fades. ";
        
        if (EYES[0] && EYES[1])
            return rep.concat(this.turnOn());
        else if (isOn)
            return rep.concat(this.turnOff());
        else
            return rep;
    }
//-----------------------------------------------------------------------------    
    @Override protected String turnOn() {
        this.determineColor();
        this.isOn = true;       
        Gal2_Statue s = (Gal2_Statue)Player.getRoomObj(Id.GAL2).getFurnRef(GAL2_STAT_ID);
        return beam + " emits from the dragon's mouth. " + s.activate(beam);
    }
//-----------------------------------------------------------------------------
    @Override protected void resetStatue() {
        ((Gal2_Statue)Player.getRoomObj(Id.GAL2).getFurnRef(GAL2_STAT_ID)).reset();
    }
//----------------------------------------------------------------------------- 
    private class Drgn_Inv extends Inventory {   
        public Drgn_Inv(Item yellowFocus) {
            super();
            this.CONTENTS.add(yellowFocus);
        }
        //---------------------------------------------------------------------
        @Override public boolean add(Item item) { 
            if (item.getType().equals(Names.FOCUS)) {
                AudioPlayer.playEffect(43);
                this.CONTENTS.add(item);
                
                if (Gal1_Dragon.this.isOn)
                    this.trigger();
                else
                    GUI.out("You place the " + item + " into the dragon's mouth.");
                
                return true;
            }
            else {
                GUI.out("It doesn't seem like that belongs there.");
                return false;
            }
        }
        //---------------------------------------------------------------------
        @Override public void remove(Item removeThis) {
            this.CONTENTS.remove(removeThis);
            
            if (Gal1_Dragon.this.isOn)
                this.trigger();
        }
        //---------------------------------------------------------------------
        private void trigger() {
            determineColor();
            Gal2_Statue s = (Gal2_Statue)Player.getRoomObj(Id.GAL2).getFurnRef(GAL2_STAT_ID);
            GUI.out(beam + " emits from the dragon's mouth. " + s.activate(beam));
        }
    }
//-----------------------------------------------------------------------------
}

