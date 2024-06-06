package com.academy.Cusromers;

public class Conexion {
    private static Conexion intanse;

    private String Usuario;
    private  String password;
    private String Host;
    private String port;


    private Conexion(){}

    public static Conexion intance(){
        if (intanse == null) {
            intanse = new Conexion();
        }
        return  intanse;
    }

    public String getHost() {
        return Host;
    }

    public void setHost(String host) {
        Host = host;
    }





    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String usuario) {
        Usuario = usuario;
    }
}
