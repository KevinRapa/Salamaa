package Gallery;

import static A_Main.Names.SCREWDRIVER;
import static A_Main.Names.WEAPON;
import A_Main.Player;
import A_Super.Furniture;
import A_Super.Gettable;
import A_Super.Item;
import A_Super.Moveable;
/**
 * The 1mm screws for fixing the red focus are found here. The player must a use
 * a screwdriver found in the workshop to obtain the screws from here.
 * 
 * @author Kevin Rapa
 */
public class Gal4_Radio extends Furniture implements Gettable, Moveable {
    private final String DESC_2;
    private final Item SCREW_REF;
    private int screwsLeft;
    //-------------------------------------------------------------------------
    public Gal4_Radio (Item screw) {
        super();
        
        this.screwsLeft = 4;
        this.SCREW_REF = screw;
        
        this.description = 
                "Its glassed-in surface protects many gauges, copper coils, " +
                "and bulbs of which you know little. Holding the panel in are "
              + "several metal brackets around the edge as well as four small " +
                "screws on the corners of the box. A small lever " +
                "sticks out from the right side of the box.";
        
        this.DESC_2 = 
                "Its glassed-in surface protects many gauges, copper coils, " +
                "and bulbs of which you know little. Holding the front glass "
              + "panel in are several metal brackets around the edge. A "
              + "small lever sticks out from the right side of the box.";

        this.actDialog = "Nothing useful has ever been accomplished through senseless "
                       + "violence. Lets keep our wits and figure out a more rational "
                       + "course of action.";
        
        this.searchDialog = "There is nothing interesting hidden on the box, nor "
                          + "are any of the odd mechanical parts inside of interest.";
        
        this.useDialog = "The screwdriver fits into one of the screws on the "
                       + "tall radio. You twist and with little-effort, the "
                       + "miniature screw falls out into your palm.";

        this.addNameKeys("(?:tall )?(?:blue )?(?:modern )?(?:metal )?(?:machine|radio)", 
                "(?:tiny )?screws?", "(?:front )?(?:glass )?panel");
        this.addUseKeys(ANYTHING);
        this.addActKeys(GETPATTERN, "break", "unscrew", "listen");
    }
    //------------------------------------------------------------------------- 
    @Override public String getDescription() {
        return (screwsLeft > 0) ? this.description : this.DESC_2;
    }
    //-------------------------------------------------------------------------   
    @Override public String interact(String key) {              
        if (key.equals("break"))
            return this.actDialog;
        else if (key.equals("listen"))
            return "The radio isn't on for you to do that.";
        else
            return "The only obtainable thing on this box seems to be the front "
                 + "screws, but digging them out by hand seems infeasible.";
    }
    //-------------------------------------------------------------------------     
    @Override public String useEvent(Item item) {
        if (item.getType().equals(WEAPON))
            return actDialog;
        else if (item.toString().equals(SCREWDRIVER))
            if (screwsLeft > 0) {
                if (Player.getInv().add(SCREW_REF)) {
                    screwsLeft--;
                    return this.useDialog;
                }
                else
                    return NOTHING;
            }
            else
                return "You have already unscrewed everything you can. Perhaps "
                     + "you should be more aware of where you leave things.";
        else
            return "You can't imagine what useful thing you could get done with that.";
    }
    //-------------------------------------------------------------------------     
}


