package students.api;

import io.jsonwebtoken.Jwts;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import students.auth.KeyGenerator;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.Key;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Base64;
import java.util.Date;

@Path("/school")
@Api(
        value = "Student resource"
)
public class StudentResource {


    @Context
    UriInfo uriInfo;
    @Inject
    private KeyGenerator keyGenerator;

    @GET
    @Path("/avatar")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAvatar() {
        String base64Image = "";

        String imagePath = "../../../icon.png";
        File file = new File(imagePath);
        try (FileInputStream imageInFile = new FileInputStream(file)) {
            byte[] imageData = new byte[(int) file.length()];
            imageInFile.read(imageData);
            base64Image = Base64.getEncoder().encodeToString(imageData);
        } catch (FileNotFoundException e) {
            System.out.println("Image not found" + e);
            return Response.status(Response.Status.NOT_FOUND).build();
        } catch (IOException ioe) {
            System.out.println("Exception while reading the Image " + ioe);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
        return Response.status(Response.Status.OK).entity(base64Image).build();
    }

    @POST
    @ApiOperation(value = "Login")
    @Path("/login")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response authenticateUser(@FormParam("login") String login, @FormParam("password") String password) {
        try {
            String token = issueToken(login);

            return Response.ok().header(HttpHeaders.AUTHORIZATION, "Bearer " + token).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
    }

    private String issueToken(String login) {
        Key key = keyGenerator.generateKey();
        String jwtToken = Jwts.builder()
                .setSubject(login)
                .setIssuer(uriInfo.getAbsolutePath().toString())
                .setIssuedAt(new Date())
                .setExpiration(Date.from(LocalDateTime.now().plusMinutes(15L).atZone(ZoneId.systemDefault()).toInstant()))
                .signWith(key)
                .compact();
        return jwtToken;
    }

}
