package cus1194.medtracker;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

/**
 * Created by pruan086 on 3/7/2017.
 */

public class ExpandableListAdapter extends BaseExpandableListAdapter
{

    private Context context;
    private List<String> status;
    private HashMap<String,List<String>> medications;

    public ExpandableListAdapter(Context context, List<String> listDataHeader, HashMap<String, List<String>> listHashMap) {
        this.context = context;
        this.status = listDataHeader;
        this.medications = listHashMap;
    }

    @Override
    public int getGroupCount() {
        return status.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return medications.get(status.get(i)).size();
    }

    @Override
    public Object getGroup(int i) {
        return status.get(i);
    }

    @Override
    public Object getChild(int i, int j) {
        return medications.get(status.get(i)).get(j);
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int j) {
        return j;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        String headerTitle = (String)getGroup(i);
        if(view==null)
        {
            LayoutInflater inflater = (LayoutInflater)this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.fragment_current_listgroup,null);
        }
        TextView lbListHeader = (TextView)view.findViewById(R.id.lbListHeader);
        lbListHeader.setTypeface(null, Typeface.BOLD);
        lbListHeader.setText(headerTitle);
        return view;
    }

    @Override
    public View getChildView(int i, int j, boolean b, View view, ViewGroup viewGroup) {
        final String childText = (String)getChild(i,j);
        if (view==null)
        {
            LayoutInflater inflater = (LayoutInflater)this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.fragment_current_listgroup,null);
        }
        TextView lbListChild = (TextView)view.findViewById(R.id.lbListItem);
        lbListChild.setText(childText);
        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int j) {
        return true;
    }
}
