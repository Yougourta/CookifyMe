package fr.facebook.hackathon.cookifyme.view.adapter;

import android.content.Context;
import android.content.Intent;
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
import fr.facebook.hackathon.cookifyme.model.Recipe;
import fr.facebook.hackathon.cookifyme.view.RecipeActivity;

public class RecipeViewAdapter extends RecyclerView.Adapter<RecipeViewAdapter.RecipeViewHolder>{

    private List<Recipe> recipes;
    private Context context;
    public RecipeViewAdapter(List<Recipe> ingredientList, Context context){
        recipes = ingredientList;
        this.context = context;
    }

    @NonNull
    @Override
    public RecipeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View item = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.recipes_item_layout, parent, false);
        return new RecipeViewHolder(item);
    }

    @Override
    public void onBindViewHolder(@NonNull RecipeViewHolder holder, final int i) {
        holder.name.setText(recipes.get(i).getName());
        Picasso.get()
                .load(recipes.get(i).getImage())
                .resize(150, 150)
                .centerCrop()
                .into(holder.image);
        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, RecipeActivity.class);
                intent.putExtra("recipe", recipes.get(i));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return recipes.size();
    }

    public static class RecipeViewHolder extends RecyclerView.ViewHolder {

        private ImageView image;
        private TextView name;

        public RecipeViewHolder(View view) {
            super(view);
            image = view.findViewById(R.id.recipe_row_image);
            name = view.findViewById(R.id.recipe_row_name);
        }

    }
}
