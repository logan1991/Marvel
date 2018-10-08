package com.oskarszymczyk.suhero.ui.welcome

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.constraint.ConstraintSet
import android.support.v7.widget.LinearLayoutManager
import android.transition.AutoTransition
import android.transition.TransitionManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.oskarszymczyk.suhero.R
import com.oskarszymczyk.suhero.base.Injectable
import com.oskarszymczyk.suhero.databinding.WelcomeFragmentInitBinding
import com.oskarszymczyk.suhero.extensions.showToolbar
import com.oskarszymczyk.suhero.ui.adapters.WelcomeAdapter
import com.oskarszymczyk.suhero.ui.utils.InfiniteScrollListener
import dagger.android.support.DaggerFragment
import javax.inject.Inject


class WelcomeFragment : DaggerFragment(), Injectable {

    @Inject
    lateinit var viewModel: WelcomeViewModel

    private lateinit var welcomeFragmentBinding: WelcomeFragmentInitBinding

    private val constraintSet = ConstraintSet()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {


        welcomeFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.welcome_fragment_init, container, false)
        showToolbar()

        welcomeFragmentBinding.viewModel = viewModel
        initRecyclerView()

        return welcomeFragmentBinding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        view.post { animateLayout() }
    }

    private fun animateLayout() {
        constraintSet.clone(context, R.layout.welcome_fragment_view)

        val transition = AutoTransition()
        transition.duration = 1200

        TransitionManager.beginDelayedTransition(welcomeFragmentBinding.welcomeConstraint, transition)
        constraintSet.applyTo(welcomeFragmentBinding.welcomeConstraint)
    }

    private fun initRecyclerView() {
        val recyclerviewLayoutManager = LinearLayoutManager(context)
        val recyclerViewAdapter = WelcomeAdapter()
        welcomeFragmentBinding.welcomeRecyclerView.layoutManager = recyclerviewLayoutManager
        welcomeFragmentBinding.welcomeRecyclerView.adapter = recyclerViewAdapter

        welcomeFragmentBinding.welcomeRecyclerView.addOnScrollListener(InfiniteScrollListener { viewModel.lastItemIsVisible() })
    }

}

