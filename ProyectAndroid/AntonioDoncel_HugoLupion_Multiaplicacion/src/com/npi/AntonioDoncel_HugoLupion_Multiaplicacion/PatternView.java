package com.npi.AntonioDoncel_HugoLupion_Multiaplicacion;

import com.npi.AntonioDoncel_HugoLupion_Multiaplicacion.R;

import android.widget.TextView; 

public class PatternView {
	public static final int STATUS_LOCK_PATTERN_SAVED = 0;
	public static final int STATUS_LOCK_PATTERN_NOT_SAVED = 1;
	public static final int STATUS_LOCK_PATTERN_VERFIED = 2;
	public static final int STATUS_LOCK_PATTERN_VERFIED_FAILED = 3;

	private LockPattern mActivity = null;

	protected TextView mTipTextView = null;

	public PatternView(LockPattern activity) {
		mActivity = activity;
		//
		mActivity.setContentView(R.layout.pattern_layout);
		//
		mTipTextView = (TextView) mActivity.findViewById(R.id.tip_textview);
	}

	public void updateView(int status) {
		switch (status) {
		case STATUS_LOCK_PATTERN_SAVED:
			mTipTextView.setText("SAVED");
			break;
		case STATUS_LOCK_PATTERN_NOT_SAVED:
			mTipTextView.setText("NOT SAVED");
			break;

		case STATUS_LOCK_PATTERN_VERFIED:
			mTipTextView.setText("VERFIED");
			break;

		case STATUS_LOCK_PATTERN_VERFIED_FAILED:
			mTipTextView.setText("VERFIED FAILED");
			break;
		}
	}
}
