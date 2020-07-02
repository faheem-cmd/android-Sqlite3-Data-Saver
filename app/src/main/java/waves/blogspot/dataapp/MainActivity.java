package waves.blogspot.dataapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.google.firebase.FirebaseApp;

import java.net.URI;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    EditText myEditText;
    Button myApplyBtn;
    String myStrin;

    Firebase myFirebase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myEditText = (EditText)findViewById(R.id.editText);
        myApplyBtn = (Button) findViewById(R.id.button);



Firebase.setAndroidContext(this);

myFirebase = new Firebase("https://dataapp-13511.firebaseio.com");

myApplyBtn = (Button) findViewById(R.id.Apply);

myApplyBtn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        myStrin = myEditText.getText().toString();
        Firebase myNewChild = myFirebase.child("ChildName");
        myNewChild.setValue("myStringData");
        Toast.makeText(MainActivity.this,"Child updated with" + myStrin,Toast.LENGTH_SHORT).show();
    }
});



}
}
