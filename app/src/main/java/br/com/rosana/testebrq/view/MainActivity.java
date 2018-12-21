package br.com.rosana.testebrq.view;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.com.rosana.testebrq.R;
import br.com.rosana.testebrq.contract.PersonContract;
import br.com.rosana.testebrq.model.Person;
import br.com.rosana.testebrq.presenter.PersonPresenter;


public class MainActivity extends AppCompatActivity implements PersonContract.View {

    private PersonRecyclerAdapter adapter;
    private List<Person> newListPeople = new ArrayList<>();
    private RecyclerView recyclerView;
    private SwipeRefreshLayout swipeRefreshLayout;
    private ProgressBar progress;
    private PersonContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new PersonPresenter();
        presenter.attachView(this);

        initViews();

        setRecyclerView();

        presenter.getListPerson();
    }

    private void initViews() {
        recyclerView = findViewById(R.id.recyclerview);
        swipeRefreshLayout = findViewById(R.id.swipeRefreshLayout);
        progress = findViewById(R.id.progress);
    }

    private void setRecyclerView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new PersonRecyclerAdapter(newListPeople);
        recyclerView.setAdapter(adapter);
        swipeRefreshLayout.setOnRefreshListener(() -> presenter.getListPerson());
    }

    @Override
    public void showProgress(Boolean show) {
        if (show) {
            progress.setVisibility(View.VISIBLE);
        } else {
            progress.setVisibility(View.GONE);
        }
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void showListPerson(List<Person> newListPeople) {
        adapter.update(newListPeople);
        swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void showError(Throwable t) {
        Toast.makeText(this, t.getMessage(), Toast.LENGTH_SHORT).show();
        swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }
}