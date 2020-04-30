package com.example.exercice4

import androidx.core.content.ContextCompat.startActivity
import android.content.Intent
import android.R.*
import android.content.Context
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.nio.file.Files.size
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker


class TasksAdapter(private val mCtx: Context, private val taskList: List<note>) :
    RecyclerView.Adapter<TasksAdapter.TasksViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TasksViewHolder {
        val view = LayoutInflater.from(mCtx).inflate(R.layout.recyclerview, parent, false)
        return TasksViewHolder(view)
    }

    override fun onBindViewHolder(holder: TasksViewHolder, position: Int) {
        val t = taskList[position]
        holder.textViewTask.setText(t.getTitre())
        holder.textViewDesc.setText(t.getDescription())
        holder.textViewFinishBy.setText(t.getColor())
        holder.textViewdate.setText(t.getDate())

    }

    override fun getItemCount(): Int {
        return taskList.size
    }

    inner class TasksViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

        var textViewStatus: TextView
        var textViewTask: TextView
        var textViewDesc: TextView
        var textViewFinishBy: TextView
        var textViewdate: TextView

        init {

            textViewStatus = itemView.findViewById(R.id.textViewStatus)
            textViewTask = itemView.findViewById(R.id.textViewTask)
            textViewDesc = itemView.findViewById(R.id.textViewDesc)
            textViewFinishBy = itemView.findViewById(R.id.textViewFinishBy)
            textViewdate = itemView.findViewById(R.id.textViewdate)

            itemView.setOnClickListener(this)
        }

        override fun onClick(view: View) {
            val note = taskList[adapterPosition]

            val intent = Intent(mCtx, updateNoteActivity::class.java)
            intent.putExtra("task", note)
            mCtx.startActivity(intent)
        }
    }
}