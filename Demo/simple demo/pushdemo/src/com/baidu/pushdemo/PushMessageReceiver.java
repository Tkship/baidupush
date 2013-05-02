package com.baidu.pushdemo;

import com.baidu.android.pushservice.PushConstants;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;


/**
 * Push��Ϣ����
 */

public class PushMessageReceiver extends BroadcastReceiver {

	/**
	 * @param context
	 *            Context
	 * @param intent
	 *            ������Ϣ��intent
	 */
	@Override
	public void onReceive(final Context context, Intent intent) {

		if (intent.getAction().equals(PushConstants.ACTION_MESSAGE)) {
			//��ȡPush��Ϣ����
			String message = intent.getExtras().getString(
					PushConstants.EXTRA_PUSH_MESSAGE_STRING);
			
		} else if (intent.getAction().equals(PushConstants.ACTION_RECEIVE)) {
			
			//����󶨵ȷ����ķ�������
			//ע:PushManager.startWork()�ķ���ֵͨ��PushConstants.METHOD_BIND�õ�
			
			//��ȡ����
			final String method = intent.getStringExtra(PushConstants.EXTRA_METHOD);
			
			//�������ش�����,����Ҫǡ���������磬����Ϊbindʱ����ʧ�ܣ���Ҫ����bind,�����µ���startWork
			final int errorCode = intent.getIntExtra(PushConstants.EXTRA_ERROR_CODE,PushConstants.ERROR_SUCCESS);
			
			//��������
			final String content = new String(intent.getByteArrayExtra(PushConstants.EXTRA_CONTENT));
			
			Toast.makeText(context,
					"method : " + method + "\n result: " + errorCode
							+ "\n content = " + content, Toast.LENGTH_SHORT).show();
				
		} else if (intent.getAction().equals(PushConstants.ACTION_RECEIVER_NOTIFICATION_CLICK)) {
			//�û����֪ͨ��Ĵ���
			Intent aIntent = new Intent();
			aIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			aIntent.setClass(context, DisplayMessage.class);
			
			//Push��Ϣ��title
			String title = intent.getStringExtra(PushConstants.EXTRA_NOTIFICATION_TITLE);
			aIntent.putExtra(PushConstants.EXTRA_NOTIFICATION_TITLE, title);
			
			//Push��Ϣ��content
			String content = intent.getStringExtra(PushConstants.EXTRA_NOTIFICATION_CONTENT);
			aIntent.putExtra(PushConstants.EXTRA_NOTIFICATION_CONTENT, content);

			context.startActivity(aIntent);
		}
	}

}
