package com.example.fragmentcommunication.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import com.example.fragmentcommunication.R
import com.example.fragmentcommunication.databinding.FragmentSecondBinding


class SecondFragment : Fragment() {
    private lateinit var _mBinding: FragmentSecondBinding
    private var firstNumber = 0
    private var secondNumber = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_second, container, false)
        catchIntent()
        initView()
        return _mBinding.root
    }

    private fun initView() {
        _mBinding.btnSum.setOnClickListener {
            val sum = firstNumber + secondNumber
            val resultBundle = Bundle().apply { putInt("RESULT", sum) }
            setFragmentResult("SUM", resultBundle)
            parentFragmentManager.popBackStack()
        }
    }

    private fun catchIntent() {
        val bundle = arguments
        if (bundle != null) {
            firstNumber = bundle.getInt("FIRST_NUMBER")
            secondNumber = bundle.getInt("SECOND_NUMBER")
        }
        if (firstNumber != 0 && secondNumber != 0) {
            _mBinding.tvNumber.text = "The Two Numbers Are $firstNumber & $secondNumber"
        }
    }


}