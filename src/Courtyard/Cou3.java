package Courtyard;

import Main.AudioPlayer;
import Main.GUI;
import Main.Player;
import Super.Room;

public class Cou3 extends Room{
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Cou3(String name, String ID) {
        super(name, ID);
        description= "You're in the center of an overgrown courtyard, just in\n" +
                     "front of the main gate. You are surrounded on all sides\n" +
                     "by the fortress-like castle wall. Before you climbs a\n" +
                     "great set of crumbling steps to the castle's entrance.\n" +
                     "The courtyard forks to your left and right, wrapping\n" +
                     "around to the sides of the steps. Ivy grows rampantly\n" +
                     "on and over everything. To your left and right appears\n" +
                     "as what used to be a couple fountains.";
    }
/*----------------------------------------------------------------------------*/
    @Override public String triggeredEvent() {
        Room cou4 = Player.getMapRef()[3][6][5];
        String rep = "You are " + this + ".";
        
        if (! cou4.isThisLocked()) {
            cou4.lock();
            AudioPlayer.playEffect(7);
            GUI.out("As you walk into the front courtyard, the huge gates\n"
                + "slowly swing shut behind you.");
        }               
        return rep;
    }
/*----------------------------------------------------------------------------*/
}

