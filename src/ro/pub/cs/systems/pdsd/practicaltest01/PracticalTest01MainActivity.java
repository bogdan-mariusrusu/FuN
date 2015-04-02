package ro.pub.cs.systems.pdsd.practicaltest01;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class PracticalTest01MainActivity extends Activity {
	
	private ButtonClickListener buttonClickListener = new ButtonClickListener( ) ;
	
	final private int[ ] ButtonIds = {
			R.id.button1,
			R.id.button2,
			R.id.button3
	} ;
	
	protected class ButtonClickListener implements View.OnClickListener
	{
		@Override
		public void onClick(View v) {
			if ( v instanceof Button )
			{
				if ( v.getId() == R.id.button1 )
				{
					  EditText counter_text1 = ( EditText )findViewById( R.id.editText1 );
					  EditText counter_text2 = ( EditText )findViewById( R.id.editText2 );
					  int number = Integer.parseInt(counter_text1.getText().toString()) + Integer.parseInt(counter_text2.getText().toString());
					  Intent intent = new Intent("ro.pub.cs.systems.pdsd.practicaltest01.intent.action.PracticalTest01MainActivity");
					  intent.putExtra("ro.pub.cs.systems.pdsd.practicaltest01.TOTAL", "" + number);
					  startActivityForResult(intent, 1);
				}
				if ( v.getId() == R.id.button2 )
				{
					EditText counter_text = ( EditText )findViewById( R.id.editText1 );
					int number = Integer.parseInt( counter_text.getText().toString() ) ;
					number++;
					counter_text.setText("" + number);
				}
				if ( v.getId() == R.id.button3 )
				{
					EditText counter_text = ( EditText )findViewById( R.id.editText2 );
					int number = Integer.parseInt( counter_text.getText().toString() ) ;
					number++;
					counter_text.setText("" + number);
				}
			}
		}
	}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_main);
        for ( int i = 0 ; i < ButtonIds.length ; i++ )
        {
        	Button button = ( Button ) findViewById ( ButtonIds[ i ] ) ;
        	button.setOnClickListener( buttonClickListener ) ;
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.practical_test01_main, menu);
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
    
    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
    	// apelarea metodei din activitatea parinte este recomandata, dar nu obligatorie
    	super.onSaveInstanceState(savedInstanceState);
    	EditText counter_text1 = (EditText)findViewById(R.id.editText1);
    	EditText counter_text2 = (EditText)findViewById(R.id.editText2);
    	savedInstanceState.putString("counter1", counter_text1.getText().toString());
    	savedInstanceState.putString("counter2", counter_text1.getText().toString());
    }
    
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
    	// apelarea metodei din activitatea parinte este recomandata, dar nu obligatorie
    	super.onRestoreInstanceState(savedInstanceState);
    	EditText counter_text1 = (EditText)findViewById(R.id.editText1);
    	EditText counter_text2 = (EditText)findViewById(R.id.editText2);
    	if ( savedInstanceState.containsKey( "counter1" ) )
    	{
    		counter_text1.setText(savedInstanceState.getString("counter1"));
    	}
    	if ( savedInstanceState.containsKey( "counter2" ) )
    	{
    		counter_text2.setText(savedInstanceState.getString("counter2"));
    	}
    }
    
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
    	if (requestCode == 1) {
    		Toast.makeText(this, "Secondary activity returned with code " + resultCode, Toast.LENGTH_LONG).show();
    	}
    }
}
