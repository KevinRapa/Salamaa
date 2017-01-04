package Library;

import A_Super.Furniture;

public class Lib_Cch extends Furniture {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Lib_Cch() {
        super();
        this.searchable = false;
        this.description = "A red gothic-era couch. It looks way more fancy\n"
                         + "than comfortable. Its frame is a glorious rosewood.";
        this.searchDialog = "You look underneath, but find nothing.";
        this.actDialog = "You relax on the couch for a moment. You feel like your\n"
                    + "IQ has just risen a couple points.";
        this.addNameKeys("(?:red )?(?:gothic-era )?(?:couch|sofa)");
        this.addActKeys("sit", "use", "relax", "lay");
    }
/*----------------------------------------------------------------------------*/
}