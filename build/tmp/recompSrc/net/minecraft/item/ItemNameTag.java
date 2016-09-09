package net.minecraft.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;

public class ItemNameTag extends Item
{
    private static final String __OBFID = "CL_00000052";

    public ItemNameTag()
    {
        this.setCreativeTab(CreativeTabs.tabTools);
    }

    /**
     * Returns true if the item can be used on the given entity, e.g. shears on sheep.
     *  
     * @param stack the item stack of the item being used
     * @param player the player who used the item
     * @param target the target we hit with the item in hand
     */
    public boolean itemInteractionForEntity(ItemStack stack, EntityPlayer player, EntityLivingBase target)
    {
        if (!stack.hasDisplayName())
        {
            return false;
        }
        else if (target instanceof EntityLiving)
        {
            EntityLiving entityliving = (EntityLiving)target;
            entityliving.setCustomNameTag(stack.getDisplayName());
            entityliving.enablePersistence();
            --stack.stackSize;
            return true;
        }
        else
        {
            return super.itemInteractionForEntity(stack, player, target);
        }
    }
}