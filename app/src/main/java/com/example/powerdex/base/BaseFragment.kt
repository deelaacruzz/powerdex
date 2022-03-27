package com.example.powerdex.base

import android.app.AlertDialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.example.powerdex.R

open class BaseFragment<T : ViewDataBinding>(@LayoutRes private val layoutResId: Int) : Fragment() {
    private var _binding: T? = null
    private val binding: T get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //Inflar vista
        _binding = DataBindingUtil.inflate(inflater, layoutResId, container, false)
        binding.initialize()
        binding.initializeWithContainer(container)
        return binding.root
    }

    open fun T.initialize() {}
    open fun T.initializeWithContainer(container: ViewGroup?) {}

    private var alertDialog: AlertDialog? = null
    fun showProgresDialog() {

        if (alertDialog != null && alertDialog!!.isShowing){
            return
        }
        val inflater = layoutInflater
        val dialoglayout: View = inflater.inflate(R.layout.loading_dialog, null)

        val builder: AlertDialog.Builder = AlertDialog.Builder(activity)
        builder.setView(dialoglayout)
        builder.setCancelable(false)
        alertDialog = builder.create()
        alertDialog!!.show()
        alertDialog!!.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        val window = alertDialog!!.window
        window!!.setLayout(
            ConstraintLayout.LayoutParams.MATCH_PARENT,
            ConstraintLayout.LayoutParams.WRAP_CONTENT
        )
    }

    fun hideProgressDialog() {
        if (alertDialog != null) {
            alertDialog?.hide()
            alertDialog?.dismiss()
        }
    }
}