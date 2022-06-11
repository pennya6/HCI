package com.example.basiccode;

import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;

import java.util.HashMap;
import java.util.Map;

@IgnoreExtraProperties
public class FirebasePost {
    public String id;
    public String name;
    public String taking;
    public String efficacy;

    public FirebasePost(){

    }
    public FirebasePost(String id,String name,String taking,String efficacy){
        this.id=id;
        this.name=name;
        this.taking=taking;
        this.efficacy=efficacy;
    }
    @Exclude
    public Map<String ,Object> toMap(){
        HashMap<String,Object> result=new HashMap<>();
        result.put("id",id);
        result.put("name",name);
        result.put("taking",taking);
        result.put("efficacy",efficacy);
        return result;
    }
}
