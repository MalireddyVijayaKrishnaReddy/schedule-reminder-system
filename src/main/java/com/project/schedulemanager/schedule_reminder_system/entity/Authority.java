package com.project.schedulemanager.schedule_reminder_system.entity;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "authorities")
@IdClass(Authority.AuthorityId.class)
public class Authority {

    @Id
    @Column(name = "username", nullable = false)
    private String username;

    @Id
    @Column(name = "authority", nullable = false)
    private String authority;

    public Authority() {
    }

    public Authority(String username, String authority) {
        this.username = username;
        this.authority = authority;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    // Composite Key Class for @IdClass
    public static class AuthorityId implements Serializable {
        private String username;
        private String authority;

        public AuthorityId() {
        }

        public AuthorityId(String username, String authority) {
            this.username = username;
            this.authority = authority;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            AuthorityId that = (AuthorityId) o;
            return Objects.equals(username, that.username) &&
                    Objects.equals(authority, that.authority);
        }

        @Override
        public int hashCode() {
            return Objects.hash(username, authority);
        }
    }
}
