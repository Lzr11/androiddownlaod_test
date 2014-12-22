package com.lzr.android;

import com.lzr.downloader.core.Downloader;
import com.lzr.downloader.core.Downloader.DownloadController;
import com.lzr.downloader.core.Downloader.OnDownloadListener;
import com.lzr.downloader.core.DownloaderUtil;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends Activity {

	private TextView txt_progress;
	private TextView txt_down;
	private TextView txt_pause;
	private TextView txt_cancel;
	private ProgressBar progressBar;
	private DownloadController downloadController;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		txt_progress=(TextView) findViewById(R.id.txt_progress);
		txt_down=(TextView) findViewById(R.id.txt_down);
		txt_pause=(TextView) findViewById(R.id.txt_pause);
		txt_cancel=(TextView) findViewById(R.id.txt_cancel);
		progressBar=(ProgressBar) findViewById(R.id.progressBar);
		
		txt_down.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				downloadController=DownloaderUtil.getInstance().download("http://download.haozip.com/haozip_v2.8_tiny.exe", "/mnt/sdcard/QQMusic.exe", 4, getApplicationContext(), listener);
				
			}
		});
		txt_pause.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				downloadController.pause();
			}
		});
		txt_cancel.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				downloadController.cancel();
			}
		});
	}
	OnDownloadListener listener=new OnDownloadListener() {
		
		@Override
		public void onStart(int total) {
			// TODO Auto-generated method stub
//			Log.d("TAG", "start");
		}
		
		@Override
		public void onDownLoading(int current, int total, int increment) {
			// TODO Auto-generated method stub
//			Log.d("TAG", "downloading");
//			progressBar.incrementProgressBy(increment);
			txt_progress.setText(current*100/total+"%");
		}
		
		@Override
		public void onCompleted() {
			// TODO Auto-generated method stub
//			Log.d("TAG", "completed");
		}
	};
}
