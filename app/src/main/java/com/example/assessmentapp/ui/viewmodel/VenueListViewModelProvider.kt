package com.example.assessmentapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.assessmentapp.data.repository.VenueListRepository
import com.example.assessmentapp.util.IMyDispatchers

class VenueListViewModelProvider constructor(private val repository: VenueListRepository, private val myDispatchers: IMyDispatchers): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(VenueListViewModel::class.java)) {
            VenueListViewModel(repository, myDispatchers) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}