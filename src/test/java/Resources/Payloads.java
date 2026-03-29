package Resources;

import java.util.ArrayList;
import java.util.List;

import pojo.Resolution;
import pojo.location;

public class Payloads {
	Resolution r;
	public Resolution addPlacePayload(String name,String address,String language)
	{
		r=new Resolution();
		r.setAccuracy(50);
		r.setAddess(address);
		r.setLanguage(language);
		r.setName(name);
		r.setPhone_number("9832654896");
		r.setWebsite("www.google.com");
		List<String> n= new ArrayList<String>();
		n.add("Shoes");
		n.add("shop");
		r.setTypes(n);
		location l = new location();
		l.setLat(90.425);
		l.setLng(45.263);
		r.setLocation(l);
		System.out.println("Edit done by Timezone2 guy");
		return r;
		
	}
	
	public String getPlacePayload(String placeid)
	{
		System.out.println("Edit done by Timezone2 guy");
		System.out.println("Edit done by timezone1 guy");
	return placeid;
	}
	
	
	public String deletePlacePayload(String placeid)
	{
		System.out.println("Testing");
	return "{\"place_id\":\""+placeid+"\"}";
	}

	
	
}
