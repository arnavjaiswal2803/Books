package com.example.books;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = MainActivity.class.getName();

    private static final String BOOK_API_REQUEST_URL = "https://www.googleapis.com/books/v1/volumes";

    private EditText mQuery;

    private boolean mIsConnected;

    public static final String REQUEST_URL_KEY = "request-url-key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button search = (Button) findViewById(R.id.search);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performSearch();
            }
        });

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

    @Override
    protected void onResume() {
        super.onResume();

        mIsConnected = isConnectedToInternet(this);
    }

    private void performSearch() {
        // Hide keyboard when user clicks search
        hideKeyboard();

        // Search
        if (mIsConnected && mQuery.getText().toString().length() > 0) {
            Uri baseUri = Uri.parse(BOOK_API_REQUEST_URL);
            Uri.Builder builder = baseUri.buildUpon();

            builder.appendQueryParameter("q", mQuery.getText().toString().trim());
            builder.appendQueryParameter("maxResults", "20");

            Intent intentToOpenResultsActivity = new Intent(this, ResultsActivity.class);
            intentToOpenResultsActivity.putExtra(REQUEST_URL_KEY, builder.toString());
            startActivity(intentToOpenResultsActivity);
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

    public static boolean isConnectedToInternet(Context context) {
        ConnectivityManager connectivityManager =
                (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = connectivityManager.getActiveNetworkInfo();
        return (activeNetwork != null && activeNetwork.isConnectedOrConnecting());
    }

    private void hideKeyboard() {
        mQuery.clearFocus();
        InputMethodManager in = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        in.hideSoftInputFromWindow(mQuery.getWindowToken(), 0);
    }
}