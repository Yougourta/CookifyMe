package fr.facebook.hackathon.cookifyme.view.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import fr.facebook.hackathon.cookifyme.R;
import fr.facebook.hackathon.cookifyme.model.Ingredient;

public class IngredientViewAdapter extends RecyclerView.Adapter<IngredientViewAdapter.IngredientViewHolder>{

    private List<Ingredient> ingredients;

    public IngredientViewAdapter(List<Ingredient> ingredientList){
        ingredients = ingredientList;
    }

    @NonNull
    @Override
    public IngredientViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View item = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.ingredient_item_layout, parent, false);
        return new IngredientViewHolder(item);
    }

    @Override
    public void onBindViewHolder(@NonNull IngredientViewHolder holder, int i) {
        holder.name.setText(ingredients.get(i).getName());
        Picasso.get()
                .load(ingredients.get(i).getImage())
                .resize(150, 150)
                .centerCrop()
                .into(holder.image);
    }

    @Override
    public int getItemCount() {
        return ingredients.size();
    }

    public static class IngredientViewHolder extends RecyclerView.ViewHolder {

        private ImageView image;
        private TextView name;

        public IngredientViewHolder(View view) {
            super(view);
            image = view.findViewById(R.id.ingredient_row_image);
            name = view.findViewById(R.id.ingredient_row_name);
        }

    }
}
