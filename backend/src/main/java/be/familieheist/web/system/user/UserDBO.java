package be.familieheist.web.system.user;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("user")
public class UserDBO {
    @Id
    String id;

    @Column("username")
    String username;

    @Column("password")
    String password;

    @Column("email")
    String email;

    @Column("role")
    Role role;
}
