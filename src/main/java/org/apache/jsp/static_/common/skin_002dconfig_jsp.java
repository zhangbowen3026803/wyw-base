package org.apache.jsp.static_.common;

import java.io.IOException;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.el.ExpressionFactory;
import javax.servlet.DispatcherType;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspFactory;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;

import org.apache.jasper.runtime.HttpJspBase;
import org.apache.jasper.runtime.InstanceManagerFactory;
import org.apache.jasper.runtime.JspSourceDependent;
import org.apache.jasper.runtime.PageContextImpl;
import org.apache.tomcat.InstanceManager;

public final class skin_002dconfig_jsp extends HttpJspBase implements JspSourceDependent {

	private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();
	private static Map<String, Long> _jspx_dependants;
	private static final Set<String> _jspx_imports_packages = new HashSet();
	private volatile ExpressionFactory _el_expressionfactory;
	private volatile InstanceManager _jsp_instancemanager;

	static {
		_jspx_imports_packages.add("javax.servlet");
		_jspx_imports_packages.add("javax.servlet.jsp");
		_jspx_imports_packages.add("javax.servlet.http");
	}

	public Map<String, Long> getDependants() {
		return _jspx_dependants;
	}

	public Set<String> getPackageImports() {
		return _jspx_imports_packages;
	}

	public ExpressionFactory _jsp_getExpressionFactory() {
		if (this._el_expressionfactory == null) {
			synchronized (this) {
				if (this._el_expressionfactory == null) {
					this._el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
				}
			}
		}
		return this._el_expressionfactory;
	}

	public InstanceManager _jsp_getInstanceManager() {
		if (this._jsp_instancemanager == null) {
			synchronized (this) {
				if (this._jsp_instancemanager == null) {
					this._jsp_instancemanager = InstanceManagerFactory.getInstanceManager(getServletConfig());
				}
			}
		}
		return this._jsp_instancemanager;
	}

	public void _jspInit() {
	}

	public void _jspDestroy() {
	}

	@Override
	public void _jspService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String _jspx_method = request.getMethod();
		if ((!"GET".equals(_jspx_method)) && (!"POST".equals(_jspx_method)) && (!"HEAD".equals(_jspx_method)) && (!DispatcherType.ERROR.equals(request.getDispatcherType()))) {
			response.sendError(405, "JSPs only permit GET POST or HEAD");
			return;
		}

		final PageContext pageContext;
		javax.servlet.http.HttpSession session = null;
		final ServletContext application;
		final ServletConfig config;
		JspWriter out = null;
		final java.lang.Object page = this;
		JspWriter _jspx_out = null;
		PageContext _jspx_page_context = null;

		try {
			response.setContentType("text/html;charset=UTF-8");
			pageContext = _jspxFactory.getPageContext(this, request, response, null, true, 8192, true);
			_jspx_page_context = pageContext;
			application = pageContext.getServletContext();
			config = pageContext.getServletConfig();
			session = pageContext.getSession();
			out = pageContext.getOut();
			_jspx_out = out;

			out.write("\n");
			out.write("<div class=\"theme-config\">\n");
			out.write("    <div class=\"theme-config-box\">\n");
			out.write("        <div class=\"spin-icon\">\n");
			out.write("            <i class=\"fa fa-cog fa-spin\"></i>\n");
			out.write("        </div>\n");
			out.write("        <div class=\"skin-setttings\">\n");
			out.write("            <div class=\"title\">主题设置</div>\n");
			out.write("            <div class=\"setings-item\">\n");
			out.write("                <span>\n");
			out.write("                        收起左侧菜单\n");
			out.write("                    </span>\n");
			out.write("\n");
			out.write("                <div class=\"switch\">\n");
			out.write("                    <div class=\"onoffswitch\">\n");
			out.write("                        <input type=\"checkbox\" name=\"collapsemenu\" class=\"onoffswitch-checkbox\" id=\"collapsemenu\">\n");
			out.write("                        <label class=\"onoffswitch-label\" for=\"collapsemenu\">\n");
			out.write("                            <span class=\"onoffswitch-inner\"></span>\n");
			out.write("                            <span class=\"onoffswitch-switch\"></span>\n");
			out.write("                        </label>\n");
			out.write("                    </div>\n");
			out.write("                </div>\n");
			out.write("            </div>\n");
			out.write("            <div class=\"setings-item\">\n");
			out.write("                <span>\n");
			out.write("                        固定顶部\n");
			out.write("                    </span>\n");
			out.write("\n");
			out.write("                <div class=\"switch\">\n");
			out.write("                    <div class=\"onoffswitch\">\n");
			out.write("                        <input type=\"checkbox\" name=\"fixednavbar\" class=\"onoffswitch-checkbox\" id=\"fixednavbar\">\n");
			out.write("                        <label class=\"onoffswitch-label\" for=\"fixednavbar\">\n");
			out.write("                            <span class=\"onoffswitch-inner\"></span>\n");
			out.write("                            <span class=\"onoffswitch-switch\"></span>\n");
			out.write("                        </label>\n");
			out.write("                    </div>\n");
			out.write("                </div>\n");
			out.write("            </div>\n");
			out.write("            <div class=\"setings-item\">\n");
			out.write("                <span>\n");
			out.write("                        固定宽度\n");
			out.write("                    </span>\n");
			out.write("\n");
			out.write("                <div class=\"switch\">\n");
			out.write("                    <div class=\"onoffswitch\">\n");
			out.write("                        <input type=\"checkbox\" name=\"boxedlayout\" class=\"onoffswitch-checkbox\" id=\"boxedlayout\">\n");
			out.write("                        <label class=\"onoffswitch-label\" for=\"boxedlayout\">\n");
			out.write("                            <span class=\"onoffswitch-inner\"></span>\n");
			out.write("                            <span class=\"onoffswitch-switch\"></span>\n");
			out.write("                        </label>\n");
			out.write("                    </div>\n");
			out.write("                </div>\n");
			out.write("            </div>\n");
			out.write("            <div class=\"title\">皮肤选择</div>\n");
			out.write("            <div class=\"setings-item default-skin\">\n");
			out.write("                <span class=\"skin-name \">\n");
			out.write("                         <a href=\"#\" class=\"s-skin-0\">\n");
			out.write("                             默认皮肤\n");
			out.write("                         </a>\n");
			out.write("                    </span>\n");
			out.write("            </div>\n");
			out.write("            <div class=\"setings-item blue-skin\">\n");
			out.write("                <span class=\"skin-name \">\n");
			out.write("                        <a href=\"#\" class=\"s-skin-1\">\n");
			out.write("                            蓝色主题\n");
			out.write("                        </a>\n");
			out.write("                    </span>\n");
			out.write("            </div>\n");
			out.write("            <div class=\"setings-item yellow-skin\">\n");
			out.write("                <span class=\"skin-name \">\n");
			out.write("                        <a href=\"#\" class=\"s-skin-3\">\n");
			out.write("                            黄色/紫色主题\n");
			out.write("                        </a>\n");
			out.write("                    </span>\n");
			out.write("            </div>\n");
			out.write("        </div>\n");
			out.write("    </div>\n");
			out.write("</div>\n");
			out.write("<script>\n");
			out.write("    // 顶部菜单固定\n");
			out.write("    $('#fixednavbar').click(function () {\n");
			out.write("        if ($('#fixednavbar').is(':checked')) {\n");
			out.write("            $(\".navbar-static-top\").removeClass('navbar-static-top').addClass('navbar-fixed-top');\n");
			out.write("            $(\"body\").removeClass('boxed-layout');\n");
			out.write("            $(\"body\").addClass('fixed-nav');\n");
			out.write("            $('#boxedlayout').prop('checked', false);\n");
			out.write("\n");
			out.write("            if (localStorageSupport) {\n");
			out.write("                localStorage.setItem(\"boxedlayout\",'off');\n");
			out.write("            }\n");
			out.write("\n");
			out.write("            if (localStorageSupport) {\n");
			out.write("                localStorage.setItem(\"fixednavbar\",'on');\n");
			out.write("            }\n");
			out.write("        } else {\n");
			out.write("            $(\".navbar-fixed-top\").removeClass('navbar-fixed-top').addClass('navbar-static-top');\n");
			out.write("            $(\"body\").removeClass('fixed-nav');\n");
			out.write("\n");
			out.write("            if (localStorageSupport) {\n");
			out.write("                localStorage.setItem(\"fixednavbar\",'off');\n");
			out.write("            }\n");
			out.write("        }\n");
			out.write("    });\n");
			out.write("\n");
			out.write("\n");
			out.write("    // 收起左侧菜单\n");
			out.write("    $('#collapsemenu').click(function () {\n");
			out.write("        if ($('#collapsemenu').is(':checked')) {\n");
			out.write("            $(\"body\").addClass('mini-navbar');\n");
			out.write("            SmoothlyMenu();\n");
			out.write("\n");
			out.write("            if (localStorageSupport) {\n");
			out.write("                localStorage.setItem(\"collapse_menu\",'on');\n");
			out.write("            }\n");
			out.write("\n");
			out.write("        } else {\n");
			out.write("            $(\"body\").removeClass('mini-navbar');\n");
			out.write("            SmoothlyMenu();\n");
			out.write("\n");
			out.write("            if (localStorageSupport) {\n");
			out.write("                localStorage.setItem(\"collapse_menu\",'off');\n");
			out.write("            }\n");
			out.write("        }\n");
			out.write("    });\n");
			out.write("\n");
			out.write("    // 固定宽度\n");
			out.write("    $('#boxedlayout').click(function () {\n");
			out.write("        if ($('#boxedlayout').is(':checked')) {\n");
			out.write("            $(\"body\").addClass('boxed-layout');\n");
			out.write("            $('#fixednavbar').prop('checked', false);\n");
			out.write("            $(\".navbar-fixed-top\").removeClass('navbar-fixed-top').addClass('navbar-static-top');\n");
			out.write("            $(\"body\").removeClass('fixed-nav');\n");
			out.write("            if (localStorageSupport) {\n");
			out.write("                localStorage.setItem(\"fixednavbar\",'off');\n");
			out.write("            }\n");
			out.write("\n");
			out.write("\n");
			out.write("            if (localStorageSupport) {\n");
			out.write("                localStorage.setItem(\"boxedlayout\",'on');\n");
			out.write("            }\n");
			out.write("        } else {\n");
			out.write("            $(\"body\").removeClass('boxed-layout');\n");
			out.write("\n");
			out.write("            if (localStorageSupport) {\n");
			out.write("                localStorage.setItem(\"boxedlayout\",'off');\n");
			out.write("            }\n");
			out.write("        }\n");
			out.write("    });\n");
			out.write("\n");
			out.write("    // 皮肤选择\n");
			out.write("    $('.spin-icon').click(function () {\n");
			out.write("        $(\".theme-config-box\").toggleClass(\"show\");\n");
			out.write("        $(\".skin-setttings\").toggleClass(\"show\");\n");
			out.write("    });\n");
			out.write("\n");
			out.write("    // 默认主题\n");
			out.write("    $('.s-skin-0').click(function () {\n");
			out.write("        \n");
			out.write("        $(\"body\").removeClass(\"skin-2\");\n");
			out.write("        $(\"body\").removeClass(\"skin-3\");\n");
			out.write("        $(\"body\").removeClass(\"skin-1\");\n");
			out.write("         $.get('");
			out.write((String) PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", String.class, _jspx_page_context, null, false));
			out.write("/theme/default?url='+window.top.location.href,function(result){  });\n");
			out.write("    });\n");
			out.write("\n");
			out.write("    // 蓝色主题\n");
			out.write("    $('.s-skin-1').click(function () {\n");
			out.write("        $(\"body\").removeClass(\"skin-2\");\n");
			out.write("        $(\"body\").removeClass(\"skin-3\");\n");
			out.write("        $(\"body\").addClass(\"skin-1\");\n");
			out.write("        $.get('");
			out.write((String) PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", String.class, _jspx_page_context, null, false));
			out.write("/theme/cerulean?url='+window.top.location.href,function(result){  });\n");
			out.write("    });\n");
			out.write("\n");
			out.write("    // 黄色主题\n");
			out.write("    $('.s-skin-3').click(function () {\n");
			out.write("        $(\"body\").removeClass(\"skin-1\");\n");
			out.write("        $(\"body\").removeClass(\"skin-2\");\n");
			out.write("        $(\"body\").addClass(\"skin-3\");\n");
			out.write("        $.get('");
			out.write((String) PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", String.class, _jspx_page_context, null, false));
			out.write("/theme/readable?url='+window.top.location.href,function(result){  });\n");
			out.write("    });\n");
			out.write("    \n");
			out.write("    if (localStorageSupport) {\n");
			out.write("        var collapse = localStorage.getItem(\"collapse_menu\");\n");
			out.write("        var fixednavbar = localStorage.getItem(\"fixednavbar\");\n");
			out.write("        var boxedlayout = localStorage.getItem(\"boxedlayout\");\n");
			out.write("\n");
			out.write("        if (collapse == 'on') {\n");
			out.write("            $('#collapsemenu').prop('checked','checked')\n");
			out.write("        }\n");
			out.write("        if (fixednavbar == 'on') {\n");
			out.write("            $('#fixednavbar').prop('checked','checked')\n");
			out.write("        }\n");
			out.write("        if (boxedlayout == 'on') {\n");
			out.write("            $('#boxedlayout').prop('checked','checked')\n");
			out.write("        }\n");
			out.write("    }\n");
			out.write("</script>\n");
			out.write("\n");
			out.write("<style>\n");
			out.write("    .fixed-nav .slimScrollDiv #side-menu {\n");
			out.write("        padding-bottom: 60px;\n");
			out.write("    }\n");
			out.write("</style>");
		} catch (java.lang.Throwable t) {
			if (!(t instanceof javax.servlet.jsp.SkipPageException)) {
				out = _jspx_out;
				if (out != null && out.getBufferSize() != 0)
					try {
						out.clearBuffer();
					} catch (java.io.IOException e) {
					}
				if (_jspx_page_context != null)
					_jspx_page_context.handlePageException(t);
				else
					throw new ServletException(t);
			}
		} finally {
			_jspxFactory.releasePageContext(_jspx_page_context);
		}
	}
}