package sg.edu.rp.c346.id21045028.demodynamiclistviewcolourlist;

import androidx.appcompat.app.AppCompatActivity;

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

    EditText etElement;
    EditText etIndex;
    Button btnAdd;
    Button btnRem;
    Button btnEdit;
    ListView lvColour;
    ArrayList<String> alColours;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etElement = findViewById(R.id.EditColourText);
        etIndex = findViewById(R.id.EditTextIndex);
        btnAdd = findViewById(R.id.buttonAddItem);
        btnRem = findViewById(R.id.buttonRemove);
        btnEdit = findViewById(R.id.buttonEditItem);
        lvColour = findViewById(R.id.listViewColour);

        alColours = new ArrayList<String>();
        alColours.add("Red");
        alColours.add("Orange");

        ArrayAdapter aaColour = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,alColours);

        lvColour.setAdapter(aaColour);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String colour = etElement.getText().toString();
                //alColours.add(colour);
                int pos = Integer.parseInt(etIndex.getText().toString());
                alColours.add((pos-1),colour);
                aaColour.notifyDataSetChanged();
            }
        });

        btnRem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int pos = Integer.parseInt(etIndex.getText().toString());
                alColours.remove(pos-1);
                aaColour.notifyDataSetChanged();
            }
        });

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String colour = etElement.getText().toString();
                //alColours.add(colour);
                int pos = Integer.parseInt(etIndex.getText().toString());
                alColours.set((pos-1),colour);
                aaColour.notifyDataSetChanged();
            }
        });

        lvColour.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0){
                    Toast.makeText(getApplicationContext(),alColours.get(position),Toast.LENGTH_SHORT).show();
                }else if(position == 1){
                    Toast.makeText(getApplicationContext(),alColours.get(position),Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}