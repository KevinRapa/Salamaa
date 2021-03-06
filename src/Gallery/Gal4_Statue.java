package Gallery;

import A_Main.AudioPlayer;
import A_Main.Id;
import A_Main.Player;
import A_Super.Furniture;
import A_Super.MachineColor;

public class Gal4_Statue extends Furniture {
    private int level;
    private final Furniture GAL7_STAT_REF;
    
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Gal4_Statue(Furniture stat) {
        super();
        
        this.GAL7_STAT_REF = stat;
        this.level = 0;
        
        this.actDialog = "What glorious rippling muscles the statue has!";
        this.description = "The statue now stands surrounded by the second floor "
                         + "balcony. The orb has stopped glowing, but one of "
                         + "the statue's eyes has started to.";  
        this.searchDialog = "The statue's hand is out of reach";
        
        this.addNameKeys("(?:grandiose )?statue");
        this.addActKeys("admire");
    }
//-----------------------------------------------------------------------------
    public int getState() {
        return this.level;
    }
//-----------------------------------------------------------------------------
    /**
     * Hits the orb in the statue's hand with light.
     * @param color the color of the beam.
     * @return returns a string of what happens.
     */
    public String activate(MachineColor color) {
        if (Player.getRoomObj(Id.GAL4).hasFurniture(this.getID())) {
            if ((color == MachineColor.BLUE && this.level == 0) || 
                (color == MachineColor.GREEN && this.level == 1) || 
                (color == MachineColor.WHITE && this.level == 2)) {
                return this.raise(); 
            }          
            else if (this.level == 0) {
                return "The beam of light shines into the orb with no effect.";
            }
            else if (this.level <= 2) {
                this.level = 0;
                return "The orb's hum dies and its glow fades.";
            }
            else
                return "The beam of light shines at the statue's base.";
        }
        else 
            return "The beam of light shines into the central chamber.";
    }     
//-----------------------------------------------------------------------------
    private String raise() {
        switch (level++) {
            case 0: 
                return "The crystal orb in the statue's palm glows blue.";
            case 1: 
                return "The orb's glow turns green and it begins to hum.";
            default: 
                Player.getRoomObj(Id.GAL7).addFurniture(GAL7_STAT_REF);
                AudioPlayer.playEffect(37);
                return "The crystal orb's glow brightens to a blinding white "
                    + "light. It hums loudly and rises once again to the "
                    + "third floor level.";
        }
    }
//-----------------------------------------------------------------------------
    @Override public String getDescription() {
        switch(this.level) {
            case 1:
                return "The statue stands holding the glowing orb. It hums softly."; 
            case 2:
                return "The statue stands holding the glowing orb. It's humming "
                    + "quite loudly now."; 
            case 3:
                return "The statue has risen yet again to the highest area of "
                    + "the central chamber across from the third floor loft. "
                    + "The statue's plinth is now exceedingly long and unusual.";
            default:
                return this.description;
        }
    }
//-----------------------------------------------------------------------------
    public void reset() {
        if (this.level <= 2)
            this.level = 0;
    }
//-----------------------------------------------------------------------------
}

