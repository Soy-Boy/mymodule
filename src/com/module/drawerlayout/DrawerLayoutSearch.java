package com.module.drawerlayout;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import com.example.module.R;

public class DrawerLayoutSearch extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.drawerlayout_search);

		// 设置输入法默认打开
		getWindow().setSoftInputMode(
				WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE
						| WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
		
		findViewById(R.id.drawerlayout_search_back).setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				finish();
				
			}
		});
	}
}
