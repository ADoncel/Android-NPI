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

package com.npi.AntonioDoncel_HugoLupion_Multiaplicacion;

public enum PuntoCardinal {
	Norte (1),
	Noreste (45),
	Este (90),
	Sudeste (135),
	Sur (180),
	Suroeste (225),
	Oeste (270),
	Noroeste (315);
	
	private final float angulo;
	
	/**
	 * Establece el �ngulo del punto cardinal
	 * @param ang
	 */
	private PuntoCardinal(float ang) {
		this.angulo = ang;
	}
	
	/**
	 * Devuelve el �ngulo del punto cardinal
	 * @return
	 */
	public float angulo(){
		return this.angulo;
	}
}