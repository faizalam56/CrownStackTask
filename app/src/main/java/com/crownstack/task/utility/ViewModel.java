package com.crownstack.task.utility;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.crownstack.task.BR;

public class ViewModel extends BaseObservable {
    @Bindable
    public boolean getDialogVisibility() {
        return dialogVisibility;
    }

    public void setDialogVisibility(boolean dialogVisibility) {
        this.dialogVisibility = dialogVisibility;
        notifyPropertyChanged(BR.dialogVisibility);
    }

    private boolean dialogVisibility;
}