package br.com.rosana.testebrq.view;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.List;

import br.com.rosana.testebrq.R;
import br.com.rosana.testebrq.model.Person;
import br.com.rosana.testebrq.utils.DateUtil;

import static br.com.rosana.testebrq.utils.ImageUtil.loadImage;

public class PersonRecyclerAdapter extends RecyclerView.Adapter<PersonRecyclerAdapter.ViewHolder> {

    private List<Person> personList;

    PersonRecyclerAdapter(List<Person> repositories) {
        this.personList = repositories;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_recyclerview, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return personList.size();
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Person person = personList.get(position);
        holder.bind(person);
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgImage;
        private TextView txtName;
        private TextView txtbirthday;
        private TextView txtbio;
        private TextView txtid;
        private ProgressBar progressBar;

        ViewHolder(View itemView) {
            super(itemView);
            imgImage = itemView.findViewById(R.id.imageView);
            txtName = itemView.findViewById(R.id.name);
            txtbirthday = itemView.findViewById(R.id.birthday);
            txtbio = itemView.findViewById(R.id.bio);
            txtid = itemView.findViewById(R.id.id);
            progressBar = itemView.findViewById(R.id.progressBar);
        }

        void bind(Person repository) {
            loadImage(repository.getImage(), imgImage, progressBar);
            txtName.setText("Name: " + repository.getName());
            txtbirthday.setText("Birthday: " + DateUtil.formatDate(repository.getBirthday()));
            txtbio.setText("BIO: " + repository.getBio());
            txtid.setText("id: " + repository.getId());
        }
    }

    void update(List<Person> personList) {
        this.personList.clear();
        this.personList.addAll(personList);
        notifyDataSetChanged();
    }
}
