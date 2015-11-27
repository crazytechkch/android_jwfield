package co.crazytech.jwfield.terrsurvey;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

import co.crazytech.jwfield.R;

/**
 * Created by eric on 11/27/2015.
 */
public class TerrsurveyListAdapter extends BaseAdapter {
    private List<Terrsurvey> terrsurveys;
    private Context context;

    public TerrsurveyListAdapter(List<Terrsurvey> terrsurveys, Context context) {
        this.terrsurveys = terrsurveys;
        this.context = context;
    }

    @Override
    public int getCount() {
        return terrsurveys.size();
    }

    @Override
    public Object getItem(int position) {
        return terrsurveys.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView==null) {
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.listitem_terrsurvey,null);
        }

        return convertView;
    }
}
