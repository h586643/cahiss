package com.ebookfrenzy.cahiss.activities;

import android.app.Activity;
import android.content.Intent;

import android.graphics.Bitmap;

import android.os.Bundle;

import android.provider.MediaStore;
import android.view.View;

import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import com.ebookfrenzy.cahiss.R;
import com.ebookfrenzy.cahiss.utils.ImageConverter;
import com.ebookfrenzy.cahiss.utils.Person;
import com.ebookfrenzy.cahiss.utils.PersonDAO;
import com.ebookfrenzy.cahiss.utils.PersonDatabase;

public class AddPersonActivity extends AppCompatActivity {

    ImageView imageView;
    EditText name;
    Bitmap bitmapImage;

    PersonDAO personDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_person);

        imageView = findViewById(R.id.imageView);
        name = findViewById(R.id.nameInput);
        bitmapImage = null;

        personDAO = PersonDatabase.getDBInstance(this).personDAO();
    }

    ActivityResultLauncher<Intent> takePictureResultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == Activity.RESULT_OK) {

                        Intent data = result.getData();

                        bitmapImage = (Bitmap) data.getExtras().get("data");
                        imageView.setImageBitmap(bitmapImage);
                    }
                }
            });

    public void takePicture(View view) {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        takePictureResultLauncher.launch(intent);
    }

    public void savePerson(View view) {

        if (name.getText().toString().isEmpty() || bitmapImage == null) {
            Toast.makeText(this,
                    "Mangler brukerdata",
                    Toast.LENGTH_SHORT).show();

        } else {
            Person person = new Person();
            person.setName(name.getText().toString());
            person.setImage(ImageConverter.convertImageToByte(bitmapImage));
            personDAO.insertPerson(person);
            Toast.makeText(
                    this,
                    "Person lagret i databasen",
                    Toast.LENGTH_SHORT).show();
            startActivity(new Intent(AddPersonActivity.this, MainActivity.class));
        }
    }
}
