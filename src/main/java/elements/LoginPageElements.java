package elements;

public class LoginPageElements {

	private static final String url = "https://outlook.live.com";
	private static final String loginButton = "/html/body/section/div/div[2]/div[2]/div/div";
	private static final String signInButton = "Sign in";
	private static final String userInputFieldId = "i0116";
	private static final String passInputField = "i0118";
	private static final String mail = "bogdancorneliu05@outlook.com";
	private static final String pass = "QAZxsw123";
	private static final String nextButtonId = "idSIButton9";

	public static String getUrl() {
		return url;
	}

	public static String getLoginbutton() {
		return loginButton;
	}

	public static String getSigninbutton() {
		return signInButton;
	}

	public static String getUserinputfieldid() {
		return userInputFieldId;
	}

	public static String getPassinputfield() {
		return passInputField;
	}

	public static String getMail() {
		return mail;
	}

	public static String getPass() {
		return pass;
	}

	public static String getNextbuttonid() {
		return nextButtonId;
	}
	
}
