/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farm;

import javafx.scene.control.Button;

/**
 *
 * @author Okello John
 */
public class UsersDisplay {
    private String firstName = null;
    private String lastName = null;
    private String Username = null;
    private String Usertype = null;
    private String telephone_num = null;
    private String farm = null;
    private Button editBtn;

    public UsersDisplay(String firstName, String lastName, String Username, String Usertype, String telephone_num, String farm, Button editBtn) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.Username = Username;
        this.Usertype = Usertype;
        this.telephone_num = telephone_num;
        this.farm = farm;
        this.editBtn = editBtn;
    }
    
    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getUsertype() {
        return Usertype;
    }

    public void setUsertype(String Usertype) {
        this.Usertype = Usertype;
    }

    public String getTelephone_num() {
        return telephone_num;
    }

    public void setTelephone_num(String telephone_num) {
        this.telephone_num = telephone_num;
    }

    public String getFarm() {
        return farm;
    }

    public void setFarm(String farm) {
        this.farm = farm;
    }

    public UsersDisplay() {
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
}
