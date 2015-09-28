package com.example.yingyouji.UI;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.yingyouji.R;

public class PersonFragment extends Fragment{
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view=inflater.inflate(R.layout.person_fragment_layout, container,false);
		TextView tv=(TextView) view.findViewById(R.id.id_tv_person_page);
		tv.setText("这是个人页面");
		return view;
	}

}
