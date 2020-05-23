package `in`.abhisheksaxena.simple_calculator

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

        calculateButton.setOnClickListener{
            val firstNumberString = numberOneEditText.text.toString()
            val secondNumberString = numberTwoEditText.text.toString()

            if (firstNumberString.isEmpty()) {
                Toast.makeText(this, "Enter first number.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (secondNumberString.isEmpty()) {
                Toast.makeText(this, "Enter second number.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val firstNumber = firstNumberString.toDouble()
            val secondNumber = secondNumberString.toDouble()

            val operation = operatorSpinner.selectedItem.toString()

            val result: Double? = when (operation) {
                ADD -> firstNumber + secondNumber
                SUBTRACT -> firstNumber - secondNumber
                MULTIPLY -> firstNumber * secondNumber
                DIVIDE -> firstNumber / secondNumber
                else -> null
            }

            resultTextView.text = if(result != null) ("Result: $result") else ("Invalid Operation")
        }

    }

    private fun setupSpinner(){
        val operators = listOf(ADD, SUBTRACT, MULTIPLY, DIVIDE)

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, operators)
        operatorSpinner.adapter = adapter
    }

    companion object{
        const val ADD = "Add"
        const val SUBTRACT = "Subtract"
        const val MULTIPLY = "Multiply"
        const val DIVIDE = "Divide"
    }
}
