package com.example.assessmentapp.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.assessmentapp.R
import com.example.assessmentapp.data.local.db.AppDatabase
import com.example.assessmentapp.data.remote.Constants
import com.example.assessmentapp.data.remote.RetrofitService
import com.example.assessmentapp.data.repository.VenueListRepository
import com.example.assessmentapp.databinding.SearchVenuesListFragmentBinding
import com.example.assessmentapp.ui.adapter.VenuesAdapter
import com.example.assessmentapp.ui.model.VenueListModel
import com.example.assessmentapp.ui.viewmodel.VenueListViewModel
import com.example.assessmentapp.ui.viewmodel.VenueListViewModelProvider
import com.example.assessmentapp.util.MyDispatchers
import java.util.*

class SearchVenuesListFragment : Fragment(), VenuesAdapter.RecyclerViewClickListener,
    View.OnClickListener {

    private var venuesAdapter: VenuesAdapter? = null
    private var viewModel: VenueListViewModel? = null
    private var _viewBinding: SearchVenuesListFragmentBinding? = null
    private val viewBinding: SearchVenuesListFragmentBinding
        get() = _viewBinding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _viewBinding = SearchVenuesListFragmentBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        initViewModel()
        initObservers()
        setClickListeners()
    }

    private fun initViews() {
        val actionBar = (activity as AppCompatActivity).supportActionBar
        actionBar?.title = getString(R.string.venue_list)
        venuesAdapter = VenuesAdapter()
        viewBinding.venuesRecyclerView.adapter = venuesAdapter
        viewBinding.venuesRecyclerView.layoutManager = LinearLayoutManager(activity)
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

        viewModel?.venueListLiveData?.observe(viewLifecycleOwner, { venueDetails ->
            venueDetails?.let {
                venuesAdapter?.setVenueList(it)
            }
        })
    }

    private fun setClickListeners() {
        venuesAdapter?.setRecyclerViewClick(this)
        viewBinding.searchButton.setOnClickListener(this)
    }

    override fun onRecyclerViewClick(venueListModel: VenueListModel) {
        val searchVenuesDetailsFragment =
            SearchVenuesDetailsFragment()
        val bundle = Bundle()
        bundle.putString(Constants.VENUE_ID, venueListModel.venueId)
        bundle.putString(Constants.TITLE, venueListModel.venueName)
        searchVenuesDetailsFragment.arguments = bundle
        activity
            ?.supportFragmentManager
            ?.beginTransaction()
            ?.add(
                R.id.fragmentContainer,
                searchVenuesDetailsFragment,
                SearchVenuesDetailsFragment::class.java.simpleName
            )
            ?.addToBackStack(SearchVenuesDetailsFragment::class.java.simpleName)
            ?.commit()
    }

    override fun onClick(view: View?) {

        if (viewBinding.enterPlaceEditText.text.toString().isNotEmpty()) {
            viewModel?.getVenueList(
                viewBinding.enterPlaceEditText.text.toString().toLowerCase(Locale.getDefault())
            )
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _viewBinding = null
        venuesAdapter = null
    }

}