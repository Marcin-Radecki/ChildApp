package sdm.application.childapp;

import java.util.ArrayList;
import sdm.application.childapp.R;
import sdm.application.entity.UserEntity;


import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ScoreItemAdapter extends BaseAdapter {
	  protected Activity activity;
	  protected ArrayList<UserEntity> items;
	  
	  public ScoreItemAdapter(Activity activity, ArrayList<UserEntity> items) {
	    this.activity = activity;
	    this.items = items;
	  }

	  @Override
	  public int getCount() {
	    return items.size();
	  }

	  @Override
	  public Object getItem(int position) {
	    return items.get(position);
	  }

	  @Override
	  public long getItemId(int position) {
	    return items.get(position).getId();
	  }

	  @Override
	  public View getView(int position, View convertView, ViewGroup parent) {
	    View vi=convertView;
	  
	    if(convertView == null) {
	      LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	      vi = inflater.inflate(R.layout.list_item_layout, null);
	    }
	            
	    UserEntity item = items.get(position);
	    
	    Typeface font = Typeface.createFromAsset(activity.getAssets(),
				"HelvetiHand.ttf");
	        
	    TextView name = (TextView) vi.findViewById(R.id.name);
	    name.setText(item.getName());
	    name.setTypeface(font);
	        
	    TextView score = (TextView) vi.findViewById(R.id.score);
	    score.setText(item.getScore() + " " + activity.getResources().getString(R.string.points));
	    score.setTypeface(font);

	    return vi;
	  }
	}
