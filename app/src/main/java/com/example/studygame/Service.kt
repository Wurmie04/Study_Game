package com.example.studygame

import android.content.Context
import android.util.Log
import android.widget.TextView
import com.github.kittinunf.fuel.Fuel
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

fun submitAddServiceReq(myScore : Int) {
    val sendScore = convertScore(myScore)
    val jsonStr = Json.encodeToString(sendScore)

    //cannot use https
    Fuel.post("http://192.168.0.15:8080/StudyGame/addMCScore").body(jsonStr).response {
        request, response, result ->

        var (data,error) = result
        if(data != null){
            val fStr = String(data!!)
            Log.d("Web Service Log", "Data returned from Rest Server: $fStr")
        }
        else {
            Log.d("Web Service Log!!!!!!!!", "${error}")
        }
    }
}
fun submitGetHSServiceReq(t : TextView){
    var sScore = 0
    //get high scores for Multiple Choice
    Fuel.get("http://192.168.0.15:8080/StudyGame/MCHighScore").response(){
            request,response,result->
        val (data,error) = result
        if(data!=null){
            val fStr = String(data)
            sScore = Json.decodeFromString(fStr)
            t.text = sScore.toString()
        }
        else
            Log.d("Web Service Log", "${error}")
    }
}