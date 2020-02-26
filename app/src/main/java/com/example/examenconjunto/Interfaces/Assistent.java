package com.example.examenconjunto.Interfaces;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.room.Room;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.examenconjunto.ConexionRoom.MetodosRoom;
import com.example.examenconjunto.ConexionRoom.MyDatabaseRoom;
import com.example.examenconjunto.R;


public class Assistent extends Fragment {


    private OnFragmentInteractionListener mListener;

    public static MyDatabaseRoom myDatabaseRoom;

    final MetodosRoom metodosRoom = new MetodosRoom();

    TextView nombre,apellido,correo,telefono,edad;

    Button insertar;

    public Assistent() {
        // Required empty public constructor
    }

    public static Assistent newInstance(String param1, String param2) {
        Assistent fragment = new Assistent();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vista = inflater.inflate(R.layout.fragment_assistent, container, false);

        nombre = vista.findViewById(R.id.nomAssistentEditText);

        apellido = vista.findViewById(R.id.cognomAssistentEditText);

        correo = vista.findViewById(R.id.emailAssistentEditText);

        telefono = vista.findViewById(R.id.telefonAssistentEditText);

        edad = vista.findViewById(R.id.edatAssistentEditText);

        insertar = vista.findViewById(R.id.button2);

        insertar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //instancia a la conexion y objetos de la clase MyDatabaseRoom de Room y creamos la base de datos
                myDatabaseRoom = Room.databaseBuilder(getActivity().getApplicationContext(),MyDatabaseRoom.class,"assistentRoom.db").allowMainThreadQueries().build();

                metodosRoom.insertarAssistentRoom(nombre.getText().toString(),apellido.getText().toString(),correo.getText().toString(),telefono.getText().toString(), Integer.parseInt(edad.getText().toString()));

                showMessage("Assistent insertado");

                myDatabaseRoom.close();


            }
        });






        return vista;
    }

    //metodo simplifica toask y lo ejecuta en una funcion
    public void showMessage(String message){

        Toast.makeText(getActivity(),message,Toast.LENGTH_SHORT).show();
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
