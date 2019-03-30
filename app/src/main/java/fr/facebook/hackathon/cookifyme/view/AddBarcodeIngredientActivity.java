package fr.facebook.hackathon.cookifyme.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import fr.facebook.hackathon.cookifyme.R;
import fr.facebook.hackathon.cookifyme.model.Ingredient;

public class AddBarcodeIngredientActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_barcode_ingredient);

        Ingredient ingredient = (Ingredient) getIntent().getSerializableExtra("ingredient");

        TextView brand = findViewById(R.id.brand);
        brand.setText(ingredient.getName());
        TextView category = findViewById(R.id.category);
        category.setText(ingredient.getCategory());

        Button add = findViewById(R.id.add_ingredient);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
