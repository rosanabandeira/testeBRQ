package br.com.rosana.testebrq.model;

import android.content.res.AssetManager;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import br.com.rosana.testebrq.contract.PersonContract;


public class PersonModel implements PersonContract.Model {

    private PersonContract.Presenter presenter;

    public PersonModel(PersonContract.Presenter presenter) {
        this.presenter = presenter;
    }


    @Override
    public void getListPerson() {
        try {
            AssetManager assetManager = presenter.getContext().getAssets();
            InputStream newJson;
            newJson = assetManager.open( "JsonTeste.json" );

            Gson gson = new Gson();

            BufferedReader bufferedReader = new BufferedReader( new InputStreamReader( newJson ) );
            PersonResponse response = gson.fromJson( bufferedReader, PersonResponse.class );
            List<Person> list = new ArrayList<>();

            for (Person person : response.getPeople()) {
                if (!list.contains( person )) {
                    list.add( person );
                }
            }

            presenter.showListPerson( list );

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}