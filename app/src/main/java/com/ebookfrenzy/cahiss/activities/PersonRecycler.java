package com.ebookfrenzy.cahiss.activities;

import android.app.Activity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.RoomDatabase;

import com.ebookfrenzy.cahiss.R;

import com.ebookfrenzy.cahiss.utils.ImageConverter;
import com.ebookfrenzy.cahiss.utils.Person;
import com.ebookfrenzy.cahiss.utils.PersonDAO;
import com.ebookfrenzy.cahiss.utils.PersonDatabase;

import java.util.List;

public class PersonRecycler extends RecyclerView.Adapter<PersonView> {

    List<Person> personList;
    private PersonDAO database;
    private Activity context;

    public PersonRecycler(List<Person> persons, Activity context) {
        personList = persons;
        this.context = context;
    }

    @NonNull
    @Override
    public PersonView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CardView view = (CardView) LayoutInflater.from(parent.getContext()).inflate(
                R.layout.activity_person_view,
                parent,
                false
        );
        return new PersonView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonView holder, int position) {
        Person person = personList.get(position);
        database = PersonDatabase.getDBInstance(context).personDAO();

        if (person.getImage() != null) {
            holder.imageView.setImageBitmap(ImageConverter.convertByteArrayToImage(person.getImage()));
        }

        if (person.getName() != null) {
            holder.name.setText(person.getName());
        }

        holder.delete.setOnClickListener(view -> {
            database.deletePerson(person);
            // slettet i Liten
            personList.remove(position);
            this.notifyDataSetChanged();

            Toast.makeText(context, "Slettet", Toast.LENGTH_SHORT).show();
            // context.finish();
            // context.startActivity(context.getIntent());
        });
    }

    @Override
    public int getItemCount() {
        // return database.getAllPersons().size();
        return personList.size();
    }
}
