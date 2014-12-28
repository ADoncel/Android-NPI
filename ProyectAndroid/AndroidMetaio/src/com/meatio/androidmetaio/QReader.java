/*
 *  Copyright (C) 2014, 2015 - Antonio Doncel Campos <adoncel@correo.ugr.es>, Hugo Mario Lupión Fernández <hugolupionfernandez@correo.ugr.es>
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

/**
 * Clase encargada de leer el código QR y mostrarlo en una caja de texto
 * @author: Antonio Doncel Campos, Hugo Mario Lupión Fernández
 * @version: 28/12/14-0
 */

package com.meatio.androidmetaio;

import android.os.Bundle;
import android.widget.TextView;

import com.metaio.sdk.ARViewActivity;
import com.metaio.sdk.MetaioDebug;
import com.metaio.sdk.jni.IGeometry;
import com.metaio.sdk.jni.IMetaioSDKCallback;
import com.metaio.sdk.jni.TrackingValues;
import com.metaio.sdk.jni.TrackingValuesVector;



public class QReader extends ARViewActivity{
	/**
     * Texto donde se visualizará la información del QR
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
     * Muestra el texto en la pantalla
     * @param datos String a ser visualizados
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
    
    /**
     * Carga el tipo de código a leer
     */
    @Override
    protected void loadContents() 
    {   
        // set QR code reading configuration
        final boolean result = metaioSDK.setTrackingConfiguration("QRCODE");
        MetaioDebug.log("Tracking data loaded: " + result);
    }
    
    /**
     * Clase encargada de reconocer los límites del código
     * y extraer la información que contiene
     */
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

	@Override
	protected void onGeometryTouched(IGeometry geometry) {		
	}
}
