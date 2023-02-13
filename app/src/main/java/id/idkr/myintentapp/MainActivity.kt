package id.idkr.myintentapp

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var btnExampleActivity: Button
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnMoveActivity: Button = findViewById(R.id.btn_move_activity)
        btnMoveActivity.setOnClickListener(this)

        val btnMoveWithDataActivity: Button =findViewById(R.id.btn_move_with_data)
        btnMoveWithDataActivity.setOnClickListener(this)

        val btnDialPhone: Button = findViewById(R.id.btn_dial_number)
        btnDialPhone.setOnClickListener(this)

        val btnFileAcesss: Button = findViewById(R.id.btn_file_access)
        btnFileAcesss.setOnClickListener(this)

        btnExampleActivity = findViewById(R.id.btn_example)
        btnExampleActivity.setOnClickListener {
            val moveIntentExample = Intent(this@MainActivity, MoveExampleActivity::class.java)
            startActivity(moveIntentExample)
        }
    }

    override fun onClick(v: View?) {
        when (v?.id){
            R.id.btn_move_activity -> {
            val moveIntent = Intent(this@MainActivity, MoveActivity::class.java)
                startActivity(moveIntent)
            }
            R.id.btn_move_with_data -> {
                val moveDatawithIntent = Intent(this@MainActivity, MoveWithDataActivity::class.java)
                moveDatawithIntent.putExtra(MoveWithDataActivity.EXTRA_NAME, "DEWANTARA")
                moveDatawithIntent.putExtra(MoveWithDataActivity.EXTRA_AGE, 5)
                startActivity(moveDatawithIntent)
            }
            R.id.btn_dial_number -> {
                val phoneNumber = "000100"
                val dialPhoneIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
                startActivity(dialPhoneIntent)
            }
            R.id.btn_file_access -> {
                val accessFile = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                startActivity(accessFile)
            }
        }
    }

}