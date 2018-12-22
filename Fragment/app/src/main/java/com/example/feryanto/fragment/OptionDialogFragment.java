package com.example.feryanto.fragment;


import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.sql.BatchUpdateException;


/**
 * A simple {@link Fragment} subclass.
 */
public class OptionDialogFragment extends DialogFragment implements View.OnClickListener {

    private Button btnchoose, btnclose;
    private RadioGroup rgoption;
    private RadioButton rbsaf, rbmou, rblvg, rbmoyes;
    private OnOptionDialogListener onOptionDialogListener;

    public OptionDialogFragment() {
        // Required empty public constructor
    }

    public OnOptionDialogListener getOnOptionDialogListener() {
        return onOptionDialogListener;
    }
    public void setOnOptionDialogListener(OnOptionDialogListener onOptionDialogListener) {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_option_dialog, container, false);
        btnclose = (Button)view.findViewById(R.id.btn_close);
        btnchoose = (Button)view.findViewById(R.id.btn_choose);
        rbsaf = (RadioButton)view.findViewById(R.id.rb_saf);
        rbmou = (RadioButton)view.findViewById(R.id.rb_mou);
        rblvg = (RadioButton)view.findViewById(R.id.rb_lvg);
        rbmoyes = (RadioButton)view.findViewById(R.id.rb_moyes);
        rgoption = (RadioGroup)view.findViewById(R.id.rg_options);
        return view;

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_close:
                getDialog().cancel();
                break;
            case R.id.btn_choose:
                int checkedRadioButtonId = rgoption.getCheckedRadioButtonId();
                if (checkedRadioButtonId != -1){
                    String coach = null;
                    switch (checkedRadioButtonId){
                        case R.id.rb_saf:
                            coach = rbsaf.getText().toString().trim();
                            break;
                        case R.id.rb_mou:
                            coach = rbmou.getText().toString().trim();
                            break;
                        case R.id.rb_lvg:
                            coach = rblvg.getText().toString().trim();
                            break;
                        case R.id.rb_moyes:
                            coach = rbmoyes.getText().toString().trim();
                            break;
                    }
                    getOnOptionDialogListener().onOptionChoosen(coach);
                    getDialog().cancel();
                }
                break;
        }
    }
    
    public interface OnOptionDialogListener {
        void onOptionChoosen(String text);
    }
}
