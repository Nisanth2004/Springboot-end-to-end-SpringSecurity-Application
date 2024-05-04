package com.nisanth.sbendtoendapplication.registration.password;

import com.nisanth.sbendtoendapplication.registration.token.TokenExpirationTime;
import com.nisanth.sbendtoendapplication.user.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class PasswordResetToken
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;
     private String token;
     private Date expirationTime;
     @OneToOne
     @JoinColumn(name="user_id")
     private User user;

    public PasswordResetToken(String token,  User user) {
        this.token = token;
        this.user = user;
        this.expirationTime = TokenExpirationTime.getExpirationTime();

    }
}
