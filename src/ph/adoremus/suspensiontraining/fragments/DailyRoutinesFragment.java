package ph.adoremus.suspensiontraining.fragments;

import java.util.LinkedList;
import java.util.List;

import ph.adoremus.suspensiontraining.R;
import ph.adoremus.suspensiontraining.adapters.DayRoutinesAdapter;
import ph.adoremus.suspensiontraining.adapters.PhaseItemAdapter;
import ph.adoremus.suspensiontraining.interfaces.BaseView;
import ph.adoremus.suspensiontraining.model.Day;
import ph.adoremus.suspensiontraining.model.Phase;
import ph.adoremus.suspensiontraining.model.Routines;
import ph.adoremus.suspensiontraining.model.Week;
import ph.adoremus.suspensiontraining.utils.Logger;
import ph.adoremus.suspensiontraining.utils.Utility;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

/**
 * A placeholder fragment containing a simple view.
 */
public class DailyRoutinesFragment extends Fragment implements BaseView {

	private View rootView;
	private View inflatedParent;
	private ListView llRoutinesList;
	
	private Day day;

	public DailyRoutinesFragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		rootView = inflater.inflate(R.layout.fragment_daily_routines, container, false);
		setupViews();
		initialize();
		return rootView;
	}

	public void setupViews() {
		Logger.log(Thread.currentThread().getStackTrace(), "setting up views of fragment_daily_routines", Log.DEBUG);
		inflatedParent = (View) rootView.findViewById(R.id.id_daily_routines_inflated_parent);
		llRoutinesList = (ListView) rootView.findViewById(R.id.id_daily_routines_list);
	}

	public void initialize() {
		Logger.log(Thread.currentThread().getStackTrace(), "initializing views of fragment_daily_routines", Log.DEBUG);
		day = Utility.getInstance().getGson().fromJson(getArguments().getString("day"), Day.class);
		
		llRoutinesList.setAdapter(new DayRoutinesAdapter(getActivity().getApplicationContext(), R.layout.inflate_routines_item, day.getDailyRoutines()));
	}
}