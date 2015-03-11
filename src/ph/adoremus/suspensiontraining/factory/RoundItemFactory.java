package ph.adoremus.suspensiontraining.factory;

import ph.adoremus.suspensiontraining.R;
import ph.adoremus.suspensiontraining.model.Routines;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class RoundItemFactory {
	private  Context context;
	
	public RoundItemFactory(Context context) {
		this.context = context;
	}
	
	public View createRountItemView(Routines routine){
		View v = LayoutInflater.from(context).inflate(R.layout.inflate_routines_round, null);
		
		TextView tvRoundItemTitle = (TextView) v.findViewById(R.id.inflate_id_routines_item_title);
		TextView tvRoundItemReps = (TextView) v.findViewById(R.id.inflate_id_routines_item_reps);
		
		tvRoundItemTitle.setText(routine.getName());
		tvRoundItemReps.setText(routine.getReps().toString());
		
		v.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
		});
	
		return v;
	}
}
