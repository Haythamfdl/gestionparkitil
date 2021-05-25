package com.sid.gestionparkitil.gestionparkitil.Securiter;

public class JWTUtil {
    public static final String SECRET = "mySecret1234";
    public static final String AUTH_HEADER = "authorization";
    public static final String PREFIX = "Bearer ";
    public static final long EXPIRE_ACCESS_TOKEN = 90*6*1000;
    public static final long EXPIRE_REFRESH_TOKEN = 95*6*1000;
}
