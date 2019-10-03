package es.iessaladillo.pedrojoya.pr01.ui.main;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import es.iessaladillo.pedrojoya.pr01.R;
import es.iessaladillo.pedrojoya.pr01.bmi.BmiCalculator;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        clickBtnReset();
        clickBtnCalculate();
    }

    private void clickBtnReset() {
        Button btnReset = ActivityCompat.requireViewById(this, R.id.btnReset);
        btnReset.setOnClickListener(r -> reset());
    }
    private void reset(){
        EditText txtHeight = ActivityCompat.requireViewById(this,R.id.txtHeight);
        EditText txtWeight = ActivityCompat.requireViewById(this,R.id.txtWeight);
        ImageView image = ActivityCompat.requireViewById(this,R.id.image);
        TextView txtViewMsg = ActivityCompat.requireViewById(this,R.id.txtViewMsg);
        txtHeight.setText("");
        txtWeight.setText("");
        image.setImageResource(R.drawable.bmi);
        txtViewMsg.setText("");
    }

    // TODO
    private void clickBtnCalculate(){
        Button btnCalculate = ActivityCompat.requireViewById(this, R.id.btnCalculate);
        btnCalculate.setOnClickListener(c -> calculate());
    }
    private void calculate(){
        EditText txtHeight = ActivityCompat.requireViewById(this,R.id.txtHeight);
        EditText txtWeight = ActivityCompat.requireViewById(this,R.id.txtWeight);
        TextView txtViewMsg = ActivityCompat.requireViewById(this,R.id.txtViewMsg);
        ImageView image = ActivityCompat.requireViewById(this,R.id.image);
        BmiCalculator.BmiClasification bmiEnum;
        float result;

        BmiCalculator bmi = new BmiCalculator();
        result = bmi.calculateBmi(Float.parseFloat(txtHeight.getText().toString()), Float.parseFloat(txtWeight.getText().toString()));
        bmiEnum = bmi.getBmiClasification(result);
        switch (bmiEnum){
            case LOW_WEIGHT:
                txtViewMsg.setText(""+ result);
                image.setImageResource(R.drawable.underweight);
                break;
            case NORMAL_WEIGHT:
                txtViewMsg.setText("2");
                image.setImageResource(R.drawable.normal_weight);
                break;
            case OVERWWEIGHT:
                txtViewMsg.setText("3");
                image.setImageResource(R.drawable.overweight);
                break;
            case OBESITY_GRADE_1:
                txtViewMsg.setText("4");
                image.setImageResource(R.drawable.obesity1);
                break;
            case OBESITY_GRADE_2:
                txtViewMsg.setText("5");
                image.setImageResource(R.drawable.obesity2);
                break;
            case OBESITY_GRADE_3:
                txtViewMsg.setText("6");
                image.setImageResource(R.drawable.obesity3);
                break;
        }


    }

}
