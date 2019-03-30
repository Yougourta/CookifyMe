package fr.facebook.hackathon.cookifyme.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import fr.facebook.hackathon.cookifyme.R;


public class IngredientsFragment extends Fragment {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ingredients, container, false);
        /*ListView ingredientsList = (ListView) findViewById(R.id.ingredientsList);

        List<Ingredient> ingredients = new ArrayList<>();

        Ingredient apple = new Ingredient("Apple", Category.FRUIT, 3);
        Ingredient orange = new Ingredient("Orange", Category.FRUIT, 2);
        Ingredient kale = new Ingredient("Kale", Category.VEGETABLE, 1);

        ingredients.add(apple);
        ingredients.add(orange);
        ingredients.add(kale);

        ArrayAdapter adapter = new ArrayAdapter(this, R.layout.ingredient_item_layout, (List) ingredients);
        ingredientsList.setAdapter(adapter);*/
    }
}
