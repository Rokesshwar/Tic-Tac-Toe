package rokesshwar.com.tictactoegame

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_developer_details.*

class DeveloperDetails : AppCompatActivity() {
    private val mobNumber = 7010874153
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_developer_details)


        call.setOnClickListener {
            onCall()
        }




        Sms.setOnClickListener {
            onSms()
        }

    }


    private fun onCall() {
        val permissionCheck = ContextCompat.checkSelfPermission(this, android.Manifest.permission.CALL_PHONE)
        if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(
                this, arrayOf(android.Manifest.permission.CALL_PHONE), "123".toInt()
            )
        } else {
            val intent = Intent(Intent.ACTION_CALL)
            intent.data = Uri.parse("tel:$mobNumber")
            startActivity(intent)
        }
    }

    private fun onSms() {
        val permissionCheck = ContextCompat.checkSelfPermission(this, android.Manifest.permission.SEND_SMS)
        if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(
                this, arrayOf(android.Manifest.permission.SEND_SMS), "123".toInt()
            )
        } else {
            val smsIntent = Intent(Intent.ACTION_SENDTO)
            smsIntent.addCategory(Intent.CATEGORY_DEFAULT)
            smsIntent.type = "vnd.android-dir/mms-sms";
            smsIntent.data = Uri.parse("sms:$mobNumber")
        }
    }

}




