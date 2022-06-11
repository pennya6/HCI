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

    public String getEfficacy() {
        return efficacy;
    }

    public void setEfficacy(String efficacy) {
        this.efficacy = efficacy;
    }

    public String getTaking() {
        return taking;
    }

    public void setTaking(String taking) {
        this.taking = taking;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public FirebasePost(){

    }
    public FirebasePost(String name,String taking,String efficacy){
        this.name=name;
        this.taking=taking;
        this.efficacy=efficacy;
    }
    @Exclude
    public Map<String ,Object> toMap(){
        HashMap<String,Object> result=new HashMap<>();
        result.put("name",name);
        result.put("taking",taking);
        result.put("efficacy",efficacy);
        return result;
    }
}
