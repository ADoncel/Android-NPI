/*
 *  Copyright (C) 2014, 2015 - Antonio Doncel Campos <adoncel@correo.ugr.es>, Hugo Mario Lupi�n Fern�ndez <hugolupionfernandez@correo.ugr.es>
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
 * Clase principal para la ejecuci�n del lector de c�digos QR
 * @author: Antonio Doncel Campos, Hugo Mario Lupi�n Fern�ndez
 * @version: 28/12/14-0
 */

package com.meatio.androidmetaio;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

//implements GestureDetector.OnGestureListener,
//GestureDetector.OnDoubleTapListener

public class MainActivity extends Activity {
	
	/**
     * Boton que lanzara la segunda actividad
     */
	public Button button_speakGPS;
	public Button button_qreader;
	public Button button_sensor;
	
	//private static final String DEBUG_TAG = "Gestures";
	//private GestureDetectorCompat mDetector;
	
	@Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        button_speakGPS = (Button) findViewById(R.id.speakGPS_button);
        button_speakGPS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            	lanzar_speakGPS(v);
            }
        });
        
        button_qreader = (Button) findViewById(R.id.qrreader_button);
        button_qreader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            	lanzar_QRReader(v);
            }
        });
        
        button_sensor = (Button) findViewById(R.id.sensor_button);
        button_sensor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            	lanzar_Sensor(v);
            }
        });
    }
	
	/**
     * M�todo para ejecturar otra actividad
     */
	public void lanzar_speakGPS(View view) {
        Intent i = new Intent(this, SpeakerS.class );
        startActivity(i);
	}
	/**
     * M�todo para ejecturar otra actividad
     */
	public void lanzar_QRReader(View view) {
        Intent i = new Intent(this, LockPattern.class );
        startActivity(i);
	}
	/**
     * M�todo para ejecturar otra actividad
     */
	public void lanzar_Sensor(View view) {
        Intent i = new Intent(this, MoveMvl.class );
        startActivity(i);
	}	
	
	/*@Override
	public boolean onTouchEvent(MotionEvent event){
		this.mDetector.onTouchEvent(event);
		return super.onTouchEvent(event);
	}

	@Override
	public boolean onSingleTapConfirmed(MotionEvent e) {
		Log.d(DEBUG_TAG, "onSingleTapConfirmed: ");
		return false;
	}

	@Override
	public boolean onDoubleTap(MotionEvent e) {
		Log.d(DEBUG_TAG, "onDoubleTap: ");
		return false;
	}

	@Override
	public boolean onDoubleTapEvent(MotionEvent e) {
		Log.d(DEBUG_TAG, "onDoubleTapEvent: ");
		return false;
	}

	@Override
	public boolean onDown(MotionEvent e) {
		Log.d(DEBUG_TAG, "onDown: " + e.toString());
		return false;
	}

	@Override
	public void onShowPress(MotionEvent e) {
		Log.d(DEBUG_TAG, "onShowPress: ");
	}

	@Override
	public boolean onSingleTapUp(MotionEvent e) {
		Log.d(DEBUG_TAG, "onSingleTapUp: ");
		return false;
	}

	@Override
	public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX,
			float distanceY) {
		Log.d(DEBUG_TAG, "onScroll: " + e1.toString() + e2.toString());
		return false;
	}

	@Override
	public void onLongPress(MotionEvent e) {
		Log.d(DEBUG_TAG, "onLongPress: ");		
	}

	@Override
	public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
			float velocityY) {
		Log.d(DEBUG_TAG, "onFling: ");
		return false;
	}*/
}
