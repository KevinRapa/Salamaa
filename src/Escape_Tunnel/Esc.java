package Escape_Tunnel;

import A_Main.GUI;
import A_Main.Id;
import A_Main.Player;
import static A_Main.Names.HAND_TORCH;
import A_Super.Ceiling;
import A_Super.Room;
import A_Super.Direction;
import A_Super.Furniture;
import A_Super.Wall;
import Tunnels.DungeonMonsterFurniture;
import Tunnels.Dungeon_Floor;
/**
 * Represents the tunnels the player must walk through to escape INTR (cell).
 * 
 * @see Cell.Intr_Grt
 * @see Cell.Intr
 * @author Kevin Rapa
 */
public class Esc extends Room {
    private static final Furniture 
        MACHINERY_REF = new Esc_Mchnry(),
        FLOOR_REF = new Esc_F(),
        ESC_WALL = new Wall("The walls are masked by a wall of machinery."),
        ESC_CLNG = new Ceiling() {{this.description = "The ceiling is pretty low here.";}},
        MONSTER = new DungeonMonsterFurniture();
    
    private static final String 
        MACHINERY_DESC = "You're crammed in a small utility tunnel. Many "
        + "pistons, gears, and other complicated machinery operate around "
        + "you. The hallway offers a bit of space in which to move forward. ",
        REFUSE_TO_MOVE = "It's too dark to see anything, and there is a lot "
        + "of dangerous sounding machinery. You don't feel comfortable moving forward.",
        TOO_DARK = "It's too dark to see anything at all. "
        + "All you here is a bunch of dangerous sounding machinery.";
//-----------------------------------------------------------------------------    
    public Esc(String name, String ID) {
        super(name, ID);
        this.addFurniture(MACHINERY_REF, FLOOR_REF, ESC_WALL, ESC_CLNG, MONSTER);
    }
//-----------------------------------------------------------------------------
    @Override public String getBarrier(Direction dir) {
        if (playerHasTorch())
            return "There's a lot of dangerous looking machinery that way.";
        else
            return TOO_DARK;
    }
//-----------------------------------------------------------------------------
    @Override public String getDescription() {
        if (playerHasTorch())
            return MACHINERY_DESC + super.getDescription();
        else
            return TOO_DARK;
    }
//-----------------------------------------------------------------------------
    @Override public String triggeredEvent() {
        if (! playerHasTorch() && ! Player.getPosId().equals(Id.ESC1)) {
            GUI.out(REFUSE_TO_MOVE);
            Player.setOccupies(Id.ESC1);
        }
        return Player.getPos().toString();
    }
//-----------------------------------------------------------------------------
    private static boolean playerHasTorch() {
        return Player.hasItem(HAND_TORCH);
    }
//-----------------------------------------------------------------------------
// ****************************************************************************
//-----------------------------------------------------------------------------    
    public static class Esc_Mchnry extends Furniture {
        public Esc_Mchnry () {
            super();

            this.description = "All sorts of dangerous exposed machinery operate "
                             + "around you. You better be careful moving. This "
                             + "machinery must power some areas of the castle?";
            this.actDialog = "You wouldn't dream of going anywhere near it.";
            this.searchDialog = "You best keep moving and get out of here.";

            this.addNameKeys("machinery", "gears?", "pistons?");
            this.addActKeys("touch", "operate");
        }
        @Override public String getDescription() {
            if (playerHasTorch())
                return this.description;
            else
                return TOO_DARK;
        }
    }
//-----------------------------------------------------------------------------
// ****************************************************************************    
//-----------------------------------------------------------------------------    
    private static class Esc_F extends Dungeon_Floor {
        public Esc_F() {
            super();
            this.searchable = false;
            this.searchDialog = 
                    "There's nothing here, and you don't feel comfortable "
                  + "putting anything down where it will drop into oblivion.";
        }
        @Override public String getDescription() {
            if (playerHasTorch())
                return this.description;
            else
                return TOO_DARK;
        }
    }
//-----------------------------------------------------------------------------
// ****************************************************************************    
//-----------------------------------------------------------------------------       
}