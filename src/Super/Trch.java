package Super;

import Main.GUI;
import Main.Player;

public class Trch extends Furniture {
    protected boolean hasTorch;
    protected final Item REF;
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Trch(Item trch) {
        super();
        this.REF = trch;
        this.searchable = false;
        this.description = "Sitting in a steel holder is a burning wall torch\n"
                         + "giving off an orange glow.";
        this.searchDialog = "There's plainly nothing of special interest but the\n"
                          + "mounted torch. If you want the torch, just take it!";
        this.interactDialog = "You slide the torch out of its holder and take it.";
        this.useDialog = "You slide the torch into the steel holder.";
        this.hasTorch = true;
        this.addActKeys("take", "grab", "get");
        this.addNameKeys("torch", "wall torch", "holder", "steel holder", "torches", "wall torches", "holders", "steel holders");
        this.addUseKeys("hand torch");
    }
/*----------------------------------------------------------------------------*/
    @Override public String interact(String key) {
        String rep = this.interactDialog;
        
        if (this.hasTorch) {
            this.hasTorch = false;
            Player.getINV().add(REF);
            GUI.invOut("You are carrying:\n" + Player.getINV());
        }
        else
            rep = "The holder is empty you bumbling oaf.";
        
        return rep;
    }
/*----------------------------------------------------------------------------*/  
    @Override public String useEvent(Item item) {
        String rep = this.useDialog;

        if (this.hasTorch)
            rep = "The holder already bears a torch you bumbling oaf.";
        
        else {
            Player.getINV().give(item, this.inv);
            this.hasTorch = true;
        }
       
        return rep;
    }
/*----------------------------------------------------------------------------*/
    @Override public String getDescription() {
        String rep = this.description;
        
        if (! this.hasTorch)
            rep = "The mounted steel holder is empty.";
            
        return rep;
    }
/*----------------------------------------------------------------------------*/
    @Override public String getSearchDialog() {
        String rep = this.searchDialog;
        
        if (! this.hasTorch)
            rep = "The mounted steel holder is empty.";
            
        return rep;
    }
/*----------------------------------------------------------------------------*/
}
