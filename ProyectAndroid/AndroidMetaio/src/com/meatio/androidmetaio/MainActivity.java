//Antonio Doncel Campos
//Hugo Mario Lupion Fernandez

package com.meatio.androidmetaio;

import android.os.Bundle;
import android.widget.TextView;

import com.metaio.sdk.ARViewActivity;
import com.metaio.sdk.MetaioDebug;
import com.metaio.sdk.jni.IGeometry;
import com.metaio.sdk.jni.IMetaioSDKCallback;
import com.metaio.sdk.jni.TrackingValues;
import com.metaio.sdk.jni.TrackingValuesVector;

public class MainActivity extends ARViewActivity {

	/**
     * Text view that will display bar code data
     */
    private TextView mText;

    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        mText = new TextView(this);
        mGUIView = mText;
    }

    @Override
    protected int getGUILayout() 
    {
        return 0;
    }

    /**
     * Display a text on screen
     * @param data String to be displayed
     */
    private void displayText(final String data)
    {
        runOnUiThread(new Runnable()
        {
            @Override
            public void run() {

                mText.setText(data);
            }
        });
    }

    @Override
    protected IMetaioSDKCallback getMetaioSDKCallbackHandler() 
    {
        return new MetaioSDKCallbackHandler();
    }

    @Override
    protected void loadContents() 
    {   
        // set QR code reading configuration
        final boolean result = metaioSDK.setTrackingConfiguration("QRCODE");
        MetaioDebug.log("Tracking data loaded: " + result);
    }

    @Override
    protected void onGeometryTouched(final IGeometry geometry) 
    {

    }

    final class MetaioSDKCallbackHandler extends IMetaioSDKCallback
    {       
        @Override
        public void onTrackingEvent(TrackingValuesVector trackingValues)
        {
            if (trackingValues.size() > 0)
            {
                final TrackingValues v = trackingValues.get(0);

                if (v.isTrackingState())
                {   
                    final String[] tokens = v.getAdditionalValues().split("::");
                    if (tokens.length > 1)
                    {
                        displayText("QR Code detected: "+tokens[1]);
                    }
                }
            }
        }

    }
}
