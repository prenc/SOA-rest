package students;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Consumer {
    private static final String URL = "http://localhost:8080/rest-api/school";
    private static String jwtToken;

    public static void main(String[] args) {
        jwtToken = login("xxx", "xxx");
        System.out.println(jwtToken);

        Student exampleS = new Student("Michal", 177, new ArrayList<>(Arrays.asList(new Subject("PE"),
                new Subject("trele"))));

        System.out.println("Add student");
        Response response = makePost("/", exampleS);
        System.out.println(response.readEntity(new GenericType<Student>() {
        }));

        printAllStudents();
    }

    private static void printAllStudents() {
        printHLine("ALL STUDENTS");
        Response response = makeGet("/");
        List<Student> studentList = response.readEntity(new GenericType<List<Student>>() {
        });
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < studentList.size(); i++) {
            output.append(i + 1).append(": ").append(studentList.get(i)).append("\n");
        }
        output.deleteCharAt(output.lastIndexOf("\n"));
        System.out.println(output);
        printHLine("");
    }

    private static Response makePost(String url, Student student) {
        ResteasyClient client = new ResteasyClientBuilder().build();
        ResteasyWebTarget target = client.target(URL);

        Response response = target
                .path(url)
                .request()
                .header("Authorization", jwtToken)
                .post(Entity.entity(student, MediaType.APPLICATION_JSON_TYPE));

        client.close();

        return response;
    }

    private static Response makeGet(String url) {
        ResteasyClient client = new ResteasyClientBuilder().build();
        ResteasyWebTarget target = client.target(URL);

        Response response = target
                .path(url)
                .request()
                .get();

        client.close();

        return response;
    }

    private static String login(String login, String password) {
        ResteasyClient client = new ResteasyClientBuilder().build();
        ResteasyWebTarget target = client.target((URL));

        Form form = new Form();
        form.param("login", login).param("password", password);

        Response response = target
                .path("login")
                .request()
                .post(Entity.form(form));
        client.close();

        return response.getHeaderString("Authorization");
    }

    private static void printHLine(String text) {
        char sign = '$';
        int width = 40;
        String newText;
        if (text.length() == 0) {
            newText = text;
        } else {
            newText = " " + text + " ";
        }

        StringBuilder output = new StringBuilder();
        int offset = (width - text.length()) / 2;
        for (int i = 0; i < offset; i++) output.append(sign);
        output.append(newText);
        for (int i = 0; i < offset; i++) output.append(sign);

        System.out.println(output);
    }
}
