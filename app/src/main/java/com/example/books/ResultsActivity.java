package com.example.books;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ResultsActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<Book>> {

    private static final String LOG_TAG = ResultsActivity.class.getName();

    private BookAdapter mBookAdapter;

    private static final int LOADER_ID = 1;

    private ProgressBar mProgressBar;

    private TextView mEmptyView;

    private String mRequestUrlString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            mRequestUrlString = extras.getString(MainActivity.REQUEST_URL_KEY);
        }

        ListView booksListView = (ListView) findViewById(R.id.list_view);

        mBookAdapter = new BookAdapter(this, new ArrayList<Book>());

        booksListView.setAdapter(mBookAdapter);

        booksListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Book clickedBook = (Book) parent.getItemAtPosition(position);

                if (clickedBook.getInfoUrl().length() > 0) {
                    Uri infoUrl = Uri.parse(clickedBook.getInfoUrl());
                    Intent intent = new Intent(Intent.ACTION_VIEW, infoUrl);
                    if (intent.resolveActivity(getPackageManager()) != null) {
                        startActivity(intent);
                    }
                } else {
                    Toast.makeText(ResultsActivity.this, "InfoUrl not available"
                            , Toast.LENGTH_SHORT).show();
                }
            }
        });

        mEmptyView = (TextView) findViewById(R.id.emptyView);
        booksListView.setEmptyView(mEmptyView);

        mProgressBar = (ProgressBar) findViewById(R.id.progressBar);

        LoaderManager.getInstance(ResultsActivity.this)
                .initLoader(LOADER_ID, null, ResultsActivity.this);
    }

    @NonNull
    @Override
    public Loader<List<Book>> onCreateLoader(int id, @Nullable Bundle args) {
        return new BookLoader(this, mRequestUrlString);
    }

    @Override
    public void onLoadFinished(@NonNull Loader<List<Book>> loader, List<Book> books) {
        mProgressBar.setVisibility(View.GONE);

        // Clear the adapter of previous book data
        mBookAdapter.clear();

        // If there is a valid list of {@link Book}s, then add them to the adapter's
        // data set. This will trigger the ListView to update.
        if (books != null && !books.isEmpty()) {
            mBookAdapter.addAll(books);
        }
        mEmptyView.setText(R.string.no_books_found);
    }

    @Override
    public void onLoaderReset(@NonNull Loader<List<Book>> loader) {
        // Clear the adapter of previous book data
        mBookAdapter.clear();
    }
}