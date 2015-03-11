package ph.adoremus.suspensiontraining.factory;

import ph.adoremus.suspensiontraining.R;
import ph.adoremus.suspensiontraining.model.Phase;
import ph.adoremus.suspensiontraining.model.Week;
import ph.adoremus.suspensiontraining.utils.Logger;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;

public class PhaseViewFactory {
	
	private Context context;
	private WeekViewFactory wvf;

	public PhaseViewFactory(Context context) {
		this.context = context;
		this.wvf = new WeekViewFactory(context);
	}
	
	public View createPhaseItemView(Phase pi, View v){
		Logger.log(Thread.currentThread().getStackTrace(), "creating phaseView " + pi.getName(), Log.DEBUG);
		if (v == null){
			v = LayoutInflater.from(context).inflate(R.layout.inflate_phase_item, null);
		}
		TextView tvName = (TextView) v.findViewById(R.id.inflate_id_phase_title);
		LinearLayout llWeekItems = (LinearLayout) v.findViewById(R.id.inflate_id_week_entries);
		
		tvName.setText(pi.getName());
		for (Week week : pi.getWeeklyExercies()){
			llWeekItems.addView(wvf.createWeekView(week, pi));
		}
		
		return v;
	}
}
