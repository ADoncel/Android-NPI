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
 * Clase principal para la ejecución del lector de códigos QR
 * @author: Antonio Doncel Campos, Hugo Mario Lupión Fernández
 * @version: 28/12/14-0
 */

package com.meatio.androidmetaio;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends ActionBarActivity {
	
	/**
     * Boton que lanzara la segunda actividad
     */
	public Button imStart;
	
	@Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imStart = (Button) findViewById(R.id.button1);
        
        imStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            	lanzar(v);
            }
        });
    }
	
	/**
     * Método para ejecturar otra actividad
     */
	public void lanzar(View view) {
        Intent i = new Intent(this, QReader.class );
        startActivity(i);
	}
}
