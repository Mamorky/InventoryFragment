package com.example.usuario.inventoryfragment.ui.dependency;

import com.example.usuario.inventoryfragment.data.db.model.Dependency;
import com.example.usuario.inventoryfragment.data.db.repository.DependencyRepository;
import com.example.usuario.inventoryfragment.ui.dependency.contracts.AddeditDependencyContract;

import java.util.ArrayList;

/**
 * Created by usuario on 24/11/17.
 */

public class AddeditDependecyInteractor implements AddeditDependencyContract.Interactor {

    @Override
    public boolean validateDependency(String name, String shortname, String description, onValidateFinish onValidateFinish) {
        if(name.isEmpty()){
            onValidateFinish.onEmptyName();
            return false;
        }
        else if(description.isEmpty()){
            onValidateFinish.onEmptyDescription();
            return false;
        }
        else if(shortname.isEmpty() || shortname.length() >= 10){
            onValidateFinish.onErrorShortName();
            return false;
        }
        else if(!DependencyRepository.getInstance().validate(name,shortname)){
            onValidateFinish.onErrorShortName();
            return false;
        }
        else {
            DependencyRepository.getInstance().addDependency(new Dependency(6,name,shortname,description));
            onValidateFinish.onSuccess();
            return true;
        }
    }

    @Override
    public void addDependency(String nameDep, String shortNameDep, String descriptionDep) {
        DependencyRepository.getInstance().addDependency(new Dependency(DependencyRepository.getInstance().getLastId()+1,nameDep,shortNameDep,descriptionDep));
    }

    @Override
    public void changeDependency(String shortNameDep, String DescriptionDep) {

        ArrayList<Dependency> dependencies = DependencyRepository.getInstance().getDependencies();

        for (int i = 0; i < dependencies.size(); i++) {
            if(dependencies.get(i).getShortname().equals(shortNameDep)){
                dependencies.get(i).setDescription(DescriptionDep);
            }
        }
    }
}
