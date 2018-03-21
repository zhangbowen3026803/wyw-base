package com.lianda.modules.gen.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.lianda.common.persistence.Page;
import com.lianda.common.utils.StringUtils;
import com.lianda.common.web.BaseController;
import com.lianda.modules.gen.entity.GenTemplate;
import com.lianda.modules.gen.service.GenTemplateService;
import com.lianda.modules.sys.entity.User;
import com.lianda.modules.sys.utils.UserUtils;

@Controller
@RequestMapping({ "${adminPath}/gen/genTemplate" })
public class GenTemplateController extends BaseController {

	@Autowired
	private GenTemplateService a;

	@ModelAttribute
	private GenTemplate a(@RequestParam(required = false) String id) {
		if (StringUtils.isNotBlank(id)) {
			return a.get(id);
		}
		return new GenTemplate();
	}

	@RequiresPermissions({ "gen:genTemplate:view" })
	@RequestMapping({ "list", "" })
	private String a(GenTemplate genTemplate, HttpServletRequest request, HttpServletResponse response, Model model) {
		User user;
		if (!(user = UserUtils.getUser()).isAdmin()) {
			genTemplate.setCreateBy(user);
		}
		Page<GenTemplate> page = a.find(new Page(request, response), genTemplate);
		model.addAttribute("page", page);
		return "modules/gen/genTemplateList";
	}

	@RequiresPermissions({ "gen:genTemplate:view" })
	@RequestMapping({ "form" })
	private static String a(GenTemplate genTemplate, Model model) {
		model.addAttribute("genTemplate", genTemplate);
		return "modules/gen/genTemplateForm";
	}

	@RequiresPermissions({ "gen:genTemplate:edit" })
	@RequestMapping({ "save" })
	private String a(GenTemplate genTemplate, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, genTemplate, new Class[0])) {
			model.addAttribute("genTemplate", genTemplate);
			return "modules/gen/genTemplateForm";
		}
		a.save(genTemplate);
		addMessage(redirectAttributes, new String[] { "保存代码模板'" + genTemplate.getName() + "'成功" });
		return "redirect:" + this.adminPath + "/gen/genTemplate/?repage";
	}

	@RequiresPermissions({ "gen:genTemplate:edit" })
	@RequestMapping({ "delete" })
	private String a(GenTemplate genTemplate, RedirectAttributes redirectAttributes) {
		a.delete(genTemplate);
		addMessage(redirectAttributes, new String[] { "删除代码模板成功" });
		return "redirect:" + this.adminPath + "/gen/genTemplate/?repage";
	}
}