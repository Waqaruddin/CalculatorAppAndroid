package com.example.calculatorapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {

    var isNewOp = true
    var oldNumber = ""
    var op = "+"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun numberEvent(view: View) {
        if(isNewOp)
            tvResult.setText("")
        isNewOp = false

        var buclick:String = tvResult.text.toString()

       // var buselect:Button = view as Button
        when (view.id) {
            tvOne.id -> {buclick += "1"}
            tvTwo.id -> {buclick += "2"}
            tvThree.id -> {buclick += "3"}
            tvFour.id -> {buclick += "4"}
            tvFive.id -> {buclick += "5"}
            tvSix.id -> {buclick += "6"}
            tvSeven.id -> {buclick += "7"}
            tvEight.id -> {buclick += "8"}
            tvNine.id -> {buclick += "9"}
            tvZero.id -> {buclick += "0"}
            tvDot.id -> {buclick += "."}

        }
        tvResult.setText(buclick)


    }

    @SuppressLint("SetTextI18n")
    fun operatorEvent(view: View) {
        isNewOp = true
        oldNumber = tvResult.text.toString()
//        var buselect:Button = view as Button
        when(view.id){
            tvMul.id -> {op = "*"}
            tvDivide.id -> {op = "/"}
            tvPlus.id -> {op = "+"}
            tvMinus.id -> {op = "-"}

        }



    }

    @SuppressLint("SetTextI18n")
    fun equalEvent(view: View) {
        var newNumber = tvResult.text.toString()
        var result = 0.0
        when(op){
            "+" -> {result = oldNumber.toDouble() + newNumber.toDouble()}
            "-" -> {result = oldNumber.toDouble() - newNumber.toDouble()}
            "*" -> {result = oldNumber.toDouble() * newNumber.toDouble()}
            "/" -> {result = oldNumber.toDouble() / newNumber.toDouble()}

        }
        tvResult.setText( result.toString() )
    }

    fun acEvent(view: View) {
        tvResult.setText("0")
        isNewOp = true

    }

    fun backEvent(view: View) {
        var str:String = tvResult.text.toString()
        if(str.length >1){
            str = str.substring(0, str.length-1)
            tvResult.setText(str)

        }else if (str.length <=1){
            tvResult.setText("0")
        }
        isNewOp = true
    }
}






