package fr.facebook.hackathon.cookifyme.api;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import fr.facebook.hackathon.cookifyme.model.Ingredient;
import fr.facebook.hackathon.cookifyme.view.IngredientsFragment;
import fr.facebook.hackathon.cookifyme.view.MainActivity;

public class BarcodeLookupApi {
    private static BarcodeLookupApi api;
    private Context context;

    public static BarcodeLookupApi getApi(Context context){
        if (api==null)
            api = new BarcodeLookupApi(context);
        return api;
    }

    private BarcodeLookupApi(Context context) { this.context = context; }

    public void requestIngredient(String barcode){
        RequestQueue queue = Volley.newRequestQueue(context);
        final String url = "https://api.barcodelookup.com/v2/products?barcode="+barcode+"&key=ud5fravplg7q1t8754li29s0931f6h";
        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                JsonParser parser = new JsonParser();
                JsonArray resultsJsonObject = parser.parse(s).getAsJsonObject().get("products").getAsJsonArray();
                JsonObject jsonObject = resultsJsonObject.get(0).getAsJsonObject();
                Ingredient ingredient = new Ingredient();

                ingredient.setName(jsonObject.get("product_name").getAsString());
                ingredient.setImage(jsonObject.get("images").getAsJsonArray().get(0).getAsString());

                IngredientsFragment.ingredients.add(ingredient);
                IngredientsFragment.adapter.notifyDataSetChanged();

                Intent intent = new Intent(context, MainActivity.class);
                context.startActivity(intent);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Log.d("Error", volleyError.getMessage());
            }
        });
        queue.add(request);
    }
}
