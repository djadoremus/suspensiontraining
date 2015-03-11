package ph.adoremus.suspensiontraining.factory;

import ph.adoremus.suspensiontraining.R;
import ph.adoremus.suspensiontraining.model.Day;
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

public class WeekViewFactory {

	private Context context;
	private DayViewFactory dvf;
	
	public WeekViewFactory(Context context) {
		this.context = context;
		this.dvf = new DayViewFactory(context);
	}
	
	public View createWeekView(Week week, Phase phase){
		Logger.log(Thread.currentThread().getStackTrace(), "creating weekView " + week.getName(), Log.DEBUG);

		View v = LayoutInflater.from(context).inflate(R.layout.inflate_week_item, null);
		TextView tvWeekName = (TextView) v.findViewById(R.id.inflate_week_id_week_title);
		LinearLayout llDayContainer = (LinearLayout) v.findViewById(R.id.inflate_week_id_day_container);
		
		tvWeekName.setText(week.getName() + " | " + phase.getName());
		for (Day day : week.getDailyExercies()){
			llDayContainer.addView(dvf.createDayView(day, week, phase));
		}
		return v;
	}
}
