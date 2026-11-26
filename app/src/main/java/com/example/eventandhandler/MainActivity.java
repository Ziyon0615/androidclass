package com.example.eventandhandler;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;
import android.view.View;
import android.widget.AdapterView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.WindowCompat;
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WindowCompat.enableEdgeToEdge(getWindow());
        setContentView(R.layout.activity_main);
        EditText edtName = findViewById(R.id.edtName);
        TextView txtresult = findViewById(R.id.txtresult);
        Button btnhello = findViewById(R.id.btnhello);
        Spinner spinnerCourse = findViewById(R.id.spinnerCourse);
        String[] courses = {
                "Select Course",
                "BS Information Technology",
                "BS Computer Science",
                "BS Information Systems",
                "BS Entertainment and Multimedia Computing"
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                courses
        );
        adapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item
        );
        spinnerCourse.setAdapter(adapter);
        spinnerCourse.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(
                            AdapterView<?> parent,
                            View view,
                            int position,
                            long id) {

                        String selectedCourse =
                                parent.getItemAtPosition(position).toString();

                        if (position > 0) {
                            Toast.makeText(
                                    MainActivity.this,
                                    "Selected: " + selectedCourse,
                                    Toast.LENGTH_SHORT
                            ).show();
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {
                    }
                }
        );

    }
}