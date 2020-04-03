package com.learn.buttonanimation

import android.animation.Animator
import android.animation.AnimatorInflater
import android.animation.AnimatorSet
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val mSetTopDown: AnimatorSet by lazy {
        AnimatorInflater.loadAnimator(this, R.animator.out_animation) as AnimatorSet
    }

    private val mSetBottomUp: AnimatorSet by lazy {
        AnimatorInflater.loadAnimator(this, R.animator.in_animation) as AnimatorSet
    }

    private var isGoToBagVisible = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnAdd.setOnClickListener {
            flipCard()

        }
        btnRemove.setOnClickListener {

        }
    }

    private fun flipCard() {
        if (!isGoToBagVisible) {
            mSetTopDown.setTarget(btnAdd)
            mSetBottomUp.setTarget(btnRemove)
            mSetTopDown.start()
            mSetBottomUp.start()
            mSetTopDown.addListener(object : Animator.AnimatorListener {
                override fun onAnimationRepeat(animation: Animator?) {
                }

                override fun onAnimationEnd(animation: Animator?) {
                    btnAdd.visibility = View.INVISIBLE
                }

                override fun onAnimationCancel(animation: Animator?) {
                }

                override fun onAnimationStart(animation: Animator?) {
                }

            })
            isGoToBagVisible = true
        }
    }
}
