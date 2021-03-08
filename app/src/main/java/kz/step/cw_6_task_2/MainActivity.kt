package kz.step.cw_6_task_2

import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {

    var capture_btn: Button? = null
    var image_view: ImageView? = null

    val REQUEST_IMAGE_CAPTURE = 1001

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initializeViews()
        initializeLiseners()
    }

    private fun initializeViews() {
        capture_btn = findViewById(R.id.capture_btn)
        image_view = findViewById(R.id.image_view)
    }

    private fun initializeLiseners() {
        capture_btn?.setOnClickListener{
            val takePicture = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(takePicture, REQUEST_IMAGE_CAPTURE)
            val imageBitmap = takePicture.extras?.get("data") as Bitmap
            image_view?.setImageBitmap(imageBitmap)
        }
    }





}