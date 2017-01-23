package Kitchen;

import static A_Main.NameConstants.HAND_TORCH;
import A_Super.Item;
import A_Super.SearchableFurniture;

public class Kitc_Hearth extends SearchableFurniture {
/* CONSTRUCTOR ---------------------------------------------------------------*/     
    public Kitc_Hearth(Item ... items) {
        super(items);
  
        this.description = "The hearth is a simple square pit lined with mortared cobblestone.";
        this.searchDialog = "You look inside the pit.";
        this.actDialog = "You really could use a steak or ham right now.";
        this.useDialog = "You try to light the wood, but they are too rotted and\n"
                       + "moist from the coatal air to light.";
        
        this.addNameKeys("(?:unlit )?hearth", "(?:square )?pit");
        this.addActKeys("cook");
        this.addUseKeys(HAND_TORCH);
    }
/*----------------------------------------------------------------------------*/
}

