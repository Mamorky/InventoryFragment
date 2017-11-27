package com.example.usuario.inventoryfragment.ui.dependency;

import com.example.usuario.inventoryfragment.data.db.model.Dependency;
import com.example.usuario.inventoryfragment.data.db.repository.DependencyRepository;

import java.util.List;

/**
 * Created by mamorky on 27/11/17.
 */

public interface ListDependencyInteractor {

    public ListDependencyInteractor.OnLoadFinishedListerner listener;

    interface OnLoadFinishedListerner{
        void onSuccess();
        void loadDependency();
    }

    public void getDependency();
}
