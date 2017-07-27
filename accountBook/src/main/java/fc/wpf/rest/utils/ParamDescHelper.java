package fc.wpf.rest.utils;

public class ParamDescHelper {
	static String DBINFO[][] = new String[][] {//
	{ "npe.host", "172.17.0.1", "NPE的地址" },//
			{ "npe.port", "18080", "NPE的端口" },//

	};

	public static String getDesc(String key) {
		for (int i = 0; i < DBINFO.length; i++) {
			if (key.equals(DBINFO[i][0])) {
				return DBINFO[i][2];
			}
		}
		return null;
	}

}
