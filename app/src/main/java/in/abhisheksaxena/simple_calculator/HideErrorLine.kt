package `in`.abhisheksaxena.layouttutorial

import android.text.Editable
import android.text.TextWatcher
import com.google.android.material.textfield.TextInputLayout


/**
 * @author Abhishek Saxena
 * @since 22-05-2020 01:28
 */

class HideErrorLine(private val layout : TextInputLayout) : TextWatcher{
    override fun afterTextChanged(p0: Editable?) {
    }

    override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
    }

    override fun onTextChanged(text: CharSequence?, p1: Int, p2: Int, p3: Int) {
        layout.isErrorEnabled = false
    }

}