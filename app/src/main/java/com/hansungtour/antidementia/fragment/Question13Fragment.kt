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
import kotlinx.android.synthetic.main.fragment_question5.* //...fragment_question**Number**.*

class Question13Fragment : Fragment(), View.OnClickListener {

    lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_question13, container, false) //fragment_question 수정
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
        when(v?.id) { //0==오답, 1==정답, score[Number] Number가 0인 경우 1번문제
            R.id.op1->{score[3] = 0}
            R.id.op2->{score[3] = 0} //이 문제 같은 경우 여기가 정답
            R.id.op3->{score[3] = 1}
            R.id.next->{navController.navigate(R.id.action_question13Fragment_to_question14Fragment)}
        }
    }
}

