package Gallery;

import A_Super.Furniture;

public class Gal2_Clmns extends Furniture{
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Gal2_Clmns() {
        super();
        this.searchable = false;
        this.description = "These columns are clean white stone. They're Greek Ionic.";
        this.actDialog = "These columns don't need extra help holding up the\nceiling.";
        this.addActKeys("grab", "hold");
        this.addNameKeys("columns?");
    }
/*----------------------------------------------------------------------------*/
}