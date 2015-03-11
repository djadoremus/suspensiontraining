package ph.adoremus.suspensiontraining.adapters;

import java.util.List;

import ph.adoremus.suspensiontraining.R;
import ph.adoremus.suspensiontraining.model.Routines;
import ph.adoremus.suspensiontraining.utils.Utility;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class DayRoutinesAdapter extends ArrayAdapter<Routines> {

	private Context context;
	private Integer resource;
	private List<Routines> items;

	public DayRoutinesAdapter(Context context, int resource,
			List<Routines> objects) {
		super(context, resource, objects);
		this.context = context;
		this.resource = resource;
		this.items = objects;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder vh;
		final Routines r = items.get(position);
		if (convertView == null) {
			convertView = LayoutInflater.from(context).inflate(resource, null);
			vh = new ViewHolder();
			
			
			vh.tvName = (TextView) convertView
					.findViewById(R.id.inflate_id_routines_round_title);
			vh.llRoundItems = (LinearLayout) convertView
					.findViewById(R.id.inflate_id_routines_container);
			
			convertView.setTag(vh);
		} else {
			vh = (ViewHolder) convertView.getTag();
		}

		convertView.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Toast.makeText(context, "routine " + Utility.getInstance().getGson().toJson(r), Toast.LENGTH_LONG).show();
			}
		});

		vh.tvName.setText(r.getName());

		return convertView;// super.getView(position, convertView, parent);
	}

	public class ViewHolder {
		TextView tvName;
		LinearLayout llRoundItems;
	}

}
