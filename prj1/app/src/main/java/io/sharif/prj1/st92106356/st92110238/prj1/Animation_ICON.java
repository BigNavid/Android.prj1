package io.sharif.prj1.st92106356.st92110238.prj1;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

/**
 * Created by Navid on 4/10/16.
 */
public class Animation_ICON extends Fragment{
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.animation_icon_fragment, container, false);
        ImageView imageView = (ImageView) view.findViewById(R.id.animation_icon);
        Animation animation = AnimationUtils.loadAnimation(getActivity().getApplicationContext(), R.anim.go_anim);
        imageView.startAnimation(animation);
        return view;
    }
}
