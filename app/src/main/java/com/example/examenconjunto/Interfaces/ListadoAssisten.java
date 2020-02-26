package com.example.examenconjunto.Interfaces;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.examenconjunto.Adaptadores.AdaptadorRoomAssistent;
import com.example.examenconjunto.ConexionRoom.AssistentRoom;
import com.example.examenconjunto.ConexionRoom.MyDatabaseRoom;
import com.example.examenconjunto.R;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ListadoAssisten.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ListadoAssisten#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListadoAssisten extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    RecyclerView recyclerFichajesRoom;

    AdaptadorRoomAssistent adaptadorRoomFichaje;

    public static MyDatabaseRoom myDatabaseRoom;

    public ListadoAssisten() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ListadoAssisten.
     */
    // TODO: Rename and change types and number of parameters
    public static ListadoAssisten newInstance(String param1, String param2) {
        ListadoAssisten fragment = new ListadoAssisten();
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
        View vista = inflater.inflate(R.layout.fragment_listado_assisten, container, false);

        recyclerFichajesRoom = vista.findViewById(R.id.recyclerFichajesRoom);

        recyclerFichajesRoom.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));

        //instancia a la conexion y objetos de la clase MyDatabaseRoom de Room y creamos la base de datos
        myDatabaseRoom = Room.databaseBuilder(getActivity().getApplicationContext(),MyDatabaseRoom.class,"assistentRoom.db").allowMainThreadQueries().build();

        List<AssistentRoom> listRoom = ListadoAssisten.myDatabaseRoom.utilidadesDao().mostrarUsuarios();

        adaptadorRoomFichaje = new AdaptadorRoomAssistent(listRoom);

        recyclerFichajesRoom.setAdapter(adaptadorRoomFichaje);

        myDatabaseRoom.close();

        return vista;
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
