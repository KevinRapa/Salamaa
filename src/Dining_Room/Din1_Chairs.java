package Dining_Room;

import A_Super.Furniture;
import A_Super.Moveable;

public class Din1_Chairs extends Furniture implements Moveable {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Din1_Chairs() {
        super();

        this.description = "The chairs are boxy with lavender upholstery. The "
                         + "hickory wood is meticulously carved. 'They can "
                         + "carve a chair worth double my life, but not one "
                         + "worth 5 minutes of sitting in!'";
        this.searchDialog = "You look underneath, but find nothing.";
        this.actDialog = "You pick out a chair to sit in and stare out the window "
                       + "on the east end. For a moment, you feel free of worry.";
        
        this.addActKeys(SITPATTERN);
        this.addNameKeys("chairs?");
    }
//-----------------------------------------------------------------------------
}
