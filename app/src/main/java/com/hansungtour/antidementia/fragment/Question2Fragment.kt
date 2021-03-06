package com.hansungtour.antidementia.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs


import com.hansungtour.antidementia.R
import kotlinx.android.synthetic.main.fragment_question2.* //...fragment_question**Number**.*

class Question2Fragment : Fragment(), View.OnClickListener {
    //val args: Question2Fragment by navArgs()

    lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_question2, container, false) //fragment_question 수정
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)

        op1.setOnClickListener(this)
        op2.setOnClickListener(this)
        op3.setOnClickListener(this)
        next.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        //val action =  Question2FragmentDirections.actionQuestion2FragmentToQuestion3Fragment(score) //Question**Number**FragmentDirections.actionQuestion**Number**FragmentToQuestion**Number**Question

        when(v?.id) { //0==오답, 1==정답, score[Number] Number가 0인 경우 1번문제
            R.id.op1->{score[1] = 0}
            R.id.op2->{score[1] = 1} //이 문제 같은 경우 여기가 정답
            R.id.op3->{score[1] = 0}
            R.id.next->{navController.navigate(R.id.action_question2Fragment_to_question3Fragment)}
        }
    }
}
