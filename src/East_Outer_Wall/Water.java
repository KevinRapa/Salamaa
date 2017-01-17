package East_Outer_Wall;

import A_Super.Furniture;
import A_Super.Item;
import A_Main.Player;
import static A_Main.NameConstants.METAL_BUCKET;

public class Water extends Furniture {
    private final Item BUCKET_REF;
/* CONSTRUCTOR ---------------------------------------------------------------*/     
    public Water(Item bckt) {
        super();
        this.BUCKET_REF = bckt;
        this.searchable = false;
        this.description = "Clean, sparkling water.";
        this.searchDialog = "Just clean H2O here.";
        this.actDialog = "Now is NOT the time for a swim, though it's tempting. You\n"
                       + "don't even have a change of clothes, and you aren't wearing\n"
                       + "servant's garb.";
        this.useDialog = "You dip the bucket in and fill it with water.";
        this.addActKeys("drink", "swim");
        this.addNameKeys("water", "clear water");
        this.addUseKeys(METAL_BUCKET);
    }
/*----------------------------------------------------------------------------*/
    @Override public String useEvent(Item item) {
        Player.getInv().remove(item);
        Player.getInv().add(BUCKET_REF);
        
        return this.useDialog;
    }
/*----------------------------------------------------------------------------*/
    @Override public String interact(String key) { 
        if (key.equals("swim"))
            return this.actDialog;
        
        return "You take a sip of water and feel refreshed. Carrying\n"
             + "all that stuff around has tired you.";
    }
/*----------------------------------------------------------------------------*/
}
