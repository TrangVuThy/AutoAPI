package body;

import java.util.ArrayList;
import java.util.HashMap;

import data_test.UpdatePlace_data;

public class googleApiPayload {
	public HashMap<String, Object> addPlacePayload() {
		HashMap<String, Object> addPlace = new HashMap();
		addPlace.put("accuracy", 60);
		addPlace.put("name", "FNJH");
		addPlace.put("phone_number", "(+91) 983 893 3937");
		addPlace.put("address", "29, side layout, cohen 09");
		addPlace.put("language", "French-IN");
		addPlace.put("website", "www.24.com.vn");

		HashMap<String, Object> l = new HashMap();
		l.put("lat", -4662);
		l.put("lng", 574);
		addPlace.put("location", l);

		ArrayList<String> array = new ArrayList<String>();
		array.add("shoes");
		array.add("shop");
		addPlace.put("types", array);
		return addPlace;
	}

	public HashMap<String, Object> UpdatePlacePayload(String place_id) {
		HashMap<String, Object> updatePlace = new HashMap();
		updatePlace.put("place_id", place_id);
		updatePlace.put("address", UpdatePlace_data.ADDRESS);
		updatePlace.put("key", UpdatePlace_data.KEY);
		
		return updatePlace;

	}
	
	public HashMap<String, Object> DeletePlacePayload(String place_id) {
		HashMap<String, Object> deletePlace = new HashMap();
		deletePlace.put("place_id", place_id);
		
		return deletePlace;

	}

}
