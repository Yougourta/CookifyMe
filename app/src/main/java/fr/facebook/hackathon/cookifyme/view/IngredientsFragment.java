package fr.facebook.hackathon.cookifyme.view;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.List;

import fr.facebook.hackathon.cookifyme.R;
import fr.facebook.hackathon.cookifyme.model.Ingredient;
import fr.facebook.hackathon.cookifyme.view.adapter.IngredientViewAdapter;


public class IngredientsFragment extends Fragment {

    private RecyclerView recycler;
    public static IngredientViewAdapter adapter;
    public static List<Ingredient> ingredients = new ArrayList();

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ingredients, container, false);

        adapter = new IngredientViewAdapter(ingredients);
        recycler = view.findViewById(R.id.list_ingredients);
        recycler.setAdapter(adapter);
        recycler.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        recycler.setLayoutManager(llm);

        FloatingActionButton addFab = view.findViewById(R.id.add_fab);
        addFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(getContext());
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setView(R.layout.fragment_ingredients_dialog);
                final AlertDialog alertDialog = builder.create();
                alertDialog.show();

                ImageButton vegies = alertDialog.findViewById(R.id.fruits_vegetables);
                ImageButton other = alertDialog.findViewById(R.id.other);

                vegies.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        final Dialog dialog2 = new Dialog(getContext());
                        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                        builder.setView(R.layout.fragment_ingredients_manual_dialog);
                        final AlertDialog alertDialog2 = builder.create();
                        alertDialog2.show();
                        final EditText name = alertDialog2.findViewById(R.id.name_edit_text);
                        final EditText qte = alertDialog2.findViewById(R.id.quantity_edit_text);

                        Button add = alertDialog2.findViewById(R.id.addIng);
                        add.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Ingredient ingredient = new Ingredient();
                                ingredient.setName(name.getText().toString());
                                ingredient.setImage("https://farm8.staticflickr.com/7814/40537754913_519d5d54d3_z.jpg");
                                IngredientsFragment.ingredients.add(ingredient);
                                IngredientsFragment.adapter.notifyDataSetChanged();
                                alertDialog2.cancel();
                                alertDialog.cancel();
                            }
                        });
                    }
                });

                other.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(getContext(), BarcodeScannerActivity.class);
                        startActivity(intent);
                    }
                });
            }
        });
        return view;
    }
}
