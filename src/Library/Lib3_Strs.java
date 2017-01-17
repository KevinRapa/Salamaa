package Library;

import A_Main.Id;
import static A_Main.NameConstants.LEATHER_SHOES;
import A_Main.Player;
import A_Super.Furniture;

public class Lib3_Strs extends Furniture {
/* CONSTRUCTOR ---------------------------------------------------------------*/     
    public Lib3_Strs() {
        super();
        this.searchable = false;
        this.searchDialog = "You begin the search, but as soon as you touch the\n"
                          + "stairs, they flatten down to the floor before popping\n"
                          + "back up again.";
        this.description = "The stairs are a gray stone with salmon-colored\n"
                         + "marble steps. They lead up to the northern second-\n"
                         + "story area of the library.";
        this.addNameKeys("stairs", "staircase", "steps");
        this.addActKeys("use", "climb", "walk");
    }
/*----------------------------------------------------------------------------*/
    @Override public String interact(String key) {     
        String rep;
        
        if (Player.getShoes().equals(LEATHER_SHOES)) {
            Player.setOccupies(Id.LIB3);
                
            rep = "You successfully climb the stairs to the second floor.";        
        }
        else {
            rep = "As soon as your foot touches the bottom step, the staircase\n"
                + "flattens against the floor. You remove your foot, and the\n"
                + "staircase pops back up again. 'How irritating!' you exclaim.";
        }
        return rep;
    }
/*----------------------------------------------------------------------------*/
}