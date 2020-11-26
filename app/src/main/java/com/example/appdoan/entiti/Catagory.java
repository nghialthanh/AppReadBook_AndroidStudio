package com.example.appdoan.entiti;

public class Catagory {
    private int id;
    private String CatagoryName;
    private int count;
    public Catagory(int id,  String Name,int count) {
        this.id = id;
        this.CatagoryName = Name;
        this.count = count;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getCatagoryName() {
        return CatagoryName;
    }

    public void setCatagoryName(String CatagoryName) {
        this.CatagoryName = CatagoryName;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int Count) {
        this.count = Count;
    }
}
