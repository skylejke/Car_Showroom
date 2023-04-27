package com.example.carshowroom.UI.StateHolder.ViewModel;


import android.content.Context;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.carshowroom.Data.Models.Brand;
import com.example.carshowroom.Data.Repositories.BrandRepository;

import java.util.List;

public class BrandViewModel extends ViewModel {
    private final MutableLiveData<List<Brand>> brandLiveData;

    public BrandViewModel(Context context) {
        brandLiveData = new MutableLiveData<>();
        BrandRepository brandRepository = new BrandRepository(context);
        brandLiveData.setValue(brandRepository.getBrandListItems());

    }

    public MutableLiveData<List<Brand>> getBrandItemListLiveData() {
        return brandLiveData;
    }
}