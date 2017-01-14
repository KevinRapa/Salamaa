package Crypt;

import A_Super.Furniture;
/**
 * @author Kevin Rapa
 */
public class Cry1_Crvng extends Furniture {

    // ========================================================================
    public Cry1_Crvng () {
        super();
        this.searchable = false;
        
        this.description = "Carved into the wall is a mural of sorts. In the center\n"
                         + "is a standing cloaked figure resembling a skeleton. It\n"
                         + "holds a scythe and stands elevated among many clothingless\n"
                         + "people piled up on eachother, crawling towards it. It's\n"
                         + "as if the people wish to embrace the standing cloaked figure.\n"
                         + "Many clouds gather high above the skeleton.";

        this.addNameKeys("(?:wall )?carving", "(?:death )?depiction", "art", "mural(?: of sorts)?");
    }
    // ========================================================================    
}


