package ph.adoremus.suspensiontraining.adapters;

import java.util.ArrayList;
import java.util.List;

import ph.adoremus.suspensiontraining.R;
import ph.adoremus.suspensiontraining.factory.PhaseViewFactory;
import ph.adoremus.suspensiontraining.factory.WeekViewFactory;
import ph.adoremus.suspensiontraining.model.Phase;
import ph.adoremus.suspensiontraining.model.Week;
import ph.adoremus.suspensiontraining.utils.Logger;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

public class PhaseItemAdapter extends ArrayAdapter<Phase> {

	private Context context;
	private Integer resource;
	private List<Phase> items;
	private PhaseViewFactory pivf;
	private WeekViewFactory wvf;

	public PhaseItemAdapter(Context context, int resource,
			List<Phase> objects) {
		super(context, resource, objects);
		pivf = new PhaseViewFactory(context);
		wvf = new WeekViewFactory(context);

		Logger.log(Thread.currentThread().getStackTrace(), "items " + objects.size(), Log.DEBUG);
		
		this.context = context;
		this.resource = resource;
		this.items = objects;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		Phase phase = items.get(position);
		Logger.log(Thread.currentThread().getStackTrace(), "creating phaseView " + phase.getName(), Log.DEBUG);
		ViewHolder vh;
		if (convertView == null){
			Logger.log(Thread.currentThread().getStackTrace(), "convertView is null, instantiating new viewHolder", Log.DEBUG);
			convertView = LayoutInflater.from(context).inflate(resource, null);
			vh = new ViewHolder();
			vh.tvName = (TextView) convertView.findViewById(R.id.inflate_id_phase_title);
			vh.llWeekItems = (LinearLayout) convertView.findViewById(R.id.inflate_id_week_entries);
			
			for (Week week : phase.getWeeklyExercies()){
				vh.llWeekItems.addView(wvf.createWeekView(week, phase));
			}
			
			convertView.setTag(vh);
		} else {
			Logger.log(Thread.currentThread().getStackTrace(), "convertView not null, retrieving tag viewHolder", Log.DEBUG);
			vh = (ViewHolder) convertView.getTag();
		}
		
//		convertView = pivf.createPhaseItemView(items.get(position), convertView);
		TextView tvName = vh.tvName;
		
		tvName.setText(phase.getName());
	
		return convertView;//super.getView(position, convertView, parent);
	}

	public class ViewHolder{
		TextView tvName;
		LinearLayout llWeekItems;
	}
}
