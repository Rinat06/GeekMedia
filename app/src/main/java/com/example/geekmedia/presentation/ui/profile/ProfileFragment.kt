package com.example.geekmedia.presentation.ui.profile

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.navigation.fragment.findNavController
import com.example.geekmedia.R
import com.example.geekmedia.databinding.FragmentProfileBinding
import com.example.geekmedia.presentation.base.BaseFragment


class ProfileFragment(override val companion: Unit) : BaseFragment<FragmentProfileBinding>() {
    override fun inflateViewBinding(inflater: LayoutInflater): FragmentProfileBinding {
        return FragmentProfileBinding.inflate(layoutInflater)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnSettingsProfile.setOnClickListener {
            findNavController().navigate(R.id.settingsFragment)
        }
    }
}

