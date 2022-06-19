package com.example.basiccode;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Result extends AppCompatActivity {

    //DB 연동
    FirebaseDatabase database;
    DatabaseReference reference;

    TextView ocr;
    TextView textname;
    TextView textefficacy;
    TextView texttaking;

    ArrayList<FirebasePost> firebasePosts=new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Intent intent=getIntent();
        String result=intent.getStringExtra("text");

        textname=findViewById(R.id.textView);
        textefficacy=findViewById(R.id.efficacy);
        texttaking=findViewById(R.id.taking);
        ocr=findViewById(R.id.resultText);

        //파이어베이스 데이터 조회를 위한 DatabaseReference 인스턴스 필요
        reference=FirebaseDatabase.getInstance().getReference();
        readDB(result);
        Log.w("Result","result="+result);

    }
    private void readDB(String result){
        reference.child("medical_information").orderByChild("name").equalTo(result).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                firebasePosts.clear();
                for(DataSnapshot dataSnapshot:snapshot.getChildren()){
                    FirebasePost firebasePost=dataSnapshot.getValue(FirebasePost.class);
                    firebasePosts.add(firebasePost);
                    String name=firebasePost.getName();
                    String efficacy=firebasePost.getEfficacy();
                    String taking=firebasePost.getTaking();
                    textname.setText(name);
                    textefficacy.setText(efficacy);
                    texttaking.setText(taking);
                }

                Log.w("Result","result="+result);
                Log.w("Result","firebaseList="+firebasePosts.toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.w("firebasedata","loadpost:oncancelled",error.toException());
            }
        });
    }
}
