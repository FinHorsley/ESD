/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net;

/**
 *
 * @author Harry Marsh
 */
public class RegisterBean {
 

 private String email;
 private String uname;
 private String passwd;
 
 public String getUserName() {
 return uname;
 }
 public void setUserName(String uname) {
 this.uname = uname;
 }
 public String getPassword() {
 return passwd;
 }
 public void setPassword(String passwd) {
 this.passwd = passwd;
 }
 public void setEmail(String email) {
 this.email = email;
 }
 public String getEmail() {
 return email;
 }
}
