package com.fermers_marketplace.fermers.utils.ext

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Context
import android.content.Context.INPUT_METHOD_SERVICE
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.NavOptions
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.fermers_marketplace.fermers.R
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.launch

object Extension {

    fun showToast(context: Context, message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    @SuppressLint("ShowToast")
    fun Snackbar.showSnack(message: String) {
        view.let {
            Snackbar.make(it, message, Snackbar.LENGTH_INDEFINITE).apply {
                setAction("Dismiss") {
                    dismiss()
                }
            }
        }
    }

    fun showAlertDialog(
        context: Context,
        title: String,
        message: String,
        positiveButtonText: String = "OK",
        negativeButtonText: String? = null,
        onPositiveButtonClick: (() -> Unit)? = null,
        onNegativeButtonClick: (() -> Unit)? = null
    ) {
        val builder = AlertDialog.Builder(context)
            .setTitle(title)
            .setMessage(message)
            .setPositiveButton(positiveButtonText) { dialog, _ ->
                onPositiveButtonClick?.invoke()
                dialog.dismiss()
            }

        if (negativeButtonText != null) {
            builder.setNegativeButton(negativeButtonText) { dialog, _ ->
                onNegativeButtonClick?.invoke()
                dialog.dismiss()
            }
        }

        val dialog = builder.create()
        dialog.show()
    }

    fun View.visible() {
        this.visibility = View.VISIBLE
    }

    fun View.gone() {
        this.visibility = View.GONE
    }

    fun View.invisible() {
        this.visibility = View.INVISIBLE
    }

    inline fun <T> Fragment.observeData(
        flow: Flow<T>,
        lifecycleOwner: LifecycleOwner = viewLifecycleOwner,
        state: Lifecycle.State = Lifecycle.State.STARTED,
        crossinline block: (T) -> Unit
    ) = lifecycleOwner.lifecycleScope.launch {
        lifecycleOwner.repeatOnLifecycle(state) {
            flow.collect { data ->
                block(data)
            }
        }
    }

    fun Context.getProgressBar(): CircularProgressDrawable {
        val circularProgressDrawable = CircularProgressDrawable(this).apply {
            strokeWidth = 7f
            centerRadius = 40f
            setColorSchemeColors(ContextCompat.getColor(this@getProgressBar, R.color.black))
            start()
        }
        return circularProgressDrawable
    }

    fun Fragment.snackbar(msg: String) {
        view?.apply {
            Snackbar.make(this, msg, Snackbar.LENGTH_LONG).show()
        }
    }

fun View.hideKeyboard() {
    val imm = context.getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(windowToken, 0)
}

fun fragmentAnim(): NavOptions {
    return NavOptions.Builder()
        .setEnterAnim(R.anim.enter_right)
        .setExitAnim(R.anim.exit_left)
        .setPopEnterAnim(R.anim.enter_left)
        .setPopExitAnim(R.anim.exit_right)
        .build()
}

val EditText.textFlow: Flow<String>
    get() = callbackFlow {
        val textWatcher = doAfterTextChanged {
            if (it != null) {
                trySend(it.toString())
            }
        }
        awaitClose { removeTextChangedListener(textWatcher) }
    }

}