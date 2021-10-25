package com.example.books;

public class Book {
    private String mImageUrl;

    private String mTitle;

    private String mAuthor;

    private String mDescription;

    private String mInfoUrl;

    public Book(String imageUrl, String title, String author, String description, String infoUrl) {
        mImageUrl = imageUrl;
        mTitle = title;
        mAuthor = author;
        mDescription = description;
        mInfoUrl = infoUrl;
    }

    public String getImageUrl() {
        return mImageUrl;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getAuthor() {
        return mAuthor;
    }

    public String getDescription() {
        return mDescription;
    }

    public String getInfoUrl() {
        return mInfoUrl;
    }
}
