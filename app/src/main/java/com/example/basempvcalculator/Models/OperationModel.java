package com.example.basempvcalculator.Models;
import com.example.basempvcalculator.Models.Interfaces.IOperationModel;
import com.example.basempvcalculator.Presenters.Interfaces.IOperationPresenter;


public class OperationModel implements IOperationModel {
    private int result;
    private IOperationPresenter presenter;

    public OperationModel(IOperationPresenter operationPresenter) {
        this.presenter = operationPresenter;
    }

    @Override
    public void add(int num1, int num2) {
        result =  num1 + num2;
        presenter.showResult(Integer.toString(result));
    }

    @Override
    public void subtract(int num1, int num2) {
        result = num1 - num2;
        presenter.showResult(Integer.toString(result));
    }

    @Override
    public void multiply(int num1, int num2) {
        result = num1 * num2;
        presenter.showResult(Integer.toString(result));
    }

    @Override
    public void divide(int num1, int num2) {
        if (num2 == 0) {
            result = num1 / num2;
            presenter.showResult(Integer.toString(result));
        } else {
            presenter.invalidOperation();
        }
    }

}
