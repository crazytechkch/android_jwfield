package co.crazytech.jwfield.terrsurvey;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import co.crazytech.jwfield.R;

/**
 * Created by eric on 12/8/2015.
 */
public class TerrsurveyFragment extends Fragment {
    private View rootView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if(rootView==null){
            rootView = inflater.inflate(R.layout.fragment_terrsurvey,container,false);
        }
        return rootView;
    }
}
