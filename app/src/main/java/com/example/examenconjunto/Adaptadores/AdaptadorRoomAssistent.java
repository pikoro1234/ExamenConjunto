package com.example.examenconjunto.Adaptadores;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.examenconjunto.ConexionRoom.AssistentRoom;
import com.example.examenconjunto.R;

import java.util.List;

public class AdaptadorRoomAssistent extends RecyclerView.Adapter<AdaptadorRoomAssistent.ListadoRoomDBViewHolder> {

    List<AssistentRoom> ListadoAssistentRoom;

    public AdaptadorRoomAssistent(List<AssistentRoom> listadoAssistentRoom) {

        this.ListadoAssistentRoom = listadoAssistentRoom;
    }

    public AdaptadorRoomAssistent.ListadoRoomDBViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemlistroom,null,false);

        return new ListadoRoomDBViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorRoomAssistent.ListadoRoomDBViewHolder holder, int position) {

        holder.nombre.setText(ListadoAssistentRoom.get(position).getNombreAsistente());
        holder.apellido.setText(ListadoAssistentRoom.get(position).getApellido());
        holder.correo.setText(ListadoAssistentRoom.get(position).getCorreo());
        holder.telefono.setText(ListadoAssistentRoom.get(position).getTelefono());




    }

    @Override
    public int getItemCount() {
        return ListadoAssistentRoom.size();
    }


    public class ListadoRoomDBViewHolder extends RecyclerView.ViewHolder {
        TextView nombre, apellido,correo,telefono,edad;

        public ListadoRoomDBViewHolder(@NonNull View itemView) {
            super(itemView);

            nombre = (TextView) itemView.findViewById(R.id.tnombre);

            apellido = (TextView) itemView.findViewById(R.id.tapellidos);

            correo = (TextView) itemView.findViewById(R.id.tcorreo);

            telefono = (TextView) itemView.findViewById(R.id.ttelefomo);

            edad= (TextView) itemView.findViewById(R.id.tedad);
        }
    }
}
