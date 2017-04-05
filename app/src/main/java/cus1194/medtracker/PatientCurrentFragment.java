package cus1194.medtracker;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ExpandableListView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;

import java.util.HashMap;
import java.util.List;




/**
 * A simple {@link Fragment} subclass.
 */
public class PatientCurrentFragment extends Fragment implements View.OnClickListener  {

    private ExpandableListView listView;
    private ExpandableListAdapter listAdapter;
    private List<String> medStatus;
    private HashMap<String, List<String>> medications;
    View v;
    EditText bp;
    EditText w;
    Button addMed;
    Button edMed;
    private DatabaseReference databaseReference;
    private FirebaseAuth firebaseAuth;

    public PatientCurrentFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         //Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_current, container, false);
        return v;
    }




    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        bp = (EditText)v.findViewById(R.id.bloodPressureEdit);
        w = (EditText)v.findViewById(R.id.weightEdit);
        listView = (ExpandableListView)v.findViewById(R.id.medicationList);
        addMed = (Button)v.findViewById(R.id.addMed);
        edMed = (Button)v.findViewById(R.id.edMed);

        listView.setAdapter(listAdapter);



    }

    private void saveVitalInfo()
    {
        String bloodP = bp.getText().toString().trim();
        String weight = w.getText().toString().trim();

        VitalInfo vitalInfo = new VitalInfo(bloodP, weight);

        FirebaseUser vitals = firebaseAuth.getCurrentUser();

        databaseReference.child(vitals.getUid()).setValue(vitalInfo);
    }

    @Override
    public void onClick(View view)
    {
        if (view == addMed) {
            saveVitalInfo();
            Intent intent = new Intent(PatientCurrentFragment.this.getActivity(), AddMed.class);
            startActivity(intent);
        }

        if (view == edMed)
        {
            saveVitalInfo();
            Intent intent2 = new Intent(PatientCurrentFragment.this.getActivity(), EdMed.class);
            startActivity(intent2);
        }


    }



}
