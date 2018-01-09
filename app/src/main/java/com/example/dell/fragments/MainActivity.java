package com.example.dell.fragments;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    Button button1,button2,button3;
    ListView listView;
    ArrayList <String> arrayList;
    ArrayAdapter <String> arrayAdapter;
//hkjhjjh
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.et1);
        button1 = (Button) findViewById(R.id.btn1);
        button2 = (Button) findViewById(R.id.btn2);
        button3 = (Button) findViewById(R.id.btn3);
        listView = (ListView) findViewById(R.id.listview1);

        arrayList = new ArrayList<String>();
        arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,arrayList);
        listView.setAdapter(arrayAdapter);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editText.getText().toString();
                if (name.isEmpty()){
                    Toast.makeText(MainActivity.this, "Text is empty", Toast.LENGTH_SHORT).show();
                    return;
                }
                //Add items to array list
                arrayList.add(name);
                arrayAdapter.notifyDataSetChanged();
                editText.setText("");
                editText.requestFocus();

            }
        });

       listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               String data = (String) parent.getItemAtPosition(position);
               editText.setText(data);

           }
       });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editText.getText().toString();
                if (name.isEmpty()){
                    Toast.makeText(MainActivity.this, "Text is empty", Toast.LENGTH_SHORT).show();
                    return;
                }
                int position = 0;
                arrayList.add(position,name);
                arrayAdapter.notifyDataSetChanged();
                editText.setText("");
                editText.requestFocus();
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "position", Toast.LENGTH_SHORT).show();
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (arrayList.get(position).equals("")){
                    Toast.makeText(MainActivity.this, "Try again", Toast.LENGTH_SHORT).show();
                    return;
                }
                arrayList.remove(position);
                arrayAdapter.notifyDataSetChanged();
                return;

            }
        });
    }
}
