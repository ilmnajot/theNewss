package com.example.thenews.entity;
import com.example.thenews.entity.enums.Authority;
import com.example.thenews.entity.templete.AbstractEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.*;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "users")
public class User extends AbstractEntity implements UserDetails {

    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false, unique = true)
    private String userName;

    @Column(nullable = false)
    private String password;

    private boolean enable;
    private boolean accountNonExpired = true;
    private boolean accountNonLocked = true;
    private boolean credentialsNonExpired = true;

    @ManyToOne(optional = false, fetch = FetchType.LAZY) //optional = false bo'lganligi sababi registratsiya qilgan insoni role bo'lishligi shart
    private Role role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        List<Authority> authorityList = this.role.getAuthorityList();
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        for (Authority authority : authorityList) {
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        //                @Override
//                public String getAuthority() {
//                    return role.getRoleName();
//                }
//            });
//
//
//        }
        return grantedAuthorities;
    }
    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return this.accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return this.enable;
    }

    public User(String fullName, String userName, String password, boolean enable, Role user) {
        this.fullName = fullName;
        this.userName = userName;
        this.password = password;
        this.enable = enable;
    }
}
