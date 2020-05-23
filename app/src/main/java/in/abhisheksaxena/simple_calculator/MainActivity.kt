package `in`.abhisheksaxena.simple_calculator

import `in`.abhisheksaxena.layouttutorial.HideErrorLine
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupSpinner()

        firstNumberEditText.addTextChangedListener(HideErrorLine(firstNumberLayout))
        secondNumberEditText.addTextChangedListener(HideErrorLine(secondNumberLayout))

        calculateButton.setOnClickListener {
            val firstNumberString = firstNumberEditText.text.toString()
            val secondNumberString = secondNumberEditText.text.toString()

            if (firstNumberString.isEmpty()) {
                firstNumberLayout.error = "First Number field is empty."
                return@setOnClickListener
            }

            if (secondNumberString.isEmpty()) {
                secondNumberLayout.error = "Second Number field is empty."
                return@setOnClickListener
            }

            val firstNumber = firstNumberEditText.text.toString().toDouble()
            val secondNumber = secondNumberEditText.text.toString().toDouble()

            val operation = operatorsSpinner.text.toString()

            val result: Double? = when (operation) {
                ADD -> firstNumber + secondNumber
                SUBTRACT -> firstNumber - secondNumber
                MULTIPLY -> firstNumber * secondNumber
                DIVIDE -> firstNumber / secondNumber
                else -> null
            }
            resultTextView.text =
                if (result != null) ("Result: $result") else ("Invalid Operation!")
        }
    }

    private fun setupSpinner() {
        val operators = listOf(ADD, SUBTRACT, MULTIPLY, DIVIDE)
        ArrayAdapter(this, R.layout.drop_down_menu_item, operators).also { adapter ->
            operatorsSpinner.setAdapter(adapter)
            operatorsSpinner.setText(operators[0], false)
        }
    }

    companion object {
        const val ADD = "Add"
        const val SUBTRACT = "Subtract"
        const val MULTIPLY = "Multiply"
        const val DIVIDE = "Divide"
    }
}
