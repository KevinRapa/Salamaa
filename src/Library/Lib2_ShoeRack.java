package Library;

import A_Super.Item;
import A_Super.SearchableFurniture;
        
public class Lib2_ShoeRack extends SearchableFurniture {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Lib2_ShoeRack(Item... items) {
        super(items);
        this.description = "The shoe rack sits next to the fireplace. A few\n"
                         + "pairs of shoes are stored on it.";
        this.searchDialog = "You browse the shoe collection.";
        this.addNameKeys("shoe rack", "rack", "rack of shoes");
    }
/*----------------------------------------------------------------------------*/
    @Override public String getDescription() {
        String rep = this.description;
        
        if (this.inv.size() == 0)
            rep = "The shoe rack sits next to the fireplace. It's empty.";
        
        else if (this.inv.size() == 1) {
            rep = "The shoe rack sits next to the fireplace. A pair of shoes\n"
                + "are stored on it.";
        }       
        return rep;
    }
/*----------------------------------------------------------------------------*/
}