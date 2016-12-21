package Chapel;

import Super.Furniture;

public class Cha1_Cylx extends Furniture {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Cha1_Cylx() {
        super();
        this.searchable = false;
        this.description = "The cylix looks like a wide brass bowl.";
        this.useDialog = "You begin banging the container against the bowl, but the"
                       + "bowl isn't fitting inside...";
        this.searchDialog = "If your logic is holding as well as this bowl is,\n"
                          + "you'd guess this vessel was filled with holy water.\n"
                          + "You can't pick up the water with your hands though.";
        this.addNameKeys("cylix", "bowl");
        this.addUseKeys("empty vial", "metal bucket", "glass bottle");
    }
/* -------------------------------------------------------------------------- */
}
