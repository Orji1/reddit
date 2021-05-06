package com.example.redditassessment.view

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.redditassessment.MainActivity
import com.example.redditassessment.RickMortyApplication
import com.example.redditassessment.databinding.CharacterListFragmentBinding
import com.example.redditassessment.model.CharacterDetail
import com.example.redditassessment.model.ResponseData
import com.example.redditassessment.model.repository.IRepository
import com.example.redditassessment.model.repository.Repository
import com.example.redditassessment.view.adapter.RickMortyAdapter
import com.example.redditassessment.viewmodel.RickMortyViewModel
import com.example.redditassessment.viewmodel.RickMortyViewModelProvider
import javax.inject.Inject

class CharacterListFragment: Fragment() {

    @Inject
    lateinit var repository: IRepository

    @Inject
    lateinit var viewModelProvider: RickMortyViewModelProvider

    private lateinit var binding: CharacterListFragmentBinding

    private lateinit var listener: ShowCharacterDetails

    private lateinit var adapter: RickMortyAdapter

    private val viewModel: RickMortyViewModel by lazy {
        viewModelProvider.create(RickMortyViewModel::class.java)
    }

    interface ShowCharacterDetails{
        fun showDetails(dataItem: CharacterDetail)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        when(context){
            is ShowCharacterDetails-> listener = context
            else -> throw ExceptionInInitializerError("Not Valid Activity")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        RickMortyApplication.component.inject(this)

        binding = CharacterListFragmentBinding.inflate(inflater)

        initViews()

        viewModel.liveData.observe(viewLifecycleOwner){
            when(it){
                is Repository.DataState.Data-> udpateDataSet(it.data)
                is Repository.DataState.Error-> showError(it.errMsg)
                is Repository.DataState.Loading-> isLoading(true)
            }
        }

        return binding.root
    }

    private fun initViews() {
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        adapter = RickMortyAdapter(null, listener)
        binding.recyclerView.adapter = adapter
    }

    private fun isLoading(loading: Boolean) {
        if(loading) binding.loading.visibility = View.VISIBLE
        else binding.loading.visibility = View.GONE
    }

    private fun showError(errMsg: String) {
        isLoading(false)
        Toast.makeText(activity, errMsg, Toast.LENGTH_SHORT).show()
    }

    private fun udpateDataSet(data: ResponseData?) {
        isLoading(false)
        adapter.updateDataSet(data)
    }

}