package io.droid.fragmenttest;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements
        AFragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        replaceNewFragment("A");
    }

    @Override
    public void onFragmentInteraction(String key) {
        switch (key) {
            case "A":
                replaceNewFragment("B");
                break;
            case "B":
                replaceNewFragment("C");
                break;
            case "C":
                replaceNewFragment("D");
                break;
            case "D":
                replaceNewFragment("E");
                break;
            case "E":
                replaceNewFragment("F");
                break;
            case "F":
                removeFragments();
                replaceNewFragment("G");
                break;
        }
    }

    private void removeFragments() {
        getSupportFragmentManager().popBackStack("F", FragmentManager.POP_BACK_STACK_INCLUSIVE);
        getSupportFragmentManager().popBackStack("E", FragmentManager.POP_BACK_STACK_INCLUSIVE);
        getSupportFragmentManager().popBackStack("D", FragmentManager.POP_BACK_STACK_INCLUSIVE);
    }

    private void replaceNewFragment(String key) {
        getSupportFragmentManager().beginTransaction().addToBackStack(key)
                .replace(android.R.id.content, AFragment.newInstance(key)).commit();
    }
}
