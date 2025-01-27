package richardlab21g01project2.utils.entities;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class MyUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String role;       

    @Column(nullable = false)
    private String creationDate;

    // @Lob
    // @Column(nullable = false)
    // private byte[] pfp;

    private Long phoneNumber;
    private String firstName, lastName, address;
    
    // @Column(nullable = false, unique = true)
    private String email;

    public MyUser() {}

    public MyUser(RegistrationForm form) {
        this.username = form.getUsername();
        this.password = form.getPassword();
        // this.role = "USER";
        // this.creationDate = ZonedDateTime.now().format(DateTimeFormatter.ISO_ZONED_DATE_TIME);
        this.phoneNumber = form.getPhoneNumber();
        this.firstName = form.getFirstName();
        this.lastName = form.getLastName();
        this.address = form.getAddress();
        this.email = form.getEmail();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ZonedDateTime getCreationDate() {
        return ZonedDateTime.parse(creationDate, DateTimeFormatter.ISO_ZONED_DATE_TIME);
    }

    public void setCreationDate(ZonedDateTime creationDate) {
        this.creationDate = creationDate.format(DateTimeFormatter.ISO_ZONED_DATE_TIME);
    }
    
    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }
}

// @Entity
// public class MyUser {
    
//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     protected int id;
//     protected int phoneNumber;
//     protected String userName, firstName, lastName, address, email, hashed_pwd;
//     protected boolean isAdmin;

//     public MyUser() {}

//     public MyUser(String firstName, String lastName, String address, int phoneNumber, String email, String pwd, boolean isAdmin) {
//         // this.id = id;
//         this.userName = firstName + " " + lastName;
//         this.firstName = firstName;
//         this.lastName = lastName;
//         this.address = address;
//         this.phoneNumber = phoneNumber;
//         this.email = email;
//         this.hashed_pwd = pwd;
//         this.isAdmin = isAdmin;
//     }
    

//     public String getFirstName() {
//         return this.firstName;
//     }
    
//     public String getLastName() {
//         return this.firstName;
//     }

//     public String getUsername() {
//         return username;
//     }

//     public void setUsername(String username) {
//         this.username = username;
//     }

//     public String getPassword() {
//         return this.hashed_pwd;
//     }

//     public void setPassword(String pwd) {
//         this.hashed_pwd = pwd;
//     }
    
//     public String getAddress() {
//         return this.firstName;
//     }
    
//     public String getEmail() {
//         return this.firstName;
//     }

//     public String getName() {
//         return this.firstName + " " + this.lastName;
//     }

//     public String getRole() {
//         return this.isAdmin ? "ADMIN" : "USER";
//     }
// }