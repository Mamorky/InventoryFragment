package com.example.usuario.inventoryfragment.ui.dependency;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;

import com.example.usuario.inventoryfragment.R;
import com.example.usuario.inventoryfragment.ui.base.BaseActivity;
import com.example.usuario.inventoryfragment.ui.dependency.presenters.AddeditDependencyPresenter;
import com.example.usuario.inventoryfragment.ui.dependency.presenters.ListDependencyPresenter;

/**
 * Activity que muestra un listado de objetos Dependency.
 */
public class DependencyActivity extends BaseActivity implements ListDependencyFragment.ListDependencyListener, AddeditDependencyFragment.AddeditDependencyListener {
    private ListDependencyFragment mListDependency;
    private ListDependencyPresenter mListPresenter;
    private AddeditDependencyFragment mAddeditDependency;
    private AddeditDependencyPresenter mAddeditPresenter;
    private Fragment mDetailFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dependency);

        mListDependency = (ListDependencyFragment) getSupportFragmentManager().findFragmentByTag(ListDependencyFragment.TAG);

        if (mListDependency == null) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            mListDependency = ListDependencyFragment.newInstance(null);
            transaction.add(android.R.id.content, mListDependency, ListDependencyFragment.TAG).commit();
        }

        mListPresenter = new ListDependencyPresenter(mListDependency);
        mListDependency.setPresenter(mListPresenter);
    }


    @Override
    public void addNewDependency() {
        mAddeditDependency = (AddeditDependencyFragment) getSupportFragmentManager().
                findFragmentByTag(AddeditDependencyFragment.TAG);

        if (mAddeditDependency == null) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            mAddeditDependency = AddeditDependencyFragment.newInstance(null);
            transaction.addToBackStack(null);
            transaction.replace(android.R.id.content, mAddeditDependency, AddeditDependencyFragment.TAG).commit();
        }

        mAddeditPresenter = new AddeditDependencyPresenter(mAddeditDependency);
        mAddeditDependency.setPresenter(mAddeditPresenter);
    }

    @Override
    public void goBack() {
        mListDependency = (ListDependencyFragment) getSupportFragmentManager().findFragmentByTag(ListDependencyFragment.TAG);

        if (mListDependency == null) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            mListDependency = ListDependencyFragment.newInstance(null);
            transaction.replace(android.R.id.content, mListDependency, ListDependencyFragment.TAG).commit();
        }
        mAddeditPresenter = new AddeditDependencyPresenter(mAddeditDependency);

        mListDependency.setPresenter(mListPresenter);
    }

    @Override
    public void addNewDependency(Bundle bundle) {
        mAddeditDependency = (AddeditDependencyFragment) getSupportFragmentManager().
                findFragmentByTag(AddeditDependencyFragment.TAG);

        if (mAddeditDependency == null) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            mAddeditDependency = AddeditDependencyFragment.newInstance(null);
            transaction.addToBackStack(null);
            transaction.replace(android.R.id.content, mAddeditDependency, AddeditDependencyFragment.TAG).commit();
        }

        mAddeditPresenter = new AddeditDependencyPresenter(mAddeditDependency);
        mAddeditDependency.setPresenter(mAddeditPresenter);
    }
}
