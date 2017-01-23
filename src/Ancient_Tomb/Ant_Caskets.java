package Ancient_Tomb;

import A_Super.Furniture;
import A_Super.Openable;
/**
 * @author Kevin Rapa
 */
public class Ant_Caskets extends Furniture implements Openable {
    // ========================================================================
    public Ant_Caskets() {
        super();
        
        this.description = "The various ramshackle coffins are pieced together\n"
                         + "with many nailed-together wooden planks.";
        this.searchDialog = "You are being watched... best not to do that.";

        this.addNameKeys("caskets", "wooden caskets");
    }
    // ========================================================================  
}

