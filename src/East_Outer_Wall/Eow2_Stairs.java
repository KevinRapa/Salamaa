package East_Outer_Wall;

import A_Super.Direction;
import A_Super.Staircase;

public class Eow2_Stairs extends Staircase {
/* CONSTRUCTOR ---------------------------------------------------------------*/     
    public Eow2_Stairs (Direction direction) {
        super(direction);
        this.description = "The curved sandstone stairs lead to a small balcony\n"
                         + "above. It's a wonder why these didn't crumble like\n"
                         + "those in the west outer wall.";
    }
/*----------------------------------------------------------------------------*/
    @Override public String getDescription() {
        if (this.DIR == Direction.DOWN) {
            return "The curved sandstone stairs lead down to the first floor.\n"
                 + "It's a wonder why these didn't crumble like those in\n"
                 + "the west outer wall.";
        }
        return this.description;
    }
/*----------------------------------------------------------------------------*/
}