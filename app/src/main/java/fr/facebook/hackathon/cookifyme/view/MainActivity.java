package fr.facebook.hackathon.cookifyme.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import fr.facebook.hackathon.cookifyme.R;

public class MainActivity extends AppCompatActivity {

    private final FragmentManager fm = getSupportFragmentManager();
    private final Fragment ingredientsFm = new IngredientsFragment();
    private final Fragment recepiesFm = new RecepiesFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        BottomNavigationView navigation = findViewById(R.id.btn_recruiter);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        fm.beginTransaction().add(R.id.main_frame, ingredientsFm).show(ingredientsFm).commit();

    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            int itemId = item.getItemId();
            switch (itemId) {
                case R.id.navigation_one:
                    fm.beginTransaction().replace(R.id.main_frame, ingredientsFm).commit();
                    return true;
                case R.id.navigation_two:
                    fm.beginTransaction().replace(R.id.main_frame, recepiesFm).commit();
                    return true;
                case R.id.navigation_three:
                    return true;
                default:
                    break;
            }
            return false;
        }
    };
}
