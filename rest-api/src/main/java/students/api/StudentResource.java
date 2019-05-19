package students.api;

import io.jsonwebtoken.Jwts;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.jaxrs.PATCH;
import students.School;
import students.Student;
import students.auth.JWTTokenNeeded;
import students.auth.KeyGenerator;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.Key;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.List;

@Path("/school")
@Api(value = "Students resource")
public class StudentResource {
    @Inject
    private School school;

    @Context
    UriInfo uriInfo;

    @Inject
    private KeyGenerator keyGenerator;

    @POST
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @JWTTokenNeeded
    @ApiOperation(
            value = "Adds new student",
            notes = "Name, height, subjects...",
            response = Student.class
    )
    @ApiResponses(value = {
            @ApiResponse(
                    code = 200,
                    message = "Student added",
                    response = Student.class
            )
    })
    public Student addStudent(
            @Valid
                    Student student
    ) {
        school.enroll(student);
        return student;
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(
            value = "Returns student with specified id",
            notes = "id is specified in path",
            response = Student.class
    )
    @ApiResponses(value = {
            @ApiResponse(
                    code = 200,
                    message = "Student returned",
                    response = Student.class
            ),
            @ApiResponse(
                    code = 404,
                    message = "Student not found"
            )
    })
    public Response getStudent(
            @PathParam("id")
                    Integer id
    ) {

        if (school.containsKey(id)) {
            return Response.status(Response.Status.OK).entity(school.get(id)).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @GET
    @Path("/avatar")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAvatar() {
        String base64Image;

        String imagePath = "/home/prenc/Desktop/students/rest-api/src/main/java/students/avatar.jpg";
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

    @PUT
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @JWTTokenNeeded
    @ApiOperation(
            value = "Updates student with specified id",
            notes = "id is specified in path",
            response = Student.class
    )
    @ApiResponses(value = {
            @ApiResponse(
                    code = 200,
                    message = "Updated student",
                    response = Student.class
            ),
            @ApiResponse(
                    code = 404,
                    message = "Student with specified id not found"
            ),
            @ApiResponse(
                    code = 500,
                    message = "This should have never happened"
            )
    })
    public Response updateStudent(
            @PathParam("id")
                    Integer id,
            @Valid
                    Student newStudent
    ) {
        if (school.containsKey(id)) {
            school.put(id, newStudent);
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
    }

    @PATCH
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @JWTTokenNeeded
    public Response patchStudent(
            @PathParam("id")
                    Integer id,
            Student newStudent
    ) {
        if (school.containsKey(id)) {
            Student oldValue = school.get(id);
            if (newStudent.getName() != null) {
                oldValue.setName(newStudent.getName());
            }

            oldValue.setName(newStudent.getName());

            if (newStudent.getSubjects() != null) {
                oldValue.setName(newStudent.getName());
            }
            school.put(id, oldValue);
            return Response.status(Response.Status.ACCEPTED).entity(oldValue).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @JWTTokenNeeded
    @ApiOperation(
            value = "Deletes student with specified id",
            notes = "id is specified in path",
            response = Boolean.class
    )
    @ApiResponses(value = {
            @ApiResponse(
                    code = 200,
                    message = "Student is deleted",
                    response = Boolean.class
            ),
            @ApiResponse(
                    code = 404,
                    message = "Student with specified id was not found",
                    response = Boolean.class
            )
    })
    public Response deleteStudent(
            @PathParam("id")
                    Integer id
    ) {
        if (school.containsKey(id)) {
            school.remove(id);
            return Response.status(Response.Status.OK).entity(true).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).entity(false).build();
        }
    }

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(
            value = "Returns all students",
            notes = "can return list of students having same name by providing queryParam",
            response = List.class
    )
    @ApiResponses(value = {
            @ApiResponse(
                    code = 200,
                    message = "Students returned",
                    response = List.class
            ),
            @ApiResponse(
                    code = 404,
                    message = "Queried students not found"
            )
    })
    public Response getStudents(
            @QueryParam("studentName") final String studentName
    ) {
        if (studentName != null) {
            List<Student> students = new ArrayList<>();
            for (Student student : school.values()) {
                if (student.getName().equals(studentName)) {
                    students.add(student);
                }
            }

            if (students.isEmpty()) {
                return Response.status(Response.Status.NOT_FOUND).build();
            } else {
                return Response.status(Response.Status.OK).entity(students).build();
            }
        } else {
            return Response.status(Response.Status.OK).entity(school.values()).build();
        }
    }

    private String issueToken(String login) {
        Key key = keyGenerator.generateKey();
        return Jwts.builder()
                .setSubject(login)
                .setIssuer(uriInfo.getAbsolutePath().toString())
                .setIssuedAt(new Date())
                .setExpiration(Date.from(LocalDateTime.now().plusMinutes(15L).atZone(ZoneId.systemDefault()).toInstant()))
                .signWith(key)
                .compact();
    }
}
