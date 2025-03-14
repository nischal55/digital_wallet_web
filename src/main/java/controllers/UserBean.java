package controllers;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.validation.constraints.NotNull;

@ManagedBean
@RequestScoped
public class UserBean {
    @NotNull(message = "Username is required")
    private String name;
    private String password;
    // Getter and setter

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Action method
    public String submit() {
        if(name.equalsIgnoreCase("nischal")){
            if(password.equals("password")){
                return "dashboard?faces-redirect=true";
            }else{
                return "fail";
            }
        }else{
            return "fail";
        }
    }
    private String outcome;

    public String getOutcome() {
        return outcome;
    }

    public void setOutcome(String outcome) {
        this.outcome = outcome;
    }

    public String navigate() {
        return "dashboard?faces-redirect=true";
    }
}
