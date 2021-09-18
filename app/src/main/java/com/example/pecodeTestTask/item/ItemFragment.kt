package com.example.pecodeTestTask.item

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.pecodeTestTask.databinding.FragmentItemBinding
import java.lang.RuntimeException

class ItemFragment : Fragment() {

    private lateinit var fragmentItemBinding: FragmentItemBinding
    private var fragmentNumber: Int? = 0
    private var size: Int? = 0
    private var onItemFragmentListener: OnItemFragmentListener? = null

    companion object {
        private const val NUMBER = "number"
        private const val SIZE = "size"

        fun newInstance(
            number: Int,
            size: Int
        ): ItemFragment {
            val fragment = ItemFragment()

            val args = Bundle()
            args.putInt(NUMBER, number)
            args.putInt(SIZE, size)
            fragment.arguments = args

            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            fragmentNumber = arguments?.getInt(NUMBER)
            size = arguments?.getInt(SIZE)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentItemBinding = FragmentItemBinding.inflate(layoutInflater)

        bindViews()
        return fragmentItemBinding.root
    }

    private fun bindViews() {
        fragmentItemBinding.createNotificationBtn.setOnClickListener{ createNotificationOnClick()}
        fragmentItemBinding.removeFragment.setOnClickListener{ removeBtnOnClick() }
        fragmentItemBinding.createFragment.setOnClickListener{ createBtnOnClick() }

        fragmentItemBinding.fragmentNumber.text = fragmentNumber.toString()
        fragmentItemBinding.removeFragment.visibility =
            if (fragmentNumber != 1) {
                View.VISIBLE
            } else {
                View.GONE
            }
    }

    private fun createNotificationOnClick() {
        onItemFragmentListener?.createNotification(fragmentNumber)
    }

    private fun createBtnOnClick() {
        onItemFragmentListener?.addFragment()
    }
    private fun removeBtnOnClick() {
        onItemFragmentListener?.removeNotification(fragmentNumber)
        onItemFragmentListener?.removeFragment()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        onItemFragmentListener = if (context is OnItemFragmentListener) {
            context
        } else {
            throw RuntimeException(
                context.toString()
                        + " must implement OnItemFragmentListener"
            )
        }
    }

    override fun onDetach() {
        super.onDetach()
        onItemFragmentListener = null
    }

}
