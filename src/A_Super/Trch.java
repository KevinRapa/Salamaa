package A_Super;

import A_Main.GUI;
import A_Main.Player;

public class Trch extends Furniture {
    protected final Item TORCH;
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Trch() {
        super();
        this.TORCH = new Item("hand torch", "It's a burning piece of wood. Stay it from your beard!");
        this.inv = new Hldr_Inv(TORCH);
        
        this.description = "Sitting in a steel holder is a burning wall torch\n"
                         + "giving off an orange glow.";
        this.searchDialog = "You look in the mounted steel holder.";
        this.actDialog = "You slide the torch out of its holder and take it.";
        this.useDialog = "You slide the torch into the steel holder.";
        
        this.addActKeys("take", "grab", "get");
        this.addNameKeys("(?:wall )?torch(?:es)?", "(?:steel )?holders?");
        this.addUseKeys("hand torch");
    }
/*----------------------------------------------------------------------------*/
    @Override public String interact(String key) {
        String rep = this.actDialog;
        
        if (this.doesThisHaveIt("hand torch")) {
            this.inv.give(TORCH, Player.getInv());
            GUI.invOut("You are carrying:\n" + Player.getInv());
        }
        else
            rep = "The holder is empty you bumbling oaf.";
        
        return rep;
    }
/*----------------------------------------------------------------------------*/  
    @Override public String useEvent(Item item) {
        if (this.doesThisHaveIt("hand torch"))
            return "The holder already bears a torch you bumbling oaf.";
        else
            Player.getInv().give(item, this.inv);
        
        return this.useDialog;
    }
/*----------------------------------------------------------------------------*/
    @Override public String getDescription() {
        if (! this.doesThisHaveIt("hand torch"))
            return "The mounted steel holder is empty.";
            
        return this.description;
    }
/*----------------------------------------------------------------------------*/
    @Override public String getSearchDialog() {
        return this.getDescription();
    }
/*----------------------------------------------------------------------------*/
}