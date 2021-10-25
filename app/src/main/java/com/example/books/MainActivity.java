package com.example.books;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = MainActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView emptyView = (TextView) findViewById(R.id.emptyView);

        ListView booksListView = (ListView) findViewById(R.id.list_view);

        booksListView.setEmptyView(emptyView);

        List<Book> books = QueryUtils.extractBooksFromJSONResponse();

        BookAdapter bookAdapter = new BookAdapter(this, books);

        booksListView.setAdapter(bookAdapter);

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
    }
}