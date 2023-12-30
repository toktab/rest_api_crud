package dev.toktab.rest_api_crud.models;

public class User {

    //Parameters
    private Long id;
    private String username;
    private String password;

    //AllArgsContructor
    public User(Long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    //NoArgsConstructor
    public User() {
    }

    //Data (Getters and Setters)
    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

    public String getUsername() {return username;}

    public void setUsername(String username) {this.username = username;}

    public String getPassword() {return password;}

    public void setPassword(String password) {this.password = password;}

    
    
}
