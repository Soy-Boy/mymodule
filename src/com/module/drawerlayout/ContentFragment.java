package com.module.drawerlayout;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.module.R;

public class ContentFragment extends Fragment {
	  
	private TextView textView;
	  
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.drawerlayout_content_fragment, container,false);
		textView = (TextView) view.findViewById(R.id.drawerlayout_content_fragment_text);
		String text = getArguments().getString("text");
		textView.setText(text);
		return view;
	}

}
