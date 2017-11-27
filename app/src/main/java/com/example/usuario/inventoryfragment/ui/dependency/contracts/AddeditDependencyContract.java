package com.example.usuario.inventoryfragment.ui.dependency.contracts;

import com.example.usuario.inventoryfragment.data.db.model.Dependency;

/**
 * Created by usuario on 23/11/17.
 */

public interface AddeditDependencyContract {

    interface View {
        void setPresenter(AddeditDependencyContract.Presenter  presenter);
        void setOnEmptyName();
        void setOnShortNameError();
        void setOnEmptyDescription();
        void onSuccess();
    }


    interface Presenter {
        boolean validateDependency(String name,String shortname,String description);
        void addDependency(String nameDep,String shortNameDep,String descriptionDep);
        void onDestroy();

    }

    interface Interactor{
        boolean validateDependency(String name, String shortname, String description, onValidateFinish onValidateFinish);
        void addDependency(String nameDep,String shortNameDep,String descriptionDep);
        interface onValidateFinish{
             void onEmptyName();
             void onErrorShortName();
             void onEmptyDescription();
             void onSuccess();
        }
    }
}
