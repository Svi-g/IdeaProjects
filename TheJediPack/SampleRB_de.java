package CoolPack;
import java.util.*;
/*
This program is the second resource bundle,
but this one is the German version.
 */
public class SampleRB_de extends ListResourceBundle {
    protected Object[][] getContents() {
        Object[][] resources = new Object[3][2];
        resources[0][0] = "title";
        resources[0][1] = "Mein Programm";
        resources[1][0] = "StopText";
        resources[1][1] = "Anschlag";
        resources[2][0] = "StartText";
        resources[2][1] = "Anfang";
        return resources;
    }
}