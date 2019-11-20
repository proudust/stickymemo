package io.github.proudust.stickymemo.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import io.github.proudust.stickymemo.R
import io.github.proudust.stickymemo.databinding.ListFragmentBinding
import io.github.proudust.stickymemo.util.dataBinding
import org.koin.android.ext.android.inject

class ListFragment : Fragment(R.layout.list_fragment) {

    private val binding: ListFragmentBinding by dataBinding()
    private val viewModel: ListViewModel by inject()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        // TODO: Use the ViewModel
    }

}
