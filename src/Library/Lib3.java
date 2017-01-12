package Library;

import A_Main.AudioPlayer;
import A_Super.Direction;
import A_Super.Room;

public class Lib3 extends Room{
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Lib3(String name, String ID) {
        super(name, ID);
        description= "This room is too sophisticated for you. You stand on the\n" +
                     "south end of a library. The room extends north, and above\n" +
                     "you is open save a balcony on the library's second floor.\n" +
                     "The room is well lit with spherical electric sconces. In \n" +
                     "the center of this area is an impressive statue of a\n" +
                     "galloping horse. Against the east wall is both a set of stairs\n" +
                     "leading to the second story and a glass pane window. Against\n" +
                     "the south wall is a bookshelf labeled \"Creation\". A couch\n" +
                     "sits just in front of a large pillar against the stairs.\n";
    }
/*----------------------------------------------------------------------------*/
    @Override public String getBarrier(Direction dir) {
        if (dir == Direction.SOUTH) {
            AudioPlayer.playEffect(6);
            return "There's a bookshelf in the way.";
        }
        else
            return bumpIntoWall();
    }
/*----------------------------------------------------------------------------*/
}

