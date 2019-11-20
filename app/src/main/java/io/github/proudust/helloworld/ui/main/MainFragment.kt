package io.github.proudust.helloworld.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import io.github.proudust.helloworld.R
import io.github.proudust.helloworld.databinding.MainFragmentBinding
import io.github.proudust.helloworld.util.dataBinding
import org.koin.android.ext.android.inject

class MainFragment : Fragment(R.layout.main_fragment) {

    private val binding: MainFragmentBinding by dataBinding()
    private val viewModel: MainViewModel by inject()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        // TODO: Use the ViewModel
    }

}
