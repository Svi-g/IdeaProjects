package CoolPack;

import java.applet.Applet;
import java.applet.AppletContext;
import java.net.MalformedURLException;
import java.net.URL;

/*
<applet code="ACDemo" width=300 height=50>
</applet>
*/

/* Using an applet context, getCodeBase(),
and showDocument() to display an HTML file.
*/
public class ACDemo extends Applet {
    public void start() {
        AppletContext ac = getAppletContext();
        URL url = getCodeBase(); // get url of this applet
        try {
            ac.showDocument(new URL(url+"Test.html"));
        } catch(MalformedURLException e) {
            showStatus("URL not found");
        }
    }
}
