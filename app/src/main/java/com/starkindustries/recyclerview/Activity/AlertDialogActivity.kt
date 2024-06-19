package com.starkindustries.recyclerview.Activity
import android.content.DialogInterface
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.starkindustries.recyclerview.R
import com.starkindustries.recyclerview.databinding.ActivityAlertDialogBinding
class AlertDialogActivity : AppCompatActivity() {
    lateinit var binding:ActivityAlertDialogBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_alert_dialog)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_alert_dialog)
        binding.singleButton.setOnClickListener()
        {
            var singleAlertDialog: AlertDialog = AlertDialog.Builder(this).create()
            singleAlertDialog.setIcon(R.drawable.check)
            singleAlertDialog.setTitle("Congratulations")
            singleAlertDialog.setMessage("You are now the most complete pprogrammer in the world")
            singleAlertDialog.setButton(DialogInterface.BUTTON_POSITIVE,"Ok",object :DialogInterface.OnClickListener{
                override fun onClick(dialog: DialogInterface?, which: Int) {
                    Toast.makeText(applicationContext, "You are the most complete programmer in the world", Toast.LENGTH_SHORT).show()
                }
            })
            singleAlertDialog.show()
        }
        binding.doubleButton.setOnClickListener()
        {
            val dialog = AlertDialog.Builder(this)
            dialog.setIcon(R.drawable.delete)
            dialog.setTitle("Delete")
            dialog.setMessage("Are you sure, you want to delete?")
            dialog.setCancelable(false)
            dialog.setPositiveButton("Yes",object:DialogInterface.OnClickListener{
                override fun onClick(dialog: DialogInterface?, which: Int)
                {
                    Toast.makeText(applicationContext, "File Deleted Sucessfully", Toast.LENGTH_SHORT).show()
                }
            })
            dialog.setNegativeButton("No",object:DialogInterface.OnClickListener{
                override fun onClick(dialog: DialogInterface?, which: Int) {

                }
            })
            dialog.show()
        }
        binding.tripleButton.setOnClickListener(){
            var dialog = AlertDialog.Builder(this)
            dialog.setIcon(R.drawable.download)
            dialog.setTitle("Download")
            dialog.setMessage("Are you sure you want to download")
            dialog.setPositiveButton("Yes",object:DialogInterface.OnClickListener{
                override fun onClick(dialog: DialogInterface?, which: Int) {
                    Toast.makeText(applicationContext, "File Downloaded successfully", Toast.LENGTH_SHORT).show()
                    if (dialog != null) {
                        dialog.dismiss()
                    }
                }

            })
            dialog.setNegativeButton("No",object:DialogInterface.OnClickListener{
                override fun onClick(dialog: DialogInterface?, which: Int) {

                }

            })
            dialog.setNeutralButton("cancel",object:DialogInterface.OnClickListener
            {
                override fun onClick(dialog: DialogInterface?, which: Int) {

                }

            })
            dialog.show()
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}