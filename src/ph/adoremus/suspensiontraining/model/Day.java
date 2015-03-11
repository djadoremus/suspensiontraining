package ph.adoremus.suspensiontraining.model;

import java.util.LinkedList;
import java.util.List;

import ph.adoremus.suspensiontraining.enums.PosType;
import ph.adoremus.suspensiontraining.enums.RepType;

public class Day extends BaseModel {
	private Integer duration;
	private Integer difficulty;
	private Integer idxRepeatStart;
	private Integer idxRepeatEnd;
	private List<Routines> dailyRoutines;
	public Integer getDuration() {
		return duration;
	}
	public void setDuration(Integer duration) {
		this.duration = duration;
	}
	public Integer getDifficulty() {
		return difficulty;
	}
	public void setDifficulty(Integer difficulty) {
		this.difficulty = difficulty;
	}
	public Integer getIdxRepeatStart() {
		return idxRepeatStart;
	}
	public void setIdxRepeatStart(Integer idxRepeatStart) {
		this.idxRepeatStart = idxRepeatStart;
	}
	public Integer getIdxRepeatEnd() {
		return idxRepeatEnd;
	}
	public void setIdxRepeatEnd(Integer idxRepeatEnd) {
		this.idxRepeatEnd = idxRepeatEnd;
	}
	public List<Routines> getDailyRoutines() {
		return dailyRoutines;
	}
	public void setDailyRoutines(List<Routines> dailyRoutines) {
		this.dailyRoutines = dailyRoutines;
	}
	
}
