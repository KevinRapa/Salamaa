package Oubliette;

import A_Super.Furniture;
import A_Super.Unmoveable;
/**
 * @author Kevin Rapa
 */
public class Ou62_Spike extends Furniture implements Unmoveable {
    //-------------------------------------------------------------------------
    public Ou62_Spike () {
        super();

        this.description = "The spike is made of iron and is quite sharp. Much "
                         + "more interesting, of course, is the clean skeleton "
                         + "adorning the spike.";

        this.addNameKeys("(?:sharp )?(?:iron )?spike");
    }
    //-------------------------------------------------------------------------    
}


