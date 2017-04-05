package cus1194.medtracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

/**
 * Created by pruan086 on 3/7/2017.
 */

public class PatientMain extends AppCompatActivity implements View.OnClickListener {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private PatientViewAdapt patientViewAdapt;
    private TextView back;

    @Override
    protected void onCreate(Bundle savedIntanceState)
    {

        super.onCreate(savedIntanceState);
        setContentView(R.layout.patient_main);

        toolbar = (Toolbar)findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
        tabLayout = (TabLayout)findViewById(R.id.tabLayout);
        viewPager = (ViewPager)findViewById(R.id.viewPager);
        back = (TextView)findViewById(R.id.back);

        patientViewAdapt = new PatientViewAdapt(getSupportFragmentManager());

        patientViewAdapt.addFragments(new PatientCurrentFragment(), "Current");
        patientViewAdapt.addFragments(new PatientCalendarFragment(), "Calendar");
        viewPager.setAdapter(patientViewAdapt);
        tabLayout.setupWithViewPager(viewPager);
        back.setOnClickListener(this);

    };



    @Override
    public void onClick(View view) {

        if (view == back)
        {
            finish();
            startActivity(new Intent(this, MainActivity.class));
        }


    }


}
