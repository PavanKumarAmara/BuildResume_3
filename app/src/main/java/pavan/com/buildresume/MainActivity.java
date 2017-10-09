package pavan.com.buildresume;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
boolean isOnLongClicked;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView startBuilding=(TextView) findViewById(R.id.start_building);
        startBuilding.setOnLongClickListener(hiddenToast);
    }
    View.OnLongClickListener hiddenToast=new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View v) {
           Toast.makeText(getApplicationContext(),"Welcome Pavan",Toast.LENGTH_LONG).show();
            return true;
        }
    };
    void startBuilding(View view){
        Intent startBuilding=new Intent(this,Resume.class);
        startActivity(startBuilding);
    }
}
