package explaning.variable;

public class ComplexIf {

	public void initial(int resize, String platform, String browser) {

		if (platform.toUpperCase().indexOf("MAC") > -1 && browser.toUpperCase().indexOf("IE") > -1 && wasInitialized()
				&& resize > 0) {
			// DO something
		}
	}

	public void refactored(int resize, String platform, String browser) {

		final boolean isMac = platform.toUpperCase().indexOf("MAC") > -1;
		final boolean isIEBrowser = isMac && browser.toUpperCase().indexOf("IE") > -1;

		if (isMac && isIEBrowser && wasInitialized() && resize > 0) {
			// DO something
		}
	}

	boolean wasInitialized() {
		return true;
	}
}
