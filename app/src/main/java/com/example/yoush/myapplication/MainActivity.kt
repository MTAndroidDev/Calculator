package com.example.yoush.myapplication

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        num0.setOnClickListener { updateInputView(num0.text as String) }
        num1.setOnClickListener { updateInputView(num1.text as String) }
        num2.setOnClickListener { updateInputView(num2.text as String) }
        num3.setOnClickListener { updateInputView(num3.text as String) }
        num4.setOnClickListener { updateInputView(num4.text as String) }
        num5.setOnClickListener { updateInputView(num5.text as String) }
        num6.setOnClickListener { updateInputView(num6.text as String) }
        num7.setOnClickListener { updateInputView(num7.text as String) }
        num8.setOnClickListener { updateInputView(num8.text as String) }
        num9.setOnClickListener { updateInputView(num9.text as String) }

        add.setOnClickListener {
            updateOperator(add.text as String)
        }
        sub.setOnClickListener {
            updateOperator(sub.text as String)
        }
        mul.setOnClickListener {
            updateOperator(mul.text as String)
        }
        div.setOnClickListener {
            updateOperator(div.text as String)
        }

        result.setOnClickListener {

        }

        delete.setOnClickListener { clearView() }


    }

    private fun clearView() {
        input.text = ""
        operator.text = ""
        output.text = ""
    }


    fun updateOperator(operatorStr: String) {
        var s = operator.text
        operator.text = "$s$operatorStr"
    }


    fun updateInputView(inputStr: String) {
        var s = input.text
        if (input.text == "" || operator.text == "") {
            input.text = "$s$inputStr"
        } else if (isAdd() || isSub() || isMul() || isDiv()) {
            updateOperator(inputStr)
            if (output.text == ""){
                updateOutputView(input.text as String, operator.text.substring(1, operator.text.length))
            } else {
                updateOutputView(output.text as String, operator.text.substring(1,operator.text.length))
            }
        }
    }

    fun updateOutputView(a: String, b: String) {
        /*if (!isMul() && !isDiv() && (isAdd()) && !isSub()) {
            calculateAdd(a, b)
        }*/


        if (isAdd()) {
            calculateAdd(a, b)
        } else if (isSub()) {
            calculateSub(a, b)
        } else if (isMul()) {
            calculateMul(a, b)
        } else if (isDiv()) {
            calculateDiv(a, b)
        }
    }


    private fun calculateDiv(num1: String, num2: String) {
        var x = 0L
        var y = 0L


        try {
            x = num1.toLong()
        } catch (e: NumberFormatException) {
            output.text = getString(R.string.NumberFormatException)
            return
        }

        try {
            y = num2.toLong()
        } catch (e: NumberFormatException) {
            output.text = getString(R.string.NumberFormatException)
            return
        }

        output.text = (x / y).toString()
    }

    private fun calculateMul(num1: String, num2: String) {
        var x = 0L
        var y = 0L


        try {
            x = num1.toLong()
        } catch (e: NumberFormatException) {
            output.text = getString(R.string.NumberFormatException)
            return
        }

        try {
            y = num2.toLong()
        } catch (e: NumberFormatException) {
            output.text = getString(R.string.NumberFormatException)
            return
        }

        output.text = (x * y).toString()
    }

    private fun calculateSub(num1: String, num2: String) {
        var x = 0L
        var y = 0L


        try {
            x = num1.toLong()
        } catch (e: NumberFormatException) {
            output.text = getString(R.string.NumberFormatException)
            return
        }

        try {
            y = num2.toLong()
        } catch (e: NumberFormatException) {
            output.text = getString(R.string.NumberFormatException)
            return
        }

        output.text = (x - y).toString()

    }

    fun calculateAdd(num1: String, num2: String) {
        var x = 0L
        var y = 0L


        try {
            x = num1.toLong()
        } catch (e: NumberFormatException) {
            output.text = getString(R.string.NumberFormatException)
            return
        }

        try {
            y = num2.toLong()
        } catch (e: NumberFormatException) {
            output.text = getString(R.string.NumberFormatException)
            return
        }

        output.text = (x + y).toString()

    }

    fun isAdd(): Boolean {
        return operator.text.contains(getString(R.string.add))
    }

    fun isSub(): Boolean {
        return operator.text.contains(getString(R.string.sub))
    }

    fun isMul(): Boolean {
        return operator.text.contains(getString(R.string.mul))
    }

    fun isDiv(): Boolean {
        return operator.text.contains(getString(R.string.div))
    }

}
