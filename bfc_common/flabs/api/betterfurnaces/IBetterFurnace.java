package flabs.api.betterfurnaces;

import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.Hopper;

public interface IBetterFurnace extends ISidedInventory, Hopper {
    /**
     * Gets the direction the furnace is facing
     */
    public byte getFacing();
    
    /**
     * Gets the Smelting Result, also including the checks for upgrades
     */
    public ItemStack getSmeltingResult(ItemStack input);
    
    /**
     * If the Furnace has the extra Storage Upgrade, this returns true, else
     * false
     */
    public boolean hasExtraStorage();
    
    /**
     * Returns if the Furnace has that upgrade
     */
    public boolean hasUpgrade(Item upgrade);
    
    /**
     * Returns the index of the upgrade, -1 if it doesn't have that upgrade
     */
    public int getUpgradeIndex(Item upgrade);
}
