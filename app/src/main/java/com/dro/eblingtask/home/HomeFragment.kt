package com.dro.eblingtask.home

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dro.eblingtask.R
import com.dro.eblingtask.baseApp.BaseFragment
import com.dro.eblingtask.databinding.FragmentHomeBinding
import com.dro.eblingtask.filter.adapter.SortByAdapter
import com.dro.eblingtask.utils.errorMessage
import com.dro.eblingtask.utils.hideLoadingDialog
import com.dro.eblingtask.utils.showLoadingDialog
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.bottom_sheet_lay.view.*
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : BaseFragment() , TrendMovieAdapter.OnMovieClickListener, AdapterView.OnItemSelectedListener {

    private lateinit var viewModel: TrendMovieViewModel
    private lateinit var binding: FragmentHomeBinding
    lateinit var loading: Dialog
    var page = 1
    lateinit var array : ArrayList<Result>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        loading = Dialog(requireContext())

        viewModel = ViewModelProvider(this).get(TrendMovieViewModel::class.java)

        binding = FragmentHomeBinding.inflate(this.layoutInflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initListeners()
        initObservers()
    }

    override fun initListeners() {

        // spinner to sorting , display types from array "sort"
        sortingSp.adapter = SortByAdapter(
            requireContext(), R.layout.item_sort_by, resources.getStringArray(
                R.array.sort
            )
        )
        sortingSp.onItemSelectedListener = this
        //init recyclerview
        trend_movie_recyclerview.layoutManager = LinearLayoutManager(requireContext())

       // paging


    }



    override fun initObservers() {
        // show loading
        viewModel.showLoading.observe(viewLifecycleOwner, Observer {
            if (it)
                loading.showLoadingDialog()
            else
                loading.hideLoadingDialog()

        })
        // show error
        viewModel.error.observe(viewLifecycleOwner, Observer {
            if (it.status_message != null)
                errorMessage(it.status_message)
        })
        //observe data to send it to adapter to display it in recyclerview
        viewModel.trendMovie.observe(viewLifecycleOwner, Observer {
            trend_movie_recyclerview.adapter = TrendMovieAdapter(it.results, this)
        })

        viewModel.getTrendMovies("popularity.desc", page)
//        page++
//        getSec()

        //observe live data emitted by view model
//        lifecycleScope.launch {
//            viewModel.flow.collectLatest { pagingData ->
//                TrendMovieAdapter.submitData(pagingData)
//            }
//        }

    }

//    private fun getSec() {
//        viewModel.getTrendMovies("popularity.desc" , page)
//        page++
//    }

    override fun onMovieClicked(result: Result) {

    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {

        when (p2) {

            1 -> {
                viewModel.getTrendMovies("popularity.desc", page)
            }
            2 -> {
                viewModel.getTrendMovies("revenue.asc", page)
            }
            3 -> {
                viewModel.getTrendMovies("release_date.asc", page)
            }

        }


    }

    override fun onNothingSelected(p0: AdapterView<*>?) {


    }


}