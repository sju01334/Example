package com.example.example

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import com.example.example.databinding.CustomviewBinding

class CustomView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
    defStyleRes: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    init {
        val binding = CustomviewBinding.inflate(LayoutInflater.from(context), this, true)

        binding.root.context.obtainStyledAttributes(
            attrs,
            R.styleable.CustomView,
            defStyleAttr,
            defStyleRes
        ).apply {
            getResourceId(R.styleable.CustomView_bg, R.color.white).apply {
                binding.clBackground.setBackgroundResource(this)
            }
            getResourceId(R.styleable.CustomView_icon, R.mipmap.ic_launcher_round).apply {
                binding.ivLogo.setImageDrawable(ContextCompat.getDrawable(context, this))
            }
            getString(R.styleable.CustomView_title).apply {
                binding.tvTitle.text = this ?: ""
            }

            recycle()
        }
    }


}
