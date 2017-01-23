package Study;

import A_Super.Item;
import A_Super.SearchableFurniture;
        
public class Stud_BookCase extends SearchableFurniture {

/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Stud_BookCase(Item... items) {
        super(items);
        this.description = "It's a small square bookcase with a stone head\n"
                         + "sculpture on top.";
        this.searchDialog = "You peruse its shelves.";
        this.addNameKeys("(?:small )?(?:square )?(?:bookcase|bookshelf|shelf)", "books", "(?:stone )?(?:head )?sculpture");
    }
/*----------------------------------------------------------------------------*/
}
