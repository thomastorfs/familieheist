package be.familieheist.web.user.domain;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class User {

    private String username;
    private String password;

    private String email;

    private String firstname;
    private String lastname;

}
