package com.starkindustries.recyclerview.Data
import com.starkindustries.recyclerview.Model.Contact
import com.starkindustries.recyclerview.R
open class Data
{
    var arraylist:ArrayList<Contact> = ArrayList<Contact>()
    open fun getData():ArrayList<Contact>
    {
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
        return arraylist
    }
    open fun addData( name:String, contactNo:String)
    {
        arraylist.add(Contact(R.drawable.chotaadi,name,contactNo))
    }
}