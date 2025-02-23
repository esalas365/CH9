package com.salas.msu.criminalintent

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import com.salas.msu.criminalintent.databinding.FragmentCrimeDetailBinding

import java.util.*




class CrimeDetailFragment :Fragment() {

   lateinit var crime: Crime
    //private lateinit var binding : FragmentCrimeDetailBinding
    private var _binding : FragmentCrimeDetailBinding? = null

            private val binding
                get() = checkNotNull(_binding){
                    "Cannot access binding because it is null. Is the view visible"

                }
    val crimeSolvedStatus: Boolean
        get() = crime.isSolved

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        crime = Crime(

            UUID.randomUUID(),
            title = "",
            date = Date(),
            isSolved = false

        )

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        //binding = FragmentCrimeDetailBinding.inflate(layoutInflater, container, false)
        _binding = FragmentCrimeDetailBinding.inflate(layoutInflater, container, false)

        return binding.root
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.apply {

            crimeTitle.doOnTextChanged{text,_,_,_->
                crime = crime.copy(title = text.toString())

            }

            crimeDate.apply{
                text = crime.date.toString()
                isEnabled = false


            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        //binding = null
        _binding = null
    }
}



