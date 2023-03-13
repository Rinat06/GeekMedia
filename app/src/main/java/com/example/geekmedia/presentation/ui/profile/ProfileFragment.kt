package com.example.geekmedia.presentation.ui.profile

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.example.geekmedia.databinding.FragmentProfileBinding
import com.example.geekmedia.presentation.base.BaseFragment


private val getContent: ActivityResultLauncher<String> =
    registerForActivityResult(ActivityResultContracts.GetContent()) { imageUri: Uri? ->
//

        Glide.with(this).load(imageUri.toString()).into(binding.ivPicture)
        pref.saveImage(imageUri.toString())
    }



class ProfileFragment : BaseFragment<FragmentProfileBinding>() {
    override fun inflateViewBinding(inflater: LayoutInflater): FragmentProfileBinding {
        return FragmentProfileBinding.inflate(layoutInflater)
        companion object {
            const val CONTENT_TYPE = "image/*"
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.avatarProfile.setOnClickListener {
            getContent.launch(CONTENT_TYPE)
        }
    }
}