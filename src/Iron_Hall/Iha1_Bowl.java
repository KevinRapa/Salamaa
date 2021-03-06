package Iron_Hall;

import A_Main.AudioPlayer;
import static A_Main.Names.POLEARM;
import A_Main.Player;
import A_Super.Item;
import A_Super.Key;
import A_Super.Furniture;

public class Iha1_Bowl extends Furniture {
    private final int FLOOR_ID;
    private final Key WOWKEY_REF;
    private boolean jabbed;
//-----------------------------------------------------------------------------
    public Iha1_Bowl(Furniture iha1F, Key wow2Key) {
            super();

            this.jabbed = false;
            this.FLOOR_ID = iha1F.getID();
            this.WOWKEY_REF = wow2Key;
            
            this.description = "It's an unlit steel bowl hanging from the ceiling by a "
                             + "chain. A draft from the outside causes it to swing "
                             + "gently. As it rocks, you hear it rattle a little.";
            this.searchDialog = "It's too high up to see if there's anything inside.";
            this.actDialog = "It's too high up to do that with your hands.";
            this.useDialog = "You give the hanging bowl a jab with the pole. "
                           + "A small piece of metal falls out onto the floor.";
            
            this.addUseKeys(POLEARM);
            this.addActKeys(JOSTLEPATTERN, "poke", "jab");
            this.addNameKeys("(?:hanging )?(?:steel )?bowl");
    }
//-----------------------------------------------------------------------------
    @Override public String useEvent(Item item) {
        if (! this.jabbed) {
            Player.getPos().getFurnRef(FLOOR_ID).getInv().add(WOWKEY_REF); 
            AudioPlayer.playEffect(27);
            this.jabbed = true;
            return this.useDialog;
        }
        else 
            return "You jab the bowl, but nothing falls out.";
    }
//-----------------------------------------------------------------------------
}
