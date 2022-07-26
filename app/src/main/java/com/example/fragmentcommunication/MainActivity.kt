package com.example.fragmentcommunication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.fragmentcommunication.databinding.ActivityMainBinding
import com.example.fragmentcommunication.fragments.FirstFragment

class MainActivity : AppCompatActivity() {
    private lateinit var _mBinding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setUpView()
    }

    private fun setUpView() {
        _mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        initFragment()
    }

    private fun initFragment() {
        val fragment: Fragment = FirstFragment()
        val mFragmentManager = supportFragmentManager
        val fragmentTransaction = mFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.mainContentView, fragment)
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_NONE)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }

}