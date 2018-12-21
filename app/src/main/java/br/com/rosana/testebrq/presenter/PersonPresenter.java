package br.com.rosana.testebrq.presenter;

import android.content.Context;

import java.util.List;

import br.com.rosana.testebrq.contract.PersonContract;
import br.com.rosana.testebrq.model.Person;
import br.com.rosana.testebrq.model.PersonModel;

public class PersonPresenter implements PersonContract.Presenter {

    private PersonContract.View view;
    private PersonContract.Model model;

    @Override
    public void attachView(PersonContract.View view) {
        this.view = view;
        this.model = new PersonModel(this);
    }

    @Override
    public void detachView() {
        this.view = null;
        this.model = null;
    }

    @Override
    public void getListPerson() {
        view.showProgress(true);
        model.getListPerson();
    }

    @Override
    public void showListPerson(List<Person> personList) {
        view.showProgress(false);
        view.showListPerson(personList);
    }

    @Override
    public void showError(Throwable t) {
        view.showProgress(false);
        view.showError(t);
    }

    @Override
    public Context getContext() {
        return view.getContext();
    }

    public void tairo(){

    }
}
