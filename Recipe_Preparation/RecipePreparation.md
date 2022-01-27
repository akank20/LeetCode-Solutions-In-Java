Write a function that will give you a list of recipes you can prepare with a given list of ingredients.

eg: to prepare Bread, you need Flour and Yeast
Intermediate Ingredient: NONE

```
Bread
Raw Ingredients: Flour and Yeast
Intermediate Ingredient: NONE

Ham and Cheese
Raw Ingredients: Ham, Cheese
Intermediate Ingredient: BREAD

Caprese Salad: Mozzrela, Tomatoes
Intermediate Ingredient: NONE
```

If you have Ham, Cheese, Flour, Yeast - your function should return BREAD and Ham and Cheese. 
Create, write your own data structire, function signature.

```
Input 1: ["Ham", "Cheese", "Flour", "Yeast"]
Output: ["Bread","Ham and Cheese"]
