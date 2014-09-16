/*
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:

string convert(string text, int nRows);
convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
*/

public class ZigZagConversion {
    public String convert(String s, int nRows) {
    	final int len = s.length();
    	if(nRows == 1) {
    	    return s;
    	}
    	
    	List<ZZ> list = new ArrayList<ZZ>(len);
    	int col = -1;
    	for(int i = 0; i < len; i++) {
    		int j = i % (2 * nRows - 2);
    		char ch = s.charAt(i);
    		if(j == 0) {
    			col++;
    		}
    		if(j < nRows) {
    			ZZ zz = new ZZ(ch, j, col);
    			list.add(zz);
    		} else {
    			col++;
    			int r = 2 * (nRows - 1) - j;
    			ZZ zz = new ZZ(ch, r, col);
    			list.add(zz);
    		}
    	}
    	Collections.sort(list);
    	StringBuilder sb = new StringBuilder();
    	for(ZZ zz : list) {
    		sb.append(zz.ch);
    	}
    	return sb.toString();
    }
    
    private class ZZ implements Comparable {
    	char ch;
    	int row;
    	int col;
    	public ZZ(char ch, int row, int col) {
    		this.ch = ch;
    		this.row = row;
    		this.col = col;
    	}
    	
    	@Override
    	public int compareTo(Object obj) {
    		ZZ zz = (ZZ)obj;
    		return this.row != zz.row ? this.row - zz.row : this.col - zz.col;
    	}
    }
}
