package com.lianda.modules.gen.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.lianda.common.utils.StringUtils;
import com.lianda.common.web.BaseController;
import com.lianda.modules.gen.entity.GenScheme;
import com.lianda.modules.gen.service.CgAutoListService;
import com.lianda.modules.gen.service.GenSchemeService;
import com.lianda.modules.gen.service.GenTableService;

@Controller
@RequestMapping({ "${adminPath}/gen/cgAutoList" })
public class CgAutoListController extends BaseController {
	private static Logger a = Logger.getLogger(CgAutoListController.class);

	@Autowired
	private GenSchemeService b;

	@Autowired
	private GenTableService c;

	@Autowired
	private CgAutoListService d;

	@ModelAttribute
	private GenScheme a(@RequestParam(required = false) String id) {
		if (StringUtils.isNotBlank(id)) {
			return b.get(id);
		}
		return new GenScheme();
	}

	@RequestMapping({ "list" })
	private void a(GenScheme genScheme, HttpServletResponse response) {
		long start = System.currentTimeMillis();

		com.lianda.modules.gen.util.a.a(genScheme);

		String html = d.generateCode(genScheme);
//		null.generateListCode(genScheme);
		try {
			PrintWriter writer =response.getWriter();
			response.setContentType("text/html");
			response.setHeader("Cache-Control", "no-store");
			writer.println(html);
			writer.flush();
		} catch (IOException localIOException) {
			localIOException.printStackTrace();
		}
		long end = System.currentTimeMillis();
		a.debug("动态列表生成耗时：" + (end - start) + " ms");
	}

	@RequestMapping({ "test", "" })
	private static ModelAndView a() {
		return new ModelAndView("com/lianda/modules/gen/template/viewList");
	}
}