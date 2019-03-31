package fr.facebook.hackathon.cookifyme.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import fr.facebook.hackathon.cookifyme.R;
import fr.facebook.hackathon.cookifyme.model.Recipe;

public class RecipeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);

        Recipe recipe = (Recipe) getIntent().getSerializableExtra("recipe");

        TextView ings = findViewById(R.id.recipeIngredients);
        TextView method = findViewById(R.id.recipeMethod);
        TextView name = findViewById(R.id.recipeName);

        ings.setText(recipe.getIngredients().toString());
        method.setText(recipe.getMethod());
        name.setText(recipe.getName());

        ImageView image = findViewById(R.id.recipe_image);
        Picasso.get()
                .load(recipe.getImage())
                .into(image);

        Button btn = findViewById(R.id.cook);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(RecipeActivity.this, "Cooking ...", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(RecipeActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
