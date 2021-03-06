package com.example.ddsapp;

import java.util.ArrayList;
import java.util.Iterator;

import usermanager.ResourceState;

import cl.puc.dds.appmgr.external.IResource;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;



public class buscarRecurso extends Activity {

	private MyApplication app;
	private ArrayList<ResourceState> ListaRecursos;
	private String[] ListaTipoRecurso;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.buscar_recurso_activity);
        getIntent();
        
	
        
        app = new MyApplication();
        
        
        
        ListaRecursos = app.getAllForeignResources();
        Log.v("ListaRecursos",""+ListaRecursos);
        ListaTipoRecurso = new String[ListaRecursos.size()];
        
        int j = 0;
        
        for(Iterator<ResourceState> i = ListaRecursos.iterator(); i.hasNext(); ) {
        	  ResourceState resource = i.next();
        	  String type = resource.getType();
        	  ListaTipoRecurso[j] = type;
        	  j++;
        	}
        
        
        
        ArrayAdapter adapter = new ArrayAdapter<String>(this, 
                android.R.layout.simple_list_item_1, ListaTipoRecurso);
        
        ListView listView = (ListView) findViewById(R.id.listview);
        listView.setAdapter(adapter);
        
        listView.setOnItemClickListener(mMessageClickedHandler); 
        
    }
	
	
	 @Override
	    public boolean onCreateOptionsMenu(Menu menu) {
	        getMenuInflater().inflate(R.menu.activity_main, menu);
	        
	        return true;
	        
	 }
	 
	 private OnItemClickListener mMessageClickedHandler = new OnItemClickListener() {
		    public void onItemClick(AdapterView parent, View v, int position, long id) {
		       Log.v("BuscarRecurso", "Position: "+position+" id: "+id);
		       ResourceState resource = ListaRecursos.get(position);
		       app.userResource(resource);
		       
		      /* Object objeto = app.recieveMesagge();
		       
		       while(objeto == null)
		       {
		    	 //  objeto = app.recieveMesagge();
		       }
		       
		       byte[] foto = (byte[])objeto;*/
		       
		       
		 
		       
		    }
		};

		
	 
	 
	
	
}
