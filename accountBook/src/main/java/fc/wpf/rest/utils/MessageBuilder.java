package fc.wpf.rest.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MessageBuilder {
	public static String getRequestContent(HttpServletRequest request) throws IOException {
		InputStream is = null;
		String jsonTxt = null;
		try {
			is = request.getInputStream();
			ByteArrayOutputStream bout = new ByteArrayOutputStream();
			byte[] data = new byte[8192];
			int rsize = 0;
			do {
				rsize = is.read(data);
				if (rsize > 0) {
					bout.write(data, 0, rsize);
				}
			} while (rsize > 0);
			jsonTxt = new String(bout.toByteArray());
			bout.close();
		} finally {
			if (is != null) {
				is.close();
			}
		}
		return jsonTxt;
	}
}
