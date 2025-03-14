package beans;

import dao.UserDao;
import dao.daoImpl.UserDaoImpl;
import models.User;
import org.mindrot.jbcrypt.BCrypt;
import services.AuthService;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class AuthBean {

    UserDao userDao = new UserDaoImpl();
    AuthService authService = new AuthService(userDao);
    private String fullName;
    private String username;
    private String email;
    private String password;
    private String cpassword;
    private String contact;
    private String userType;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getCpassword() {
        return cpassword;
    }

    public void setCpassword(String cpassword) {
        this.cpassword = cpassword;
    }

    public String loginTest(){
        if(username.equals("nischal")){
            if(password.equals("nischal")){
                return "dashboard";
            }else{
                return "login";
            }
        }else{
            return "login";
        }
    }

    public boolean registerUser(String username,String email,String contact, String fullName,String userType,String password){
        boolean status = false;
        User newUser = new User();
        newUser.setUsername(username);
        newUser.setEmail(email);
        newUser.setContact(contact);
        newUser.setFullName(fullName);
        newUser.setUserType(userType);
        String hashedPassword = BCrypt.hashpw(password,BCrypt.gensalt(12));
        newUser.setPassword(hashedPassword);

        if(authService.registerUser(newUser)){
            status=true;
        }

        return status;
    }

    public String registerPage(){
        return "register";
    }

    public String loginPage(){
        return "login";
    }
}
