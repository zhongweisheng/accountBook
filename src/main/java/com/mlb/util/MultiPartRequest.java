package com.mlb.util;

/*
 * Copyright BeiJing Xintuoyida(c) Software Co.,Ltd 2012.
 *
 *          http://www.xintuoyida.com
 *
 * @Author          Spance Wong ,Email: huangsy@xintuoyida.com
 * @Project         dwxj-new
 * @Module          dwxj-new
 * @File            com.xtyd.dwxj_xlxj.common.asdf/asdf.java
 * @LastModified    2012-39-20 21:39:36
 * @Version         12.6.2
 * @Description
 */

/**
 * Created with IntelliJ IDEA.
 * User: Spance
 * Date: 12-8-20
 * Time: 下午9:39
 * To change this template use File | Settings | File Templates.
 */

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

//import com.mlbweb.core.system.Environment;
import com.oreilly.servlet.MultipartRequest;

/**
 * Multipart Encapsulation
 */
@SuppressWarnings("unchecked")
public class MultiPartRequest extends HttpServletRequestWrapper {

	private MultipartRequest multipartRequest;
	private final static boolean PREVENT_SQL_INJECTION = true;

	public MultiPartRequest(HttpServletRequest req, String upload_tmp_path, int MAX_FILE_SIZE, String enc)
			throws IOException {
		super(req);
		this.multipartRequest = new MultipartRequest(req, upload_tmp_path, MAX_FILE_SIZE, enc);
	}

	public String getContentType(String name) {
		return multipartRequest.getContentType(name);
	}

	public File getFile(String name) {
		return multipartRequest.getFile(name);
	}

	public Enumeration getFileNames() {
		return multipartRequest.getFileNames();
	}

	public String getFilesystemName(String name) {
		return multipartRequest.getFilesystemName(name);
	}

	public String getOriginalFileName(String name) {
		return multipartRequest.getOriginalFileName(name);
	}

	@Override
	public String getParameter(String name) {
		String v = super.getParameter(name);
		v = v == null ? multipartRequest.getParameter(name) : v;
		if (PREVENT_SQL_INJECTION)
			v = v == null ? null : FilterableRequest.reqEncode(v);
		return v;
	}

	@Override
	public Enumeration<String> getParameterNames() {
		return multipartRequest.getParameterNames();
	}

	@Override
	public String[] getParameterValues(String name) {
		String[] v = super.getParameterValues(name);
		if (v == null)
			v = multipartRequest.getParameterValues(name);
		return v;
	}

	@Override
	public Map<String, String[]> getParameterMap() {
		Map<String, String[]> map = new HashMap<String, String[]>();
		Enumeration<String> names = getParameterNames();
		while (names.hasMoreElements()) {
			String name = names.nextElement();
			map.put(name, getParameterValues(name));
		}
		return map;
	}

	public Map<String, UploadedFile> getFileParts() {
		Field filesField;
		Map<String, Object> files;
		Map<String, UploadedFile> publicFiles = new HashMap<String, UploadedFile>();
		try {
			filesField = MultipartRequest.class.getDeclaredField("files");
			filesField.setAccessible(true);
			files = (Hashtable<String, Object>) filesField.get(multipartRequest);
			for (Map.Entry<String, Object> file : files.entrySet()) {
				UploadedFile up = new UploadedFile(file.getValue(), file.getKey());
				publicFiles.put(up.toString(), up);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return publicFiles;
	}

}
