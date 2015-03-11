package ph.adoremus.suspensiontraining.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Utility {
	private static Utility instance;
	
	private Gson gson;
	
	private Utility() {
		gson = (new GsonBuilder().serializeSpecialFloatingPointValues()).create();
	}
	
	public static Utility getInstance(){
		if (instance == null){
			instance = new Utility();
		}
		
		return instance;
	}
	
	public Gson getGson() {
		return gson;
	}
}
