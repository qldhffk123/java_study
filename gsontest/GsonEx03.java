package gsontest;

import com.google.gson.Gson;

public class GsonEx03 {

	public static void main(String[] args) {
		//1. 다운 받은 json data
		String jsonData="{\"name\":\"코스\",\"age\":40}";
		System.out.println(jsonData);
		//2. json data -> json object 변환
		Gson gson=new Gson();
		People people=gson.fromJson(jsonData, People.class);
		System.out.println(people.getName());
		System.out.println(people.getAge());
	}

}
