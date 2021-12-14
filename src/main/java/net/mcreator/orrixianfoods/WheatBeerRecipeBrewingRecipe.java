
package net.mcreator.orrixianfoods;

import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.common.brewing.IBrewingRecipe;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;

import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;

import net.mcreator.orrixianfoods.item.WoodSteinItem;
import net.mcreator.orrixianfoods.item.WheatBeerItem;

@OrrixianfoodsModElements.ModElement.Tag
public class WheatBeerRecipeBrewingRecipe extends OrrixianfoodsModElements.ModElement {
	public WheatBeerRecipeBrewingRecipe(OrrixianfoodsModElements instance) {
		super(instance, 9);
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
		BrewingRecipeRegistry.addRecipe(new CustomBrewingRecipe());
	}
	public static class CustomBrewingRecipe implements IBrewingRecipe {
		@Override
		public boolean isInput(ItemStack input) {
			return input.getItem() == WoodSteinItem.block;
		}

		@Override
		public boolean isIngredient(ItemStack ingredient) {
			return ingredient.getItem() == Items.WHEAT;
		}

		@Override
		public ItemStack getOutput(ItemStack input, ItemStack ingredient) {
			if (isInput(input) && isIngredient(ingredient)) {
				return new ItemStack(WheatBeerItem.block);
			}
			return ItemStack.EMPTY;
		}
	}
}
