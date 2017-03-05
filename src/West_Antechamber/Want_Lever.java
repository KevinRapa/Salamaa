package West_Antechamber;

import A_Main.AudioPlayer;
import A_Main.Id;
import A_Super.Lever;
import A_Main.Player;
import Rotunda.Rotu;

public class Want_Lever extends Lever {
    public Want_Lever() {
        super();

        this.description = "It's a black iron lever resting on the plinth of the\n"
                         + "statue.";
        this.searchDialog = "There's a pile of gold! No, not really, just a lever.";
        this.actDialog = "You pull the lever. The room vibrates and you\n"
                       + "here a prolonged rumble past the wall to your west.";
        this.addNameKeys("lever", "(?:black )?(?:iron )?lever");
    }
/*----------------------------------------------------------------------------*/    
    @Override public String event(String key) {
        Rotu ref = (Rotu)Player.getRoomObj(Id.ROTU);
        
        if (ref.getState() == 'e')
            return "You pull the lever, but nothing happens except a faint\n"
                 + "-click- sounding past the wall to your west.";
        else {
            AudioPlayer.playEffect(19, -10);
            ref.rotate();
            return this.actDialog;
        }
    }
/*----------------------------------------------------------------------------*/
}
