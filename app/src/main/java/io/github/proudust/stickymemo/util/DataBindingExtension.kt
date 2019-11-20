package io.github.proudust.stickymemo.util

import android.view.ViewGroup
import androidx.annotation.MainThread
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.get
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

@MainThread
fun <V : ViewDataBinding> AppCompatActivity.dataBinding(): Lazy<V> = object : Lazy<V> {

    private var holder: V? = null

    override fun isInitialized(): Boolean = holder != null

    override val value: V
        get() = holder
            ?: DataBindingUtil.bind<V>(findViewById<ViewGroup>(android.R.id.content)[0])!!.also {
                holder = it
                lifecycle.addObserver(object : LifecycleObserver {
                    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
                    fun onDestroy() {
                        lifecycle.removeObserver(this)
                        holder = null
                    }
                })
            }

}

fun <V : ViewDataBinding> Fragment.dataBinding(): Lazy<V> = object : Lazy<V> {

    private var holder: V? = null

    override fun isInitialized(): Boolean = holder != null

    override val value: V
        get() = holder ?: DataBindingUtil.bind<V>(view!!)!!.also {
            holder = it
            viewLifecycleOwner.lifecycle.addObserver(object : LifecycleObserver {
                @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
                fun onDestroyView() {
                    viewLifecycleOwner.lifecycle.removeObserver(this)
                    holder = null
                }
            })
        }

}
