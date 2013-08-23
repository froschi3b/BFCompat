package flabs.api.betterfurnaces;

/**
 * This can be implemented into items in order for them to be able to be put
 * into the fuel slot of the furnace. It's will not be burned. (Usage example:
 * some kind of block which stores electricity next to the furnace)
 * 
 * @author TheFrogMC
 * 
 */
public interface IElectricFuelItem {
    /**
     * Get's called every tick in the TileEntity.updateEntity(); The index of
     * the electricFuelitem is always 3;
     */
    public void update(IBetterFurnace furnace);
    
    /**
     * Get's called on every Block Update
     */
    public void blockUpdate(IBetterFurnace furnace);
    
    /**
     * <li>return true if it should add 1 item burntime to the furnace and you
     * subtracted the needed energy <li>return false if it shouldn't add 1
     * itemburntime (make sure you don't subtract energy)
     */
    public boolean canSmeltAndTakeEnergy(IBetterFurnace furnace);
    
    /**
     * should return an integer between 0 and the passed value representing how
     * much energy is left, where 0 means that the energy is empty and the
     * passed value means that the energy is full;
     */
    public int getEnergyScaled(IBetterFurnace furnace, int i);
}
