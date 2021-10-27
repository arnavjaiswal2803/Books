package com.example.books;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.loader.content.AsyncTaskLoader;

import java.util.List;

public class BookLoader extends AsyncTaskLoader<List<Book>> {
    private String[] mRequestUrls;

    public BookLoader(@NonNull Context context, String... requestUrls) {
        super(context);
        mRequestUrls = requestUrls;
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();

        forceLoad();
    }

    @Nullable
    @Override
    public List<Book> loadInBackground() {
        // Don't perform the request if there are no URLs, or the first URL is null.
        if (mRequestUrls.length < 1 || mRequestUrls[0] == null) {
            return null;
        }

        // Perform the HTTP request for book data and process the response.
        List<Book> books = QueryUtils.fetchBooksData(mRequestUrls[0]);
        return books;
    }
}
