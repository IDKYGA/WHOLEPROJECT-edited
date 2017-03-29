package cus1194.medtracker;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ExpandableListView;

import java.util.HashMap;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class PatientCurrentFragment extends Fragment
{

    private ExpandableListView listView;
    private ExpandableListAdapter listAdapter;
    private List<String> medStatus;
    private HashMap<String, List<String>> medications;
    View v;

    public PatientCurrentFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_current, container, false);
        return v;
    }

    EditText bp;
    EditText w;
    ExpandableListView elv;

    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);


        bp = (EditText)v.findViewById(R.id.bloodPressureEdit);
        w = (EditText)v.findViewById(R.id.weightEdit);
        ExpandableListView elv = (ExpandableListView)v.findViewById(R.id.medicationList);

        elv.setAdapter(listAdapter);

        bp.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v)
            {
                String input = bp.getText().toString();
                if(null!=input && input.length()>0)
                {
                    medStatus.add(input);
                    listAdapter.notifyDataSetChanged();
                }
            }
        });

    }



}
