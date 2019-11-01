
package join;

import java.io.*;
import java.util.Properties;

public class Config {

	private final static String RESSOURCE = "ressources/config.properties";

	private final static String FILE1 = "FILE1";
	private final static String FILE2 = "FILE2";
	private final static String FILE3 = "FILE3";
	private final static String MAX_SIZE = "MAX_SIZE";

	private final static String SIZE_R = "SIZE_R";
	private final static String SIZE_S = "SIZE_S";

	private final String PATHFILE1 = "src/r.txt";
	private final String PATHFILE2 = "src/s.txt";
	private final String PATHFILE3 = "src/rs.txt";

	private final int DEFAULT_SIZE = 10;
	private final int DEFAULT_SIZE_R = 10;
	private final int DEFAULT_SIZE_S = 10;

	private InputStream input;
	private OutputStream output;

	private Properties prop;

	private static Config instance = null;

	private Config() {
		try {
			input = new FileInputStream(RESSOURCE);
			output = new FileOutputStream(RESSOURCE);
			prop = new Properties();
			initPropreties(PATHFILE1, PATHFILE2, PATHFILE3, DEFAULT_SIZE, DEFAULT_SIZE_R, DEFAULT_SIZE_S);
			// load a properties file
			prop.load(input);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void initPropreties(String pathFileR, String pathFileS, String pathFileRS, int max_size, int size_r,
			int size_s) throws Exception {
		setMaxSize(max_size);
		setSizeR(size_r);
		setSizeS(size_s);
		setPathFileR(pathFileR);
		setPathFileS(pathFileS);
		setPathFileRS(pathFileRS);
	}

	public static Config getConfig() {
		if (instance == null) {
			instance = new Config();
		}
		return instance;
	}

	public int getMaxSize() {
		return Integer.parseInt(prop.getProperty(MAX_SIZE));
	}

	public void setMaxSize(int new_size) throws IOException {
		prop.setProperty(MAX_SIZE, String.valueOf(new_size));
		prop.store(output, null);
	}

	public int getSizeR() {
		return Integer.parseInt(prop.getProperty(SIZE_R));
	}

	public void setSizeR(int new_size) throws IOException {
		prop.setProperty(SIZE_R, String.valueOf(new_size));
		prop.store(output, null);
	}

	public int getSizeS() {
		return Integer.parseInt(prop.getProperty(SIZE_S));
	}

	public void setSizeS(int new_size) throws IOException {
		prop.setProperty(SIZE_S, String.valueOf(new_size));
		prop.store(output, null);
	}

	public String getPathFileR() {
		return prop.getProperty(FILE1);
	}

	public void setPathFileR(String new_file) throws IOException {
		prop.setProperty(FILE1, new_file);
		prop.store(output, null);
	}

	public String getPathFileS() {
		return prop.getProperty(FILE2);
	}

	public void setPathFileS(String new_file) throws IOException {
		prop.setProperty(FILE2, new_file);
		prop.store(output, null);
	}

	public String getPathFileRS() {
		return prop.getProperty(FILE3);
	}

	public void setPathFileRS(String new_file) throws IOException {
		prop.setProperty(FILE3, new_file);
		prop.store(output, null);
	}
}
