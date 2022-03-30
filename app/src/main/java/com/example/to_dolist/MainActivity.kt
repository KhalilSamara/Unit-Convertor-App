/************************************************
 Unit Convertor Application
 Khalil Samara
 20200836
************************************************/


package com.example.to_dolist

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    //var units = arrayOf("kilometre","metre", "centimetre", "millimetre", "micrometre", "Mile", "Yard", "foot", "Inch")
    //@SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //var amount: Float = findViewById<EditText>(R.id.enterAmt).text.toString().toFloat()
        var amount: EditText = findViewById(R.id.enterAmt)
        val result: Button = findViewById(R.id.bResult)
        val dispRes: TextView = findViewById(R.id.textViewResult)
        var value: Float = 0F

        var message: TextView = findViewById(R.id.tvMessage)

        var x: String = "kilometre"
        var y: String = "kilometre"

        var spFrom: Spinner = findViewById(R.id.spFrom)
        var options = arrayOf("kilometre","metre", "centimetre", "millimetre", "micrometre", "Mile", "Yard", "foot", "Inch")
        spFrom.adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,options)

        var spTo : Spinner = findViewById(R.id.spTo)
        var units = arrayOf("kilometre","metre", "centimetre", "millimetre", "micrometre", "Mile", "Yard", "foot", "Inch")
        spTo.adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,units)

        result.setOnClickListener{
            var amount2: Float = amount.text.toString().toFloat()

            //Changes value from entered unit to cm
            if (x=="kilometre") {
                value=amount2*100000F
            }else if(x=="metre"){
                value=amount2*100F
            }else if(x=="millimetre"){
                value=amount2/10F
            }else if(x=="micrometre"){
                value=amount2/10000F
            }else if(x=="Mile"){
                value=amount2*160934F
            }else if(x=="Yard"){
                value=amount2*91.44F
            }else if(x=="foot"){
                value=amount2*30.48F
            }else if(x=="Inch"){
                value=amount2*2.54F
            }else{
                //value=amount2
            }

            //changes value from cm to selected unit
            if(y=="kilometre"){
                value /= 100000F
            }else if(y=="metre"){
                value /= 100F
            }else if(y=="millimetre"){
                value *= 10F
            }else if(y=="micrometre"){
                value *= 10000F
            }else if(y=="Mile"){
                value /=  160934F
            }else if(y=="Yard"){
                value /= 91.44F
            }else if(y=="foot"){
                value /= 30.48F
            }else if(y=="Inch"){
                value /= 2.54F
            }else {
                //value=amount2
            }

            dispRes.text = value.toString()

            message.setText("\n ${amount2} ${x}(s) = ${value} ${y}(s)")
            }

        spFrom.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                x = options.get(p2) //p2 is the index of selected item
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        spTo.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                y = units.get(p2) //p2 is the index of selected item
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }
    }
}

