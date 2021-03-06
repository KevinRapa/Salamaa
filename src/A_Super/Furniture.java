package A_Super;

import A_Main.GUI;
import A_Main.Inventory;
import A_Main.Names;
import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.regex.Pattern;

/**
 * Furniture is ANY object that can be examined, interacted with, and searched.
 * Furniture may also be interacted with in the Inventory USE sub-prompt
 * </p> <p>
 * SearchableFurniture (a sub-class) have inventories. Items may be traded between
 * searchable furniture and the player during a search.
 * </p> <p>
 * Furniture is referenced by the player by entering a string matching a string
 * in <code>NAMEKEYS</code>, which is generally a regex pattern.
 * </p> <p>
 * Any method in furniture that sends text through <code>GUI.out</code> or
 * <code>GUI.roomOut</code> can return an empty string which will be ignored.
 * </p>
 * 
 * @see A_Main.Player#searchPrompt(A_Super.Furniture) 
 * @see A_Main.Player#usePrompt() 
 * @author Kevin Rapa
 */
abstract public class Furniture implements Serializable {
    private static int count = 0; // Used as a unique ID for this 
    
    // Here only to avoid having to cast to SearchableFurniture every time.
    protected Inventory inv;      
    protected boolean searchable; // If items can be traded with this 
    
    protected final int ID; // Used to access furniture from Room references.
    
    protected String 
            description,   // Printed when inspected.
            searchDialog,  // Printed when searched.
            actDialog,     // Printed when interacted with.  
            useDialog;     // Printed when an item is used on this.
    
    protected final ArrayList<Pattern> 
            USEKEYS,    // Valid items that may be used on this.
            ACTKEYS,    // Valid actions that may be performed on this.
            NAMEKEYS;   // Valid names of this. Regular expression.

    protected static final String 
            HOLDPATTERN = "grab|hold|touch",
            CLIMBPATTERN = "climb|scale|ascend|descend",
            GETPATTERN = "get|take|acquire|grab|scoop",      
            SITPATTERN = "sit|relax|lay|use|sleep",
            JOSTLEPATTERN = "kick|hit|jostle|nudge|bump|knock|bang",
            VALVEPATTERN = "turn|rotate|spin|twist|open|close",
            MOVEPATTERN = "move|slide|displace|push|pull|spin|rotate",
            FEELPATTERN = "feel|touch|poke",
            DEFAULT_USE = "An interesting but far-fetched proposition.",
            NOTHING_HERE = "There's nothing hiding here.",
            ANYTHING = ".+",
            NOTHING = ""; // Returning NOTHING will be ignored by GUI
    
    
    /*
     * A set of all verbs that the game accepts. If the player enters in just a
     * verb, the game will prompt the player for more information.
     */
    public static final HashSet<String> ALL_ACTION_KEYS = new HashSet<>();
    
    static {
        try(ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(new File(Names.W_DIR, "data" + Names.SEP + "verbs.data")))) 
        {
            for (String s : (String[])ois.readObject())
                ALL_ACTION_KEYS.add(s);
                
        } catch (IOException | ClassNotFoundException ex) {
            System.err.println(ex.getMessage() + " Could not finds verbs to add.");
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    //-------------------------------------------------------------------------
    /**
     * Constructor for furniture.
     * Many attributes are overwritten in furniture sub-classes.
     */
    public Furniture () {
        this.searchable = false;
        this.inv = null;
        this.ID = count++;
        
        this.NAMEKEYS = new ArrayList<>(5); 
        this.USEKEYS = new ArrayList<>(5);  
        this.ACTKEYS = new ArrayList<>(6);  
        
        this.description = NOTHING;
        this.actDialog = DEFAULT_USE;
        this.useDialog = DEFAULT_USE;
        this.searchDialog = NOTHING_HERE;
    }
    //-------------------------------------------------------------------------     
    /**
     * Used to check if this piece contains a certain item.
     * Removes titles from books.
     * @param name The name of an item.
     * @return If this piece contains an item with the name.
     */
    public boolean containsItem(String name) {
        if (this.inv == null)
            return false;
        
        for (Item i : this.inv)
            if (i.toString().equals(name)) 
                return true; 
        
        return false;
    }
//******************************************************************************
// <editor-fold desc="GETTERS">
//******************************************************************************   
    public String getDescription() {
        return this.description; 
    }
    //-------------------------------------------------------------------------  
    public String getSearchDialog() {
        return this.searchDialog; 
    }
    //-------------------------------------------------------------------------  
    public int getID() {
        return this.ID;
    }
    //-------------------------------------------------------------------------
    public boolean isSearchable() {
        // Item's can be traded with searchable furniture.
        return this.searchable;
    }
    //-------------------------------------------------------------------------     
    public Inventory getInv() {
        if (this.inv == null) {
            // To be safe. This shouldn't be called if this isn't searchable.
            GUI.out("Hm... that furniture shouldn't be searchable.");
            return new Inventory();
        }
        
        return this.inv;
    }
    //-------------------------------------------------------------------------     
    @Override public String toString() {
        return this.NAMEKEYS.get(0).toString();
    }
//******************************************************************************        
// </editor-fold>
//******************************************************************************

    
//******************************************************************************
// <editor-fold desc="ACTIVATING AND INTERACTING">
//****************************************************************************** 
    /**
     * Invoked when the player interacts with this piece using a correct action.
     * The map reference may be used in overwritten version of this method.
     * @param key The name of an action.
     * @return A string that prints when this piece is interacted with.
     */
    public String interact(String key) {              
        return this.actDialog;
    }
    //-------------------------------------------------------------------------     
    /**
     * This method is invoked when an item is used on this piece.
     * @param item The object reference to the item used on this.
     * @return String that prints when the item is used on this.
     */
    public String useEvent(Item item) {
        return this.useDialog;
    }
    //-------------------------------------------------------------------------     
    public boolean actKeyMatches(String verb) {
        return this.ACTKEYS.stream()
                .anyMatch(i -> i.matcher(verb).matches());
    }    
    //-------------------------------------------------------------------------     
    public boolean useKeyMatches(String itemName) {
        return this.USEKEYS.stream()
                .anyMatch(i -> i.matcher(itemName).matches());
    }
    //------------------------------------------------------------------------- 
    /**
     * Checks if any pattern in this furniture's list matches the string.
     * If a match is found, moves it to the front of the list, assuming the
     * same pattern will be used again in the future.
     * @param furnName A string the player typed.
     * @return If a matching pattern is found.
     */
    public boolean nameKeyMatches(String furnName) {
        for (int i = 0; i < NAMEKEYS.size(); i++) {
            Pattern p = NAMEKEYS.get(i);
            
            if (p.matcher(furnName).matches()) {
                if (i > 0) {
                    NAMEKEYS.set(i, NAMEKEYS.get(0));
                    NAMEKEYS.set(0, p);
                }
                return true;
            }
        }
        
        return false;
    }
    //------------------------------------------------------------------------- 
    /**
     * Adds a list of use keys to this furniture.
     * @param keys A list of use keys.
     */
    public final void addUseKeys(String ... keys) {
        for (String key : keys)
            this.USEKEYS.add(Pattern.compile(key));
        
        this.USEKEYS.trimToSize();
    }
    //-------------------------------------------------------------------------     
    /**
     * Adds a list of name keys to this furniture.
     * @param keys A list of name keys.
     */
    public final void addNameKeys(String ... keys) {
        for (String key : keys)
            this.NAMEKEYS.add(Pattern.compile(key));
        
        this.NAMEKEYS.trimToSize();
    }
    //-------------------------------------------------------------------------     
    /**
     * Adds a list of action keys to this furniture.
     * @param keys A list of action keys.
     */
    public final void addActKeys(String ... keys) {
        for (String key : keys) {
            this.ACTKEYS.add(Pattern.compile(key));
        }
        
        this.ACTKEYS.trimToSize();
    }
//******************************************************************************        
// </editor-fold>
//******************************************************************************
}
