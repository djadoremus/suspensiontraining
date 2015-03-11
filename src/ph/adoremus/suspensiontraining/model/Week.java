package ph.adoremus.suspensiontraining.model;

import java.util.LinkedList;
import java.util.List;

import ph.adoremus.suspensiontraining.enums.PosType;
import ph.adoremus.suspensiontraining.enums.RepType;

public class Week extends BaseModel {
	private List<Day> dailyExercies;

	public List<Day> getDailyExercies() {
		return dailyExercies;
	}

	public void setDailyExercies(List<Day> dailyExercies) {
		this.dailyExercies = dailyExercies;
	}

}
