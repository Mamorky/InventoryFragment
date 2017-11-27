package com.example.usuario.inventoryfragment.ui.dependency.presenters;

import com.example.usuario.inventoryfragment.data.db.model.Dependency;
import com.example.usuario.inventoryfragment.ui.dependency.ListDependencyInteractor;
import com.example.usuario.inventoryfragment.ui.dependency.ListDependencyInteractorImp;
import com.example.usuario.inventoryfragment.ui.dependency.contracts.ListDependencyContract;

import java.util.List;

/**
 * Created by usuario on 23/11/17.
 */

public class ListDependencyPresenter implements ListDependencyContract.Presenter,
        ListDependencyInteractor.OnLoadFinishedListerner{
    ListDependencyContract.View view;
    //private static int TYPE_FILTER;

    private ListDependencyInteractor listDependencyInteractor;
    public ListDependencyPresenter(ListDependencyContract.View view) {
        this.view = view;
        this.listDependencyInteractor = new ListDependencyInteractorImp(this);
    }

    @Override
    public void onSuccess() {
        listDependencyInteractor.loadDependency();
    }

    @Override
    public void loadDependency() {
        listDependencyInteractor.getDependency();
    }
}
