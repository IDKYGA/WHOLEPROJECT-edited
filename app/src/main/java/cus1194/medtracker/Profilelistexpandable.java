package cus1194.medtracker;

/**
 * Created by liu on 3/22/17.
 */
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;
import java.util.List;
import java.util.Map;
import android.widget.TextView;
import java.util.List;
import java.util.Map;

public class Profilelistexpandable extends BaseExpandableListAdapter {

    Context context;
    List<String> patients;
    Map<String, List<String>> topics;


    public Profilelistexpandable(Context context, List<String> patients, Map<String, List<String>> topics) {
        this.context = context;
        this.patients = patients;
        this.topics = topics;
    }

    public Profilelistexpandable(List<String> patients, Map<String, List<String>> topics) {

    }

    @Override
    public int getGroupCount() {
        return patients.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return topics.get(patients.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return patients.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return topics.get(patients.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {

        String patients = (String) getGroup(groupPosition);
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.profileparent,null);

        }
        TextView txtParent = (TextView) convertView.findViewById(R.id.txtParent);
        txtParent.setText(patients);

        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {

        String topics = (String) getChild(groupPosition, childPosition);

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.profileparent,null);

        }
        TextView txtChild = (TextView) convertView.findViewById(R.id.txtChild);
        txtChild.setText(topics);

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

}