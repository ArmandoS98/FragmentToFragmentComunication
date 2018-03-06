package com.example.user.fragmenttofragmentcomunication;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.user.fragmenttofragmentcomunication.Fragments.AFragment;
import com.example.user.fragmenttofragmentcomunication.Fragments.BFragment;
import com.example.user.fragmenttofragmentcomunication.Fragments.CFragment;
import com.example.user.fragmenttofragmentcomunication.Fragments.SelectorFragment;
import com.example.user.fragmenttofragmentcomunication.Interface.IMainActivity;

public class MainActivity extends AppCompatActivity implements IMainActivity {

    private static final String TAG = "MainActivity";

    //widgets
    private TextView mToolbarTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToolbarTitle = findViewById(R.id.toolbar_title);

        init();
    }

    private void init(){
        SelectorFragment fragment = new SelectorFragment();
        doFragmentTransaction(fragment, getString(R.string.fragment_selector),false,"");
    }

    private void doFragmentTransaction(Fragment fragment, String tag, boolean addToBackStack, String message){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        if (!message.equals("")){
            Bundle bundle = new Bundle();
            bundle.putString(getString(R.string.intent_message), message);
            fragment.setArguments(bundle);
        }

        transaction.replace(R.id.main_container,fragment,tag);

        if (addToBackStack){
            transaction.addToBackStack(tag);
        }
        transaction.commit();
    }

    @Override
    public void setToolbarTitle(String fragmentTag) {
        mToolbarTitle.setText(fragmentTag);
    }

    @Override
    public void inflateFragment(String fragmentTag, String message) {
        if (fragmentTag.equals(getString(R.string.fragment_a))){
            AFragment fragment = new AFragment();
            doFragmentTransaction(fragment,fragmentTag,true, message);
        } else if (fragmentTag.equals(getString(R.string.fragment_b))){
            BFragment fragment = new BFragment();
            doFragmentTransaction(fragment,fragmentTag,true, message);
        } else if (fragmentTag.equals(getString(R.string.fragment_c))){
            CFragment fragment = new CFragment();
            doFragmentTransaction(fragment,fragmentTag,true, message);
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        mToolbarTitle.setText(getString(R.string.fragment_selector));
    }
}
