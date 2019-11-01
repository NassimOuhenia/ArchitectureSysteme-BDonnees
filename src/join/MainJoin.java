
package join;

public class MainJoin {

	public static void main(String[] args) throws Exception {

//		char[] r = { 'A', 'B', 'B', 'E', 'G', 'J', 'K', 'U', 'V', 'Z' };
//		char[] s = { 'B', 'B', 'E', 'K', 'M', 'N', 'U', 'U', 'V', 'X' };

		MergeJoin join = new MergeJoin();
		File file = new File();

		char[] r = file.getArray(file.getBuFileR());
		char[] s = file.getArray(file.getBuFileS());

		char[] rs = join.mergeJoinDupplicated(r, s);

		// affichage sur la console
		for (int i = 0; i < rs.length; i++) {
			System.out.println(rs[i]);
		}

		try {
			file.writeJoin(rs);
			file.closeBuffers();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
