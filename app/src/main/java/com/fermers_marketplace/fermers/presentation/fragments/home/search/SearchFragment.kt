package com.fermers_marketplace.fermers.presentation.fragments.home.search

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.fermers_marketplace.fermers.R
import com.fermers_marketplace.fermers.data.model.AdvertModel
import com.fermers_marketplace.fermers.databinding.FragmentSearchBinding

class SearchFragment : Fragment(R.layout.fragment_search) {

    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        deleteClearBtn()
        searchCharacterListener()

        val items = mutableListOf(
            AdvertModel(R.drawable.horse, "Продаю лошадь", "Цена 120тыс"),
            AdvertModel(R.drawable.cow, "Продаю корову", "Цена 80тыс"),
            AdvertModel(R.drawable.ram, "Продаю барана", "Цена 50тыс"),
            AdvertModel(R.drawable.horse, "Продаю лошадь", "Цена 120тыс"),
            AdvertModel(R.drawable.cow, "Продаю корову", "Цена 80тыс"),
            AdvertModel(R.drawable.ram, "Продаю барана", "Цена 50тыс"),
            AdvertModel(R.drawable.horse, "Продаю лошадь", "Цена 120тыс"),
            AdvertModel(R.drawable.cow, "Продаю корову", "Цена 80тыс"),
            AdvertModel(R.drawable.ram, "Продаю барана", "Цена 50тыс"),
            AdvertModel(R.drawable.horse, "Продаю лошадь", "Цена 120тыс"),
            AdvertModel(R.drawable.cow, "Продаю корову", "Цена 80тыс"),
            AdvertModel(R.drawable.ram, "Продаю барана", "Цена 50тыс"),
            AdvertModel(R.drawable.horse, "Продаю лошадь", "Цена 120тыс"),
            AdvertModel(R.drawable.cow, "Продаю корову", "Цена 80тыс"),
            AdvertModel(R.drawable.ram, "Продаю барана", "Цена 50тыс"),
            AdvertModel(R.drawable.horse, "Продаю лошадь", "Цена 120тыс"),
            AdvertModel(R.drawable.cow, "Продаю корову", "Цена 80тыс"),
            AdvertModel(R.drawable.ram, "Продаю барана", "Цена 50тыс"),
            AdvertModel(R.drawable.horse, "Продаю лошадь", "Цена 120тыс"),
            AdvertModel(R.drawable.cow, "Продаю корову", "Цена 80тыс"),
            AdvertModel(R.drawable.ram, "Продаю барана", "Цена 50тыс"),
        )
    }

    private fun searchCharacterListener() {
        binding.etSearch.addTextChangedListener(object : TextWatcher {

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {}
        })
    }

    private fun deleteClearBtn() {
        binding.deleteClearBtn.setOnClickListener {
            if (binding.etSearch.text != null) {
                binding.etSearch.text = null
                binding.etSearch.clearFocus()
            }
        }
    }

}