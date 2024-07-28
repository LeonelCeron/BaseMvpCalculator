package com.example.basempvcalculator.Views;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.basempvcalculator.R;
import com.example.basempvcalculator.Presenters.Interfaces.IOperationPresenter;
import com.example.basempvcalculator.Views.Interfaces.IOperationView;
import com.example.basempvcalculator.Presenters.OperationPresenter;


public class OperationActivityView extends AppCompatActivity implements IOperationView {

    private EditText number1;
    private EditText number2;
    private TextView txtResult;
    private IOperationPresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activy_operation);

        number1 = findViewById(R.id.txtNumber1);
        number2 = findViewById(R.id.txtNumber2);
        txtResult = findViewById(R.id.txtResult);
        presenter = new OperationPresenter(this);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void doAdd(View view) {
        try {
            int num1 = Integer.parseInt(number1.getText().toString());
            int num2 = Integer.parseInt(number2.getText().toString());
            presenter.add(num1, num2);
        } catch (NumberFormatException e) {
            invalidOperation();
        }
    }

    public void doSubtract(View view) {
        try {
            int num1 = Integer.parseInt(number1.getText().toString());
            int num2 = Integer.parseInt(number2.getText().toString());
            presenter.subtract(num1, num2);
        } catch (NumberFormatException e) {
            invalidOperation();
        }

    }

    public void doMultiply(View view) {
        try {
            int num1 = Integer.parseInt(number1.getText().toString());
            int num2 = Integer.parseInt(number2.getText().toString());
            presenter.multiply(num1, num2);
        } catch (NumberFormatException e) {
            invalidOperation();
        }

    }

    public void doDivide(View view) {
        try {
            int num1 = Integer.parseInt(number1.getText().toString());
            int num2 = Integer.parseInt(number2.getText().toString());
            presenter.divide(num1, num2);
        } catch (NumberFormatException e) {
            invalidOperation();
        }

    }

    @Override
    public void showResult(String result) {
        txtResult.setText(result);
    }

    @Override
    public void invalidOperation() {
        Toast.makeText(this, "Invalid operation", Toast.LENGTH_SHORT).show();
    }
}