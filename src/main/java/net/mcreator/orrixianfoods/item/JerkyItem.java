
package net.mcreator.orrixianfoods.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.item.UseAction;
import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.Food;
import net.minecraft.entity.LivingEntity;

import net.mcreator.orrixianfoods.procedures.JerkyFoodEatenProcedure;
import net.mcreator.orrixianfoods.OrrixianfoodsModElements;

import java.util.Map;
import java.util.HashMap;

@OrrixianfoodsModElements.ModElement.Tag
public class JerkyItem extends OrrixianfoodsModElements.ModElement {
	@ObjectHolder("orrixianfoods:jerky")
	public static final Item block = null;
	public JerkyItem(OrrixianfoodsModElements instance) {
		super(instance, 7);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}
	public static class FoodItemCustom extends Item {
		public FoodItemCustom() {
			super(new Item.Properties().group(ItemGroup.FOOD).maxStackSize(64).rarity(Rarity.COMMON)
					.food((new Food.Builder()).hunger(5).saturation(0.6f).setAlwaysEdible().meat().build()));
			setRegistryName("jerky");
		}

		@Override
		public UseAction getUseAction(ItemStack itemstack) {
			return UseAction.EAT;
		}

		@Override
		public ItemStack onItemUseFinish(ItemStack itemstack, World world, LivingEntity entity) {
			ItemStack retval = super.onItemUseFinish(itemstack, world, entity);
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				JerkyFoodEatenProcedure.executeProcedure($_dependencies);
			}
			return retval;
		}
	}
}
