package br.com.rosana.testebrq.contract;

import android.content.Context;

import java.util.List;

import br.com.rosana.testebrq.model.Person;

public class PersonContract {

    public interface Model {
        void getListPerson();
    }

    public interface View {
        Context getContext();

        void showListPerson(List<Person> newListPeople);

        void showError(Throwable t);

        void showProgress(Boolean show);
    }

    public interface Presenter {
        void attachView(View view);

        void detachView();

        void showListPerson(List<Person> personList);

        void showError(Throwable t);

        Context getContext();

        void getListPerson();
    }
}
