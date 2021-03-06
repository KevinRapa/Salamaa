package Workshop;

import A_Super.Item;
import A_Super.Moveable;
import A_Super.Openable;
import A_Super.SearchableFurniture;
        
public class Wrk_Barrel extends SearchableFurniture implements Openable, Moveable {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Wrk_Barrel(Item... items) {
        super(items);
        this.description = "It's not full sized... maybe only three feet high. "
                         + "It has a wooden lid on top.";
        this.searchDialog = "You open the lid and peer inside.";
        this.addNameKeys("(?:wood(?:en)? )?barrel");
    }
//-----------------------------------------------------------------------------
}
