package Tower;

import A_Main.NameConstants;
import A_Super.Item;
/**
 * @author Kevin Rapa
 */
public class Tow_ScptrPhy extends Item {
    // ========================================================================
    public Tow_ScptrPhy(String name) {
        super(name);
        this.type = NameConstants.PHYLACTERY;
        this.description = "It's a glimmering silver scepter holding a large opal\n"
                         + "at the top. The handle resembles a snake wrapped around\n"
                         + "a stick.";
    }
    // ========================================================================
}
