package be.familieheist.web.system.user;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("user")
public class UserDBO {
    @Id
    private String id;

    @Column("username")
    private String username;

    @Column("password")
    private String password;

    @Column("email")
    private String email;

    @Column("role")
    private Role role;
}
