package Courtyard;

import A_Super.Furniture;
import A_Super.Unmoveable;
/**
 * @author Kevin Rapa
 */
public class Cou1_Bench extends Furniture implements Unmoveable {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Cou1_Bench() {
        super();
        this.description = "The bench is blanketed in multiflora. Its backrest "
                         + "lies on the ground behind it.";
        this.searchDialog = "You aren't risking getting pricked by those thorns.";
        this.actDialog = this.searchDialog;
        this.addActKeys(SITPATTERN, JOSTLEPATTERN, MOVEPATTERN);
        this.addNameKeys("(?:ruined )?(?:stone )?bench");
    }
//-----------------------------------------------------------------------------
    @Override public String interact(String key) {
        if (key.matches(SITPATTERN))
            return this.actDialog;
        else if (key.matches(JOSTLEPATTERN))
            return "You give it a nudge. 'Sure is sturdy!' You think to yourself.";    
        else
            return "It's solid stone and heavy. You can't move it.";
    }
//-----------------------------------------------------------------------------
}
