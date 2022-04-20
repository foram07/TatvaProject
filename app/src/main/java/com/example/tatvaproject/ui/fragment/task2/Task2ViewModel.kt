package com.example.tatvaproject.ui.fragment.task2

import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.tatvaproject.base.BaseViewModel
import com.example.tatvaproject.model.UserResponse
import com.example.tatvaproject.repo.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class Task2ViewModel @Inject constructor(
    private val repository: UserRepository
) : BaseViewModel() {

    var pagingUserResponseObservable: LiveData<PagingData<UserResponse.UserModel>>? = null
    fun getUserList(): LiveData<PagingData<UserResponse.UserModel>> {
        val newResultLiveData: LiveData<PagingData<UserResponse.UserModel>> =
            repository.getUsersList().cachedIn(viewModelScope)
        pagingUserResponseObservable = newResultLiveData
        return newResultLiveData
    }
}