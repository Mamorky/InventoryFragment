package com.example.usuario.inventoryfragment.ui.dependency.presenters;

import com.example.usuario.inventoryfragment.ui.dependency.AddeditDependecyInteractor;
import com.example.usuario.inventoryfragment.ui.dependency.contracts.AddeditDependencyContract;

/**
 * Created by usuario on 23/11/17.
 */

public class AddeditDependencyPresenter implements AddeditDependencyContract.Presenter, AddeditDependencyContract.Interactor.onValidateFinish {
    private AddeditDependencyContract.View view;
    private AddeditDependecyInteractor interactor;


    public AddeditDependencyPresenter (AddeditDependencyContract.View view) {
        this.view = view;
        interactor = new AddeditDependecyInteractor();
    }


    @Override
    public boolean validateDependency(String name, String shortname, String description) {
        return interactor.validateDependency(name,shortname,description,this);
    }

    @Override
    public void addDependency(String nameDep, String shortNameDep, String descriptionDep) {
    }

    @Override
    public void onDestroy() {
        view = null;
        interactor = null;
    }

    @Override
    public void onEmptyName() {
        view.setOnEmptyName();
    }

    @Override
    public void onErrorShortName() {
        view.setOnShortNameError();
    }

    @Override
    public void onEmptyDescription() {
        view.setOnEmptyDescription();
    }

    @Override
    public void onSuccess() {

    }

}
