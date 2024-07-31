package apps.alquran.utils;

import android.text.Html;
import android.os.Build;

public class HtmlUtils {
    public static String stripHtmlTags(String htmlText) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            return Html.fromHtml(htmlText, Html.FROM_HTML_MODE_LEGACY).toString();
        } else {
            return Html.fromHtml(htmlText).toString();
        }
    }
}
