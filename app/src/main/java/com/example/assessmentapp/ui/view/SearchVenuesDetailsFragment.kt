package com.example.assessmentapp.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.assessmentapp.R
import com.example.assessmentapp.data.local.db.AppDatabase
import com.example.assessmentapp.data.remote.Constants
import com.example.assessmentapp.data.remote.RetrofitService
import com.example.assessmentapp.data.repository.VenueListRepository
import com.example.assessmentapp.databinding.SearchVenuesDetailsFragmentBinding
import com.example.assessmentapp.ui.model.VenueDetailsModel
import com.example.assessmentapp.ui.viewmodel.VenueListViewModel
import com.example.assessmentapp.ui.viewmodel.VenueListViewModelProvider
import com.example.assessmentapp.util.MyDispatchers
import com.squareup.picasso.Picasso

class SearchVenuesDetailsFragment : Fragment() {

    private var viewModel: VenueListViewModel? = null
    private var _viewBinding: SearchVenuesDetailsFragmentBinding? = null
    private val viewBinding: SearchVenuesDetailsFragmentBinding
        get() = _viewBinding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _viewBinding = SearchVenuesDetailsFragmentBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)
        initViews()
        initViewModel()
        initObservers()
        venueDetailsCall()
    }


    private fun initViews() {
        val actionBar = (activity as AppCompatActivity).supportActionBar
        actionBar?.title = arguments?.getString(Constants.TITLE)
        actionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun initViewModel() {
        context?.let { safeContext ->
            RetrofitService.getInstance()?.let { retrofitService ->
                val myDispatchersImpl = MyDispatchers()
                viewModel = ViewModelProvider(
                    this,
                    VenueListViewModelProvider(
                        VenueListRepository(
                            retrofitService,
                            myDispatchersImpl,
                            AppDatabase.getInstance(safeContext)
                        ),
                        myDispatchersImpl
                    )
                ).get(VenueListViewModel::class.java)
            }
        }
    }

    private fun initObservers() {
        viewModel?.showProgressLiveData?.observe(viewLifecycleOwner, { showProgressBar ->
            viewBinding.progressBar.visibility =
                if (showProgressBar) View.VISIBLE else View.GONE
        })

        viewModel?.venueDetailsLiveData?.observe(viewLifecycleOwner, {
            updateUI(it)
        })
    }

    private fun venueDetailsCall() {
        arguments?.getString(Constants.VENUE_ID)?.let { safeVenueId ->
            viewModel?.getVenueDetails(safeVenueId)
        }
    }

    private fun updateUI(venueDetailsModel: VenueDetailsModel?) {
        context?.let { safeContext ->
            if (venueDetailsModel?.venueImageUrl.isNullOrEmpty()) {
                viewBinding.venueDetailsImageView.visibility = View.GONE
            } else {
                Picasso.with(safeContext)
                    .load(venueDetailsModel?.venueImageUrl)
                    .fit()
                    .centerCrop()
                    .into(viewBinding.venueDetailsImageView)
            }

            if (venueDetailsModel?.venueRating.isNullOrEmpty()) {
                viewBinding.venueDetailsRatingTextView.visibility = View.GONE
            } else {
                viewBinding.venueDetailsRatingTextView.text = String.format(
                    safeContext.getString(R.string.rating_out_of_10),
                    venueDetailsModel?.venueRating.toString()
                )
            }

            if (venueDetailsModel?.venueDescription.isNullOrEmpty()) {
                viewBinding.venueDetailsDescriptionTextView.visibility = View.GONE
            } else {
                viewBinding.venueDetailsDescriptionTextView.text = String.format(
                    safeContext.getString(R.string.description_text),
                    venueDetailsModel?.venueDescription
                )
            }

            if (venueDetailsModel?.venueContact.isNullOrEmpty()) {
                viewBinding.venueContactInfoTextView.visibility = View.GONE
            } else {
                viewBinding.venueContactInfoTextView.text = String.format(
                    safeContext.getString(R.string.contact_info_text),
                    venueDetailsModel?.venueContact
                )
            }

            if (venueDetailsModel?.venueAddress.isNullOrEmpty()) {
                viewBinding.venueDetailsAddressTextView.visibility = View.GONE
            } else {
                viewBinding.venueDetailsAddressTextView.text = String.format(
                    safeContext.getString(R.string.address_text),
                    venueDetailsModel?.venueAddress
                )
            }

        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                activity?.supportFragmentManager?.popBackStack()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _viewBinding = null
    }

}