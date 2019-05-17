package com.example.pruebafinalxd;

import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.annotation.NonNull;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    //private TextView mTextMessage;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);

        BottomNavigationView navigation=(BottomNavigationView)findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        //CoordinatorLayout.LayoutParams layoutParams=(CoordinatorLayout.LayoutParams)navigation.getLayoutParams();
        //layoutParams.setBehavior(new BottomNavigationBehavior());
        //se agrega el load
        toolbar.setTitle("Tabla Periodica");
        loadFragment(new tablaPeriodicaFragment() );
    }
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment;
            switch (item.getItemId()) {
                case R.id.info:
                    //mTextMessage.setText(R.string.title_informacion);
                    toolbar.setTitle("Informacion");
                    fragment= new infoFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.tabla:
                    //mTextMessage.setText(R.string.title_tabla);
                    toolbar.setTitle("Tabla Periodica");
                    fragment= new tablaPeriodicaFragment();
                    loadFragment(fragment);
                    return true;
                    
                case R.id.elementos:
                    //mTextMessage.setText(R.string.title_elementos);
                    toolbar.setTitle("Elementos");
                    fragment= new ElementosFragment();
                    loadFragment(fragment);
                    return true;
                    
            }
            return false;
        }
    };



    private void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container,fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

}
