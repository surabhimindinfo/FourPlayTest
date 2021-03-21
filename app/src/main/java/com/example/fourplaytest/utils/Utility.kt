package com.example.fourplaytest.utils

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.net.ConnectivityManager
import android.view.Gravity
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import com.example.fourplaytest.R
import kotlinx.android.synthetic.main.custom_layout.view.*

object Utility {


    fun Context.isInternetAvailable(): Boolean {
        try {
            val cm = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val netInfo = cm.activeNetworkInfo
            return if (netInfo != null && netInfo.isConnected) {
                true
            } else {
                showErrorToast("Internet not available. Please try again!!")
                false
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return false
    }

    fun Context.showErrorToast(message: String?) {

        try {
            val toast = Toast.makeText(this, message, Toast.LENGTH_LONG)

            // set message color
            val textView = toast.view.findViewById(android.R.id.message) as? TextView
            textView?.setTextColor(Color.WHITE)
            textView?.gravity = Gravity.CENTER

            // set background color
            toast.view.setBackgroundColor(Color.RED)

            toast.setGravity(Gravity.TOP or Gravity.FILL_HORIZONTAL, 0, 0)

            toast.show()
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    fun Context.showCustomDialog( ) {
        val mDialogView = LayoutInflater.from(this).inflate(R.layout.custom_layout, null)
        //AlertDialogBuilder
        val mBuilder = AlertDialog.Builder(this)
            .setView(mDialogView)
         //show dialog
        val  mAlertDialog = mBuilder.show()
         mDialogView.ok_btn.setOnClickListener {
            //dismiss dialog
            mAlertDialog.dismiss()

        }

    }
}