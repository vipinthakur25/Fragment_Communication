package com.example.fragmentcommunication.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.setFragmentResultListener
import com.example.fragmentcommunication.R
import com.example.fragmentcommunication.databinding.FragmentFirstBinding


class FirstFragment : Fragment() {

    private lateinit var _mBinding: FragmentFirstBinding
    private val firstNumber = 20
    private val secondNumber = 30

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_first, container, false)
        initView()
        return _mBinding.root
    }

    private fun initView() {
       _mBinding.btnNext.setOnClickListener {
           initFragment()
       }
    }

    private fun initFragment() {
        val bundle = Bundle()
        bundle.apply {
            putInt("FIRST_NUMBER", firstNumber)
            putInt("SECOND_NUMBER", secondNumber)
        }
        val fragment: Fragment = SecondFragment()
        val mFragmentManager = requireActivity().supportFragmentManager
        fragment.arguments = bundle
        val fragmentTransaction = mFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.mainContentView, fragment)
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_NONE)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setFragmentResultListener("SUM") { reqKey, bundle ->
            if (reqKey == "SUM")
            {
                val result = bundle.getInt("RESULT")
               _mBinding.tvResult.text = "The Sum of $firstNumber & $secondNumber is = $result"
            }
        }
    }
}