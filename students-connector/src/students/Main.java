package students;

import javax.xml.ws.BindingProvider;
import java.io.File;
import java.io.FileInputStream;
import java.util.Base64;

public class Main {

    public static void main(String[] args) {
        SchoolServiceService s = new SchoolServiceService();
        SchoolService service = s.getSchoolServicePort();

        ((BindingProvider) service).getRequestContext().put(BindingProvider.USERNAME_PROPERTY, "t1");
        ((BindingProvider) service).getRequestContext().put(BindingProvider.PASSWORD_PROPERTY, "1234");
//        ((BindingProvider) service).getRequestContext().put(BindingProvider.USERNAME_PROPERTY, "a1");
//        ((BindingProvider) service).getRequestContext().put(BindingProvider.PASSWORD_PROPERTY, "1234");


        for (Student i : service.studentsByName()) {
            System.out.println(i.toString());
        }


        File img = new File("/home/prenc/Documents/SOA/students/students-connector/src/students/avatar.jpg");


        String avatar;
        try {
            FileInputStream fileInputStream = new FileInputStream(img);
            byte[] bytesImg = new byte[(int) img.length()];
            fileInputStream.read(bytesImg);
            avatar = Base64.getEncoder().encodeToString(bytesImg);
            service.setAvatar("jas", avatar);
        } catch (Exception e) {
            e.printStackTrace();
        }


        System.out.println(service.getAvatar("jas"));
    }

}
