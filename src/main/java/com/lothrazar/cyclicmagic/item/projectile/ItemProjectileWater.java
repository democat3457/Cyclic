package com.lothrazar.cyclicmagic.item.projectile;
import java.util.List;
import com.lothrazar.cyclicmagic.IHasRecipe;
import com.lothrazar.cyclicmagic.entity.projectile.EntityThrowableDispensable;
import com.lothrazar.cyclicmagic.entity.projectile.EntityWaterBolt;
import com.lothrazar.cyclicmagic.util.UtilChat;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemProjectileWater extends BaseItemProjectile implements IHasRecipe {
  public EntityThrowableDispensable getThrownEntity(World world, double x, double y, double z) {
    return new EntityWaterBolt(world, x, y, z);
  }
  @Override
  public void addRecipe() {
    GameRegistry.addShapelessRecipe(new ItemStack(this, 8), new ItemStack(Items.WATER_BUCKET), Blocks.ICE,new ItemStack(Items.PAPER), new ItemStack(Items.STRING));  }
  @Override
  void onItemThrow(ItemStack held, World world, EntityPlayer player, EnumHand hand) {
    this.doThrow(world, player, hand, new EntityWaterBolt(world, player));
  }
  @SideOnly(Side.CLIENT)
  public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
    tooltip.add(UtilChat.lang("item.ender_water.tooltip"));
  }
}
