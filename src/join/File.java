
package join;

import java.io.*;
import java.util.Arrays;

public class File {

	private BufferedReader buFileR;
	private BufferedReader buFileS;
	private BufferedWriter bwFileRS;
	private Config config;

	public File() throws IOException {
		config = Config.getConfig();
		buFileR = new BufferedReader(new FileReader(config.getPathFileR()));
		buFileS = new BufferedReader(new FileReader(config.getPathFileS()));
		bwFileRS = new BufferedWriter(new FileWriter(config.getPathFileRS()));
	}

	public File(String fileR, String fileS, String fileRS) throws IOException {
		buFileR = new BufferedReader(new FileReader(fileR));
		buFileS = new BufferedReader(new FileReader(fileS));
		bwFileRS = new BufferedWriter(new FileWriter(fileRS));
	}

	public void writeJoin(char[] rs) throws Exception {

		for (int i = 0; i < rs.length; i++) {
			bwFileRS.write(rs[i]);
			bwFileRS.write('\n');
		}

	}

	public char[] getArray(BufferedReader br) throws Exception {
		int max_size = config.getMaxSize();
		char[] result = new char[max_size];

		String line;
		int i = 0;
		while ((line = br.readLine()) != null) {
			result[i] = line.charAt(0);
			i++;
			if (max_size == i)
				break;
		}

		if (i == max_size) {
			return result;
		}

		return Arrays.copyOf(result, i);
	}

	public void closeBuffers() throws IOException {
		buFileR.close();
		buFileS.close();
		bwFileRS.close();
	}

	public BufferedReader getBuFileR() {
		return buFileR;
	}

	public BufferedReader getBuFileS() {
		return buFileS;
	}

}
