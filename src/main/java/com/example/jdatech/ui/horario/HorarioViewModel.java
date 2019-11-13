package com.example.jdatech.ui.horario;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HorarioViewModel extends ViewModel {
    private MutableLiveData<String> mText;

    public HorarioViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Horario fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
