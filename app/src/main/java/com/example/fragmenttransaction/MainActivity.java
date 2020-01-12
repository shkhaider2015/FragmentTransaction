package com.example.fragmenttransaction;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

    Button frag1, frag2, frag3, frag4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    @Override
    public void onClick(View v)
    {
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();

        switch (v.getId())
        {
            case R.id.frag1:
                fragmentTransaction.replace(R.id.frameLayout, new FragmentOne());
                break;
            case R.id.frag2:
                fragmentTransaction.replace(R.id.frameLayout, new FragmentTwo());
                break;
            case R.id.frag3:
                fragmentTransaction.replace(R.id.frameLayout, new FragmentThree());
                break;
            case R.id.frag4:
                fragmentTransaction.replace(R.id.frameLayout, new FragmentFour());
                break;

        }

        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .addToBackStack(String.valueOf(fragmentManager.getBackStackEntryCount()))
                .commit();


    }

    @Override
    public void onBackPressed() {
        if(fragmentManager.getBackStackEntryCount() <= 1)
        {
            finish();
            return;
        }

        super.onBackPressed();
    }

    private void init()
    {
        frag1 = findViewById(R.id.frag1);
        frag2 = findViewById(R.id.frag2);
        frag3 = findViewById(R.id.frag3);
        frag4 = findViewById(R.id.frag4);

        frag1.setOnClickListener(this);
        frag2.setOnClickListener(this);
        frag3.setOnClickListener(this);
        frag4.setOnClickListener(this);
    }
}
