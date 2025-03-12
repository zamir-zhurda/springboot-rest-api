package net.javaguides.springboot.controllers;

import net.javaguides.springboot.beans.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

//    http://localhost:8080/student
   @GetMapping("/student")
   public Student getStudent(){
       Student student = new Student(1,"Zamir","Zhurda");
       return student;
   }
   //    http://localhost:8080/students
    @GetMapping("/students")
    public List<Student> getStudents(){
        List<Student> oListStudents = new ArrayList<Student>();
        oListStudents.add( new Student(1,"Zamir","Zhurda"));
        oListStudents.add( new Student(2,"Miri","Zhurda"));
        oListStudents.add( new Student(3,"Gerta","Zhurda"));
        oListStudents.add( new Student(4,"Blerta","Zhurda"));
        return oListStudents;
    }

   /* Spring Boot REST API with Path Variable
      {id} - first URI template variable
      {first-name} - second URI template variable
      {last-name} - third template variable
      http://localhost:8080/students/5/Zamir/Zhurda
    */
   @GetMapping("/students/{id}/{first-name}/{last-name}")
   public Student getStudentWithPathVariable(@PathVariable("id") int studentId, @PathVariable("first-name") String firstName, @PathVariable("last-name") String lastName){
       return new Student(studentId,firstName,lastName);
   }

    /*
       Spring Boot REST API with Request Parameter
       http://localhost:8080/students/query?id=1&firstName=Zamir&lastName=Zhurda
     */
    @GetMapping("/students/query")
    public Student getStudentWithQueryParameter(@RequestParam("id") int id,
                                                 @RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName){
        return new Student(id,firstName,lastName);
    }

    /*
       Spring Boot REST API that handles HTTP POST request
       @PostMapping and @RequestBody
       http://localhost:8080/students/create
     */
    @PostMapping("students/create")
    public Student createStudent(@RequestBody Student studentToBeCreated){
        Integer id = studentToBeCreated.getId();
        String firstName = studentToBeCreated.getFirstName();
        String lastName = studentToBeCreated.getLastName();
        System.out.println("Created student : " +id + " " + firstName + " "+ lastName );
        return studentToBeCreated;
    }

    /*
   Spring Boot REST API that handles HTTP PUT request
   @PutMapping and @RequestBody
   http://localhost:8080/students/{id}/update
 */
    @PutMapping("students/{id}/update")
    public Student updateStudent(@PathVariable("id") int studentId, @RequestBody Student studentToBeUpdated){
        Integer id = studentId;
        String firstName = studentToBeUpdated.getFirstName();
        String lastName = studentToBeUpdated.getLastName();
        System.out.println("Updated student : " + id + " " + firstName + " "+ lastName );
        studentToBeUpdated.setId(id);
        return studentToBeUpdated;
    }

   /*
   Spring Boot REST API that handles HTTP DELETE request
   This deletes an existing request
   @DeleteMapping and @RequestBody
   http://localhost:8080/students/{id}/delete
 */
    @DeleteMapping("/students/{id}/delete")
    public String deleteStudent(@PathVariable("id") int studentId)
    {
        return "Student deleted sucessfully!";
    }
}
