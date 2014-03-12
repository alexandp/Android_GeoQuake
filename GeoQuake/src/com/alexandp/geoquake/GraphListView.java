package com.alexandp.geoquake;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class GraphListView extends ListView{
	
	  public GeoQuakeDbAdapter db_;
	  public ArrayList<String> graph_names_;
	  protected ArrayAdapter<String> adapter_;
	  
	  public GraphListView(Context ctx) {
		  super(ctx);
		    setCacheColorHint(0xFFFFFFFF);
		    setBackgroundColor(0xFFFFFFFF);
		    setDivider(new ColorDrawable(0xFF898989));
		    setDividerHeight(1);
		    db_ = GeoQuakeDbAdapter.getAdapter();
		    db_.open(ctx);
		    graph_names_ = db_.fetchGraphNames();
		    adapter_ = new ArrayAdapter<String>(ctx, R.layout.export, graph_names_);
		    setAdapter(adapter_);
		    db_.close();	    
	  }
}
