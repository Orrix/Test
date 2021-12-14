
package net.mcreator.orrixianfoods.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.UseAction;
import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.Food;

import net.mcreator.orrixianfoods.OrrixianfoodsModElements;

@OrrixianfoodsModElements.ModElement.Tag
public class TomatoItem extends OrrixianfoodsModElements.ModElement {
	@ObjectHolder("orrixianfoods:tomato")
	public static final Item block = null;
	public TomatoItem(OrrixianfoodsModElements instance) {
		super(instance, 13);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}
	public static class FoodItemCustom extends Item {
		public FoodItemCustom() {
			super(new Item.Properties().group(ItemGroup.FOOD).maxStackSize(64).rarity(Rarity.COMMON)
					.food((new Food.Builder()).hunger(1).saturation(0.2f).setAlwaysEdible().build()));
			setRegistryName("tomato");
		}

		@Override
		public UseAction getUseAction(ItemStack itemstack) {
			return UseAction.EAT;
		}
	}
}
