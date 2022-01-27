package googlepractise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class RecipePreparation {
	
	public static void main(String[] args) {
		List<String> rawIngredients1 = new ArrayList<String>(Arrays.asList("Ham", "Cheese"));
		List<String> rawIngredients2 = new ArrayList<String>(Arrays.asList("Flour", "Yeast"));
		List<String> rawIngredients3 = new ArrayList<String>(Arrays.asList("Mozzrela", "Tomatoes"));
		Recipe bread = addRecipe(rawIngredients2, "Bread", new ArrayList<>());
		List<Recipe> intermediateRecipes1 = new ArrayList<Recipe>();
		intermediateRecipes1.add(bread);
		addRecipe(rawIngredients1, "Ham and Cheese", intermediateRecipes1);
		addRecipe(rawIngredients3, "Caprese Salad", new ArrayList<>());
		List<String> givenRawIngredients = new ArrayList<String>(Arrays.asList("Ham", "Cheese", "Flour", "Yeast"));
		List<Recipe> recipes = getRecipes(givenRawIngredients);
		for (Recipe recipe : recipes)
			System.out.println(recipe.name);
	}

	private static HashMap<Recipe, List<Recipe>> recipeMap = new HashMap<>();
	private static HashMap<Recipe, Integer> indegreeMap = new HashMap<>();

	public static Recipe addRecipe(List<String> rawIngredients, String name, List<Recipe> intermediateRecipes) {
		Recipe recipe = new Recipe(name, rawIngredients);
		recipeMap.put(recipe, new ArrayList<>());
		indegreeMap.put(recipe, 0);
		for (Recipe intermediateRecipe : intermediateRecipes) {
			// Time: O(d) where d= number of dependencies
			List<Recipe> adjRecipes = recipeMap.get(intermediateRecipe);
			adjRecipes.add(recipe);
			indegreeMap.put(recipe, indegreeMap.get(recipe) + 1);
		}
		return recipe;
	}

	public static List<Recipe> getRecipes(List<String> rawIngredients) {
		HashSet<String> ingredientSet = new HashSet<>(rawIngredients);
		Queue<Recipe> queue = new LinkedList<>();
		for (Map.Entry<Recipe, Integer> e : indegreeMap.entrySet()) {
			// Time: O(r*l) where r= number of recipes, l= number of raw ingredients
			Recipe recipe = e.getKey();
			List<String> rawIngredientsReqd = recipe.rawIngredients;
			if (indegreeMap.get(recipe) == 0 && areAllIngredientsPresent(rawIngredientsReqd, ingredientSet)) {
				// if all raw ingredients are found & no intermediate ingredient is required, we
				// can make this recipe
				queue.add(recipe);
			}
		}
		List<Recipe> result = new ArrayList<>();
		while (!queue.isEmpty()) {
			// Time: O(r+d) where r= number of recipes, d= number of dependencies
			Recipe recipe = queue.poll();
			result.add(recipe);
			for (Recipe adjRecipe : recipeMap.get(recipe)) {
				indegreeMap.put(adjRecipe, indegreeMap.get(adjRecipe) - 1);
				List<String> rawIngredientsReqd = adjRecipe.rawIngredients;
				if (indegreeMap.get(adjRecipe) == 0 && areAllIngredientsPresent(rawIngredientsReqd, ingredientSet)) {
					// if all raw ingredients are found & no intermediate ingredient is required, we
					// can make this recipe
					queue.add(adjRecipe);
				}
			}
		}
		return result;
	}

	private static boolean areAllIngredientsPresent(List<String> rawIngredientsReqd, HashSet<String> ingredientSet) {
		boolean foundAllIngredients = true;
		for (String ingredient : rawIngredientsReqd) {
			if (!ingredientSet.contains(ingredient)) {
				foundAllIngredients = false;
				break;
			}
		}
		return foundAllIngredients;
	}

	private static class Recipe {
		String name;
		List<String> rawIngredients;

		public Recipe(String name, List<String> rawIngredients) {
			this.name = name;
			this.rawIngredients = rawIngredients;
		}
	}
}
