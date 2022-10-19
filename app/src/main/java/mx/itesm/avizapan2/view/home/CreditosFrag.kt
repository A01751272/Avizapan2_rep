package mx.itesm.avizapan2.view.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import mx.itesm.avizapan2.R
import mx.itesm.avizapan2.databinding.FragmentCreditosBinding
import mx.itesm.avizapan2.databinding.FragmentMasInfoBinding

class CreditosFrag : Fragment() {

    // binding
    private lateinit var binding: FragmentCreditosBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCreditosBinding.inflate(layoutInflater)
        return binding.root
    }
}