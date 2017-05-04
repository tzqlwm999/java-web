package GsonChanged;

import com.google.gson.Gson;

public class GsonUser {
	public static void main(String[] args) {
		Gson gson = new Gson();
		User user = new User("guaidaojide", 24, "qqemail");
		gson.toJson(user, System.out);

	}
}