package com.example.yingyouji;

import java.util.ArrayList;
import java.util.List;

import android.app.ActionBar;
import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.example.yingyouji.UI.MainPageFragment;
import com.example.yingyouji.UI.PersonFragment;
import com.example.yingyouji.UI.SettingFragment;
import com.example.yingyouji.atys.AtyLogin;

public class MainActivity extends Activity implements OnClickListener{

	private List<Fragment>mTabs=new ArrayList<Fragment>();
	private String[] mTitles=new String[]{
			"主页","个人","设置"
	};
	private LinearLayout mTabMainPage,mTabPerson,mTabSetting;
	private ImageButton mMainPageImg,mPersonImg,mSettingImg;
	private MainPageFragment mMainPage;
	private PersonFragment mPerson;
	private SettingFragment mSetting;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		init();
		
		setDefaultFragment();
	}

	private void init() {
		mTabMainPage=(LinearLayout)findViewById(R.id.layout_main_page);
		mTabPerson=(LinearLayout) findViewById(R.id.layout_person);
		mTabSetting=(LinearLayout)findViewById(R.id.layout_setting);
		
		mMainPageImg=(ImageButton) findViewById(R.id.mMainImg);
		mPersonImg=(ImageButton) findViewById(R.id.mPersonImg);
		mSettingImg=(ImageButton) findViewById(R.id.mSettingsImg);

		mTabMainPage.setOnClickListener(this);
		mTabPerson.setOnClickListener(this);
		mTabSetting.setOnClickListener(this);
		
		mMainPage=new MainPageFragment();
		mPerson=new PersonFragment();
		mSetting=new SettingFragment();
	}

	private void setDefaultFragment() {
		
		FragmentManager fm=getFragmentManager();
		FragmentTransaction transaction=fm.beginTransaction();
		transaction.replace(R.id.id_content, mMainPage);
		transaction.commit();
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch(item.getItemId()){
		case R.id.action_login:
			Intent i=new Intent(MainActivity.this,AtyLogin.class);
			startActivity(i);
			break;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onClick(View v) {
		FragmentManager fm=getFragmentManager();
		FragmentTransaction transaction=fm.beginTransaction();
		resetImg();
		switch(v.getId()){
		case R.id.layout_main_page:
			mMainPageImg.setImageResource(R.drawable.tab_weixin_pressed);
			if(mMainPage!=null){
				transaction.replace(R.id.id_content, mMainPage);
			}
			break;
		case R.id.layout_person:
			mPersonImg.setImageResource(R.drawable.tab_address_pressed);
			if(mPerson!=null){
				transaction.replace(R.id.id_content, mPerson);
			}
			break;
		case R.id.layout_setting:
			mSettingImg.setImageResource(R.drawable.tab_settings_pressed);
			if(mSetting!=null){
				transaction.replace(R.id.id_content, mSetting);
			}
			break;
		default:break;
		}
		transaction.commit();
	}
	
	private void resetImg(){
		mMainPageImg.setImageResource(R.drawable.tab_weixin_normal);
		mPersonImg.setImageResource(R.drawable.tab_address_normal);
		mSettingImg.setImageResource(R.drawable.tab_settings_normal);
	}
	
}
