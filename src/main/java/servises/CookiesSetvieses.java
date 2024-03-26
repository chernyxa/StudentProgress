package servises;

import javax.servlet.http.Cookie;

public class CookiesSetvieses {

    public static Cookie getCookieByName(Cookie[] cookies,String cookie){
        if (cookies == null){
            return null;
        }
        for (Cookie c:cookies){
            if (c.getName().equals(cookie)){
                return c;
            }
        }
        return null;
    }
}