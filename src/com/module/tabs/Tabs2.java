package com.module.tabs;

import java.util.ArrayList;
import java.util.List;

import android.app.ActionBar;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.module.R;

public class Tabs2 extends FragmentActivity {

	private ViewPager mViewPager;
	private FragmentPagerAdapter mAdapter;
	private List<Fragment> mDatas;

	private TextView mChatTextView;
	private TextView mFindTextView;
	private TextView mBookTextView;
	
	private View mTabline;
	
	private int mScreen1_3;//������Ļ��ȵ�1/3
	private int mCurrentPageIndex;//ָʾҳ��

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setTitle("ViewPager");
		setContentView(R.layout.tabs_viewpager);
		
		//���actionBar���ذ�ť
		ActionBar actionBar = getActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);
		
		initTabLine();//��ָʾ�����г�ʼ��������Ϊ��Ļ��ȵ�1/3
		
		initView();// ��������ĳ�ʼ����viewpager,TextView��
	}

	private void initTabLine() {
		mTabline = findViewById(R.id.id_iv_tabline);
		
		//�õ���Ļ�Ŀ��
		Display display = getWindow().getWindowManager().getDefaultDisplay();
		DisplayMetrics outMetrics = new DisplayMetrics();
		display.getMetrics(outMetrics);
		
		mScreen1_3 = outMetrics.widthPixels/3;
		
		LayoutParams lp = mTabline.getLayoutParams();
		//��ָʾ���ĳ���Ϊ��Ļ��1/3
		lp.width = mScreen1_3;
		mTabline.setLayoutParams(lp);
	}

	private void initView() {
		mViewPager = (ViewPager) findViewById(R.id.id_viewpager);
		mChatTextView = (TextView) findViewById(R.id.id_chat);
		mFindTextView = (TextView) findViewById(R.id.id_find);
		mBookTextView = (TextView) findViewById(R.id.id_book);
		mDatas = new ArrayList<Fragment>();
		TabChat tab01 = new TabChat();
		TabFind tab02 = new TabFind();
		TabBook tab03 = new TabBook();

		mDatas.add(tab01);
		mDatas.add(tab02);
		mDatas.add(tab03);

		mAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {

			@Override
			public int getCount() {
				return mDatas.size();
			}

			@Override
			public Fragment getItem(int arg0) {
				return mDatas.get(arg0);
			}
		};

		mViewPager.setAdapter(mAdapter);

		//�����¼���ҳ�滬��
		mViewPager.setOnPageChangeListener(new OnPageChangeListener() {

			//ҳ��ѡ��ʱ���¼�
			public void onPageSelected(int position) {
				resetTextView();
				switch (position) {
				case 0:
					mChatTextView.setTextColor(getResources().getColor(R.color.green));
					break;
				case 1:
					mFindTextView.setTextColor(getResources().getColor(R.color.green));
					break;
				case 2:
					mBookTextView.setTextColor(getResources().getColor(R.color.green));
					break;
				}
				
				mCurrentPageIndex = position;
				
				System.out.println("mCurrentPageIndex:"+mCurrentPageIndex);

			}

			//�����¼��������¼�
			public void onPageScrolled(int position, float positionOffset, 
					int positionOffsetPx) {
				//��������˼
				//        position:��߾����ڽ���id
				//  positionOffset:��ǰҳ��ƫ�Ƶİٷֱ�
				//positionOffsetPx:��ǰҳ��ƫ�Ƶ�����λ�� 
				System.out.println("Tag"+position+","+positionOffset+","
					+positionOffsetPx);
				
				LinearLayout.LayoutParams lp =  (android.widget.LinearLayout.LayoutParams) mTabline.getLayoutParams();
				
				//ҳ�滬�������У���߾�ľ��붯̬�仯
				/*if(mCurrentPageIndex ==0 && position == 0)//0->1ҳ
				{
					lp.leftMargin = (int) (positionOffset*mScreen1_3 
							+ mCurrentPageIndex*mScreen1_3);
				}else if(mCurrentPageIndex == 1 && position == 0){//1->0ҳ
					lp.leftMargin = (int) (mCurrentPageIndex*mScreen1_3 + (positionOffset-1)*mScreen1_3);
				}else if(mCurrentPageIndex == 1 && position == 1)//1-2ҳ
				{
					lp.leftMargin = (int) (mCurrentPageIndex*mScreen1_3 + positionOffset*mScreen1_3);
				}else if(mCurrentPageIndex == 2 && position == 1)//2->1ҳ
				{
					lp.leftMargin = (int) (mCurrentPageIndex*mScreen1_3 + (positionOffset-1)*mScreen1_3);
				}*/
				
				//�ϲ�֮���
				if(position == 0)//0->1|1->0ҳ
				{
					lp.leftMargin = (int) (positionOffset*mScreen1_3);
				}else if(position == 1)//1-2|2->1ҳ
				{
					lp.leftMargin = (int) (mScreen1_3 + positionOffset*mScreen1_3);
				}
				
				mTabline.setLayoutParams(lp);

			}

			public void onPageScrollStateChanged(int arg0) {
			}
		});
	}

	protected void resetTextView() {
		mChatTextView.setTextColor(Color.BLACK);
		mFindTextView.setTextColor(Color.BLACK);
		mBookTextView.setTextColor(Color.BLACK);
	}
	
	//actionBar��ť����¼�
	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
		switch(item.getItemId())
		{
		case android.R.id.home:
			finish();
			break;
		}
		return super.onMenuItemSelected(featureId, item);
	}

}
