package com.hansungtour.antidementia.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation

import com.hansungtour.antidementia.R
import kotlinx.android.synthetic.main.fragment_question.* //...fragment_question**Number**.*

var score = IntArray(20) //초기 배열 수정 금지 QuestionFragment(1번문제)에서 최초 생성

class QuestionFragment : Fragment(), View.OnClickListener {

    lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_question, container, false) //fragment_question 수정
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)

        for (index in 0..19) {
            score[index] = 0
        }

        op1.setOnClickListener(this)
        op2.setOnClickListener(this)
        op3.setOnClickListener(this)
        next.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        //val action = QuestionFragmentDirections.actionQuestionFragmentToQuestion2Fragment(score) //Question**Number**FragmentDirections.actionQuestion**Number**FragmentToQuestion**Number**Question
        when(v?.id) { //0==오답, 1==정답
            R.id.op1->{score[0] = 0}
            R.id.op2->{score[0] = 1} //이 문제 같은 경우 여기가 정답
            R.id.op3->{score[0] = 0}
            R.id.next->{navController.navigate(R.id.action_questionFragment_to_question2Fragment)} //R.id.action_question**Number**Fragment_to_question**Number**Fragment 자동생성
        }
    }
}
