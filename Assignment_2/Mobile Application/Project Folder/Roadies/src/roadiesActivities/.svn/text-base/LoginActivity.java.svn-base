package roadiesActivities;

import roadies.login.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
/**
 * A login prototype of Roadies (Global Roadside Assistance)
 * It contains a Roadies logo, user login inputs and a login button,
 * which defind in main.xml file.
 * @author Gary
 *
 */
public class LoginActivity extends Activity implements OnClickListener {
    /** Called when the activity is first created. */
	
	/**
	 * An instance of user type, providing setUsername and setPassword methods
	 */
	public User user;
	
	/**
	 * Define variables to store user name and password to pass to the instance
	 * of user
	 */
	private String userName;
	private String password;
	
	/**
	 * Define the user input from user name and password to EditText type
	 */
	private EditText view_userName;
	private EditText view_password;
	
	/**
	 * Define the login button as Button type
	 */
	private Button button;

	/**
	 * Initializes the application and the activity.
	 * 1. Sets the view
	 * 2. Instantiates a button listener for the login activity
	 * 
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
    public void onCreate(Bundle savedInstanceState) {
    	 /**
         * derived classes that use onCreate() overrides 
         * must always call the super constructor
         */
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        button = (Button)findViewById(R.id.login);
        
        /*
         * Create a listener that is triggered when the user click on the
         * login button.
         */
        if(button != null){
        	button.setOnClickListener(this);
        	
        }
    }
    
    /**
     * The button action for login button:
     * 1. Find the TextView id of user input
     * 2. Set the inputs into the user type, e.g user name and password
     * 3. Change to the dashboard activity
     * 4. Close this activity.
     */
    @Override
    public void onClick(View v){
		
		findViewById();	
		user = new User(userName, password);

		setUserName();
		setPassword();

		String uname = user.getUserName();
		String psw = user.getPassword();
		if(uname == null || uname.isEmpty()|| uname=="" ){
			Toast.makeText(this, "Please input your user name!", 
					Toast.LENGTH_LONG).show();
		} else if(psw == null || psw.isEmpty()|| psw=="" ){
			Toast.makeText(this, "Please input your password!", 
					Toast.LENGTH_LONG).show();
		} else {
			WriteSharedPreferences(userName, password);
			Intent i = new Intent(LoginActivity.this, 
					DashBoardActivity.class);	
			startActivity(i);
			finish();	
		}				
	}
    
    /**
     * Store the user input in the EditText type variable.
     */
    public void findViewById(){
    	view_userName = (EditText)findViewById(R.id.nameInput);
    	view_password = (EditText)findViewById(R.id.pswInput);
    }
    
    /**
     * Set the user name into User type by calling setUserName();
     */
    public void setUserName(){
    	this.userName =	view_userName.getText().toString();
    		this.user.setUserName(userName);
    }
    
    /**
     * Set the user password into User type by calling setPassword().
     */
    public void setPassword(){
    	this.password = view_password.getText().toString();
    	this.user.setPassword(password);
    }
   
    /**
     * This method reads the preference data through the sharedPreferences
     * instance.
     * strName and strPassword store the date from the preferences by 
     * corresponding to the "keys": username & password
     */
    public void ReadSharedPreferences(){
    	String strName;
    	String strPassword;
    	SharedPreferences userData = 
    			this.getSharedPreferences("roadiesActivities",
    					Context.MODE_PRIVATE);
    	strName = userData.getString("username", "");
    	strPassword = userData.getString("password","");
    }
    
    /**
     * This method save the user input of user name and user password to 
     * shared preferences temporary in order to be retrieved by the 
     * RequestActivity to send the data to the database.
     * @param strName
     * @param strPassword
     */
    public void WriteSharedPreferences(String strName, String strPassword){
    	SharedPreferences userData = 
    			this.getSharedPreferences("roadiesActivities", 
    					Context.MODE_PRIVATE);
    	Editor editor = userData.edit();
    	editor.clear();
    	editor.putString("username", strName);
    	editor.putString("passwordData", strPassword);
    	editor.commit();  
    	
    }  
    
}