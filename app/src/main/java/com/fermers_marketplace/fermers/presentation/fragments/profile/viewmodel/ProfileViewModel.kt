package com.fermers_marketplace.fermers.presentation.fragments.profile.viewmodel

import android.net.Uri
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.fermers_marketplace.fermers.utils.pref.ProfileSharedPreferences
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val sharedPreferences: ProfileSharedPreferences
) : ViewModel() {

    private val _userName = MutableLiveData<String>()
    val userName: LiveData<String> = _userName

    private val _profileImageUri = MutableLiveData<Uri?>()
    val profileImageUri: LiveData<Uri?> = _profileImageUri

    init {
        _userName.value = sharedPreferences.getName()
        val imageUriString = sharedPreferences.getImage()
        _profileImageUri.value = imageUriString?.let { Uri.parse(it) }
    }

    fun updateUserName(newUserName: String) {
        _userName.value = newUserName
        sharedPreferences.saveName(newUserName)
    }

    fun updateProfileImageUri(uri: Uri) {
        _profileImageUri.value = uri
        sharedPreferences.saveImage(uri.toString())
    }
}