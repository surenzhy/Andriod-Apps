package com.andriod.light.flashlight;

import android.annotation.SuppressLint;
import android.hardware.Camera;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class MainFlashActivity extends ActionBarActivity {

	private Camera camera;

	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_flash);

		Button onBtn = (Button) findViewById(R.id.on_button);
		Button offBtn = (Button) findViewById(R.id.off_button);
		if (Camera.getNumberOfCameras() > 1) {
			camera = Camera.open();

			onBtn.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View v) {
					Camera.Parameters params = camera.getParameters();
					params.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
					;
					camera.setParameters(params);
					camera.startPreview();
				}
			});

			offBtn.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View v) {
					if (null != camera) {
						camera.startPreview();
						camera.release();
					}

				}
			});

		}

	}

	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		if (null != camera) {
			camera.startPreview();
			camera.release();
		}
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		if (null != camera) {
			camera.startPreview();
			camera.release();
		}
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main_flash,
					container, false);
			return rootView;
		}
	}

	public void switchOnCameraLED(View view) {
		System.out.println("switching on camera");

	}

}
