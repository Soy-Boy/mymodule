package com.module.arcmenu;

import java.util.ArrayList;
import java.util.List;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import com.module.arcmenu.ArcMenu.OnMenuItemClickListener;

import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.module.R;

public class ArcMenuActivity extends Activity {

	private ListView mListView;
	private ArcMenu mArcMenu;
	private List<String> mDatas;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setTitle("ArcMenu");
		setContentView(R.layout.arcmenu);
		
		//ActionBar添加点击返回按钮
		ActionBar actionBar = getActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);

		initData();
		initView();
		mListView.setAdapter(new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, mDatas));

		initEvent();

	}

	private void initEvent()
	{
		mListView.setOnScrollListener(new OnScrollListener()
		{

			public void onScrollStateChanged(AbsListView view, int scrollState)
			{

			}

			public void onScroll(AbsListView view, int firstVisibleItem,
					int visibleItemCount, int totalItemCount)
			{
				if (mArcMenu.isOpen())
					mArcMenu.toggleMenu(600);
			}
		});
		
		mArcMenu.setOnMenuItemClickListener(new OnMenuItemClickListener()
		{
			public void onClick(View view, int pos)
			{
				Toast.makeText(ArcMenuActivity.this, pos+":"+view.getTag(), Toast.LENGTH_SHORT).show();
			}
		});
	}

	private void initData()
	{
		mDatas = new ArrayList<String>();

		for (int i = 'A'; i < 'Z'; i++)
		{
			mDatas.add((char) i + "");
		}

	}

	private void initView()
	{
		mListView = (ListView) findViewById(R.id.id_listview);
		mArcMenu = (ArcMenu) findViewById(R.id.id_menu);
	}
	
	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
		switch(item.getItemId()){
		case android.R.id.home:
			finish();
			break;
		}
		return super.onMenuItemSelected(featureId, item);
	}

}
