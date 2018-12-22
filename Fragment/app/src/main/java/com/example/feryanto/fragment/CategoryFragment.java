package com.example.feryanto.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class CategoryFragment extends Fragment implements View.OnClickListener {

    private Button btndetailcategory;
    public CategoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_category, container, false);
        btndetailcategory = view.findViewById(R.id.btn_detail_category);
        btndetailcategory.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        if (v.getId()== R.id.btn_detail_category){
            DetailCategoryFragment mDetailCategoryFragment = new DetailCategoryFragment();
            Bundle mBundle = new Bundle();
            mBundle.putString(DetailCategoryFragment.EXTRA_NAME,"Lifstyle");
            String description = "Kategori ini akan berisi produk lifestyle";
            mDetailCategoryFragment.setArguments(mBundle);
            mDetailCategoryFragment.setDescription(description);
            FragmentManager mFragmentManager = getFragmentManager();
            FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
            mFragmentTransaction.replace(R.id.frame_container, mDetailCategoryFragment, DetailCategoryFragment.class.getSimpleName());
            mFragmentTransaction.addToBackStack(null);
            mFragmentTransaction.commit();
        }
    }
}
