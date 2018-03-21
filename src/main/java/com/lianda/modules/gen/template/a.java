package com.lianda.modules.gen.template;

import java.io.StringWriter;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class a {
	private static Configuration a;

	static {
		a = new Configuration();
		a.setClassForTemplateLoading(a.class, "/");
	}

	public static String a(String tplName, String encoding, Map<String, Object> paras) {
		try {
			StringWriter swriter = new StringWriter();
			Template template = a.getTemplate(tplName, encoding);
			template.process(paras, swriter);
			return swriter.toString();
		} catch (Exception e) {
			e.printStackTrace();
			return e.toString();
		}
	}

	public final String a(String tplName, Map<String, Object> paras) {
		return a(tplName, "utf-8", paras);
	}
}