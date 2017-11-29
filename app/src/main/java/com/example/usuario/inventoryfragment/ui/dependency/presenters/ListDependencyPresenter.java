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
    ListDependencyInteractorImp interactor;
    //private static int TYPE_FILTER;
    ;
    public ListDependencyPresenter(ListDependencyContract.View view) {
        this.view = view;
        this.interactor = new ListDependencyInteractorImp(this);
    }

    @Override
    public void onSuccess(List<Dependency> list) {
        interactor.showDependencies(list);
    }

    @Override
    public void loadDependency() {
        interactor.loadDependency();
    }

    @Override
    public void addNewDependency(String name, String shortname, String desc) {
        interactor.addNewDEpendency(name,shortname,desc);
    }
}
