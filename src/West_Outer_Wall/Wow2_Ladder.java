package West_Outer_Wall;

import A_Main.AudioPlayer;
import static A_Main.NameConstants.FIXED_LADDER;
import A_Main.Player;
import A_Super.Staircase;
import A_Super.Direction;
/**
 * Created from the wooden rod, broken ladder, and wooden spoke.
 * 
 * @author Kevin Rapa
 */
public class Wow2_Ladder extends Staircase {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Wow2_Ladder(Direction direction) {
        super(direction);
        this.searchDialog = "The ladder hides nothing.";
        this.description = "The ladder rests against the upper balcony, but it's\n"
                         + "unstable from the debris.";
        this.NAMEKEYS.clear();
        this.addNameKeys("ladder", FIXED_LADDER);
    }
/*----------------------------------------------------------------------------*/ 
    @Override public String interact(String key) {     
        Player.move(this.DIR);
        playEffect();       
        return null;       
    }
/*----------------------------------------------------------------------------*/
    @Override protected void playEffect() {
        AudioPlayer.playEffect(16);
    }
/*----------------------------------------------------------------------------*/
}