package com.example.ddsapp;

import IIC2113.resource.manager.IConsumptionObs;
import android.util.Log;

public class CameraObserver implements IConsumptionObs
{
	byte[] data;

	public byte[] getData()
	{
		return data;
	}

	public void consumptionFinished(int i, Object o) {
		// TODO Auto-generated method stub
		Log.v("ConsumptionFinished", "Objeto: "+o);
		data = (byte[]) o;
		
	}

	
	public void consumptionUpdate(int i, Object o) {

		data = (byte[]) o;
		
	}

	public void consumptionFailed(int resource_id, String error) {
		// TODO Auto-generated method stub
		
	}

	public void consumptionInterrupted(int resource_id, String error) {
		// TODO Auto-generated method stub
		
	}
	
	
}
