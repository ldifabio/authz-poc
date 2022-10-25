package ldifabio.recursosapi;


import java.util.ArrayList;
import java.util.List;

public class UsuarioKeycloak {
    protected String username;
    protected Boolean enabled;
    protected Boolean emailVerified;
    protected String firstName;
    protected String lastName;
    protected String email;
    protected List<String> groups;

    public UsuarioKeycloak() {
    }

    public List<String> getGroups() {
        return this.groups;
    }

    public void setGroups(String group) {
        this.groups = new ArrayList<>();
        groups.add(group);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Boolean getEmailVerified() {
        return emailVerified;
    }

    public void setEmailVerified(Boolean emailVerified) {
        this.emailVerified = emailVerified;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
