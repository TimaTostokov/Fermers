package com.fermers_marketplace.fermers.presentation.activity.viewmodel

import android.content.Context
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.fermers_marketplace.fermers.R
import com.fermers_marketplace.fermers.data.model.ButtonConfig
import com.fermers_marketplace.fermers.domain.usecase.ChangeButtonIconAndTextColorUseCase
import com.fermers_marketplace.fermers.domain.usecase.ResetLastSelectedButtonUseCase
import com.fermers_marketplace.fermers.domain.usecase.SelectInitialButtonUseCase
import com.fermers_marketplace.fermers.domain.usecase.SetupButtonClickListenerUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val setupButtonClickListenerUseCase: SetupButtonClickListenerUseCase,
    private val selectInitialButtonUseCase: SelectInitialButtonUseCase,
    private val resetLastSelectedButtonUseCase: ResetLastSelectedButtonUseCase,
    private val changeButtonIconAndTextColorUseCase: ChangeButtonIconAndTextColorUseCase
) : ViewModel() {

    private val _lastSelectedButtonLayout = MutableStateFlow<LinearLayout?>(null)
    val lastSelectedButtonLayout: StateFlow<LinearLayout?> = _lastSelectedButtonLayout

    private val _lastSelectedButtonId = MutableStateFlow<Int?>(null)
    val lastSelectedButtonId: StateFlow<Int?> = _lastSelectedButtonId

    private val _lastSelectedTextId = MutableStateFlow<Int?>(null)
    val lastSelectedTextId: StateFlow<Int?> = _lastSelectedTextId

    private val _lastSelectedIconResId = MutableStateFlow<Int?>(null)
    val lastSelectedIconResId: StateFlow<Int?> = _lastSelectedIconResId

    fun setupButtonClickListener(
        context: Context,
        layout: LinearLayout,
        config: ButtonConfig,
        navController: NavController
    ) {
        setupButtonClickListenerUseCase.execute(context, layout, config, navController, this)
    }

    fun selectInitialButton(
        context: Context,
        layout: LinearLayout,
        config: ButtonConfig
    ) {
        selectInitialButtonUseCase.execute(context, layout, config, this)
    }

    fun resetLastSelectedButton(context: Context) {
        resetLastSelectedButtonUseCase.execute(context, this)
    }

    fun changeButtonIconAndTextColor(
        context: Context,
        buttonId: Int,
        textId: Int,
        newIconResId: Int
    ) {
        changeButtonIconAndTextColorUseCase.execute(context, buttonId, textId, newIconResId, this)
    }

    fun updateSelectedButtonState(layout: LinearLayout, config: ButtonConfig) {
        _lastSelectedIconResId.value = config.defaultIconResId
        _lastSelectedButtonLayout.value = layout
        _lastSelectedButtonId.value = config.buttonId
        _lastSelectedTextId.value = config.textId
    }

    fun resetLastSelectedButtonState(context: Context) {
        val layout = _lastSelectedButtonLayout.value ?: return
        val buttonId = _lastSelectedButtonId.value ?: return
        val textId = _lastSelectedTextId.value ?: return
        val iconResId = _lastSelectedIconResId.value ?: return

        layout.findViewById<ImageButton>(buttonId).setImageDrawable(
            ContextCompat.getDrawable(context, iconResId)
        )
        layout.findViewById<TextView>(textId).setTextColor(
            ContextCompat.getColor(context, R.color.gray)
        )
    }

    fun changeButtonIconAndTextColorState(
        context: Context,
        buttonId: Int,
        textId: Int,
        newIconResId: Int
    ) {
        _lastSelectedButtonLayout.value?.findViewById<ImageButton>(buttonId)?.setImageDrawable(
            ContextCompat.getDrawable(context, newIconResId)
        )
        _lastSelectedButtonLayout.value?.findViewById<TextView>(textId)?.setTextColor(
            ContextCompat.getColor(context, R.color.colorWhite)
        )
    }

}