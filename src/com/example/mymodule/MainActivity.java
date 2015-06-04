package com.example.mymodule;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.module.R;
import com.module.arcmenu.ArcMenuActivity;
import com.module.drawerlayout.DrawerLayout;
import com.module.refresh.Refresh;
import com.module.tabs.Tabs2;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		findViewById(R.id.drawerlayout).setOnClickListener(
				new View.OnClickListener() {

					public void onClick(View v) {
						startActivity(new Intent().setClass(MainActivity.this,
								DrawerLayout.class));
					}
				});
		findViewById(R.id.tabs).setOnClickListener(
				new View.OnClickListener() {

					public void onClick(View v) {
						startActivity(new Intent().setClass(MainActivity.this,
								Tabs2.class));
					}
				});
		findViewById(R.id.arcmenu).setOnClickListener(
				new View.OnClickListener() {

					public void onClick(View v) {
						startActivity(new Intent().setClass(MainActivity.this,
								ArcMenuActivity.class));
					}
				});
		findViewById(R.id.refresh).setOnClickListener(
				new View.OnClickListener() {

					public void onClick(View v) {
						startActivity(new Intent().setClass(MainActivity.this,
								Refresh.class));
					}
				});
	}
}
