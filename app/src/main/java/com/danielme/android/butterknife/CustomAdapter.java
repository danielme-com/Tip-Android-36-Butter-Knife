package com.danielme.android.butterknife;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class CustomAdapter extends ArrayAdapter<String> {

    private LayoutInflater layoutInflater;

    public CustomAdapter(Context context, List<String> objects) {
        super(context, 0, objects);
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        ViewHolder holder;
        if (view != null) {
            holder = (ViewHolder) view.getTag();
        } else {
            view = layoutInflater.inflate(R.layout.listview_row, parent, false);
            holder = new ViewHolder(view);
            view.setTag(holder);
        }

        holder.title.setText(getItem(position));
        holder.subtitle.setText(getItem(position));

        return view;
    }

    static class ViewHolder {
        @Bind(R.id.title)
        TextView title;
        @Bind(R.id.subtitle)
        TextView subtitle;

        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }

}
