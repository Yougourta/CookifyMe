package fr.facebook.hackathon.cookifyme.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import fr.facebook.hackathon.cookifyme.R;
import fr.facebook.hackathon.cookifyme.model.Recipe;
import fr.facebook.hackathon.cookifyme.view.adapter.RecipeViewAdapter;

public class RecepiesFragment extends Fragment {

    public RecepiesFragment() { }

    private RecyclerView recycler;
    public static RecipeViewAdapter adapter;
    public static List<Recipe> allRecipes = new ArrayList();
    public static List<Recipe> canDoRecipes = new ArrayList();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        allRecipes.clear();
        canDoRecipes.clear();

        Recipe recipe = new Recipe();
        recipe.setImage("https://www.goodfood.com.au/content/dam/images/2/r/i/0/4/image.related.articleLeadwide.620x349.2ri2a.png/1376978156587.jpg");
        recipe.setName("Scrambled eggs");
        String method="1. Crack the eggs into a bowl, add the milk or cream and season with sea salt. Whisk gently with a fork until well combined.\n\n" +
                "2. Melt half the butter in a small saucepan or frying pan over low heat. Add the egg mixture and stir constantly using a wooden spoon. Do not turn up the heat, scrambling must be done slowly and gently. When most of the egg has set, add the remaining butter and remove the pan from the heat. There should be enough heat left in the pan to finish cooking the eggs and melt the butter. Scrambled eggs should be creamy, not dry or rubbery. Serve immediately on toast, they will not sit even for a minute.";
        recipe.setMethod(method);
        ArrayList<String> ings = new ArrayList();
        ings.add("eggs");ings.add("butter");
        recipe.setIngredients(ings);
        allRecipes.add(recipe);

        Recipe recipe2 = new Recipe();
        recipe2.setImage("https://www.bbcgoodfood.com/sites/default/files/recipe-collections/collection-image/2013/05/spaghetti-bolognese_2.jpg");
        recipe2.setName("Spaghetti Bolognese");
        String method2 ="1. Heat a drizzle of olive oil in a large non-stick frying pan and crumble in the mince and sausagemeat. Spend a good 30 mins cooking the mince – it will release lots of liquid, which you want to evaporate, and then eventually it will end up sizzling in its own fat. If the pan becomes too dry, drizzle in a little more olive oil. Towards the end, continue stirring the mince until it becomes speckled with crisp brown bits.\n\n" +
                "2. Heat oven to 140C/120C fan/gas 2. While the mince is browning, heat a drizzle more oil in a casserole dish and sizzle the pancetta for 5 mins until it starts to brown and release its fat, then throw in the vegetables and herbs, and finely crumble over the dried porcini. Cook gently for 5 mins until soft and starting to brown. Sprinkle over the sugar, then stir in the tomato purée and splash in the fish sauce and vinegar. Simmer down until gloopy, then stir through the meat and pour in the milk and tomatoes. Rinse out the tomato tins with the wine and stir into the pan. Season, then nestle in the parmesan rind. Bring to a simmer, then cover and cook in the oven for 3 hrs.\n\n"+
                "3. When cooked, tip as many portions of Bolognese as you need into a sauté pan. Cook the pasta until very al dente, then tong into the pan with a bit of the water and finish cooking with the sauce for 2 mins. Stir through the parmesan and a drizzle more olive oil. Twirl the pasta and Bolognese into bowls, scatter with basil and serve with more parmesan."
                ;
        recipe2.setMethod(method2);
        ArrayList<String> ings2 = new ArrayList();
        ings2.add("pasta");ings2.add("Tomato Sauce");
        recipe2.setIngredients(ings2);
        allRecipes.add(recipe2);

        for (int i=0; i<allRecipes.size(); i++){
            int cpt=0;
            for (int k=0; k<IngredientsFragment.ingredients.size(); k++){
                for (int j=0; j<allRecipes.get(i).getIngredients().size(); j++){
                    if (IngredientsFragment.ingredients.get(k).getName().toLowerCase().contains(allRecipes.get(i).getIngredients().get(j).toLowerCase())){
                        cpt++;
                    }
                }
            }
            if (cpt == allRecipes.get(i).getIngredients().size())
                canDoRecipes.add(allRecipes.get(i));
        }

        View view = inflater.inflate(R.layout.fragment_recepies, container, false);
        adapter = new RecipeViewAdapter(canDoRecipes, getContext());
        recycler = view.findViewById(R.id.list_recipes);
        recycler.setAdapter(adapter);
        recycler.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        recycler.setLayoutManager(llm);

        return view;
    }

}
