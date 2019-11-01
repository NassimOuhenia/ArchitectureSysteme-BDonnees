

package testsMergeJoin;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import join.MergeJoin;

class MergeJoinTests {

	char[] r = { 'A', 'B', 'B', 'E', 'G', 'J', 'K', 'U', 'V', 'Z' };

	char[] s = { 'B', 'B', 'E', 'K', 'M', 'N', 'U', 'U', 'V', 'X' };

	char[] rs = { 'B', 'B', 'B', 'B', 'E', 'K', 'U', 'U', 'V'};

	MergeJoin mjoin;

	@BeforeEach
	void setUp() throws Exception {
		mjoin = new MergeJoin();
	}

	@Test
	void mergeJoinTest() {
		assertArrayEquals(rs, mjoin.mergeJoinDupplicated(r, s));
	}

}
