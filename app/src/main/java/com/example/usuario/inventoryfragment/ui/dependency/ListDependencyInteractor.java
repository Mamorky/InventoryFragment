package com.example.usuario.inventoryfragment.ui.dependency;

import com.example.usuario.inventoryfragment.data.db.model.Dependency;

import java.util.List;

/**
 * Created by mamorky on 27/11/17.
 */

public interface ListDependencyInteractor {

    void loadDependency();

    void showDependencies(List<Dependency> list);

    interface OnLoadFinishedListerner{
        void onSuccess(List<Dependency> list);
    }

    public void getDependency();
    void addNewDEpendency(String name,String shortname,String desc);
}
