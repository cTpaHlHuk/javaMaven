package Lesson16;

import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class PersonApi {
    public static Person getPersonFromApi() {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://randomuser.me/api"))
                .GET().build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            Person person = parseJsonToPerson(response);
            return person;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Person parseJsonToPerson(HttpResponse<String> response) {
        JSONObject object = new JSONObject(response.body())
                .getJSONArray("results")
                .getJSONObject(0);
        Person res = new Person();
        res.setName(object.getJSONObject("name").getString("first"));
        res.setLastName(object.getJSONObject("name").getString("last"));
        res.setCountry(object.getJSONObject("location").getString("country"));

        res.setUsername(object.getJSONObject("login").getString("username"));
        res.setPassword(object.getJSONObject("login").getString("password"));
        //res.setDob(LocalDateTime.parse(object.getJSONObject("dob").getString("date")));

        ZonedDateTime zonedDateTime = ZonedDateTime.parse(object.getJSONObject("dob").getString("date"));
        System.out.println(zonedDateTime);
        res.setDob(zonedDateTime.toLocalDateTime());

        // DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
         //LocalDateTime dateTime = LocalDateTime.parse("date", format);

//дополнить остальные поля.. поле с датой загуглить/ из стринга перевести в дату и вывести
        return res;
    }
}
