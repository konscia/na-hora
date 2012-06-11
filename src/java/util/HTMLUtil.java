package util;

public class HTMLUtil {

    public static String link(String url, String texto){
        return "<a href=\""+url+"\" target=\"_blank\">"+texto+"</a>";
    }
}
