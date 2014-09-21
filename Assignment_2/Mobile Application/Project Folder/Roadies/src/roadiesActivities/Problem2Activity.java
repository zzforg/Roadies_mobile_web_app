package roadiesActivities;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

/**
 * 
 * @author Dean Chen Create a details listview activity for chosen problem. It
 *         restore data from last saved instance status and pass the chosen
 *         narrow down details to submit activity.
 * 
 */
public class Problem2Activity extends ListActivity {

	protected ListAdapter adapter;
	String[] narrowItem;
	String problem;

	/**
	 * Create activity and get data from saved instance status.Also, create an
	 * adapter to monitor click event.
	 * 
	 * @param icicle
	 *            bundle data type--get data from saved instance
	 */
	public void onCreate(Bundle icicle) {
		super.onCreate(icicle);
		Bundle b = getIntent().getExtras();
		this.narrowItem = b.getStringArray("narrowItem");
		this.problem = b.getString("problem");
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, narrowItem);
		setListAdapter(adapter);

	}

	@Override
	/**
	 * After click, this method record the details issue as well as the main problem it linked
	 * and pass these data into next activity.
	 */
	protected void onListItemClick(ListView l, View v, int position, long id) {
		String item = (String) getListAdapter().getItem(position);
		super.onListItemClick(l, v, position, id);
		Log.i("DebugMessage", "clicked an item..");
		// save problem and issue chosen in bundle and pass it to next activity
		Bundle bundle = new Bundle();
		bundle.putString("problem", this.problem);
		bundle.putString("narrowItem", item);
		Toast.makeText(this, this.problem + item, Toast.LENGTH_LONG).show();
		Intent i = new Intent(this, RequestActivity.class);
		i.putExtras(bundle);
		finish();
		startActivity(i);
	}

}