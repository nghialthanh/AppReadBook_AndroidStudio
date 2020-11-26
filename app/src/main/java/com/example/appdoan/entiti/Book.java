package com.example.appdoan.entiti;



public class Book  {
    private int id;
    private int categoryID;
    private String bookName;
    private String imageName;
    private int favorite;
    public Book(int id, int categoryID, String bookName, String imageName,int favorite) {
        this.id = id;
        this.categoryID = categoryID;
        this.bookName = bookName;
        this.imageName = imageName;
        this.favorite = favorite;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public int getFavorite() {
        return favorite;
    }

    public void setFavorite(int favorite) {
        this.favorite = favorite;
    }
}
