package Ransacked_Quarters;

import A_Super.SearchableFurniture;
        
public class Rqua_Table extends SearchableFurniture {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Rqua_Table () {
        super();

        this.description = "The plain wood end table lies on its side.";
        this.searchDialog = "Nothing here. It's a bad place to hide something,\n"
                          + "as someone has already searched it.";
        this.addNameKeys("(?:plain )?(?:wood(?:en)? )?(?:end )?table");
    }
/*----------------------------------------------------------------------------*/
}