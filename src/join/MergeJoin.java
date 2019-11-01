
package join;

public class MergeJoin {

	public MergeJoin() {
		super();
	}

	public char[] mergeJoinDupplicated(char[] r, char[] s) {

		int max_size = Config.getConfig().getMaxSize();
		int sizeR = Config.getConfig().getSizeR();
		int sizeS = Config.getConfig().getSizeS();

		char[] rs = new char[max_size];

		int index_r = 0;
		int index_s = 0;
		int index_rs = 0;

		int old_indexS = 0;

		while (index_r < sizeR && index_s < sizeS) {

			if (r[index_r] == s[index_s]) {

				old_indexS = index_s;

				while (index_s < sizeS && r[index_r] == s[index_s]) {

					rs[index_rs] = r[index_r];
					index_s++;
					index_rs++;
				}

				if (r[index_r] < s[index_s]) {
					index_s = old_indexS;
					index_r++;
				} else if (s[index_s] < r[index_r]) {
					index_s++;
				}

			} else if (s[index_s] < r[index_r]) {
				index_s++;
			} else if (r[index_r] < s[index_s]) {
				index_r++;
			}

		}

		if (max_size == index_rs)
			return rs;

		return Tableau.copierTableau(rs, index_rs);
	}

}
