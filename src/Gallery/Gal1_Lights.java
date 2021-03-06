package Gallery;

import A_Super.Furniture;

public class Gal1_Lights extends Furniture{
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Gal1_Lights() {
        super();
        this.searchable = false;
        this.description = "These lights are electric. Your assumption is that "
                         + "this is the newer wing of the castle.";
        this.actDialog = "Ow! It's not fire, but it's still hot!";
        this.addActKeys(HOLDPATTERN);
        this.addNameKeys("(?:electric )?lights?");
    }
//-----------------------------------------------------------------------------
}
