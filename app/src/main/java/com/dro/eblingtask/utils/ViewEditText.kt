package com.dro.eblingtask.utils

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.FrameLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.dro.eblingtask.R
import com.google.android.material.snackbar.Snackbar


fun Dialog.showLoadingDialog() = run {
    Dialog(context).requestWindowFeature(Window.FEATURE_NO_TITLE)
    this.window?.setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
    this.window?.setGravity(Gravity.CENTER)
    this.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    this.setContentView(R.layout.dialog_loading)
    this.setCancelable(false)
    this.show()
}

fun Dialog.hideLoadingDialog() = run { if (this.isShowing) this.dismiss() }


fun Fragment.errorMessage(message: String) = run {
    // create an instance of the snackbar
    val snackbar = Snackbar.make(requireView(), "", Snackbar.LENGTH_LONG)

    val view: View =snackbar.view
    val params = view.layoutParams as FrameLayout.LayoutParams
    params.gravity = Gravity.CENTER_HORIZONTAL or Gravity.TOP

    view.layoutParams=params

    // inflate the custom_snackbar_view created previously
    val customSnackView: View = layoutInflater.inflate(R.layout.layout_error_snackbar, null)

    // set the background of the default snackbar as transparent
    snackbar.view.setBackgroundColor(Color.TRANSPARENT)

    // now change the layout of the snackbar
    val snackbarLayout = snackbar.view as Snackbar.SnackbarLayout

    // set padding of the all corners as 0
    snackbarLayout.setPadding(0, 0, 0, 0)

    // register the button from the custom_snackbar_view layout file
    val messageTv: TextView = customSnackView.findViewById(R.id.message_tv)

    messageTv.text = message

    // add the custom snack bar layout to snackbar layout
    snackbarLayout.addView(customSnackView, 0)

    snackbar.show()

}
