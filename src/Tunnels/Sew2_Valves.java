package Tunnels;

import A_Main.AudioPlayer;
import A_Main.GUI;
import A_Main.Menus;
import static A_Main.Patterns.ONE_TO_NINE;
import static A_Main.Patterns.ROMAN_NUMERAL_P;
import A_Super.Furniture;
import A_Super.Resetable;
import java.util.HashMap;
/**
 * This is a valve puzzle. 
 * The player must turn the correct combination of valves to on and then pull
 * the lever in SEW5 to empty the poisonous gas from the cistern.
 * 
 * SOLUTION: 001
 *           110
 *           011
 * 
 * @see Cistern.Cis1
 * @author Kevin Rapa
 */
public class Sew2_Valves extends Furniture implements Resetable {
    //----------------------------------------
    private enum State {
        // Represents an on and off state and
        // an appropriate character image of
        // the dial.
        ON("( /)  ", 1), OFF("(\\ )  ", 0);
        
        private final String DIAL;
        private final int STATE;
        //------------------------------------
        State(String dial, int state) {
            this.DIAL = dial;
            this.STATE = state;
        }
        @Override public String toString() {
            return this.DIAL;
        }
        public int state() {
            return this.STATE;
        }
    }
    //----------------------------------------
    
    private final State[] VLVS = {State.OFF, State.OFF, State.OFF,
                                  State.OFF, State.OFF, State.OFF,
                                  State.OFF, State.OFF, State.OFF}; 
    
    private final HashMap<String, Integer> MAP = new HashMap<>();
    
    private final int[] SOLUTION = {0, 0, 1, 
                                    1, 1, 0, 
                                    0, 1, 1};
    //-------------------------------------------------------------------------
    public Sew2_Valves () {
        super();

        MAP.put("i", 0); MAP.put("ii", 1); MAP.put("iii", 2); MAP.put("iv", 3);
        MAP.put("v", 4); MAP.put("vi", 5); MAP.put("vii", 6); MAP.put("viii", 7);
        MAP.put("ix", 8);
        
        this.description = "It's a grid of 9 valves protruding from a console "
                         + "on the wall. Above each is a roman numeral and a small "
                         + "gauge. The rusty metal pipe originates from and leads out of the console's top.";
        
        this.searchDialog = "There's nothing here that you can take.";

        this.addNameKeys("(?:metal )?valves?", "console", "grid of valves", "(?:roman )?(?:numerals|numbers)");
        this.addActKeys(VALVEPATTERN);
    }
    //-------------------------------------------------------------------------   
    @Override public String interact(String key) {    
        String ans;
        
        do {
            GUI.out("There are dials above each.\t\t\t\t\t" + printValves() + "\t\t\t\tTurn which one?");
            ans = GUI.askChoice(Menus.SEW_VALVE, ROMAN_NUMERAL_P);

            if (ONE_TO_NINE.matcher(ans).matches()) 
                this.turnValve(Integer.parseInt(ans) - 1);
            else if (! ans.isEmpty()) 
                this.turnValve(ans);
            
        } while (! ans.isEmpty());
        
        return NOTHING;
    }
    //-------------------------------------------------------------------------  
    private String printValves() {        
        String result = "       I     II   III\t\t" +
                        "      " + VLVS[0] + VLVS[1] + VLVS[2] + "\t" +
                        "       IV    V     VI\t\t" +
                        "      " + VLVS[3] + VLVS[4] + VLVS[5] + "\t" +
                        "      VII   VIII   IX\t\t" +
                        "      " + VLVS[6] + VLVS[7] + VLVS[8] + "\t"; 
        
        return result;
    }
    //-------------------------------------------------------------------------  
    private void turnValve(int v) {
        AudioPlayer.playEffect(17);
        
        switch(this.VLVS[v]) {
            case ON:
                VLVS[v] = State.OFF;
                break;
            default:
                VLVS[v] = State.ON;
        }
    }
    //-------------------------------------------------------------------------  
    private void turnValve(String v) {
        AudioPlayer.playEffect(17);
        int valveNum = MAP.get(v);
        
        switch(VLVS[valveNum]) {
            case ON:
                VLVS[valveNum] = State.OFF;
                break;
            default:
                VLVS[valveNum] = State.ON;
        }
    }
    //-------------------------------------------------------------------------
    public boolean solved() {
        for (int v = 0; v < 9; v++) {
            if (this.SOLUTION[v] != this.VLVS[v].state())
                return false;
        }
        return true;
    }
    //-------------------------------------------------------------------------
    @Override public void reset() {
        for (int i = 0; i < this.VLVS.length; i++)
            this.VLVS[i] = State.OFF;
    }
    //-------------------------------------------------------------------------
    
}


