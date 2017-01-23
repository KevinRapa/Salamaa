package Courtyard;

import static A_Main.NameConstants.HAND_TORCH;
import static A_Main.NameConstants.SCYTHE;
import A_Main.Player;
import A_Super.Furniture;
import A_Super.Item;
/**
 * @author Kevin Rapa
 */
abstract public class Courtyard_Growth extends Furniture {
    protected String cutDialog;
    // ========================================================================
    public Courtyard_Growth () {
        super();

        this.addUseKeys("\\w* (?:axe|sword)", SCYTHE, HAND_TORCH, "hoe");
        this.addActKeys("grab", "touch", "hold", "cut", "chop", "remove");
    }
    // ========================================================================   
    @Override public String interact(String key) {              
        if (key.matches("grab|touch|hold"))
            return this.actDialog;
        else if (Player.hasItem("\\w* (?:axe|sword)|scythe"))
            return this.cutDialog;
        else
            return "You have nothing to cut it up with.";
    }
    // ========================================================================     
    @Override public String useEvent(Item item) {
        String i = item.toString();
        
        if (i.equals(HAND_TORCH))
            return this.useDialog;
        else if (i.matches("hoe"))
            return "You're not a gardener!";
        else 
            return this.cutDialog;
    }
    // ========================================================================     
}

