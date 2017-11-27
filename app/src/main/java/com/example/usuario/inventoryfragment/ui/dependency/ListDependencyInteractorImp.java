package com.example.usuario.inventoryfragment.ui.dependency;

import com.example.usuario.inventoryfragment.data.db.repository.DependencyRepository;
import com.example.usuario.inventoryfragment.ui.dependency.ListDependencyInteractor;
import com.example.usuario.inventoryfragment.ui.dependency.presenters.ListDependencyPresenter;

/**
 * Created by mamorky on 27/11/17.
 */

public class ListDependencyInteractorImp implements ListDependencyInteractor {

    public ListDependencyInteractor.OnLoadFinishedListerner listener;

    public ListDependencyInteractorImp(ListDependencyPresenter listDependencyPresenter) {
        this.listener = listDependencyPresenter;
    }

    interface OnLoadFinishedListerner{
        void onSuccess();
    }

    @Override
    public void getDependency() {
        DependencyRepository.getInstance().getDependencies();
    }
}
