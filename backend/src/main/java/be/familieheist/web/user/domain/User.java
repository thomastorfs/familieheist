package be.familieheist.web.user.domain;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class User {

    private String userName;
    private String email;
    private String password;

    private String firstName;
    private String lastName;

}
