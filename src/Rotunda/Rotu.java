package Rotunda;

import A_Main.AudioPlayer;
import A_Main.GUI;
import A_Main.Id;
import A_Main.Player;
import A_Super.Direction;
import A_Super.Room;
import A_Super.Furniture;
/**
 * This room rotates, only allowing access to two of its adjacent rooms at a time.
 * Room is rotated by four levers in the adjacent rooms or by a wheel in the
 * fountain, that must first be drained.
 * Connects to Foyw, Look, Stud, and Iha1
 * 
 * @see Iron_Hall.Iha1_Lever
 * @see West_Antechamber.Want_Lever
 * @see Iron_Hall.Iha1
 * @see Study.Stud
 * @see Lookout.Look
 * @see West_Antechamber.Want
 * @see Rotunda.Rotu_Fountain
 * @see Rotunda.Rotu_Wheel
 * @author Kevin Rapa
 */
public class Rotu extends Room {
    public static enum State {EAST_WEST, NORTH_SOUTH}
    private State state;
    private final Furniture NDOOR, SDOOR, EDOOR, WDOOR; 
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Rotu(String name, String ID) {
        super(name, ID);
        
        this.NDOOR = new Rotu_Door(Direction.NORTH);
        this.SDOOR = new Rotu_Door(Direction.SOUTH);
        this.EDOOR = new Rotu_Door(Direction.EAST);
        this.WDOOR = new Rotu_Door(Direction.WEST);
        
        this.addFurniture(WDOOR, EDOOR);
        
        this.state = State.EAST_WEST;
    }
//-----------------------------------------------------------------------------
    public void rotate() {
        AudioPlayer.playEffect(18);
        
        if (this.state == State.EAST_WEST) {
            this.addAdjacent(Id.STUD);
            Player.getRoomObj(Id.STUD).addAdjacent(this.ID);
            this.addAdjacent(Id.IHA1); 
            Player.getRoomObj(Id.IHA1).addAdjacent(this.ID);
            this.removeAdjacent(Id.FOYW);
            Player.getRoomObj(Id.FOYW).removeAdjacent(this.ID);
            this.removeAdjacent(Id.LOOK);
            Player.getRoomObj(Id.LOOK).removeAdjacent(this.ID);
            
            this.removeFurniture(EDOOR.getID());
            this.removeFurniture(WDOOR.getID());
            this.addFurniture(NDOOR);
            this.addFurniture(SDOOR);
            this.state = State.NORTH_SOUTH;
        }
        else {
            this.addAdjacent(Id.FOYW);
            Player.getRoomObj(Id.FOYW).addAdjacent(this.ID);
            this.addAdjacent(Id.LOOK); 
            Player.getRoomObj(Id.LOOK).addAdjacent(this.ID);
            this.removeAdjacent(Id.STUD);
            Player.getRoomObj(Id.STUD).removeAdjacent(this.ID);
            this.removeAdjacent(Id.IHA1);
            Player.getRoomObj(Id.IHA1).removeAdjacent(this.ID);
            
            this.removeFurniture(NDOOR.getID());
            this.removeFurniture(SDOOR.getID());
            this.addFurniture(EDOOR);
            this.addFurniture(WDOOR);
            this.state = State.EAST_WEST; 
        }    
    }
//-----------------------------------------------------------------------------        
    public State getState() {
        return this.state;
    }
//-----------------------------------------------------------------------------   
    @Override public String triggeredEvent() {
        if (! Player.hasVisited(ID))
            GUI.out("\"What a foul stench of decay!\" You think to yourself as you enter this domed chamber.");
            
        return NAME;
    }
}
