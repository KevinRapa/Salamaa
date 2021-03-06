package West_Antechamber;

import A_Super.Furniture;

public class Want_Ramp extends Furniture{
//-----------------------------------------------------------------------------    
    public Want_Ramp() {
        super();

        this.description = "At the far end of the antechamber, a ramp slopes "
                         + "downward about six feet before terminating at a door.";
        this.searchDialog = "There's nothing there except dust and a few cobwebs.";
        this.addNameKeys("ramp");
    }
//-----------------------------------------------------------------------------
}
