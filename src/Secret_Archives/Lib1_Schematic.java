package Secret_Archives;

import A_Super.Note;
/**
 * The solution for the light puzzle.
 * Floor 3: All foci
 * Floor 2: Blue -> Yellow -> Red
 * Floor 1: Red -> Blue -> Dark
 * 
 * @author Kevin Rapa
 */
public class Lib1_Schematic extends Note {
/* CONSTRUCTOR ---------------------------------------------------------------*/
    public Lib1_Schematic(String name) {
        super(name);
        this.description = "25-4-1652 - \n" +
                           "gamma schematic\n" +
                           "   \t  [d   ][ ]" +
                           " \t\t\t [b g w][ ]" +
                           "\t\t\t[r p dp][S]" +
                           "	    \t\t\t[|]" +
                           "	    \t\t\t[|]" +
                           "\n" +
                           "  \t\tTo self:\n" +
                           "require a vessel\n" +
                           "thats holds a charge. -Rhadamanthus";
    }
/*----------------------------------------------------------------------------*/
}