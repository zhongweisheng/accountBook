package com.mlb.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class FilterableRequest extends HttpServletRequestWrapper {

    HttpServletRequest orgRequest = null;

    public FilterableRequest(HttpServletRequest request) {
        super(request);
        orgRequest = request;
    }

    /**
     * 覆盖getParameter方法，将参数名和参数值都做req过滤。<br/>
     * 如果需要获得原始的值，则通过super.getParameterValues(name)来获取<br/>
     * getParameterNames,getParameterValues和getParameterMap也可能需要覆盖
     */
    @Override
    public String getParameter(String name) {
        String value = super.getParameter(name);
        if (value != null) {
            value = reqEncode(value);
        }

        return value;
    }

    /**
     * 覆盖getHeader方法，将参数名和参数值都做req过滤。<br/>
     * 如果需要获得原始的值，则通过super.getHeaders(name)来获取<br/> getHeaderNames 也可能需要覆盖
     */
/*	@Override
    public String getHeader(String name) {
		String value = super.getHeader(reqEncode(name));
		if (value != null) {
			value = reqEncode(value);
		}
		return value;
	}*/

    /**
     * 将容易引起req漏洞的半角字符直接替换成全角字符
     *
     * @param s
     * @return
     */
    public static String reqEncode(String s) {
        if (s.startsWith("---"))
            return "";
        int len = s.length();
        if (s == null || "".equals(s) || len > 512) {
            return s;
        }
        StringBuilder sb = new StringBuilder(len + 18);
        char lastChar = ' ';
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            switch (c) {
                case '>':
                    sb.append('＞');     //全角大于号
                    break;
                case '<':
                    sb.append('＜');     //全角小于号
                    break;
                case '\'':
                    sb.append('‘');     //全角单引号
                    break;
                case '\"':
                    sb.append('“');     //全角双引号
                    break;
                case '&':
                    sb.append('＆');     //全角
                    break;
                case '\\':
//                    sb.append('＼');     //全角斜线
                    sb.append(lastChar == '\\' ? '＼' : c);
                    break;
                case '#':
                    sb.append('＃');     //全角井号
                    break;
                case ';':
                    sb.append('；');     //全角
                    break;
                case '-':
                    sb.append(lastChar == '-' ? '_' : c);
                    break;
                default:
                    sb.append(c);
                    break;
            }
            lastChar = c;
        }
        return sb.toString();
    }

    /**
     * 获取最原始的request
     *
     * @return
     */
    public HttpServletRequest getOrgRequest() {
        return orgRequest;
    }

    /**
     * 获取最原始的request的静态方法
     *
     * @return
     */
    public static HttpServletRequest getOrgRequest(HttpServletRequest req) {
        if (req instanceof FilterableRequest) {
            return ((FilterableRequest) req).getOrgRequest();
        }

        return req;
    }
}
