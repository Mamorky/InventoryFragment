package com.example.usuario.inventoryfragment.ui.dependency;

import com.example.usuario.inventoryfragment.data.db.model.Dependency;
import com.example.usuario.inventoryfragment.data.db.repository.DependencyRepository;
import com.example.usuario.inventoryfragment.ui.dependency.presenters.ListDependencyPresenter;

import java.util.List;

/**
 * Created by mamorky on 27/11/17.
 */

public class ListDependencyInteractorImp implements ListDependencyInteractor {

    public ListDependencyInteractor.OnLoadFinishedListerner listener;

    public ListDependencyInteractorImp(ListDependencyPresenter listDependencyPresenter) {
        this.listener = listDependencyPresenter;
    }

    @Override
    public void loadDependency() {
        listener.onSuccess(DependencyRepository.getInstance().getDependencies());
    }

    @Override
    public void showDependencies(List<Dependency> list) {

    }

    @Override
    public void getDependency() {
        DependencyRepository.getInstance().getDependencies();
    }

    @Override
    public void addNewDEpendency(String name, String shortname, String desc) {
        DependencyRepository.getInstance().addDependency(new Dependency(DependencyRepository.getInstance().getLastId()+1,name,shortname,desc));
    }
}
