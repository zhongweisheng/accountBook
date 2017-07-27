package com.mlb.util;

/*
 * Copyright BeiJing Xintuoyida(c) Software Co.,Ltd 2013.
 *
 *          http://www.xintuoyida.com
 *
 * @Author          Spance Wong ,Email: huangsy@xintuoyida.com
 * @Project         dwxj
 * @Module          dwxj
 * @File            com.xtyd.core.j2ee.asd
 * @LastModified    13-9-16 下午9:36
 * @Version         $Rev$
 * @Description
 */

import java.io.File;
import java.lang.reflect.Field;

/**
 * Created with IntelliJ IDEA. User: spance Date: 13-9-16 Time: 下午9:36 To change
 * this template use File | Settings | File Templates.
 */
public class UploadedFile {

	private String dir;
	private String filename;
	private String original;
	private String type;
	private String fieldName;

	public UploadedFile(Object oreillyUploadedFile, String fieldName) {
		if (oreillyUploadedFile == null) {
			throw new IllegalArgumentException("argument is null");
		}
		Class clazz = oreillyUploadedFile.getClass();
		if (clazz.getPackage().getName().equals("com.oreilly.servlet.UploadedFile")) {
			throw new IllegalArgumentException(oreillyUploadedFile.getClass().toString());
		}
		try {
			this.fieldName = fieldName;
			dir = (String) getFieldValue(clazz, "dir", oreillyUploadedFile);
			filename = (String) getFieldValue(clazz, "filename", oreillyUploadedFile);
			original = (String) getFieldValue(clazz, "original", oreillyUploadedFile);
			type = (String) getFieldValue(clazz, "type", oreillyUploadedFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static Object getFieldValue(Class clazz, String fieldName, Object obj) throws NoSuchFieldException,
			IllegalAccessException {
		Field field = clazz.getDeclaredField(fieldName);
		field.setAccessible(true);
		return field.get(obj);
	}

	public UploadedFile(String dir, String filename, String original, String type) {
		this.dir = dir;
		this.filename = filename;
		this.original = original;
		this.type = type;
	}

	public String getContentType() {
		return this.type;
	}

	public String getFilesystemName() {
		return this.filename;
	}

	public String getOriginalFileName() {
		return this.original;
	}

	public String getFieldName() {
		return fieldName;
	}

	public File getFile() {
		if ((this.dir == null) || (this.filename == null)) {
			return null;
		}

		return new File(this.dir + File.separator + this.filename);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		UploadedFile that = (UploadedFile) o;

		if (dir != null ? !dir.equals(that.dir) : that.dir != null)
			return false;
		if (filename != null ? !filename.equals(that.filename) : that.filename != null)
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = dir != null ? dir.hashCode() : 0;
		result = 31 * result + (filename != null ? filename.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		if ((this.dir == null) || (this.filename == null)) {
			return "_NULL_";
		}
		return this.dir + File.separator + this.filename;
	}
}
