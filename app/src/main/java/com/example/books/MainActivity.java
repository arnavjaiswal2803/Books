package com.example.books;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<Book>> {

    private static final String BOOK_API_REQUEST_URL = "https://www.googleapis.com/books/v1/volumes";

    private static final String LOG_TAG = MainActivity.class.getName();

    private BookAdapter mBookAdapter;

    private static final int LOADER_ID = 1;

    private ProgressBar mProgressBar;

    private TextView mEmptyView;

    private EditText mQuery;

    private boolean mIsConnected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
                    Toast.makeText(MainActivity.this, "InfoUrl not available"
                            , Toast.LENGTH_SHORT).show();
                }
            }
        });

        Button search = (Button) findViewById(R.id.search);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performSearch();
            }
        });

        mEmptyView = (TextView) findViewById(R.id.emptyView);
        booksListView.setEmptyView(mEmptyView);

        mProgressBar = (ProgressBar) findViewById(R.id.progressBar);

        ConnectivityManager connectivityManager =
                (ConnectivityManager) this.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = connectivityManager.getActiveNetworkInfo();
        mIsConnected = activeNetwork != null && activeNetwork.isConnectedOrConnecting();

        if (!mIsConnected) {
            mEmptyView.setText(R.string.no_internet);
        }

        mQuery = (EditText) findViewById(R.id.query);

        mQuery.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                search.setEnabled(s.toString().trim().length() > 0);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mQuery.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    performSearch();
                    return true;
                }
                return false;
            }
        });
    }

    private void performSearch() {
        // Hide keyboard when user clicks search
        mQuery.clearFocus();
        InputMethodManager in = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        in.hideSoftInputFromWindow(mQuery.getWindowToken(), 0);

        //Clear adapter
        mBookAdapter.clear();

        // Search
        if (mIsConnected && mQuery.getText().toString().length() > 0) {
            mEmptyView.setVisibility(View.GONE);
            mProgressBar.setVisibility(View.VISIBLE);

            LoaderManager.getInstance(MainActivity.this)
                    .restartLoader(LOADER_ID, null, MainActivity.this);
        } else {
            if (!mIsConnected) {
                Toast.makeText(this, R.string.no_internet, Toast.LENGTH_SHORT)
                        .show();
            } else if (!(mQuery.getText().toString().length() > 0)) {
                Toast.makeText(this, "Please type something first", Toast.LENGTH_SHORT)
                        .show();
            }
        }
    }

    @NonNull
    @Override
    public Loader<List<Book>> onCreateLoader(int id, @Nullable Bundle args) {
        Uri baseUri = Uri.parse(BOOK_API_REQUEST_URL);
        Uri.Builder builder = baseUri.buildUpon();

        builder.appendQueryParameter("q", mQuery.getText().toString().trim());
        return new BookLoader(this, builder.toString());
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

        ConnectivityManager connectivityManager =
                (ConnectivityManager) this.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = connectivityManager.getActiveNetworkInfo();
        mIsConnected = activeNetwork != null && activeNetwork.isConnectedOrConnecting();

        if (mIsConnected) {
            mEmptyView.setText(R.string.no_books_found);
        } else {
            mEmptyView.setText(R.string.no_internet);
        }
    }

    @Override
    public void onLoaderReset(@NonNull Loader<List<Book>> loader) {
        // Clear the adapter of previous book data
        mBookAdapter.clear();
    }
}