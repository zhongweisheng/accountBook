package fc.wpf.rest.npe;

import org.springframework.stereotype.Repository;

/**
 * 参数表帮助类
 * 
 * @author brew
 * 
 */
@Repository
public class CtrlParamsHelper {

	public void insert(String key, Object v) {
//		if (v != null) {
//			FCBankMsgCtrl record = new FCBankMsgCtrl();
//			record.setKeyy(key);
//			record.setValuee("" + v);
//			record.setDescs(ParamDescHelper.getDesc(key));
//			ctrlDAO.insert(record);
//		}
	}

	public String get(String key, String defaultv) {
//		FCBankMsgCtrlKey ctrlkey = new FCBankMsgCtrlKey();
//		ctrlkey.setKeyy(key);
//		FCBankMsgCtrl param = ctrlDAO.selectByPrimaryKey(ctrlkey);
//		if (param == null) {
//			insert(key, defaultv);
//			return defaultv;
//		}
		return "";
	}

	public int get(String key, int defaultv) {
//		FCBankMsgCtrlKey ctrlkey = new FCBankMsgCtrlKey();
//		ctrlkey.setKeyy(key);
//		FCBankMsgCtrl param = ctrlDAO.selectByPrimaryKey(ctrlkey);
//		if (param == null) {
//			insert(key, defaultv);
//			return defaultv;
//		}
//		try {
//			return Integer.parseInt(param.getValuee());
//		} catch (NumberFormatException e) {
//			e.printStackTrace();
//		}
//		insert(key, defaultv);
		return defaultv;
	}

}
