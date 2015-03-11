package ph.adoremus.suspensiontraining.model;

import ph.adoremus.suspensiontraining.enums.PosType;
import ph.adoremus.suspensiontraining.enums.RepType;

public class Routines extends BaseModel {
	private RepType repType;
	private Integer reps;
	private String videoUriLvl01;
	private String videoUriLvl02;
	private String videoUriLvl03;
	private PosType posType;

	public RepType getRepType() {
		return repType;
	}

	public void setRepType(RepType repType) {
		this.repType = repType;
	}

	public Integer getReps() {
		return reps;
	}

	public void setReps(Integer reps) {
		this.reps = reps;
	}

	public String getVideoUriLvl01() {
		return videoUriLvl01;
	}

	public void setVideoUriLvl01(String videoUriLvl01) {
		this.videoUriLvl01 = videoUriLvl01;
	}

	public String getVideoUriLvl02() {
		return videoUriLvl02;
	}

	public void setVideoUriLvl02(String videoUriLvl02) {
		this.videoUriLvl02 = videoUriLvl02;
	}

	public String getVideoUriLvl03() {
		return videoUriLvl03;
	}

	public void setVideoUriLvl03(String videoUriLvl03) {
		this.videoUriLvl03 = videoUriLvl03;
	}

	public PosType getPosType() {
		return posType;
	}

	public void setPosType(PosType posType) {
		this.posType = posType;
	}

}
