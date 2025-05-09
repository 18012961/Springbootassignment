package model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name= "  User")

public class User {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
     private Long userId;

    @Column (nullable = false, unique = true, length = 100)
    private String userName;

    public String getUserSurName() {
        return userSurName;
    }

    public void setUserSurName(String userSurName) {
        this.userSurName = userSurName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Column (nullable = false, unique = true, length = 100)
    private String userSurName;
}
