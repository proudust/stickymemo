package io.github.proudust.stickymemo.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import io.github.proudust.stickymemo.R
import io.github.proudust.stickymemo.databinding.MainFragmentBinding
import io.github.proudust.stickymemo.util.dataBinding
import org.koin.android.ext.android.inject

class MainFragment : Fragment(R.layout.main_fragment) {

    private val binding: MainFragmentBinding by dataBinding()
    private val viewModel: MainViewModel by inject()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        // TODO: Use the ViewModel
    }

}
