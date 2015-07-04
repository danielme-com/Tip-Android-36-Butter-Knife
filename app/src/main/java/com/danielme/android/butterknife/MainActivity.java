package com.danielme.android.butterknife;


import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemClick;
import butterknife.OnItemSelected;


public class MainActivity extends Activity {

    @Bind(R.id.editText)
    EditText editText;

    @Bind(R.id.textView)
    TextView textView;

    @Bind(R.id.listView)
    ListView listView;

    private List<String> objects;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //IMPORTANTE!!!
        ButterKnife.bind(this);
        objects = new ArrayList<String>(20);
        for (int i = 0; i < 20; i++) {
            objects.add("object " + i);
        }
        listView.setAdapter(new CustomAdapter(this, objects));
    }

    @OnClick(R.id.button)
    public void copy(Button button) {
        textView.setText(editText.getText());
    }

    @OnItemClick(R.id.listView)
    public void onItemClick(int position) {
        Toast.makeText(this, objects.get(position), Toast.LENGTH_SHORT).show();
    }


}
