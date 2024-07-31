package apps.alquran.activty;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import apps.alquran.R;
import apps.alquran.fragment.BerandaFragment;
import apps.alquran.fragment.HistoryFragment;
import apps.alquran.fragment.MenuAlQuranFragment;
import apps.alquran.utils.Preferences;
import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity {

    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull android.view.MenuItem item) {
                Fragment selectedFragment = null;
                if (item.getItemId() == R.id.menu_beranda) {
                    selectedFragment = new BerandaFragment();
                } else if (item.getItemId() == R.id.menu_al_quran) {
                    selectedFragment = new MenuAlQuranFragment();
                    String[] lastOpenedSurah = Preferences.getLastOpenedSurah(getApplicationContext());
                    if (lastOpenedSurah[0] != null && lastOpenedSurah[1] != null) {
                        Bundle bundle = new Bundle();
                        bundle.putString("nomor", lastOpenedSurah[0]);
                        bundle.putString("name", lastOpenedSurah[1]);
                        selectedFragment.setArguments(bundle);
                    }
                } else if (item.getItemId() == R.id.history) {
                    selectedFragment = new HistoryFragment();
                }
                if (selectedFragment != null) {
                    fragmentManager.beginTransaction()
                            .replace(R.id.fragment_container, selectedFragment)
                            .commit();
                }
                return true;
            }
        });

        // Load default fragment
        if (savedInstanceState == null) {
            bottomNavigationView.setSelectedItemId(R.id.menu_beranda);
        }
    }
}
