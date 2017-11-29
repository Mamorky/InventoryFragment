package com.example.usuario.inventoryfragment.ui.dependency;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.example.usuario.inventoryfragment.R;
import com.example.usuario.inventoryfragment.adapters.DependencyAdapter;
import com.example.usuario.inventoryfragment.data.db.model.Dependency;
import com.example.usuario.inventoryfragment.ui.dependency.contracts.ListDependencyContract;
import com.example.usuario.inventoryfragment.ui.dependency.presenters.ListDependencyPresenter;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListDependencyFragment extends ListFragment implements ListDependencyContract.View {
    public static final String TAG = "listdependency";
    private ListDependencyContract.Presenter mListPresenter;
    private ListDependencyListener mCallback;
    private DependencyAdapter adapter;
    private ListDependencyPresenter presenter;
    private FloatingActionButton fabAdd;

    @Override
    public void showDependencies(List<Dependency> list) {
        adapter.clear();
        adapter.addAll(list);
    }


    interface ListDependencyListener {
        void addNewDependency(Bundle bundle);
    }


    public static ListDependencyFragment newInstance(Bundle bundle) {
        ListDependencyFragment listDependencyFragment = new ListDependencyFragment();

        if (bundle != null)
            listDependencyFragment.setArguments(bundle);

        return listDependencyFragment;
    }

    public ListDependencyFragment(){

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.adapter = new DependencyAdapter(getActivity());
        setRetainInstance(true);
    }
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        try {
            mCallback = (ListDependencyListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(getActivity().getLocalClassName() + " must implements ListDepedencyListener");
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_list_dependency, container, false);

        fabAdd = (FloatingActionButton) root.findViewById(R.id.fab_dependencyAdd);
        fabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCallback.addNewDependency(null);
            }
        });

        presenter = new ListDependencyPresenter(this);
        presenter.loadDependency();

        return root;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setListAdapter(adapter);
        getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Bundle bundle = new Bundle();
                bundle.putParcelable(Dependency.TAG,(Dependency)parent.getItemAtPosition(position));
                mCallback.addNewDependency(bundle);
            }
        });
    }


    @Override
    public void setPresenter(ListDependencyContract.Presenter presenter) {
        mListPresenter = presenter;
    }
}
