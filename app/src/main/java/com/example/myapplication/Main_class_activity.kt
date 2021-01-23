package com.example.myapplication

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*

class Main_class_activity : AppCompatActivity(){


    fun openTab1(){
        btn_tab_1.setTextColor(ContextCompat.getColor(this,
            R.color.colorPrimary
        ))
        btn_tab_2.setTextColor(ContextCompat.getColor(this,
            R.color.colorPrimaryDark
        ))
        line_tab_1.visibility = View.VISIBLE
        line_tab_2.visibility = View.GONE
        showFragment(
            DashboardFragment.newInstance(),
            R.id.fragment_container
        )
    }


    fun openTab2(){
        btn_tab_1.setTextColor(ContextCompat.getColor(this,
            R.color.colorPrimaryDark
        ))
        btn_tab_2.setTextColor(ContextCompat.getColor(this,
            R.color.colorPrimary
        ))
        line_tab_1.visibility = View.GONE
        line_tab_2.visibility = View.VISIBLE

        showFragment(
            DashboardFragment.newInstance(),
            R.id.fragment_container
        )
    }

    fun showFragment(fragment: Fragment?, fragmentResourceID: Int) {
        if (fragment != null) {
            val fragmentManager = this.supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(fragmentResourceID, fragment)
            fragmentTransaction.detach(fragment)
            fragmentTransaction.attach(fragment)
            fragmentTransaction.commit()
        }
    }


    fun initTab(){
        btn_tab_1.setOnClickListener{
            openTab1()
        }

        btn_tab_2.setOnClickListener{
            openTab2()
        }


        openTab1()
    }


    fun initView() {
        initTab()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }
}