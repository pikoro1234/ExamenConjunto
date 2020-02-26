package com.example.examenconjunto.Interfaces;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.examenconjunto.ConexionPSQL.ConexionPsql;
import com.example.examenconjunto.R;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Event.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Event#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Event extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    Button cancelar,insertar;

    String fechaComoCadena,horaComoCadena;

    TextView nombre,lugar,fecha,organizador,sala,precio,aforo,descripcion;


    public Event() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Event.
     */
    // TODO: Rename and change types and number of parameters
    public static Event newInstance(String param1, String param2) {
        Event fragment = new Event();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        //construccion de formateo de fecha
        final SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

        final SimpleDateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");

        fechaComoCadena = sdf.format(new Date());

        horaComoCadena = hourFormat.format(new Date());

        View vista = inflater.inflate(R.layout.fragment_event, container, false);

        //TextView nombre,lugar,fecha,organizador,sala,precio,aforo,descripcion;

        nombre = vista.findViewById(R.id.tnombreevent);

        lugar = vista.findViewById(R.id.tlugarevent);

        fecha = vista.findViewById(R.id.tfechaevent);

        organizador = vista.findViewById(R.id.tcorreevent);

        sala = vista.findViewById(R.id.tsalaevent);

        precio = vista.findViewById(R.id.tprecioevent);

        aforo = vista.findViewById(R.id.taforoevent);

        descripcion = vista.findViewById(R.id.tdescripcionevent);

        insertar = vista.findViewById(R.id.insertarEvent);

        insertar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //String nombreh, String lugarh, String fechah, String organizadorh, String salah, String descripcionh, int precioh, int aforoh
                //instacia de postgres
                final hiloInsertarEvent hilos = new hiloInsertarEvent(nombre.getText().toString(),lugar.getText().toString(),fecha.getText().toString(),organizador.getText().toString(),sala.getText().toString(),descripcion.getText().toString(),Integer.parseInt(precio.getText().toString()),Integer.parseInt(precio.getText().toString()));

                hilos.execute();

            }
        });


        return vista;
    }

    //clase multitarea
    public class hiloInsertarEvent extends AsyncTask<String,Void,String> {

        //TextView nombre,lugar,fecha,organizador,sala,precio,aforo,descripcion;

        private final String nombreh,lugarh,fechah,organizadorh,salah,descripcionh;

        private final int precioh,aforoh;

        public hiloInsertarEvent(String nombreh, String lugarh, String fechah, String organizadorh, String salah, String descripcionh, int precioh, int aforoh) {
            this.nombreh = nombreh;

            this.lugarh = lugarh;

            this.fechah = fechah;

            this.organizadorh = organizadorh;

            this.salah = salah;

            this.descripcionh = descripcionh;

            this.precioh = precioh;

            this.aforoh = aforoh;
        }

        @SuppressLint("WrongThread")
        @Override
        protected String doInBackground(String... strings) {

            ConexionPsql conexionPsql = new ConexionPsql();


            Connection con = null;

            con = conexionPsql.conectar();


            if (con != null){

                try {

                    String insertEvent = "insert into eventdetail(nombre,fecha,lugar,organizador,sala,precio,aforo,descripcion) \n" +
                            "values (?,?,?,?,?,?,?,?);\n";

                    PreparedStatement insercionEventos;

                    insercionEventos = con.prepareStatement(insertEvent);

                    insercionEventos.setString(1,nombre.getText().toString());
                    insercionEventos.setString(2,fechaComoCadena);
                    insercionEventos.setString(3,lugar.getText().toString());
                    insercionEventos.setString(4,organizador.getText().toString());
                    insercionEventos.setString(5,sala.getText().toString());
                    insercionEventos.setInt(6, Integer.parseInt(precio.getText().toString()));
                    insercionEventos.setInt(7, Integer.parseInt(aforo.getText().toString()));
                    insercionEventos.setString(8,descripcion.getText().toString());
                    insercionEventos.executeUpdate();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }




            return null;
        }
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


        /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
