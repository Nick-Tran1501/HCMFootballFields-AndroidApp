package com.example.hcmfootballfields_asm1_tranchannam_s3804825.utils

import android.content.Context
import android.util.Log
import com.example.hcmfootballfields_asm1_tranchannam_s3804825.models.DebuggingIdentifiers
import java.io.BufferedReader
import java.io.InputStreamReader

fun readJSON(context: Context, path: String): String {
    val identifier = "[ReadJSON]"
    try {
        val file = context.assets.open("$path")
        Log.i(
            identifier,
            "${DebuggingIdentifiers.actionOrEventSucceded} Found File: $file.",
        )
        val bufferedReader = BufferedReader(InputStreamReader(file))
        val stringBuilder = StringBuilder()
        bufferedReader.useLines { lines ->
            lines.forEach {
                stringBuilder.append(it)
            }
        }
        /* Log.i(
             identifier,
             "getJSON  ${DebuggingIdentifiers.actionOrEventSucceded} stringBuilder: $stringBuilder.",
         )*/
        val jsonString = stringBuilder.toString()
        /*Log.i(
            identifier,
            "${DebuggingIdentifiers.actionOrEventSucceded} JSON as String: $jsonString.",
        )*/
        return jsonString
    } catch (e: Exception) {
        Log.e(
            identifier,
            "${DebuggingIdentifiers.actionOrEventFailed} Error reading JSON: $e.",
        )
        e.printStackTrace()
        return ""
    }
}