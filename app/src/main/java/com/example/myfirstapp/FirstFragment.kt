package com.example.myfirstapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.myfirstapp.R.id.toast_button
import com.example.myfirstapp.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    // add method countMe
    private fun countMe(view: View) {
        // get the text view
        val showCountTextView = view.findViewById<TextView>(R.id.textview_first)

        //get the value of the text view
        val countString = showCountTextView.text.toString()

        // convert value to a number and increment it
        var count = countString.toInt()
        count++

        // display the new value in the text view
        showCountTextView.text = count.toString()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.random_button).setOnClickListener {
            val showCountTextView = view.findViewById<TextView>(R.id.textview_first)

            // get the text of the view and convert it to an Int
            val currentCount = showCountTextView.text.toString().toInt()

            // create an action with currentCount as the argument to actionFirstFragmentToSecondFragment()
            val action = FirstFragmentDirections.actionFirstFragmentToSecondFragment(currentCount)

            //add a line to find the nav controller and navigate with the action created
            findNavController().navigate(action)
        }

        // find the toast_button by it's ID and set a click listener
        view.findViewById<Button>(toast_button).setOnClickListener {
            // create a Toast with some text, to appear for a short time
            val myToast = Toast.makeText(context, "Hello Toast!", Toast.LENGTH_SHORT)
            // show the Toast
            myToast.show()
        }

        view.findViewById<Button>(R.id.count_button).setOnClickListener {
            countMe(view)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}