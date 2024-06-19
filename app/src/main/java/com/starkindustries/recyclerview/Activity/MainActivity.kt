package com.starkindustries.recyclerview.Activity
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.starkindustries.recyclerview.Adapter.RecyclerViewAdapter
import com.starkindustries.recyclerview.Data.Data
import com.starkindustries.recyclerview.Model.Contact
import com.starkindustries.recyclerview.R
import com.starkindustries.recyclerview.databinding.ActivityMainBinding
class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    lateinit var name:AppCompatEditText
    lateinit var phoneNo:AppCompatEditText
    lateinit var addButton:AppCompatButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        binding= DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.recyclerView.layoutManager=LinearLayoutManager(applicationContext)
        var arraylist:ArrayList<Contact> = ArrayList<Contact>()
        arraylist.add(Contact(R.drawable.chotaadi,"Aditya","1111111111"))
        arraylist.add(Contact(R.drawable.boy_one,"Sandeep","22222222222"))
        arraylist.add(Contact(R.drawable.boy_three,"Kelaskar","33333333333"))
        arraylist.add(Contact(R.drawable.boy_two,"Nidish","4444444444"))
        arraylist.add(Contact(R.drawable.chutiya_one,"Palak","5555555555"))
        arraylist.add(Contact(R.drawable.girl_three,"Deepak","66666666666"))
        arraylist.add(Contact(R.drawable.girlone,"Shonali","77777777777"))
        arraylist.add(Contact(R.drawable.girl_three,"Roohi","8888888888"))
        arraylist.add(Contact(R.drawable.boy_two,"Sanchita","99999999999"))
        arraylist.add(Contact(R.drawable.girl_three,"Rutuja","11111111111"))
        arraylist.add(Contact(R.drawable.boy_two,"Rushikesh" ,"22222222222"))
        arraylist.add(Contact(R.drawable.chotaadi,"Ravindra","3333333333"))
        arraylist.add(Contact(R.drawable.girl_three,"Sarita","4444444444"))
        arraylist.add(Contact(R.drawable.boy_two,"sampada","5555555555"))
        arraylist.add(Contact(R.drawable.boy_three,"Sarvesh","666666666"))
        arraylist.add(Contact(R.drawable.boy_one,"Pichka","77777777777"))
        arraylist.add(Contact(R.drawable.girl_three,"Deepak","8888888888"))
        arraylist.add(Contact(R.drawable.girlone,"Minakshi","99999999999"))
        arraylist.add(Contact(R.drawable.chotaadi,"Shantaram","111111111"))
        binding.recyclerView.adapter=RecyclerViewAdapter(applicationContext, arraylist)
        binding.add.setOnClickListener()
        {
            var adapter:RecyclerViewAdapter= RecyclerViewAdapter(applicationContext,arraylist)
            var dialog:Dialog = Dialog(this)
            dialog.setContentView(R.layout.add_contact)
            name=dialog.findViewById(R.id.addName)
            phoneNo=dialog.findViewById(R.id.addPhoneNo)
            addButton=dialog.findViewById(R.id.addButton)
            addButton.setOnClickListener()
            {
                var view= this.currentFocus
                if(view!=null)
                {
                    var manager : InputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                    manager.hideSoftInputFromWindow(view.windowToken,0)
                }
                var data:Data = Data()
                arraylist.add(Contact(R.drawable.chotaadi,name.text.toString().trim(),phoneNo.text.toString().trim()))
                adapter.notifyItemInserted(arraylist.size-1)
                binding.recyclerView.scrollToPosition(arraylist.size-1)
                dialog.dismiss()
            }
            dialog.show()
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}