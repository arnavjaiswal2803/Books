package com.example.books;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String BOOK_API_REQUEST_URL = "https://www.googleapis.com/books/v1/volumes?q=Dove";

    private static final String LOG_TAG = MainActivity.class.getName();

    private BookAdapter mBookAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView emptyView = (TextView) findViewById(R.id.emptyView);

        ListView booksListView = (ListView) findViewById(R.id.list_view);

        booksListView.setEmptyView(emptyView);


        mBookAdapter = new BookAdapter(this, new ArrayList<Book>());

        booksListView.setAdapter(mBookAdapter);

        booksListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Book clickedBook = (Book) parent.getItemAtPosition(position);

                Uri infoUrl = Uri.parse(clickedBook.getInfoUrl());
                Intent intent = new Intent(Intent.ACTION_VIEW, infoUrl);
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });

        new BookAsyncTask().execute(BOOK_API_REQUEST_URL);
    }

    private class BookAsyncTask extends AsyncTask<String, Void, List<Book>> {

        @Override
        protected List<Book> doInBackground(String... requestUrls) {
            // Don't perform the request if there are no URLs, or the first URL is null.
            if (requestUrls.length < 1 || requestUrls[0] == null) {
                return null;
            }

            // Perform the HTTP request for book data and process the response.
            List<Book> books = QueryUtils.fetchBooksData(requestUrls[0]);
            return books;
        }

        @Override
        protected void onPostExecute(List<Book> books) {
            // Clear the adapter of previous book data
            mBookAdapter.clear();

            // If there is a valid list of {@link Book}s, then add them to the adapter's
            // data set. This will trigger the ListView to update.
            if (books != null && !books.isEmpty()) {
                mBookAdapter.addAll(books);
            }
        }
    }
}