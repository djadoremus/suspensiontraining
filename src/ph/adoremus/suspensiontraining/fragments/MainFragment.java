package ph.adoremus.suspensiontraining.fragments;

import java.util.LinkedList;
import java.util.List;

import ph.adoremus.suspensiontraining.R;
import ph.adoremus.suspensiontraining.adapters.PhaseItemAdapter;
import ph.adoremus.suspensiontraining.interfaces.BaseView;
import ph.adoremus.suspensiontraining.model.Day;
import ph.adoremus.suspensiontraining.model.Phase;
import ph.adoremus.suspensiontraining.model.Routines;
import ph.adoremus.suspensiontraining.model.Week;
import ph.adoremus.suspensiontraining.utils.Logger;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainFragment extends Fragment implements BaseView {

	private View rootView;

	private ListView lvPhases;

	public MainFragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		rootView = inflater.inflate(R.layout.fragment_main, container, false);
		setupViews();
		initialize();
		return rootView;
	}

	public void setupViews() {
		Logger.log(Thread.currentThread().getStackTrace(), "setting up views of fragment_main", Log.DEBUG);
		lvPhases = (ListView) rootView.findViewById(R.id.id_phase);
	}

	public void initialize() {
		Logger.log(Thread.currentThread().getStackTrace(), "initializing views of fragment_main", Log.DEBUG);
		// call db? set to phaseItem objects
		List<Phase> phases = new LinkedList<Phase>();
		for (int i = 0; i < 3; i++) {
			Phase item = new Phase();
			item.setName("Phase " + (i + 1));
			
			item.setWeeklyExercies(new LinkedList<Week>());
			for (int j=0; j < 4; j++){
				Week week = new Week();
				week.setName("Week " + (j+1));
				
				week.setDailyExercies(new LinkedList<Day>());
				for (int k=0; k<4; k++){
					Day day = new Day();
					day.setName("Day " + (k+1));
					day.setDifficulty(k);
					day.setDuration(k*5);
					
					day.setDailyRoutines(new LinkedList<Routines>());
					for (int l=0; l<6; l++){
						Routines routine = new Routines();
						routine.setName("Routine " + (l+1));
						day.getDailyRoutines().add(routine);
					}
					week.getDailyExercies().add(day);
				}
				item.getWeeklyExercies().add(week);
			}
			phases.add(item);
		}
		lvPhases.setAdapter(new PhaseItemAdapter(getActivity(),
				R.layout.inflate_phase_item, phases));
	}
}