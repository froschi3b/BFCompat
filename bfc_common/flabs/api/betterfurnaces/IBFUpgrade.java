package flabs.api.betterfurnaces;

import net.minecraft.item.ItemStack;

/**
 * This can be implemented into items in order for them to be able to be put
 * into the upgrade Slots of the Furnace
 * 
 * @author TheFrogMC
 * 
 */
public interface IBFUpgrade {
    
    /**
     * Returns true if the furnace can smelt an item, i.e. has a source item,
     * destination stack isn't full, etc.
     * 
     * @param furnace
     *            - has 9 slots: 0&1=burnable slots, 2&3 are fuel items, 4&5 are
     *            results, 6&7&8 are upgrades
     * @param furnace
     *            - cast it to an TileEntity to use TileEntity methods;
     * @return true if you don't use this
     */
    public boolean canSmelt(IBetterFurnace furnace);
    
    /**
     * Returns true if this upgrade changes the color of the extreme furnace;
     */
    public boolean changesColor();
    
    /**
     * If changesColor == true then this method will be called to get the Color
     * of the extreme furnace
     */
    public int getColor(ItemStack upgrade);
    
    /**
     * This will be called once, when determining the fuelValue of an Item (Also
     * Upgrade gets Damaged here)
     * 
     * @param index
     *            - the index of the upgrade in the furnace
     * @return additional Fuel which gets Added, 0 if not used
     */
    public int getFuelValue(int index, IBetterFurnace furnace, int fuelValue);
    
    /**
     * Get's the Smelting Result for the furnace
     * 
     * @return null if not used;
     */
    public ItemStack getSmeltingResult(ItemStack input, IBetterFurnace furnace);
    
    /**
     * Get's Called just before the item smelts
     */
    public void onSmelting(IBetterFurnace furnace, ItemStack output, int index);
    
    /**
     * Get's Called just after the item smelts
     */
    public void afterSmelting(IBetterFurnace furnace, ItemStack output, int index);
    
    /**
     * Get's called every tick in the TileEntity.updateEntity();
     */
    public void updateTick(IBetterFurnace furnace, int index);
    
    /**
     * Get's called on every Block Update
     */
    public void blockUpdate(IBetterFurnace furnace, int index);
    
}
