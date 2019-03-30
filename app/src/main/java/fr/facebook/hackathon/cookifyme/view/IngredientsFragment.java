package fr.facebook.hackathon.cookifyme.view;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import fr.facebook.hackathon.cookifyme.R;


public class IngredientsFragment extends Fragment {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_ingredients, container, false);
        FloatingActionButton addFab = view.findViewById(R.id.add_fab);
        addFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(getContext());
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setView(R.layout.fragment_ingredients_dialog);
                AlertDialog alertDialog = builder.create();
                alertDialog.show();

                ImageButton vegies = alertDialog.findViewById(R.id.fruits_vegetables);
                ImageButton other = alertDialog.findViewById(R.id.other);

                vegies.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

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
