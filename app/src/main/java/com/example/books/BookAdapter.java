package com.example.books;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;

import java.util.List;

public class BookAdapter extends ArrayAdapter<Book>  {
    public BookAdapter(@NonNull Context context, @NonNull List<Book> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext())
                    .inflate(R.layout.list_item, parent, false);
        }

        Book currentBook = getItem(position);

        ImageView image = (ImageView) convertView.findViewById(R.id.image);
        if (currentBook.getImageUrl().length() > 0) {
            Glide.with(image.getContext()).load(currentBook.getImageUrl()).into(image);
        } else {
            image.setVisibility(View.INVISIBLE);
        }

        TextView title = (TextView) convertView.findViewById(R.id.title);
        title.setText(currentBook.getTitle());

        TextView author = (TextView) convertView.findViewById(R.id.author);
        author.setText(currentBook.getAuthor());

        TextView description = (TextView) convertView.findViewById(R.id.description);
        description.setText(currentBook.getDescription());

        return convertView;
    }
}
