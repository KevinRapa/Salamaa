package Gallery;

import A_Super.Furniture;
import java.util.Random;
import A_Main.GUI;
import A_Main.Menus;
import static A_Main.Patterns.YES_NO_P;
import A_Main.Player;
/**
 * Prints a weird dialog when worn.
 * Superficial, not important to game progression.
 * 
 * @author Kevin Rapa
 */
public class Gal6_Helmet extends Furniture {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Gal6_Helmet() {
        super();

        this.searchDialog = "Everything on the helmet looks concretely attached "
                          + "to the helmet and not removable.";
        this.description = "The metal helmet is covered in wires and metal rods. "
                         + "On the inside are three metal contact plates. It would "
                         + "not be a good idea to wear this.";
        this.actDialog = "AAAAAAAAAAAAAAAAAAAAAAHHHHHHHHHHHHHHHHHHHHHHH "
                    + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! "
                    + "With all your strength, you rip the helmet off your head. "
                    + "It takes you a few moments to catch your breath and recover "
                    + "your sense of direction. You cannot comprehend what just "
                    + "happened.";
        
        this.addActKeys(GETPATTERN);
        this.addActKeys("wear", "put");
        this.addNameKeys("(?:bizarre|cool )?helmet");
    }
//-----------------------------------------------------------------------------
    @Override public String interact(String key) {
        String choice; 
        String r;
        
        GUI.out("Are you really sure you want to wear the helmet?");
 
        choice = GUI.askChoice(Menus.GAL6_HELM, YES_NO_P);

        if (Player.answeredYes(choice)) {
            Random generator = new Random();
            for (int i = 0; i < 18000; i++) {
                r = Integer.toString(generator.nextInt(2));
                for (int j = 0; j < 60; j++) {
                    r += Integer.toString(generator.nextInt(2));    
                }  
                GUI.out(r);
            }
        }
        else
            return "That was a smart decision.";

        return this.actDialog;
    }
//-----------------------------------------------------------------------------
}
