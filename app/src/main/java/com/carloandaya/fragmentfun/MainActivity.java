package com.carloandaya.fragmentfun;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity
        implements ButtonsFragment.OnFragmentInteractionListener, TextFragment.OnTextFragmentInteractionListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (findViewById(R.id.container) != null) {

            if (savedInstanceState != null) {
                return;
            }

//            Fragment buttonsFragment = ButtonsFragment.newInstance("Hello", "Everyone");
            ButtonsFragment buttonsFragment = new ButtonsFragment();
            FragmentManager fm = getFragmentManager();
            fm.beginTransaction()
                    .add(R.id.container, buttonsFragment)
                    .commit();
        }

    }

    @Override
    public void onBackPressed() {
        FragmentManager fm = getFragmentManager();
        if(fm.getBackStackEntryCount() != 0) {
            fm.popBackStack();
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public void onFragmentInteraction() {
        Log.v("MainActivity", "Button pressed in ButtonsFragment");
        FragmentManager fm = getFragmentManager();
        Fragment textFragment = new TextFragment();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.container, textFragment);
        ft.addToBackStack(null);
        ft.commit();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
