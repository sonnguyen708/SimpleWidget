package vn.ntu.edu.thanhson.simplewidget;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edtName;
    EditText edtBirthDate;
    RadioGroup rdgGender;
    LinearLayout llHobby;
    EditText edtDiffHobby;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addViews();
        addEvents();
    }
    private void addViews(){
        edtName=findViewById(R.id.edtName);
        edtBirthDate= findViewById(R.id.edtBirthDate);
        rdgGender=findViewById(R.id.rdgGender);
        llHobby=findViewById(R.id.llHobby);
        edtDiffHobby=findViewById(R.id.edtDiffHobby);
        btnSubmit=findViewById(R.id.btnSubmit);
    }
    private void addEvents(){
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toast();
            }
        });
    }
    private void toast() {
        Person person = new Person();
        person.setName(edtName.getText().toString());
        person.setBirthDate(edtBirthDate.getText().toString());
        switch (rdgGender.getCheckedRadioButtonId()) {
            case R.id.rdbMale:
                person.setGender(true);
                break;
            case R.id.rdbFemale:
                person.setGender(false);
        }
        int hobbyFixedCount= llHobby.getChildCount();
        for (int i=0;i<hobbyFixedCount;i++){
            CheckBox cb=(CheckBox)llHobby.getChildAt(i);
            if (cb.isChecked()){
                person.addHobby(cb.getText().toString());
            }
        }
        if (edtDiffHobby.getText().toString() != "") {
            person.addHobby(edtDiffHobby.getText().toString());
        }
        Toast.makeText(getApplicationContext(), person.toString(),Toast.LENGTH_SHORT).show();
    }
}
