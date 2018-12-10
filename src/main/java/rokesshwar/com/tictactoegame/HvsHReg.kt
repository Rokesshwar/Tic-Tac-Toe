package rokesshwar.com.tictactoegame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_hvs_h_registation.*
import kotlinx.android.synthetic.main.activity_main.*


class HvsHReg : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ok.setOnClickListener {

            val name1 = ed1.text.toString()
            val name2 = ed2.text.toString()
            val nm1 = name1.toUpperCase()
            val nm2 = name2.toUpperCase()
            if(nm1.isEmpty() && nm2.isNotEmpty()){
                Toast.makeText(this,"Enter Player 1 name",Toast.LENGTH_LONG).show()
            }
            if(nm1.isNotEmpty() && nm2.isEmpty()){
                Toast.makeText(this,"Enter player 2 name",Toast.LENGTH_LONG).show()
            }
            if(nm1.isEmpty() && nm2.isEmpty()){
                Toast.makeText(this,"Enter player names",Toast.LENGTH_LONG).show()
            }
            else if(nm1.isNotEmpty()&& nm2.isNotEmpty()){
                startGame(nm1,nm2)

            }


        }
//        val stub = findViewById<View>(R.id.activity_main) as ViewStub
//        stub.layoutResource = R.layout.whatever_layout_you_want
//        val inflated = stub.inflate()
info.setOnClickListener {
    val intent=Intent(this,DeveloperDetails::class.java)
    startActivity(intent)
}

    }

    private fun startGame(name1 : String, name2 : String) {
        val intent = Intent(this, HvsH::class.java)
        val bundle=Bundle()
        bundle.putString("1", name1)
        bundle.putString("2", name2)
        intent.putExtra("firstbundle", bundle)
        startActivity(intent)
    }

}
