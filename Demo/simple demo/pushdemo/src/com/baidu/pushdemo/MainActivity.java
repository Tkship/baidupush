package com.baidu.pushdemo;

import com.baidu.android.pushservice.PushConstants;
import com.baidu.android.pushservice.PushManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.app.Activity;


/*
 * MainActivityΪpushdemo����Activity����Ҫʵ��Push�ĳ�ʼ����bind����
 * 
 */

public class MainActivity extends Activity {
	
	private Button ak_init;
	
	//���������Ļ�ȡ��API Key
	private static final String API_KEY = "RzsF4GsrWwrdM69DnjZ2XHLP";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		ak_init = (Button)findViewById(R.id.ak_init);
		
		ak_init.setOnClickListener(new Button.OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				// startWork()���Push����ĳ�ʼ������������Զ�bind����		
				PushManager.startWork(getApplicationContext(),PushConstants.LOGIN_TYPE_API_KEY, API_KEY);
			}
						
		});
	}

}
