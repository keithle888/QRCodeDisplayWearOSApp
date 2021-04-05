package com.tenko.qrcodedisplaywear

import android.R.attr.bitmap
import android.os.Bundle
import android.support.wearable.activity.WearableActivity
import android.util.Log
import android.widget.ImageView
import androidmads.library.qrgenearator.QRGContents
import androidmads.library.qrgenearator.QRGEncoder
import com.google.zxing.WriterException


class MainActivity : WearableActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Enables Always-on
        setAmbientEnabled()
    }

    override fun onStart() {
        super.onStart()

        // Initializing the QR Encoder with your value to be encoded, type you required and Dimension
        // Initializing the QR Encoder with your value to be encoded, type you required and Dimension
        val inputValue = "https://www.safeentry-qr.gov.sg/tenant/PROD-201528946R-7374-IGLOOHOMEPTELTD-SE"
        val qrgEncoder = QRGEncoder(inputValue, null, QRGContents.Type.TEXT, 320)
        try {
            // Getting QR-Code as Bitmap
            val bitmap = qrgEncoder.bitmap
            // Setting Bitmap to ImageView
            findViewById<ImageView>(R.id.qr_code).setImageBitmap(bitmap)
        } catch (e: WriterException) {
            Log.v("TAG", e.toString())
        }
    }
}