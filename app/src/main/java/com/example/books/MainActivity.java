package com.example.books;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<Book>>{

    private static final String BOOK_API_REQUEST_URL = "https://www.googleapis.com/books/v1/volumes";

    private static final String LOG_TAG = MainActivity.class.getName();

    private BookAdapter mBookAdapter;

    private static final int LOADER_ID = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button search = (Button) findViewById(R.id.search);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoaderManager.getInstance(MainActivity.this)
                        .restartLoader(LOADER_ID, null, MainActivity.this);

            }
        });

        TextView emptyView = (TextView) findViewById(R.id.emptyView);

        ListView booksListView = (ListView) findViewById(R.id.list_view);

        booksListView.setEmptyView(emptyView);

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
                    Toast.makeText(MainActivity.this, "InfoUrl not available"
                            , Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @NonNull
    @Override
    public Loader<List<Book>> onCreateLoader(int id, @Nullable Bundle args) {
        EditText query = (EditText) findViewById(R.id.query);

        Uri baseUri = Uri.parse(BOOK_API_REQUEST_URL);
        Uri.Builder builder = baseUri.buildUpon();

        builder.appendQueryParameter("q", query.getText().toString());
        return new BookLoader(this, builder.toString());
    }

    @Override
    public void onLoadFinished(@NonNull Loader<List<Book>> loader, List<Book> books) {
        // Clear the adapter of previous book data
        mBookAdapter.clear();

        // If there is a valid list of {@link Book}s, then add them to the adapter's
        // data set. This will trigger the ListView to update.
        if (books != null && !books.isEmpty()) {
            mBookAdapter.addAll(books);
        }
    }

    @Override
    public void onLoaderReset(@NonNull Loader<List<Book>> loader) {
        // Clear the adapter of previous book data
        mBookAdapter.clear();
    }
}