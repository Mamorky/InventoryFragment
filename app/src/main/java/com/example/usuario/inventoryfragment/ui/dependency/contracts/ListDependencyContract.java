package com.example.usuario.inventoryfragment.ui.dependency.contracts;

import com.example.usuario.inventoryfragment.data.db.model.Dependency;

import java.util.List;

/**
 * Created by usuario on 23/11/17.
 */

public interface ListDependencyContract {

    interface View {
        void showDependencies(List<Dependency> list);

        void setPresenter(Presenter presenter);
    }


    interface Presenter {
        void loadDependency();
        void addNewDependency(String name,String shortname,String desc);
    }
}
