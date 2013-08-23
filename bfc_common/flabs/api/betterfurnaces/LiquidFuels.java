package flabs.api.betterfurnaces;

import java.util.ArrayList;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

/**
 * How to create your own LiquidFuel: <li>LiquidFuel.fuels.add(new
 * LiquidFuel(liquid,totalburntime,upgradeitem)); <li>totalburntime is the
 * number of items per bucket * 200 (lava has 20000, which is 100 items per
 * bucket)
 */
public class LiquidFuels {
    /**
     * Add your LiquidFuel here, the upgrade is already registered
     */
    public static ArrayList<LiquidFuels> fuels = new ArrayList<LiquidFuels>();
    public static ArrayList<Item> upgrades = new ArrayList<Item>();
    
    public static LiquidFuels getFuelForLiquid(FluidStack liquid) {
        if (liquid == null) {
            return null;
        }
        if (liquid.fluidID <= 0) {
            return null;
        }
        
        for (LiquidFuels fuel : fuels) {
            if (fuel.liquid.isFluidEqual(liquid)) {
                return fuel;
            }
        }
        
        return null;
    }
    
    public final FluidStack liquid;
    public final Item upgrade;
    public final int totalBurningTime;
    
    public LiquidFuels(Fluid f, int totalBurningTime, Item upgrade) {
        this(new FluidStack(f, FluidContainerRegistry.BUCKET_VOLUME), totalBurningTime, upgrade);
    }
    
    /**
     * You still have to add it to the fuels List
     */
    public LiquidFuels(FluidStack liquid, int totalBurningTime, Item upgrade) {
        this.liquid = liquid;
        this.upgrade = upgrade;
        this.totalBurningTime = totalBurningTime;
        if (!upgrades.contains(upgrade)) {
            upgrades.add(upgrade);
        }
    }
    
    @Override
    public String toString() {
        return FluidRegistry.getFluidName(this.liquid) + " for " + ((this.totalBurningTime) / 20000F) + " items/mB with " + this.upgrade.getItemDisplayName(new ItemStack(this.upgrade));
    }
}
