package com.example.basempvcalculator.Presenters;

import com.example.basempvcalculator.Models.OperationModel;
import com.example.basempvcalculator.Models.Interfaces.IOperationModel;
import com.example.basempvcalculator.Presenters.Interfaces.IOperationPresenter;
import com.example.basempvcalculator.Views.Interfaces.IOperationView;

public class OperationPresenter implements IOperationPresenter {
    private IOperationView view;
    private IOperationModel model;

    public OperationPresenter(IOperationView view) {
        this.view = view;
        this.model = new OperationModel(this);
    }

    @Override
    public void showResult(String result) {
        if (view != null) {
            view.showResult(result);
        }
    }

    @Override
    public void invalidOperation() {
        if (view != null) {
            view.invalidOperation();
        }
    }


    @Override
    public void add(int num1, int num2) {
        if (model != null) {
            model.add(num1, num2);
        }
    }

    @Override
    public void subtract(int num1, int num2) {
        if (model != null) {
            model.subtract(num1, num2);
        }
    }

    @Override
    public void multiply(int num1, int num2) {
        if (model != null) {
            model.multiply(num1, num2);
        }
    }

    @Override
    public void divide(int num1, int num2) {
        if (model != null) {
            model.divide(num1, num2);
        }
    }
}
