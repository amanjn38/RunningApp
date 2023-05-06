package com.example.runningapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.runningapp.R
import com.example.runningapp.db.RunDAO
import com.example.runningapp.other.Constants.ACTION_SHOW_TRACKING_FRAGMENT
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        bottomNavigationView.setupWithNavController(navHostFragment.findNavController())

        navHostFragment.findNavController().addOnDestinationChangedListener {  _, destination,_ ->
            when(destination.id){
                R.id.settingsFragment, R.id.runFragment, R.id.statisticsFragment ->
                    bottomNavigationView.visibility = View.VISIBLE
                else -> bottomNavigationView.visibility = View.GONE
            }
        }


    }

    private fun navigateToTrackingFragmentIfNeeded(intent : Intent?){
        if(intent?.action == ACTION_SHOW_TRACKING_FRAGMENT){
                
        }
    }
}