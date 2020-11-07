package com.egiwon.benxtest.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.egiwon.benxtest.DummyFragment
import com.egiwon.benxtest.R
import com.egiwon.benxtest.databinding.ActivityMainBinding
import com.egiwon.benxtest.shop.ShopFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this

        initBottomNavigationView()
        setSelectItemListener()
    }

    private fun setSelectItemListener() {
        binding.bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.menu_shop -> {
                    showFragment(ShopFragment())
                    true
                }
                else -> {
                    showFragment(DummyFragment())
                    true
                }
            }
        }
    }

    private fun initBottomNavigationView() {
        binding.bottomNavigationView.selectedItemId = R.id.menu_shop
        showFragment(ShopFragment())
    }

    private fun showFragment(fragment: Fragment) {
        supportFragmentManager.commit(allowStateLoss = true) {
            replace(R.id.fragment_container, fragment, fragment::javaClass.name)
        }
    }
}