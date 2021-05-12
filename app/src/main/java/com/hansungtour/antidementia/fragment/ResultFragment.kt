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
import kotlinx.android.synthetic.main.fragment_result.*

/**
 * A simple [Fragment] subclass.
 */
class ResultFragment : Fragment(), View.OnClickListener {

    lateinit var navController: NavController

    val ResultFragmentArgs by navArgs<ResultFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_result, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)

        var sum = 0
        for(index in 0..19) {
            sum = sum + score[index]
        }
        if (sum >= 10) {
            resultMsg.text = "치매가 아닐 확률이 70%이상입니다. \n" +
                    "기억력은 잘 유지되고 있으나 추후에 나빠지는 느낌이 있다면 언제나 가까운 보건소에 방문하셔서 무료로 제공하는 치매검진을 받아보시기 바랍니다.\n"
        }
        else {
            resultMsg.text = "치매일 확률이70%이상입니다. \n" +
                    "가까운 보건소에 방문하셔서 무료로 제공하는 치매검진을 받아 보시기 바랍니다.\n"
        }

        restart.setOnClickListener(this)
        gotomain.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.restart->{navController.navigate(R.id.action_resultFragment_to_questionFragment)}
            R.id.gotomain->{navController.navigate(R.id.action_resultFragment_to_mainFragment)}
        }
    }

}
