package com.module.drawerlayout;

import java.util.ArrayList;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.module.R;

public class DrawerLayout extends Activity implements OnItemClickListener{
	
	private android.support.v4.widget.DrawerLayout drawerLayout;
	private ListView listView;
	private ArrayList<String> alist;
	private ArrayAdapter<String> adapter;
	  
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.drawerlayout);
		
		//ActionBar添加点击返回按钮
		ActionBar actionBar = getActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);
		
		drawerLayout = (android.support.v4.widget.DrawerLayout) findViewById(R.id.drawer_layout);
		listView = (ListView) findViewById(R.id.left_drawer);
		alist  = new ArrayList<String>();
		for (int i = 0; i<5; i++)
		{
			alist.add("界面"+i);
		}
		adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1,alist);
		listView.setAdapter(adapter);
		listView.setOnItemClickListener(this);
	}

	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		Fragment contentFragment = new ContentFragment();
		Bundle args = new Bundle();
		args.putString("text", alist.get(position));
		System.out.println("position是："+alist.get(position));
		contentFragment.setArguments(args);
		
		FragmentManager fm = getFragmentManager();
		fm.beginTransaction().replace(R.id.content_frame, contentFragment).commit();
		drawerLayout.closeDrawer(listView);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
		switch(item.getItemId()){
		case android.R.id.home:
			finish();
			break;
		case R.id.main_search:
			startActivity(new Intent().setClass(DrawerLayout.this,DrawerLayoutSearch.class));
			break;
		case R.id.main_setting:
			Toast.makeText(getApplicationContext(), "设置", 1).show();
			break;
		case R.id.main_share:
			Toast.makeText(getApplicationContext(), "分享", 1).show();
			break;
		case R.id.main_collect:
			Toast.makeText(getApplicationContext(), "收藏", 1).show();
			break;
		case R.id.main_copy:
			Toast.makeText(getApplicationContext(), "复制", 1).show();
			break;
		case R.id.main_daddy:
			Toast.makeText(getApplicationContext(), "你大爷，骂谁呢？！！", 1).show();
			break;
		}
		return super.onMenuItemSelected(featureId, item);
	}

}
