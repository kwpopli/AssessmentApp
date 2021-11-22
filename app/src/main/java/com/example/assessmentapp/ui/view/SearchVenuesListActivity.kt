package com.example.assessmentapp.ui.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.assessmentapp.R
import com.example.assessmentapp.databinding.SearchVenuesActivityBinding

class SearchVenuesListActivity : AppCompatActivity() {

    private lateinit var viewBinding: SearchVenuesActivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = SearchVenuesActivityBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        supportFragmentManager
            .beginTransaction()
            .replace(
                    R.id.fragmentContainer,
                SearchVenuesListFragment(),
                SearchVenuesListFragment::class.java.simpleName
            )
            .commit()

        supportFragmentManager.addOnBackStackChangedListener{
            when(supportFragmentManager.findFragmentById(R.id.fragmentContainer)) {
                is SearchVenuesListFragment -> {
                    supportActionBar?.setDisplayHomeAsUpEnabled(false)
                    supportActionBar?.title = getString(R.string.venue_list)
                }
            }
        }
    }

}