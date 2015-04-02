package ro.pub.cs.systems.pdsd.practicaltest01;

import ro.pub.cs.systems.pdsd.practicaltest01.PracticalTest01MainActivity.ButtonClickListener;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PracticalTest01SecondaryActivity extends Activity {
	
private ButtonClickListener buttonClickListener = new ButtonClickListener( ) ;
	
	final private int[ ] ButtonIds = {
			R.id.button4,
			R.id.button5,
	} ;
	
	protected class ButtonClickListener implements View.OnClickListener
	{
		@Override
		public void onClick(View v) {
			if ( v instanceof Button )
			{
				if ( v.getId() == R.id.button4 )
				{
					  Intent intentToParent = new Intent();
					  intentToParent.putExtra("ro.pub.cs.systems.pdsd.practicaltest01.ANSWER", "Ok");
					  setResult(0, intentToParent);
					  finish();
				}
				if ( v.getId() == R.id.button5 )
				{
					  Intent intentToParent = new Intent();
					  intentToParent.putExtra("ro.pub.cs.systems.pdsd.lab04.ANSWER", "Cancel");
					  setResult(1, intentToParent);
					  finish();
				}
			}
		}
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_practical_test01_secondary);
		
		Intent intentFromParent = getIntent();
		Bundle data = intentFromParent.getExtras();
		if ( data.containsKey( "ro.pub.cs.systems.pdsd.practicaltest01.TOTAL" ) )
		{
			EditText total = ( EditText )findViewById( R.id.editText3 );
			total.setText(data.getString("ro.pub.cs.systems.pdsd.practicaltest01.TOTAL"));
		}
        for ( int i = 0 ; i < ButtonIds.length ; i++ )
        {
        	Button button = ( Button ) findViewById ( ButtonIds[ i ] ) ;
        	button.setOnClickListener( buttonClickListener ) ;
        }
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.practical_test01_secondary, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
