package com.example.exo6tdm2


import android.widget.TextView
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class SeanceActivity (private val mCtx: Context, private val seancesList: List<Seance>) :
    RecyclerView.Adapter<SeanceActivity.TasksViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TasksViewHolder {
        val view = LayoutInflater.from(mCtx).inflate(R.layout.seance, parent, false)
        return TasksViewHolder(view)

    }

    override fun onBindViewHolder(holder: TasksViewHolder, position: Int) {
        val t = seancesList[position]
        holder.textViewModule.setText(t.getModule())
        holder.textViewDate.setText(t.getJour())
        holder.textViewDateDeb.setText(t.getHeureDeb())
        holder.textViewDateFin.setText(t.getHeureFin())
        holder.textViewSalle.setText(t.getSale())
        holder.textViewEns.setText(t.getEnseignant())

    }

    override fun getItemCount(): Int {
        return seancesList.size
    }

    inner class TasksViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

        var textViewModule: TextView
        var textViewDate: TextView
        var textViewDateDeb: TextView
        var textViewDateFin: TextView
        var textViewSalle: TextView
        var textViewEns: TextView
        init {

            textViewModule = itemView.findViewById(R.id.module)
            textViewDate = itemView.findViewById(R.id.jour)
            textViewDateDeb = itemView.findViewById(R.id.dateDeb)
            textViewDateFin = itemView.findViewById(R.id.dateFin)
            textViewSalle = itemView.findViewById(R.id.Salle)
            textViewEns = itemView.findViewById(R.id.enseignant)

            itemView.setOnClickListener(this)
        }

        override fun onClick(view: View) {
            val note = seancesList[adapterPosition]


         //   val intent = Intent(mCtx, updateNoteActivity::class.java)
           // intent.putExtra("task", note)
            //mCtx.startActivity(intent)
        }
    }

}