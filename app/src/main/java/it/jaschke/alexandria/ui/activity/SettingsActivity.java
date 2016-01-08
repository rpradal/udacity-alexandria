package it.jaschke.alexandria.ui.activity;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import it.jaschke.alexandria.R;
import it.jaschke.alexandria.ui.fragment.SettingsFragment;

/**
 * Created by saj on 27/01/15.
 */
public class SettingsActivity extends ActionBarActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new SettingsFragment())
                    .commit();
        }
    }
}
