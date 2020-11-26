package com.example.appdoan.entiti;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.ArrayList;

public class AddCatagory {
    public static ArrayList<Catagory> getCata(ArrayList<Book> ls) {
        int i1=0,i2=0,i3=0,i4=0;
        for (Book b: ls){
            if(b.getCategoryID()==1)
                i1++;
            else if (b.getCategoryID()==2)
                i2++;
            else if (b.getCategoryID()==3)
                i3++;
            else
                i4++;

        }
        Catagory c1 = new Catagory(1,"Văn học việt nam", i1);
        Catagory c2 = new Catagory(2,"Tiểu thuyết nước ngoài", i2);
        Catagory c3 = new Catagory(3,"Kỹ Năng", i3);
        Catagory c4 = new Catagory(4,"Tử vi", i4);


        ArrayList<Catagory> list = new ArrayList<Catagory>();
        list.add(c1);list.add(c2);
        list.add(c3);list.add(c4);

        return list;
    }
}
