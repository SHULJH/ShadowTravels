package com.example.yingyouji.UI;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yingyouji.R;
import com.example.yingyouji.atys.AtyYingyouActivity;

public class MainPageFragment extends Fragment implements OnClickListener{
	
	private ViewPager mViewPager;
	private List<ImageView> imageViews;
	private String[] titles;
	private int[] imageResId;
	private List<View>dots;
	
	private TextView tv_title;
	private int currentItem=0;
	
	Button btn_activity_yingyou;
	
	private ScheduledExecutorService scheduledExecutorService; 
	private Handler handler=new Handler(){
		@Override
		public void handleMessage(Message msg) {
			mViewPager.setCurrentItem(currentItem);
		}
	};
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view=inflater.inflate(R.layout.mainpage_fragment_layout, container,false);
		imageResId=new int[]{R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.d,R.drawable.e};
		titles=new String[imageResId.length];
		titles[0]="图片一";
		titles[1]="图片二";
		titles[2]="图片三";
		titles[3]="图片四";
		titles[4]="图片五";
		
		imageViews=new ArrayList<ImageView>();
		
		for(int i=0;i<imageResId.length;i++){
			ImageView imageView=new ImageView(getActivity());
			imageView.setImageResource(imageResId[i]);
			imageView.setScaleType(ScaleType.CENTER);
			imageViews.add(imageView);
		}
		
		dots=new ArrayList<View>();
		dots.add(view.findViewById(R.id.id_dot0));
		dots.add(view.findViewById(R.id.id_dot1));
		dots.add(view.findViewById(R.id.id_dot2));
		dots.add(view.findViewById(R.id.id_dot3));
		dots.add(view.findViewById(R.id.id_dot4));
		
		tv_title=(TextView) view.findViewById(R.id.id_main_viewpager_title);
		tv_title.setText(titles[0]);
		
		mViewPager=(ViewPager) view.findViewById(R.id.id_main_viewpager);
		mViewPager.setAdapter(new MyAdapter());
		mViewPager.setOnPageChangeListener(new MyPageChangeListener());
		
		btn_activity_yingyou=(Button) view.findViewById(R.id.btn_activity_yingyou);
		btn_activity_yingyou.setOnClickListener(this);
		
		return view;
	}
	
	@Override
	public void onStart() {
		scheduledExecutorService=Executors.newSingleThreadScheduledExecutor();
		 // 当Activity显示出来后，每两秒钟切换一次图片显示  
		scheduledExecutorService.scheduleAtFixedRate(new ScrollTask(), 1, 2, TimeUnit.SECONDS);
		super.onStart();
	}
	
	@Override
	public void onStop() {
		scheduledExecutorService.shutdown();
		super.onStop();
	}
	
	private class ScrollTask implements Runnable{

		@Override
		public void run() {
			synchronized(mViewPager){
				System.out.println("currentItem: "+currentItem);
				currentItem=(currentItem+1)%imageViews.size();
				handler.obtainMessage().sendToTarget();
			}
			
		}
		
	}
	
	private class MyPageChangeListener implements OnPageChangeListener{

		private int oldPosition=0;
		@Override
		public void onPageScrollStateChanged(int arg0) {
			
		}

		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {
			
		}

		@Override
		public void onPageSelected(int position) {
			currentItem=position;
			tv_title.setText(titles[position]);
			dots.get(oldPosition).setBackgroundResource(R.drawable.dot_nomal);
			dots.get(position).setBackgroundResource(R.drawable.dot_focused);
			oldPosition=position;
		}
		
	}
	
	class MyAdapter extends PagerAdapter{

		@Override
		public Object instantiateItem(View container, int position) {
			((ViewPager) container).addView(imageViews.get(position));
			final int p=position;
			imageViews.get(position).setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					switch(p){
					case 0:
						Toast.makeText(getActivity(), "您点中了第1张图片", Toast.LENGTH_SHORT).show();
						break;
					case 1:
						Toast.makeText(getActivity(), "您点中了第2张图片", Toast.LENGTH_SHORT).show();
						break;
					case 2:
						Toast.makeText(getActivity(), "您点中了第3张图片", Toast.LENGTH_SHORT).show();
						break;
					case 3:
						Toast.makeText(getActivity(), "您点中了第4张图片", Toast.LENGTH_SHORT).show();
						break;
					case 4:
						Toast.makeText(getActivity(), "您点中了第5张图片", Toast.LENGTH_SHORT).show();
						break;
					default:break;
					}
					
				}
			});
			return imageViews.get(position);
		}
		
		@Override
		public void destroyItem(View container, int position, Object object) {
			((ViewPager)container).removeView((View) object);
		}
		@Override
		public int getCount() {
			return imageResId.length;
		}

		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			// TODO Auto-generated method stub
			return arg0==arg1;
		}
		
	}

	@Override
	public void onClick(View v) {
		switch(v.getId()){
		case R.id.btn_activity_yingyou:
			Intent i=new Intent(getActivity(),AtyYingyouActivity.class);
			startActivity(i);
			break;
		default: break;
		}
		
	}

}
