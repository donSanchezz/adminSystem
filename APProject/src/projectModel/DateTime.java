package projectModel;

import java.text.SimpleDateFormat;

public class DateTime {

public  String  Date () {
	java.util.Date date = new java.util.Date();
	SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
	return (formatter.format(date));

}
	
public  String Time() {
	java.util.Date date = new java.util.Date();
	SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
	return (formatter.format(date));
	
}

}
