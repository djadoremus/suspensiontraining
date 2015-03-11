package ph.adoremus.suspensiontraining.factory;

import ph.adoremus.suspensiontraining.DailyRoutines;
import ph.adoremus.suspensiontraining.R;
import ph.adoremus.suspensiontraining.model.Day;
import ph.adoremus.suspensiontraining.model.Phase;
import ph.adoremus.suspensiontraining.model.Week;
import ph.adoremus.suspensiontraining.utils.Logger;
import ph.adoremus.suspensiontraining.utils.Utility;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class DayViewFactory {

	private Context context;
	
	public DayViewFactory(Context context) {
		this.context = context;
	}
	
	public View createDayView(final Day day, final Week week, final Phase phase){
		Logger.log(Thread.currentThread().getStackTrace(), "creating dayView " + day.getName(), Log.DEBUG);
		View v = LayoutInflater.from(context).inflate(R.layout.inflate_day_item, null);
		
		TextView tvTitle = (TextView) v.findViewById(R.id.inflate_day_id_day_title);
		TextView tvDuration = (TextView) v.findViewById(R.id.inflate_day_id_day_duration);
		TextView tvDifficulty = (TextView) v.findViewById(R.id.inflate_day_id_difficulty);
		
		tvTitle.setText(day.getName() + " | " + week.getName() + " | " + phase.getName());
		tvDuration.setText(day.getDuration().toString());
		tvDifficulty.setTag(day.getDifficulty().toString());
		
		v.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Bundle bundle = new Bundle();
				bundle.putString("day", Utility.getInstance().getGson().toJson(day));
				
				Intent dailyRoutines = new Intent(context, DailyRoutines.class);
				dailyRoutines.putExtra("DAY_DATA", bundle);
				
				context.startActivity(dailyRoutines);
				
			}
		});
		
		return v;
	}
}
