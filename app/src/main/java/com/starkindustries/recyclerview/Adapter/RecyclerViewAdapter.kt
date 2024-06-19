package com.starkindustries.recyclerview.Adapter
import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnLongClickListener
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.starkindustries.recyclerview.Model.Contact
import com.starkindustries.recyclerview.R
open class RecyclerViewAdapter(var context_: Context,studentList_:ArrayList<Contact>):RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewViewHolder>()
{
    lateinit var context:Context
    lateinit var studentList: ArrayList<Contact>
    init
    {
        this.context=context_
        this.studentList=studentList_
    }
    open inner class RecyclerViewViewHolder(var view:View):RecyclerView.ViewHolder(view)
    {
        lateinit var profileImage:AppCompatImageView
        lateinit var name:AppCompatTextView
        lateinit var contact:AppCompatTextView
        lateinit var cardContact:LinearLayoutCompat
        init
        {
            profileImage=view.findViewById(R.id.proifleImage)
            name=view.findViewById(R.id.name)
            contact=view.findViewById(R.id.contact)
            cardContact=view.findViewById(R.id.contactCard)
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewViewHolder
    {
        var view:View = LayoutInflater.from(context).inflate(R.layout.conntactrow,parent,false)
        var viewHolder:RecyclerViewViewHolder=RecyclerViewViewHolder(view)
        return viewHolder
    }
    override fun getItemCount(): Int
    {
    return studentList.size
    }
    override fun onBindViewHolder(holder: RecyclerViewViewHolder, position: Int)
    {
        holder.profileImage.setImageResource(studentList.get(position).profileImage)
        holder.name.setText(studentList.get(position).name)
        holder.contact.setText(studentList.get(position).contactNo)
        holder.itemView.setOnClickListener()
        {
            var dialog:Dialog = Dialog(context.applicationContext)
            dialog.setContentView(R.layout.update_coontact)
            dialog.show()
        }
        holder.itemView.setOnLongClickListener(object:OnLongClickListener{
            override fun onLongClick(v: View?): Boolean {
                studentList.removeAt(holder.getPosition())
                notifyItemRemoved(holder.position)
//                var deleteAlertDialog= AlertDialog.Builder(context)
//                deleteAlertDialog.setIcon(R.drawable.delete)
//                deleteAlertDialog.setTitle("Delete")
//                deleteAlertDialog.setMessage("Are you sure,you want to delete?")
//                deleteAlertDialog.setCancelable(false)
//                deleteAlertDialog.setPositiveButton("Yes",object:DialogInterface.OnClickListener{
//                    override fun onClick(dialog: DialogInterface?, which: Int) {
//
//                    }
//                })
//                deleteAlertDialog.setNegativeButton("No",object:DialogInterface.OnClickListener{
//                    override fun onClick(dialog: DialogInterface?, which: Int) {
//
//                    }
//                })
//                deleteAlertDialog.setNeutralButton("Cancel",object:DialogInterface.OnClickListener{
//                    override fun onClick(dialog: DialogInterface?, which: Int) {
//
//                    }
//                })
//                deleteAlertDialog.show()
                return true
            }
        })


    }
}