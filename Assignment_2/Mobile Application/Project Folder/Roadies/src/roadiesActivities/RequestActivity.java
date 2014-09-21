package roadiesActivities;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import roadies.login.R;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * 
 * @author Jue Wang Create a httprequest on the basis of a case including for
 *         attributes: username, password, problems and location in longitude
 *         and latitude.
 * 
 */
public class RequestActivity extends Activity implements OnClickListener,
		LocationListener {
	private Button submitBtn;
	private TextView msg;
	private User user;
	private String location = "XX,YY";
	private String problemPath;
	private LocationManager lms;// create a new location manager
	private String bestProvider = LocationManager.GPS_PROVIDER; // choose best
																// provider

	@Override
	/**
	 *  Create and initialize the activity from previous bundle. And get data stored in 
	 *  loginActivity.
	 *  @param savedInstanceState bundle data
	 */
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.submitlay);
		// Get bundle from last activity;
		Bundle b = getIntent().getExtras();

		// Grab problems
		this.problemPath = b.getString("problem") + ": "
				+ b.getString("narrowItem");

		// get username and password
		user = new User();
		SharedPreferences getData = getSharedPreferences("roadiesActivities",
				Context.MODE_PRIVATE);
		user.setUserName(getData.getString("username", null));
		user.setPassword(getData.getString("passwordData", null));

		locationServiceInitial();

		submitBtn = (Button) findViewById(R.id.send_btn);
		if (submitBtn != null) {
			submitBtn.setOnClickListener(this);
		}

	}

	/**
	 * Get location and construct a string in the format of
	 * "longitude,latitude", then store it to variable location.
	 * 
	 * @param location
	 */

	private void getLocation(Location location) { // show on screen
		if (location != null) {
			this.location = location.getLongitude() + ","
					+ location.getLatitude();
			Toast.makeText(this, this.location, Toast.LENGTH_LONG).show();
		} else {
			Toast.makeText(this, "GPS Disabled", Toast.LENGTH_LONG).show();
		}

	}

	/**
	 * Initialize GPS locating and choose the best GPS provider.
	 */
	private void locationServiceInitial() {
		lms = (LocationManager) getSystemService(LOCATION_SERVICE); // Get
																	// service
		Criteria criteria = new Criteria();
		bestProvider = lms.getBestProvider(criteria, true); // choose best
															// provider
		Location location = lms.getLastKnownLocation(bestProvider);
		getLocation(location);
	}

	@Override
	/**
	 *  Construct a string of four attributes: username, password, location and problem.
	 *  @param v :data of view type 
	 */
	public void onClick(View v) {

		if (v == submitBtn) {

			String result = getSolution(user.getUserName(), user.getPassword());
			Toast.makeText(this, result, Toast.LENGTH_LONG).show();
			msg = (TextView) findViewById(R.id.msg_view);
			this.msg.setText("Please wait for your response.");
			// print words posted
			if (result == null) {

			}
		}
	}

	/**
	 * Using httpclient to constructing a httprequest containing case
	 * infromations, then sending it to web server side for further web and
	 * database implementation. A response will be received to show the status
	 * of connecting. As a prototype, nothing will be returned.
	 * 
	 * @param username
	 *            String type
	 * @param password
	 *            String type
	 * @param loc
	 *            String type
	 * @param pro
	 *            String type
	 * @return null if no exception detected
	 */
	public String getSolution(String username, String password) {
		String url = "http://192.168.2.102:8080/roadiesapp/services/getSolution?";
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("username", username));
		params.add(new BasicNameValuePair("password", password));
		params.add(new BasicNameValuePair("location", this.location));
		params.add(new BasicNameValuePair("problem", this.problemPath));
		String paramString = URLEncodedUtils.format(params, "utf-8");
		url += paramString;
		HttpGet httpRequest = new HttpGet(url);
		try {
			HttpResponse httpResponse = new DefaultHttpClient()
					.execute(httpRequest);

		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// For this prototype we are not obtaining a solution so just display a
		// waiting message
		return "";
	}

	@Override
	public void onLocationChanged(Location location) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onProviderDisabled(String provider) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onProviderEnabled(String provider) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStatusChanged(String provider, int status, Bundle extras) {
		// TODO Auto-generated method stub

	}

}
