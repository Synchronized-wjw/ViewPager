package com.vince.viewpager;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MainActivity extends Activity {

	private ViewPager viewPager;
	private View v1,v2,v3;
	//存放要切换的视图
	private ArrayList<View> list = new ArrayList<View>();
	//存放标题指示
	private ArrayList<String> titles = new ArrayList<String>();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initView();
	}
	private void initView() {
		
		viewPager = (ViewPager) findViewById(R.id.viewpager);
		
		LayoutInflater inflater = getLayoutInflater();
		v1 = inflater.inflate(R.layout.layout1, null);
		v2 = inflater.inflate(R.layout.layout2, null);
		v3 = inflater.inflate(R.layout.layout3, null);
		
		list.add(v1);
		list.add(v2);
		list.add(v3);
		
		titles.add("红色");
		titles.add("绿色");
		titles.add("蓝色");
		
		viewPager.setAdapter(new MyPagerAdapter());
	}

	class MyPagerAdapter extends PagerAdapter{

		//切换的视图总数
		@Override
		public int getCount() {
			return list.size();
		}
		
		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			return arg0==arg1;
		}
		@Override
		public CharSequence getPageTitle(int position) {
//			return super.getPageTitle(position);
			return titles.get(position);
		}
		
		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			//super.destroyItem(container, position, object);
			container.removeView(list.get(position));
		}
		@Override
		public Object instantiateItem(ViewGroup container, int position) {
			View v = list.get(position);
			container.addView(v,0);
			return v;
		}
	}
}
