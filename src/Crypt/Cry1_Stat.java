package Crypt;

import A_Main.Id;
import A_Main.NameConstants;
import A_Main.Player;
import A_Super.Furniture;
import A_Super.Item;
import A_Super.Resetable;
import A_Super.Statue;
/**
 * @author Kevin Rapa
 */
public class Cry1_Stat extends Statue implements Resetable {
    private boolean hasScythe, eyesGlowing;
    private final Furniture SCYTHE_REF, DOOR_REF;
    // ========================================================================
    public Cry1_Stat (Furniture scythe, Furniture door) {
        super();
        
        this.hasScythe = this.eyesGlowing = false;
        
        this.SCYTHE_REF = scythe;   this.DOOR_REF = door;
        
        this.useDialog = "You place the scythe into the statue's left hand.";
        this.description = "The tall statue stands in the center of this side\n"
                         + "of the room. The statue is cloaked with a skull for\n"
                         + "a head and stares at you. It holds one of its boney hands up as if it were\n"
                         + "grasping something, though its palm is empty. With the other\n"
                         + "palm it reaches out openly towards you.";
        
        this.addNameKeys("(?:tall )?(?:stone )?(?:cloaked )?statue", "(?:bone?y)?(?:hand|palm)");
        this.addUseKeys(NameConstants.SCYTHE);
        this.addActKeys("shake", "embrace", "greet", "hold", "grasp", 
                        "push", "pull", "move", "turn", "twist");
    }
    // ======================================================================== 
    @Override public String getDescription() {
        String result;
        
        if (! this.hasScythe)
            result =  this.description;
        else
            result = this.description.replaceFirst(
                    "one of its boney hands up as if it were\ngrasping something, though its palm is empty", 
                    "a scythe in one hand");
        
        if (this.eyesGlowing)
            return result.concat(" It's eyeholes glow with an orange light.");
        else
            return result;
    }
    // ========================================================================   
    @Override public String getSearchDialog() {
        return this.getDescription();
    }
    // ========================================================================   
    @Override public String interact(String key) {              
        if (key.matches("touch|feel"))
            return this.actDialog;
        else {
            if (this.hasScythe) {
                this.eyesGlowing = true;
                return "You grasp the statue's right hand and twist. An orange\n"
                     + "light glows deep in the statue's eyes.";
            }
            else {
                return "You grasp the statue's right hand and twist. Nothing happens.";
            }
        }
    }
    // ========================================================================     
    @Override public String useEvent(Item item) {
        Player.getInv().remove(item);
        this.hasScythe = true;
        return this.useDialog;
    }
    // ========================================================================     
    @Override public void reset() {
        if (this.hasScythe) {
            Player.getRoomObj(Id.CRY2).removeFurniture(DOOR_REF);
            Player.getRoomObj(Id.TORC).addFurniture(SCYTHE_REF);
            this.hasScythe = false;
        }
        if (Player.getRoomObj(Id.CRY2).isAdjacent(Id.CAS1)) {
            Player.getRoomObj(Id.CRY2).removeAdjacent(Id.CAS1);
            Player.getRoomObj(Id.CAS1).removeAdjacent(Id.CRY2);
        }
        this.eyesGlowing = false;
    }
    // ========================================================================     
    public boolean isSolved() {
        return this.eyesGlowing; 
    }
    // ========================================================================     
}


