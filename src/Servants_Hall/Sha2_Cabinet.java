package Servants_Hall;

import static A_Main.Id.CBNT;
import A_Super.Item;
import A_Super.LockedContainer;
/**
 * @author Kevin Rapa
 */
public class Sha2_Cabinet extends LockedContainer {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Sha2_Cabinet(Item... items) {
        super(CBNT, items);
        
        this.description = "It's a large wooden double-door cabinet. It looks "
                         + "plain and cheap. It must just house tools for the "
                         + "servants.";
        this.actDialog = "The tiny metal key fits perfectly. You turn it and the "
                            + "cabinet makes a satisfying *click*.";
        this.searchDialog = "The cabinet is locked. Maybe one of the servants "
                          + "had a key...";

        this.addNameKeys("(?:large )?(?:wood(?:en)? )?(?:double-door )?cabinet");
    }    
///-----------------------------------------------------------------------------
}
