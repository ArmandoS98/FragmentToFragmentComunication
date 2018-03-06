package com.example.user.fragmenttofragmentcomunication.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.user.fragmenttofragmentcomunication.Interface.IMainActivity;
import com.example.user.fragmenttofragmentcomunication.R;

/**
 * Created by user on 05/03/2018.
 */

public class CFragment extends Fragment {

    private static final String TAG = "CFragment";

    //widgets
    private TextView mDisplayMessage;

    //vars
    private IMainActivity mIMainActivity;
    private String mIncomingMessage = "";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mIMainActivity.setToolbarTitle(getTag());

        Bundle bundle = this.getArguments();
        if (bundle !=  null){
            mIncomingMessage = bundle.getString(getString(R.string.intent_message));
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_c, container, false);
        mDisplayMessage = view.findViewById(R.id.incoming_message);

        setIncomingMessage();

        return view;
    }

    private void setIncomingMessage(){
        if (!mIncomingMessage.equals("")){
            mDisplayMessage.setText(mIncomingMessage);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mIMainActivity = (IMainActivity) getActivity();
    }
}
