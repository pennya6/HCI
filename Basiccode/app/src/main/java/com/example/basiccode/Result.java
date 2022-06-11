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

public class Result extends AppCompatActivity {

    //DB 연동
    FirebaseDatabase database;
    DatabaseReference reference;

    TextView textname;
    TextView textefficacy;
    TextView texttaking;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Intent intent=getIntent();
        String result=intent.getStringExtra("text");

        textname=findViewById(R.id.textView);
        textefficacy=findViewById(R.id.efficacy);
        texttaking=findViewById(R.id.taking);
        //textView.setText(result);

        //파이어베이스 데이터 조회를 위한 DatabaseReference 인스턴스 필요
        reference=FirebaseDatabase.getInstance().getReference();
        readDB();

    }
    private void readDB(){
        reference.child("medical_information").child("id1").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                FirebasePost firebasePost=snapshot.getValue(FirebasePost.class);
                String name=firebasePost.getName();
                String efficacy=firebasePost.getEfficacy();
                String taking=firebasePost.getTaking();
                textname.setText(name);
                textefficacy.setText(efficacy);
                texttaking.setText(taking);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError){
                Log.w("firebasedata","loadpost:oncancelled",databaseError.toException());
            }
        });
    }
}
