package com.example.eteach;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.ktx.Firebase;

import java.util.HashMap;

public class CourseActivity extends AppCompatActivity {
    private EditText noteEditText;
    private EditText nameEditText;
    private Button addButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);
        noteEditText = (EditText) findViewById(R.id.editTextText);
        nameEditText = (EditText) findViewById(R.id.editTextText2);
        addButton = (Button) findViewById(R.id.addButton);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String note = noteEditText.getText().toString();
                String name = nameEditText.getText().toString();

                if(note.isEmpty()){
                    noteEditText.setError("must no be empty");
                    return;
                }
                if(name.isEmpty()){
                    nameEditText.setError("must no be empty");
                    return;

                }
                addToDb(note, name);
            }
        });

    }

    private void addToDb(String note, String name) {
        HashMap<String, Object> noteHashmap = new HashMap<>();
        noteHashmap.put("note", note);
        noteHashmap.put("name", name);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference notesRef = database.getReference("notes");
        String key = notesRef.push().getKey();
        noteHashmap.put("key", key);
        notesRef.child(key).setValue(noteHashmap).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                Toast.makeText(CourseActivity.this, "added", Toast.LENGTH_SHORT).show();
                noteEditText.getText().clear();
                nameEditText.getText().clear();

            }
        });
    }
}