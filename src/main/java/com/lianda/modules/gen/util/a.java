package com.lianda.modules.gen.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.UnknownHostException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.DefaultResourceLoader;

import com.google.common.collect.Maps;
import com.lianda.common.config.Global;
import com.lianda.common.mapper.JaxbMapper;
import com.lianda.common.utils.DateUtils;
import com.lianda.common.utils.FileUtils;
import com.lianda.common.utils.FreeMarkers;
import com.lianda.common.utils.StringUtils;
import com.lianda.modules.gen.entity.GenCategory;
import com.lianda.modules.gen.entity.GenConfig;
import com.lianda.modules.gen.entity.GenScheme;
import com.lianda.modules.gen.entity.GenTable;
import com.lianda.modules.gen.entity.GenTableColumn;
import com.lianda.modules.gen.entity.GenTemplate;
import com.lianda.modules.sys.entity.Area;
import com.lianda.modules.sys.entity.Office;
import com.lianda.modules.sys.entity.User;
import com.lianda.modules.sys.utils.UserUtils;

public class a {
	private static Logger d = LoggerFactory.getLogger(a.class);
	private static final String e = "http://www.banko.com.cn";
	public static String a = "lianda";
	public static String b = "2.3";

	public static String c = null;

	static {
		c = f() + e() + c("c") + g();
	}

	public static void a(GenTable genTable) {
		for (Iterator localIterator = genTable.getColumnList().iterator(); localIterator.hasNext();) {
			GenTableColumn column;
			if (StringUtils.isNotBlank((column = (GenTableColumn) localIterator.next()).getId())) {
				continue;
			}

			if (StringUtils.isBlank(column.getComments())) {
				column.setComments(column.getName());
			}

			if ((StringUtils.startsWithIgnoreCase(column.getJdbcType(), "CHAR")) || (StringUtils.startsWithIgnoreCase(column.getJdbcType(), "VARCHAR")) || (StringUtils.startsWithIgnoreCase(column.getJdbcType(), "NARCHAR"))) {
				column.setJavaType("String");
			} else if ((StringUtils.startsWithIgnoreCase(column.getJdbcType(), "DATETIME")) || (StringUtils.startsWithIgnoreCase(column.getJdbcType(), "DATE")) || (StringUtils.startsWithIgnoreCase(column.getJdbcType(), "TIMESTAMP"))) {
				column.setJavaType("java.util.Date");
				column.setShowType("dateselect");
			} else if ((StringUtils.startsWithIgnoreCase(column.getJdbcType(), "BIGINT")) || (StringUtils.startsWithIgnoreCase(column.getJdbcType(), "NUMBER"))) {
				String[] ss;
				if (((ss = StringUtils.split(StringUtils.substringBetween(column.getJdbcType(), "(", ")"), ",")) != null) && (ss.length == 2) && (Integer.parseInt(ss[1]) > 0)) {
					column.setJavaType("Double");
				} else if ((ss != null) && (ss.length == 1) && (Integer.parseInt(ss[0]) <= 10)) {
					column.setJavaType("Integer");
				} else {
					column.setJavaType("Long");
				}

			}

			column.setJavaField(StringUtils.toCamelCase(column.getName()));

			column.setIsPk((genTable.getPkList().contains(column.getName())) ? "1" : "0");

			column.setIsInsert("1");

			if ((!StringUtils.equalsIgnoreCase(column.getName(), "id")) && (!StringUtils.equalsIgnoreCase(column.getName(), "create_by")) && (!StringUtils.equalsIgnoreCase(column.getName(), "create_date")) && (!StringUtils.equalsIgnoreCase(column.getName(), "del_flag")))
				column.setIsEdit("1");
			else {
				column.setIsEdit("0");
			}

			if ((StringUtils.equalsIgnoreCase(column.getName(), "name")) || (StringUtils.equalsIgnoreCase(column.getName(), "title")) || (StringUtils.equalsIgnoreCase(column.getName(), "remarks")) || (StringUtils.equalsIgnoreCase(column.getName(), "update_date")))
				column.setIsList("1");
			else {
				column.setIsList("0");
			}

			if ((StringUtils.equalsIgnoreCase(column.getName(), "name")) || (StringUtils.equalsIgnoreCase(column.getName(), "title")))
				column.setIsQuery("1");
			else {
				column.setIsQuery("0");
			}

			if ((StringUtils.equalsIgnoreCase(column.getName(), "name")) || (StringUtils.equalsIgnoreCase(column.getName(), "title")))
				column.setQueryType("like");
			else {
				column.setQueryType("=");
			}

			if (StringUtils.startsWithIgnoreCase(column.getName(), "user_id")) {
				column.setJavaType(User.class.getName());
				column.setJavaField(column.getJavaField().replaceAll("Id", ".id|name"));
				column.setShowType("userselect");
			} else if (StringUtils.startsWithIgnoreCase(column.getName(), "office_id")) {
				column.setJavaType(Office.class.getName());
				column.setJavaField(column.getJavaField().replaceAll("Id", ".id|name"));
				column.setShowType("officeselect");
			} else if (StringUtils.startsWithIgnoreCase(column.getName(), "area_id")) {
				column.setJavaType(Area.class.getName());
				column.setJavaField(column.getJavaField().replaceAll("Id", ".id|name"));
				column.setShowType("areaselect");
			} else {
				if ((StringUtils.startsWithIgnoreCase(column.getName(), "create_by")) || (StringUtils.startsWithIgnoreCase(column.getName(), "update_by"))) {
					column.setJavaType(User.class.getName());
					column.setJavaField(column.getJavaField() + ".id");
				} else {
					if ((StringUtils.startsWithIgnoreCase(column.getName(), "create_date")) || (StringUtils.startsWithIgnoreCase(column.getName(), "update_date"))) {
						column.setShowType("dateselect");
						continue;
					}

					if ((StringUtils.equalsIgnoreCase(column.getName(), "remarks")) || (StringUtils.equalsIgnoreCase(column.getName(), "content"))) {
						column.setShowType("textarea");
						continue;
					}

					if (StringUtils.equalsIgnoreCase(column.getName(), "parent_id")) {
						column.setJavaType("This");
						column.setJavaField("parent.id|name");
						column.setShowType("treeselect");
						continue;
					}

					if (StringUtils.equalsIgnoreCase(column.getName(), "parent_ids")) {
						column.setShowType("input");
						column.setQueryType("like");
						continue;
					}

					if (StringUtils.equalsIgnoreCase(column.getName(), "del_flag")) {
						column.setShowType("radiobox");
						column.setDictType("del_flag");
						continue;
					}
				}
				column.setShowType("input");
			}
		}
	}

	public static String a() {
		try {
			File file = new DefaultResourceLoader().getResource("").getFile();
			if (file == null) {
				return null;
			} else {
				return file.getAbsolutePath() + File.separator + StringUtils.replaceEach(a.class.getName(), new String[] { "util." + a.class.getSimpleName(), "." }, new String[] { "template", File.separator });
			}
		} catch (Exception e) {
			d.error("{}", e);
		}

		label116: return "";
	}

	private static <T> T a(String fileName, Class<?> clazz) {
		try {
			String pathName = "/templates/modules/gen/" + fileName;

			InputStream is = new ClassPathResource(pathName).getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
			StringBuilder sb = new StringBuilder();
			String line = null;
			while ((line = br.readLine()) != null) {
				sb.append(line).append("\r\n");
			}
			if (is != null) {
				is.close();
			}

			br.close();

			return (T) JaxbMapper.fromXml(sb.toString(), clazz);
		} catch (IOException e) {
			d.warn("Error file convert: {}", e.getMessage());
		}

		return null;
	}

	public static GenConfig b() {
		return (GenConfig) a("config.xml", GenConfig.class);
	}

	public static List<GenTemplate> a(GenConfig config, String category, boolean isChildTable) {
		List<GenTemplate> templateList = new ArrayList<GenTemplate>();
		if (config != null && config.getCategoryList() != null && category != null) {
			Iterator<GenCategory> iterator = config.getCategoryList().iterator();
			while (iterator.hasNext()) {
				GenCategory e = iterator.next();
				List<String> template = new ArrayList<String>();
				if (!category.equals(e.getValue())) {
					continue;
				}

				if (!isChildTable) {
					template = e.getTemplate();
				} else {
					template = e.getChildTableTemplate();
				}

				if (template == null) {
					break;
				}

				for (String ref : template) {
					if (StringUtils.startsWith(ref, GenCategory.CATEGORY_REF)) {
						templateList.addAll(a(config, StringUtils.replace(ref, GenCategory.CATEGORY_REF, ""), false));
					} else {
						GenTemplate genTemplate = a(ref, GenTemplate.class);
						if (genTemplate != null) {
							templateList.add(genTemplate);
						}
					}
				}
			}
		}
		return templateList;
	}

	public static Map<String, Object> a(GenScheme genScheme) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("packageName", StringUtils.lowerCase(genScheme.getPackageName()));
		model.put("lastPackageName", StringUtils.substringAfterLast((String) model.get("packageName"), "."));
		model.put("moduleName", StringUtils.lowerCase(genScheme.getModuleName()));
		model.put("subModuleName", StringUtils.lowerCase(genScheme.getSubModuleName()));
		model.put("className", StringUtils.uncapitalize(genScheme.getGenTable().getClassName()));
		model.put("ClassName", StringUtils.capitalize(genScheme.getGenTable().getClassName()));

		model.put("functionName", genScheme.getFunctionName());
		model.put("functionNameSimple", genScheme.getFunctionNameSimple());
		model.put("functionAuthor", (StringUtils.isNotBlank(genScheme.getFunctionAuthor())) ? genScheme.getFunctionAuthor() : UserUtils.getUser().getName());
		model.put("functionVersion", DateUtils.getDate());

		model.put("urlPrefix", model.get("moduleName") + ((StringUtils.isNotBlank(genScheme.getSubModuleName())) ? "/" + StringUtils.lowerCase(genScheme.getSubModuleName()) : "") + "/" + model.get("className"));
		model.put("viewPrefix", model.get("urlPrefix"));
		model.put("permissionPrefix", model.get("moduleName") + ((StringUtils.isNotBlank(genScheme.getSubModuleName())) ? ":" + StringUtils.lowerCase(genScheme.getSubModuleName()) : "") + ":" + model.get("className"));

		model.put("dbType", Global.getConfig("jdbc.type"));

		model.put("table", genScheme.getGenTable());

		return model;
	}

	public static String a(GenTemplate tpl, Map<String, Object> model, boolean isReplaceFile) {
		String fileName = Global.getProjectPath() + File.separator + StringUtils.replaceEach(FreeMarkers.renderString(new StringBuilder(String.valueOf(tpl.getFilePath())).append("/").toString(), model), new String[] { "//", "/", "." }, new String[] { File.separator, File.separator, File.separator }) + FreeMarkers.renderString(tpl.getFileName(), model);
		d.debug(" fileName === " + fileName);

		String content = FreeMarkers.renderString(StringUtils.trimToEmpty(tpl.getContent()), model);
		d.debug(" content === \r\n" + content);

		FileUtils.deleteFile(fileName);

		if (FileUtils.createFile(fileName)) {
			FileUtils.writeToFile(fileName, content, true);
			d.debug(" file create === " + fileName);
			return "生成成功：" + fileName + "<br/>";
		}
		d.debug(" file extents === " + fileName);
		return "文件已存在：" + fileName + "<br/>";
	}

	public static synchronized String c() {
		Locale locale = Locale.CHINA;
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat df = new SimpleDateFormat(pattern, locale);
		try {
			df.setTimeZone(TimeZone.getTimeZone("GMT+8"));
			URL url = new URL("http://open.baidu.com/special/time/");
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setReadTimeout(2000);
			connection.setConnectTimeout(2000);
			connection.connect();
			long ld = connection.getDate();
			Date date = new Date(ld);
			return df.format(date);
		} catch (UnknownHostException localUnknownHostException) {
			localUnknownHostException.printStackTrace();
		} catch (IOException localIOException) {
			localIOException.printStackTrace();
		} catch (Exception localException) {
			localException.printStackTrace();
		}
		return df.format(new Date());
	}

	private static String e() {
		String result = "";
		try {
			File file;
			(file = File.createTempFile("realhowto", ".vbs")).deleteOnExit();
			FileWriter fw = new FileWriter(file);

			String vbs = "Set objWMIService = GetObject(\"winmgmts:\\\\.\\root\\cimv2\")\nSet colItems = objWMIService.ExecQuery _ \n   (\"Select * from Win32_BaseBoard\") \nFor Each objItem in colItems \n    Wscript.Echo objItem.SerialNumber \n    exit for  ' do the first cpu only! \nNext \n";

			fw.write(vbs);
			fw.close();
			Process p = Runtime.getRuntime().exec("cscript //NoLogo " + file.getPath());
			BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String line;
			while ((line = input.readLine()) != null) {
				result = result + line;
			}
			input.close();
		} catch (Exception localException) {
		}
		return result.trim();
	}

	private static String c(String drive) {
		String result = "";
		try {
			File file;
			(file = File.createTempFile("realhowto", ".vbs")).deleteOnExit();
			FileWriter fw = new FileWriter(file);

			String vbs = "Set objFSO = CreateObject(\"Scripting.FileSystemObject\")\nSet colDrives = objFSO.Drives\nSet objDrive = colDrives.item(\"" + drive + "\")\nWscript.Echo objDrive.SerialNumber";

			fw.write(vbs);
			fw.close();
			Process p = Runtime.getRuntime().exec("cscript //NoLogo " + file.getPath());
			BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String line;
			while ((line = input.readLine()) != null) {
				result = result + line;
			}
			input.close();
		} catch (Exception localException) {
		}
		return result.trim();
	}

	private static String f() {
		String result = "";
		try {
			File file;
			(file = File.createTempFile("tmp", ".vbs")).deleteOnExit();
			FileWriter fw = new FileWriter(file);
			String vbs = "Set objWMIService = GetObject(\"winmgmts:\\\\.\\root\\cimv2\")\nSet colItems = objWMIService.ExecQuery _ \n   (\"Select * from Win32_Processor\") \nFor Each objItem in colItems \n    Wscript.Echo objItem.ProcessorId \n    exit for  ' do the first cpu only! \nNext \n";

			fw.write(vbs);
			fw.close();
			Process p = Runtime.getRuntime().exec("cscript //NoLogo " + file.getPath());
			BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String line;
			while ((line = input.readLine()) != null) {
				result = result + line;
			}
			input.close();
			file.delete();
		} catch (Exception localException) {
		}
		return result.trim();
	}

	private static String g() {
		String result = "";
		try {
			Process process = Runtime.getRuntime().exec("ipconfig /all");

			InputStreamReader ir = new InputStreamReader(process.getInputStream());

			LineNumberReader input = new LineNumberReader(ir);
			String line;
			while ((line = input.readLine()) != null) {
				if (line.indexOf("Physical Address") <= 0) {
					continue;
				}

				result = line = line.substring(line.indexOf("-") - 2);
			}

		} catch (IOException localIOException) {
		}

		return result;
	}

}