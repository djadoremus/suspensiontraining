package ph.adoremus.suspensiontraining.model;

import java.util.List;

public class Phase extends BaseModel {
	private List<Week> weeklyExercies;

	public List<Week> getWeeklyExercies() {
		return weeklyExercies;
	}

	public void setWeeklyExercies(List<Week> weeklyExercies) {
		this.weeklyExercies = weeklyExercies;
	}
}
