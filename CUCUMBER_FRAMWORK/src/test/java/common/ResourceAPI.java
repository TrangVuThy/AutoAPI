package common;

public enum ResourceAPI {
	GetPlaceAPI("maps/api/place/get/json"),
	AddPlaceAPI("maps/api/place/add/json"),
	UpdatePlaceAPI("maps/api/place/update/json"), 
	DeletePlaceAPI("maps/api/place/delete/json");

	private String resource;

	private ResourceAPI(String resource) {
		this.resource = resource;
	}
	public String getResource() {
		return resource;
	}

}
