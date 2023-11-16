package com.example.rest_http.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.rest_http.model.jsonplace;
import com.example.rest_http.R;
import java.util.List;

public class PostAdapter extends ArrayAdapter<jsonplace> {
    private Context context;
    private List<jsonplace> jsonplaces;

    public PostAdapter(Context context, List<jsonplace> jsonplaces) {
        super(context, 0, jsonplaces);
        this.context = context;
        this.jsonplaces = jsonplaces;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.list_item_post, parent, false);


        TextView titleTextView = view.findViewById(R.id.titleTextView);
        TextView bodyTextView = view.findViewById(R.id.bodyTextView);
        TextView userIdTextView = view.findViewById(R.id.userIdTextView);


        jsonplace jso = jsonplaces.get(position);


        titleTextView.setText(jso.getTitle());
        bodyTextView.setText(jso.getBody());
        userIdTextView.setText(String.valueOf(jso.getUserId()));
        return view;
    }
}
