package com.example.fragmenttransaction;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FragmentThree.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FragmentThree#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentThree extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;

    private Button frag1, frag2, frag3, frag4;

    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public FragmentThree() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentThree.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentThree newInstance(String param1, String param2) {
        FragmentThree fragment = new FragmentThree();
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
        View view = inflater.inflate(R.layout.fragment_fragment_three, container, false);
        init(view);
        return view;
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
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    private void init(View view)
    {
        frag1 = view.findViewById(R.id.f3_frag1);
        frag2 = view.findViewById(R.id.f3_frag2);
        frag3 = view.findViewById(R.id.f3_frag3);
        frag4 = view.findViewById(R.id.f3_frag4);

        frag1.setOnClickListener(this);
        frag2.setOnClickListener(this);
        frag3.setOnClickListener(this);
        frag4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        fragmentManager = getFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();

        switch (v.getId())
        {
            case R.id.f3_frag1:
                fragmentTransaction.replace(R.id.frameLayout, new FragmentOne());
                break;
            case R.id.f3_frag2:
                fragmentTransaction.replace(R.id.frameLayout, new FragmentTwo());
                break;
            case R.id.f3_frag3:
                fragmentTransaction.replace(R.id.frameLayout, new FragmentThree());
                break;
            case R.id.f3_frag4:
                fragmentTransaction.replace(R.id.frameLayout, new FragmentFour());
                break;

        }

        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .addToBackStack(String.valueOf(fragmentManager.getBackStackEntryCount()))
                .commit();



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
