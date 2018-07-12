package view.pager.sample.android;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class ScreenSlidePageFragment extends Fragment {
    private ArrayList<ImageData> imageDataArrayList;
    private int currentDisplayPosition;
    private TextView urlTextView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_screen_slide_page, container, false);

        urlTextView = rootView.findViewById(R.id.urlTextView);
        receiveDataFromBundle();
        setDataToShow();
        return rootView;
    }

    private void setDataToShow() {
        imageDataArrayList.get(currentDisplayPosition).getImageUrl();
    }

    private void receiveDataFromBundle() {
        Bundle bundle = getArguments();
        currentDisplayPosition = bundle.getInt(AppConstants.BUNDLE_KEY_IMAGE_OPENED);
        imageDataArrayList = bundle.getParcelableArrayList(AppConstants.BUNDLE_KEY_IMAGE_DATA_ARRAY);
        if (urlTextView != null)
            urlTextView.setText(imageDataArrayList.get(currentDisplayPosition).getImageUrl());
    }
}