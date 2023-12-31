package dev.toktab.rest_api_crud.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserFormController {

    @GetMapping("/user-form")
    @ResponseBody
    public String showUserForm() {
        return """
                <!DOCTYPE html>
                <html lang="en">
                <head>
                    <meta charset="UTF-8">
                    <meta name="viewport" content="width=device-width, initial-scale=1.0">
                    <title>User Form</title>
                </head>
                <body>
                    <h2>Create or Update User</h2>

                    <!-- Create User Form -->
                    <form action="/create" method="post">
                        <label for="createUsername">Username:</label>
                        <input type="text" id="createUsername" name="username" required>

                        <label for="createPassword">Password:</label>
                        <input type="password" id="createPassword" name="password" required>

                        <button type="submit">Create User</button>
                    </form>

                    <hr>

                    <!-- Update User Form -->
                    <form action="/update" method="put">
                        <label for="updateUserId">User ID to Update:</label>
                        <input type="text" id="updateUserId" name="id" required>

                        <label for="updateUsername">New Username:</label>
                        <input type="text" id="updateUsername" name="username" required>

                        <label for="updatePassword">New Password:</label>
                        <input type="password" id="updatePassword" name="password" required>

                        <button type="submit">Update User</button>
                    </form>
                </body>
                </html>
                """;
    }
    
}




















// @Controller
// public class UserFormController {
    
    
//     // @ResponseBody//for rest
//     //@Controller for basic html returns. @RestController for basic value returns
//     //if we want a @Controller to return a @Restcontroller basic value instead of html
//     //we use this @ResponseBody
//     @GetMapping("/user-form")
//     public String showUserForm(){
//         return "user-form"; // This corresponds to the HTML file name without the extension
//     }
// }
