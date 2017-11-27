package com.example.usuario.inventoryfragment.ui.dependency;


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.usuario.inventoryfragment.R;
import com.example.usuario.inventoryfragment.ui.dependency.contracts.AddeditDependencyContract;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddeditDependencyFragment extends Fragment implements AddeditDependencyContract.View {
    public static final String TAG = "addeditdependency";
    private AddeditDependencyContract.Presenter presenter;
    FloatingActionButton fab;
    TextInputLayout tilname,tilshortname,tildescription;
    EditText edtname,edtShortName,edtDesc;
    AddeditDependencyListener callback;

    interface  AddeditDependencyListener{
        void goBack();
    }


    public static AddeditDependencyFragment newInstance(Bundle bundle) {
        AddeditDependencyFragment addeditDependencyFragment = new AddeditDependencyFragment();

        if (bundle != null)
            addeditDependencyFragment.setArguments(bundle);

        return addeditDependencyFragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_addedit_dependency, container, false);
        fab = (FloatingActionButton) root.findViewById(R.id.fab_dependencyAdd);
        edtname = (EditText) root.findViewById(R.id.edt_dependency_name);
        edtShortName = (EditText) root.findViewById(R.id.edt_dependency_sortname);
        edtDesc = (EditText) root.findViewById(R.id.edt_description);
        tilname = (TextInputLayout) root.findViewById(R.id.til_dependency_name);

        edtname.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                tilname.setError(null);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        tilshortname = (TextInputLayout) root.findViewById(R.id.til_dependency_sortname);
        tildescription = (TextInputLayout) root.findViewById(R.id.til_dependency_description);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(presenter.validateDependency(tilname.getEditText().getText().toString(),tilshortname.getEditText().getText().toString(),tildescription.getEditText().getText().toString()))
                    presenter.addDependency(edtname.getText().toString(),edtShortName.getText().toString(),edtShortName.getText().toString());
            }
        });
        if (getArguments() != null) {

        }

        return root;
    }


    @Override
    public void setPresenter(AddeditDependencyContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void setOnEmptyName() {
        tilname.setError("Nombre vacio");
    }

    @Override
    public void setOnShortNameError() {
        tilshortname.setError("Nombre corto erroneo");
    }

    @Override
    public void setOnEmptyDescription() {
        tildescription.setError("Descripcion vacia");
    }

    @Override
    public void onSuccess() {
        callback.goBack();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        presenter.onDestroy();
    }
}
