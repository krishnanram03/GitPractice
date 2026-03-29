package Resources;

public enum EnumConst 
{

	addPlaceApi("/maps/api/place/add/json"),
	getPlaceApi("/maps/api/place/get/json"),
	deletePlaceApi("/maps/api/place/delete/json");
	private String link;
	
	
	EnumConst(String link)
	{
    this.link=link;		
	}
	
	public String getLink()
	{
		return link;
	}
	
}
