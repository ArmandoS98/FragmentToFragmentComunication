package com.example.user.fragmenttofragmentcomunication.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.user.fragmenttofragmentcomunication.Interface.IMainActivity;
import com.example.user.fragmenttofragmentcomunication.R;

/**
 * Created by user on 05/03/2018.
 */

public class SelectorFragment extends Fragment implements View.OnClickListener {

    private static final String TAG = "SelectorFragment";

    //wiggets
    private Button btnFragmentA;
    private Button btnFragmentB;
    private Button btnFragmentC;
    private EditText mMessage;

    //vars
    private IMainActivity mIMainActivity;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mIMainActivity.setToolbarTitle(getTag());
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_selector, container,false);

        mMessage = view.findViewById(R.id.message);
        btnFragmentA = view.findViewById(R.id.btn_fragment_a);
        btnFragmentB = view.findViewById(R.id.btn_fragment_b);
        btnFragmentC = view.findViewById(R.id.btn_fragment_c);

        btnFragmentA.setOnClickListener(this);
        btnFragmentB.setOnClickListener(this);
        btnFragmentC.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        String message = mMessage.getText().toString();

        switch (v.getId()){
            case R.id.btn_fragment_a:{
                mIMainActivity.inflateFragment(getString(R.string.fragment_a),message);
                break;
            }

            case R.id.btn_fragment_b:{
                mIMainActivity.inflateFragment(getString(R.string.fragment_b),message);
                break;
            }

            case R.id.btn_fragment_c:{
                mIMainActivity.inflateFragment(getString(R.string.fragment_c),message);
                break;
            }
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mIMainActivity = (IMainActivity) getActivity();
    }

}
