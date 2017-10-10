package com.example.shiva.database;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
dbhelper db;
    Button b1,b2;
    EditText name;
    TextView t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db=new dbhelper(this);

        b1=(Button)findViewById(R.id.insert);
        b2=(Button)findViewById(R.id.display);
        name=(EditText) findViewById(R.id.name);
        t1=(TextView)findViewById(R.id.t1);

    }
    public void insert(View view)
    {
        String text= name.getText().toString();
        db.insert_album(text);

    }
    public void disp(View view)
    {
        t1.setText("");
        Cursor cr;
        cr=db.list_album();
        while(cr.moveToNext())
        {
            t1.append(cr.getString(0)+"\n");
        }

    }
    public void del(View view)
    {
        db.delete_album();

    }
}
