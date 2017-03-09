package Observatory;

import A_Super.Heavy;
import A_Super.Item;
import A_Super.SearchableFurniture;
/**
 * @author Kevin Rapa
 */
public class Obs1_Telescope extends SearchableFurniture implements Heavy {
    // ========================================================================
    public Obs1_Telescope (Item... items) {
        super(items);
        this.description = "The large old heavy telescope sits as an antique\n"
                         + "against the west wall. It looks to be made of mostly\n"
                         + "aluminum, bronze, and wood. A small eyepiece connects to a\n"
                         + "foot-wide lens near the top. Many various gears and other\n"
                         + "parts comprise it as well.";
        this.searchDialog = "You carefully look through its various intricacies.";
        this.actDialog = "You look into the eyepiece and see nothing but black.";

        this.addNameKeys("(?:large )?(?:old )?(?:heavy )?(?:antique )?telescope");
        this.addActKeys("use", "look", "gaze", "view");
    }
    // ========================================================================     
}


