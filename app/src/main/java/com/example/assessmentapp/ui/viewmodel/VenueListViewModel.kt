package com.example.assessmentapp.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.assessmentapp.data.repository.IVenueListRepository
import com.example.assessmentapp.ui.model.VenueDetailsModel
import com.example.assessmentapp.ui.model.VenueListModel
import com.example.assessmentapp.util.IMyDispatchers
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class VenueListViewModel(private val repository: IVenueListRepository, private val myDispatchersImpl: IMyDispatchers) : ViewModel() {

    private var _venueListLiveData = MutableLiveData<List<VenueListModel>>()
    var venueListLiveData: LiveData<List<VenueListModel>> = _venueListLiveData
    private var _venueDetailsLiveData = MutableLiveData<VenueDetailsModel>()
    var venueDetailsLiveData: LiveData<VenueDetailsModel> = _venueDetailsLiveData
    private var _showProgressLiveData = MutableLiveData<Boolean>()
    var showProgressLiveData: LiveData<Boolean> = _showProgressLiveData

    private var venueDetailsJob: Job? = null
    private var venueListJob: Job? = null

    fun getVenueList(nearPlace: String) {
        venueListJob = CoroutineScope(myDispatchersImpl.IO).launch {
            try {
                _showProgressLiveData.postValue(true)
                _venueListLiveData.postValue(repository.getVenueList(nearPlace))
                _showProgressLiveData.postValue(false)
            } catch (e: Exception) {
                _showProgressLiveData.postValue(false)
            }
        }
    }


    fun getVenueDetails(venueId: String) {
        venueDetailsJob = CoroutineScope(myDispatchersImpl.IO).launch {

            try {
                _showProgressLiveData.postValue(true)
                _venueDetailsLiveData.postValue(repository.getVenueDetails(venueId))
                _showProgressLiveData.postValue(false)
            } catch ( e: Exception) {
                _showProgressLiveData.postValue(false)
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        venueListJob?.cancel()
        venueDetailsJob?.cancel()
    }

}