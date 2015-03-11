package ph.adoremus.suspensiontraining;

import ph.adoremus.suspensiontraining.fragments.DailyRoutinesFragment;
import ph.adoremus.suspensiontraining.utils.Logger;
import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;

public class DailyRoutines extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_daily_routines);
		Logger.log(Thread.currentThread().getStackTrace(), "" + getIntent().getExtras().getBundle("DAY_DATA").getString("day"), Log.DEBUG);
		if (savedInstanceState == null) {
			Fragment fragment = new DailyRoutinesFragment();
			fragment.setArguments(getIntent().getExtras().getBundle("DAY_DATA"));
			getFragmentManager().beginTransaction()
					.add(R.id.container, fragment).commit();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.daily_routines, menu);
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
