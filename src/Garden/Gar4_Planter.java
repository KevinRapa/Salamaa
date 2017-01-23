package Garden;

import A_Main.AudioPlayer;
import static A_Main.NameConstants.SHOVEL;
import static A_Main.NameConstants.TROWEL;
import A_Main.Player;
import A_Super.Furniture;
import A_Super.Item;
import A_Super.SearchableFurniture;
/**
 * @author Kevin Rapa
 */
public class Gar4_Planter extends SearchableFurniture {
    private final Gar4_Plaque PLQ_REF;
    private final Item PLT_REF;
    // ========================================================================
    public Gar4_Planter (Furniture plaque, Item plate, Item... items) {
        super(items);
        this.PLQ_REF = (Gar4_Plaque)plaque;
        this.PLT_REF = plate;
        this.description = "This planter contains no plants, just a bed of soil.";
        this.actDialog = "You dig around the plaque, but find nothing in the soil.";
        this.searchDialog = "The soil surface is bare and doesn't seem to hide anything.";
        this.useDialog = this.actDialog;

        this.addNameKeys("planter", "(?:bed of )?(?:soil|dirt)", "bed");
        this.addUseKeys(SHOVEL, TROWEL);
        this.addActKeys("dig", "plant", "garden");
    }
    // ========================================================================   
    @Override public String interact(String key) {      
        if (key.equals("dig")) {
            if (Player.hasItem(SHOVEL) || Player.hasItem(TROWEL)) {
                if (PLQ_REF.isMoved()) {
                    if (this.inv.contains(PLT_REF)) {
                        this.inv.give(PLT_REF, Player.getInv());
                        AudioPlayer.playEffect(34);
                        return "You dig under where the plaque was to find a shiny plate!";
                    }
                    else 
                        return "You have already dug under the plaque";
                }
                else {
                    AudioPlayer.playEffect(34);
                    return this.actDialog;
                }
            }
            else 
                return "You have nothing to dig with, and your stocky hands are terrible for digging.";   
        }
        else
            return "You aren't a gardener!";
    }
    // ========================================================================     
    @Override public String useEvent(Item item) {
        return this.interact("dig");
    }
    // ========================================================================     
    @Override public String getSearchDialog() {
        this.searchable = this.PLQ_REF.isMoved();
    
        return this.interact("dig");
    }
    // ========================================================================     
}

