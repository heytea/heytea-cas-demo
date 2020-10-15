package com.heytea.demo.cas.client1.controller;

/**
 * @author houyehua
 *
 */
public class ConfigConstant {

    public static String SERVICE_ID = "https://dev-sso-client1.heyteago.com/login/cas";
    public static String CAS_SERVER_URL_PREFIX = "https://dev-cas.heyteago.com/api/base-oauth2";
    public static String LOGIN_URL = CAS_SERVER_URL_PREFIX + "/login";
    public static String LOGOUT_SUCCESS_URL = CAS_SERVER_URL_PREFIX + "/logout";
    public static String LOGOUT_CALLBACK_PATH = CAS_SERVER_URL_PREFIX + "/exit/cas";

}