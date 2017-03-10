package A_Main;

import static A_Main.Patterns.*;
import java.util.LinkedList;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javafx.embed.swing.JFXPanel;
import javax.swing.border.BevelBorder;
/******************************************************************************
 * This class is responsible for the game interface.
 * All graphical components are set up here.
 * Any text useful to the player is collected here and displayed.
 * Any input from the player is processed here.
 * @author Kevin Rapa
 ******************************************************************************/
public class GUI extends JFXPanel {
    
    // Click noises when player types.
    private enum Click {
        NONE(0), SOFT(21), CLICK(22), VINTAGE(23);
    
        public final int soundEffectId;
        //----------------------------------------
        Click(int key) { this.soundEffectId = key; }
        //----------------------------------------
    }
    
    // <editor-fold defaultstate="collapsed" desc="COMPONENTS AND ATTRIBUTES">
    private static boolean big = true;
    private static int key = Click.NONE.soundEffectId;
    
    private final static JTextArea 
            MEN = new JTextArea(), DESC = new JTextArea(), 
            INV = new JTextArea(), DIAL = new JTextArea();

    private final static JPanel 
            EAST = new JPanel(new BorderLayout()), 
            CNORTH = new JPanel(new BorderLayout()),
            WEST = new JPanel(new BorderLayout()),
            CENTER = new JPanel(), CCENTER = new JPanel(), 
            CSOUTH = new JPanel(), SALAMAA = new JPanel(new FlowLayout(FlowLayout.LEFT));          
    
    private final static JScrollPane 
            SCROLLW = new JScrollPane(DIAL, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, 
                    JScrollPane.HORIZONTAL_SCROLLBAR_NEVER),
            SCROLLE = new JScrollPane(INV, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, 
                    JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    
    private final static JLabel 
            ROOM = new JLabel(), 
            INVLBL = new JLabel("Inventory");
    
    private final static JButton 
            SIZE = new JButton("Small mode"),
            MUTE = new JButton("Mute"),
            KEYS = new JButton("Key click");
    
    private final static JTextField 
            INPUT = new JTextField(" ", 35);
    
    private final static LinkedList<String> UNDO = new LinkedList<>();
    private final static Input_Holder HOLDER = new Input_Holder();
    private final static ArrayList<String> FURN_PARSER = new ArrayList<>();
    private final static LinkedList<Click> KEYSOUND = new LinkedList<>();

    static {
        KEYSOUND.add(Click.NONE); KEYSOUND.add(Click.SOFT); 
        KEYSOUND.add(Click.CLICK); KEYSOUND.add(Click.VINTAGE); 
    }
    // </editor-fold>
    
// *****************************************************************************
// <editor-fold defaultstate="collapsed" desc="CONSTRUCTOR AND COMPONENT CONTROLLERS">
// *****************************************************************************     
    public GUI() {
        Font myFont = new Font("Monospaced", Font.BOLD, 16);
        Font labelFont = new Font("MagicMedieval", Font.BOLD, 20);
        Color myColor = new Color(150, 84, 13);
        
        SCROLLW.setBackground(Color.DARK_GRAY);
        SCROLLW.setBorder(BorderFactory.createSoftBevelBorder(BevelBorder.RAISED, Color.DARK_GRAY, Color.DARK_GRAY));
        
        SALAMAA.setBackground(Color.darkGray);
        SALAMAA.setPreferredSize(new Dimension(390, 45));
        SALAMAA.setBorder(BorderFactory.createRaisedBevelBorder());
        
        JButton[] buttons = {SIZE, MUTE, KEYS};
        for (JButton b : buttons) {
            b.setBackground(Color.DARK_GRAY);
            b.setFocusPainted(false);
            b.setForeground(Color.BLACK);
            b.setPreferredSize(new Dimension(90, 30));
            b.setBorder(BorderFactory.createRaisedBevelBorder());
            b.setFont(new Font("MagicMedieval", Font.BOLD, 15));
            b.addActionListener(new Button_Listener());
            SALAMAA.add(b);
        }

        WEST.add(SALAMAA, BorderLayout.NORTH);
        WEST.add(SCROLLW, BorderLayout.SOUTH);
        
        CENTER.setLayout(new BorderLayout());
        CNORTH.setBackground(Color.DARK_GRAY);
        ROOM.setFont(labelFont);
        ROOM.setForeground(Color.BLACK);
        CNORTH.add(DESC, BorderLayout.NORTH);
        CNORTH.add(ROOM, BorderLayout.SOUTH);
        CCENTER.setBackground(Color.BLACK);
        MEN.setEditable(false);
        MEN.setFont(myFont);
        MEN.setBackground(Color.BLACK);
        MEN.setForeground(myColor);
        CCENTER.add(MEN);
        CSOUTH.setBackground(Color.DARK_GRAY);
        INPUT.addActionListener(new Text_Field_Listener());
        INPUT.addKeyListener(new Text_Field_Key_Listener());
        INPUT.addFocusListener(new GameFocusListener());
        INPUT.setFont(myFont);
        INPUT.setBorder(BorderFactory.createLoweredBevelBorder());
        INPUT.setBackground(Color.DARK_GRAY);
        INPUT.setForeground(Color.BLACK);
        INPUT.setCaretColor(Color.LIGHT_GRAY);
        
        CSOUTH.add(INPUT);
        CENTER.add(CNORTH, BorderLayout.NORTH);
        CENTER.add(CCENTER, BorderLayout.CENTER);
        CENTER.add(CSOUTH, BorderLayout.SOUTH);
            
        SCROLLE.setBackground(Color.DARK_GRAY);
        SCROLLE.setBorder(BorderFactory.createSoftBevelBorder(BevelBorder.RAISED, Color.DARK_GRAY, Color.DARK_GRAY));
        INVLBL.setFont(labelFont);
        INVLBL.setForeground(Color.BLACK);
        EAST.add(INVLBL, BorderLayout.NORTH);
        EAST.add(SCROLLE, BorderLayout.SOUTH);
        
        JLabel[] labels = {ROOM, INVLBL};
        for (JLabel l : labels) {
            l.setOpaque(true);      
            l.setBackground(Color.DARK_GRAY);
            l.setHorizontalAlignment(JLabel.CENTER);
            l.setPreferredSize(new Dimension(390, 45));
            l.setBorder(BorderFactory.createRaisedBevelBorder());
        }
        
        JTextArea[] textAreas = {DIAL, DESC, INV};
        for (JTextArea t : textAreas) {
            t.setMargin(new Insets(0,6,0,6));
            t.setEditable(false);       t.setLineWrap(true);
            t.setWrapStyleWord(true);   t.setBackground(Color.BLACK);
            t.setForeground(myColor);   t.setFont(myFont);
        }
        
        INPUT.setPreferredSize(new Dimension(400, 40));
        WEST.setPreferredSize(new Dimension(300, 600));
        SCROLLW.setPreferredSize(new Dimension(290, 555));
        CENTER.setPreferredSize(new Dimension(400, 600));
        DESC.setPreferredSize(new Dimension(390, 350));
        EAST.setPreferredSize(new Dimension(300, 600));
        SCROLLE.setPreferredSize(new Dimension(290, 555));

        this.addComponents(true);
    }
/*----------------------------------------------------------------------------*/     
    private void addComponents(boolean big) {
        this.setPreferredSize(new Dimension (1000, big ? 600: 510));
        this.setLayout(new BorderLayout());
        this.add(WEST, BorderLayout.WEST);
        this.add(CENTER, BorderLayout.CENTER);
        this.add(EAST, BorderLayout.EAST);
    }
/*----------------------------------------------------------------------------*/
    /**
     * Resizes the frame and components when the upper-right resize button
     * is pressed.
     * 
     * @param big If the frame is entering big mode.
     */
    private void smallMode(boolean big) {
        Main.GAME_FRAME.setVisible(false);
        
        this.removeAll();
        
        if (big) {
            WEST.setPreferredSize(new Dimension(300, 600));
            SCROLLW.setPreferredSize(new Dimension(290, 555));
            CENTER.setPreferredSize(new Dimension(400, 600));
            DESC.setPreferredSize(new Dimension(390, 350));
            EAST.setPreferredSize(new Dimension(300, 600));
            SCROLLE.setPreferredSize(new Dimension(290, 555));
        }
        else {
            WEST.setPreferredSize(new Dimension(300, 510));
            SCROLLW.setPreferredSize(new Dimension(290, 465));
            CENTER.setPreferredSize(new Dimension(400, 510));
            DESC.setPreferredSize(new Dimension(390, 260));
            EAST.setPreferredSize(new Dimension(300, 510));
            SCROLLE.setPreferredSize(new Dimension(290, 465));
        }
        
        DESC.setFont(new Font("Monospaced", Font.BOLD, big ? 16 : 14));
        
        this.addComponents(big);
        
        Main.GAME_FRAME.pack();
        Main.GAME_FRAME.setVisible(true);
    }
// *****************************************************************************
// </editor-fold> CONFIGURES AND ADDS ALL COMPONENTS
// *****************************************************************************       
    
    
// *****************************************************************************
// <editor-fold defaultstate="collapsed" desc="COLLECTORS">
//    
// These methods collect all text output in the game for the player.
// Each method sets the text of a different GUI component.    
// *****************************************************************************       
    /**
     * Collects all text not collected by the other collectors.
     * Complicated events may send <code>null</code>.
     * @param txt dialog text.
     */
    public static void out(String txt) {
        if (txt != null)
            DIAL.setText(NEWLINE.matcher(txt).replaceAll(" "));
    }
/*----------------------------------------------------------------------------*/    
    /**
     * Collects all room descriptions.
     * @param txt a room description.
     */
    public static void descOut(String txt) {
        DESC.setText(NEWLINE.matcher(txt).replaceAll(" "));
    }
/*----------------------------------------------------------------------------*/    
    /**
     * Collects <code>triggeredEvent</code> return text.
     * For triggered events that move the player, <code>null</code> is sent.
     * @param txt <code>triggeredEvent</code> room text
     */
    public static void roomOut(String txt) {
        if (txt != null)
            ROOM.setText(txt);
    }
/*----------------------------------------------------------------------------*/    
    /**
     * Collects all menu text; text which prompts player for input.
     * @param txt menu text
     */
    public static void menOut(String txt) {
        MEN.setText(txt);
    }
/*----------------------------------------------------------------------------*/    
    /**
     * Displays all <code>toString</code> calls on inventories.
     * @param txt inventory toString method return text.
     * @see Inventory#toString() 
     */
    public static void invOut(String txt) {
        INV.setText(txt);
    }
// *****************************************************************************
// </editor-fold> COLLECT ALL GAME OUTPUT
// *****************************************************************************       
    
    
// *****************************************************************************       
// <editor-fold defaultstate="collapsed" desc="INPUT RELATED">
// *****************************************************************************           
    /**
     * Used for any request of player input.
     * @return Commands input by the player.
     * @see Text_Field_Listener#actionPerformed
     */
    public static String promptOut() {
        synchronized (HOLDER) {
            try {
                HOLDER.wait();
            }
            catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
        return HOLDER.request();
    }
/*----------------------------------------------------------------------------*/
    public static String askChoice(String menu, String pattern) {
        String answer;
        
        menOut(menu);
        
        answer = promptOut();
        
        while (! answer.matches(pattern)) {
            menOut("That's not valid" + menu);
            answer = promptOut();
        }
        return answer;
    }
/*----------------------------------------------------------------------------*/
    /**
     * Holds player input.
     * @see Text_Field_Listener#actionPerformed 
     */
    private static class Input_Holder {
        private String playerInput;
        
        public void recieve(String s) {
            playerInput = s;
        }
        public String request() {
            return playerInput;
        }
    }
/*----------------------------------------------------------------------------*/
    /**
     * The player may reference the last typed existing furniture using 'it' or 'them'.
     * This retrieves the last referenced furniture if one exists.
     * Firsts, filters out previous input resembling phrases.
     * Then searches furniture matching the phrase,
     *      - First tries whole string
     *      - If none exists, tries with first word removed. Might be a verb.
     * @return The last referenced object in the player's location.
     */
    public static String parsePreviousFurniture() {
        FURN_PARSER.clear();

        UNDO.stream()
                .filter(i -> (THREE_PLUS_CHAR_WORD.matcher(i).matches()))
                .forEach(j -> 
        {
            if (Player.getPos().hasFurniture(j)
                 || Player.getPos().hasFurniture(
                        j = FURNITURE_SPACE_P.matcher(j).replaceFirst("")))
            {
                FURN_PARSER.add(j); 
            }
        });
        
        return (FURN_PARSER.size() > 0) ? FURN_PARSER.get(0) : "object with that name";
    }
/*----------------------------------------------------------------------------*/
    /**
     * Prints the main menu of controls.
     */
    public static void toMainMenu() {
        MEN.setText(Menus.MAIN_MENU);
    }
/*----------------------------------------------------------------------------*/
    public static void clearDesc() {
        DESC.setText("");
    }
/*----------------------------------------------------------------------------*/
    public static void clearDialog() {
        DIAL.setText("");
    }
/*----------------------------------------------------------------------------*/
    public static void giveFocus() {
        // Only used by title frame when the game starts.
        INPUT.requestFocus();
        INPUT.setText(" ");
    }
// *****************************************************************************       
// </editor-fold> CLEAR METHODS AND PARSERS   
// *****************************************************************************           
    
    
// *****************************************************************************
// <editor-fold defaultstate="collapsed" desc="LISTENERS">  
// *****************************************************************************
    /**
     * Allows player to go to last keyboard input with arrow keys.
     */
    private class Text_Field_Key_Listener implements KeyListener {
        private boolean pressed = false;
        private int current = 0;
        /*------------------------------------------------------*/
        @Override public void keyReleased(KeyEvent e) {
            pressed = false;
        }
        /*------------------------------------------------------*/
        @Override public void keyPressed(KeyEvent e) {
            if (! pressed) {
                // For playing the key sound
                if (key != 0)
                    AudioPlayer.playEffect(key);
                if (e.getKeyCode() == KeyEvent.VK_ENTER)
                    current = 0;
                
                // For fetching last command or clearing prompt.
                switch(e.getKeyCode()) {
                    case KeyEvent.VK_UP:
                        if (current < UNDO.size())
                            INPUT.setText(UNDO.get(current++));
                        break;
                    case KeyEvent.VK_DOWN:
                        INPUT.setText(" "); 
                        current = 0;
                        break;  
                }   
            }
            pressed = true;
        }
        /*------------------------------------------------------*/
        @Override public void keyTyped(KeyEvent e) {}
    }
/*----------------------------------------------------------------------------*/
    private class Text_Field_Listener implements ActionListener {
        /**
         * Waits for text to entered by the player and stores it, then notifies
         * the game to receive the input.
         * @param event Text entered by the player into the text field.
         */
        @Override public void actionPerformed(ActionEvent event) {
            synchronized (HOLDER) {
                HOLDER.recieve(INPUT.getText().toLowerCase().trim());

                if (UNDO.size() == 10)
                    UNDO.removeLast();
                
                if (HOLDER.request().length() > 1)
                    UNDO.push(HOLDER.request());
                
                INPUT.setText(" ");
                HOLDER.notify();
            }
        } 
    }
/*----------------------------------------------------------------------------*/
    private class Button_Listener implements ActionListener {
        /**
         * Resizes the game panel, toggles the ambience, and changes key sound. 
         * On some monitors, the frame has been to large.
         * @param push A push of a button.
         */
        @Override public void actionPerformed(ActionEvent push) { // Resize
            if (push.getSource().equals(SIZE)) {
                AudioPlayer.playEffect(10);
                big = ! big;
                smallMode(big);
                SIZE.setText(big ? "Small mode" : "Big mode");
            }
            else if (push.getSource().equals(MUTE)) { // Toggles ambience
                AudioPlayer.playEffect(10);
                MUTE.setText(MUTE.getText().equals("Mute") ? "Unmute" : "Mute");
                AudioPlayer.muteTrack();
            }
            else { // Changes key click
                KEYSOUND.offer(KEYSOUND.poll());
                key = KEYSOUND.peek().soundEffectId;
                
                if (key != 0)
                    AudioPlayer.playEffect(key);
            }
        }
    }
/*----------------------------------------------------------------------------*/
    /**
     * Keeps focus on the text field so user doesn't have to set in manually.
     */
    private class GameFocusListener implements FocusListener {
        @Override public void focusGained(FocusEvent e) {
            // Unused
        }

        @Override public void focusLost(FocusEvent e) {
            INPUT.requestFocus();
        }
    }
// *****************************************************************************
// </editor-fold> BUTTON AND TEXT FIELD LISTENERS
// *****************************************************************************   
}
