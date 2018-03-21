package org.apache.jsp.tag.web.table;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.el.ExpressionFactory;
import javax.servlet.ServletConfig;
import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspFactory;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.SkipPageException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import javax.servlet.jsp.tagext.TagAdapter;

import org.apache.jasper.runtime.InstanceManagerFactory;
import org.apache.jasper.runtime.JspContextWrapper;
import org.apache.jasper.runtime.JspSourceDependent;
import org.apache.jasper.runtime.PageContextImpl;
import org.apache.jasper.runtime.ProtectedFunctionMapper;
import org.apache.jasper.runtime.TagHandlerPool;
import org.apache.taglibs.standard.tag.rt.core.SetTag;
import org.apache.tomcat.InstanceManager;

import com.lianda.common.config.Global;

public final class sortColumn_tag extends SimpleTagSupport implements JspSourceDependent {

	private static ProtectedFunctionMapper _jspx_fnmap_0 = ProtectedFunctionMapper.getMapForFunction("fns:getAdminPath", Global.class, "getAdminPath", new Class[0]);

	private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

	private static Map<String, Long> _jspx_dependants = new HashMap<String, Long>();
	private static final Set<String> _jspx_imports_packages;
	private JspContext jspContext;
	private TagHandlerPool _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody;
	private ExpressionFactory _el_expressionfactory;
	private InstanceManager _jsp_instancemanager;
	private String id;
	private String name;
	private String value;
	private String callback;

	static {
		_jspx_dependants.put("/WEB-INF/tlds/shiros.tld", Long.valueOf(1464506993421L));
		_jspx_dependants.put("/WEB-INF/tlds/echarts.tld", Long.valueOf(1464506993423L));
		_jspx_dependants.put("/WEB-INF/tlds/fns.tld", Long.valueOf(1464506993420L));
		_jspx_dependants.put("/webpage/include/taglib.jsp", Long.valueOf(1464507568941L));
		_jspx_dependants.put("/WEB-INF/tlds/menu.tld", Long.valueOf(1464506993419L));

		_jspx_imports_packages = new HashSet<String>();
		_jspx_imports_packages.add("javax.servlet");
		_jspx_imports_packages.add("javax.servlet.jsp");
		_jspx_imports_packages.add("javax.servlet.http");
	}

	public void setJspContext(JspContext ctx) {
		super.setJspContext(ctx);
		ArrayList _jspx_nested = null;
		ArrayList _jspx_at_begin = null;
		ArrayList _jspx_at_end = null;
		this.jspContext = new JspContextWrapper(ctx, _jspx_nested, _jspx_at_begin, _jspx_at_end, null);
	}

	public JspContext getJspContext() {
		return this.jspContext;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
		this.jspContext.setAttribute("id", id);
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
		this.jspContext.setAttribute("name", name);
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
		this.jspContext.setAttribute("value", value);
	}

	public String getCallback() {
		return this.callback;
	}

	public void setCallback(String callback) {
		this.callback = callback;
		this.jspContext.setAttribute("callback", callback);
	}

	public Map<String, Long> getDependants() {
		return _jspx_dependants;
	}

	public Set<String> getPackageImports() {
		return _jspx_imports_packages;
	}

	private void _jspInit(ServletConfig config) {
		this._005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody = TagHandlerPool.getTagHandlerPool(config);
		this._el_expressionfactory = _jspxFactory.getJspApplicationContext(config.getServletContext()).getExpressionFactory();
		this._jsp_instancemanager = InstanceManagerFactory.getInstanceManager(config);
	}

	public void _jspDestroy() {
		this._005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.release();
	}

	@Override
	public void doTag() throws JspException, IOException {

		PageContext _jspx_page_context = (PageContext) this.jspContext;
		JspWriter out = jspContext.getOut();
		ServletConfig config = _jspx_page_context.getServletConfig();
		_jspInit(config);

		this.jspContext.getELContext().putContext(JspContext.class, this.jspContext);
		if (getId() != null)
			_jspx_page_context.setAttribute("id", getId());
		if (getName() != null)
			_jspx_page_context.setAttribute("name", getName());
		if (getValue() != null)
			_jspx_page_context.setAttribute("value", getValue());
		if (getCallback() != null)
			_jspx_page_context.setAttribute("callback", getCallback());
		try {
			out.write(10);
			out.write("\n");
			out.write("\n");
			out.write("\n");
			out.write("\n");
			out.write("\n");
			out.write("\n");
			out.write("\n");
			out.write("\n");
			out.write("\n");
			out.write("\n");
			out.write("\n");
			if (_jspx_meth_c_005fset_005f0(_jspx_page_context))
				return;
			out.write(10);
			if (_jspx_meth_c_005fset_005f1(_jspx_page_context))
				return;
			out.write("\n");
			out.write("\n");
			out.write("\n");
			out.write("\n");
			out.write("\n");
			out.write("<input id=\"");
			out.write((String) PageContextImpl.proprietaryEvaluate("${id}", String.class, (PageContext) getJspContext(), null, false));
			out.write("\" name=\"");
			out.write((String) PageContextImpl.proprietaryEvaluate("${name}", String.class, (PageContext) getJspContext(), null, false));
			out.write("\" type=\"hidden\" value=\"");
			out.write((String) PageContextImpl.proprietaryEvaluate("${value}", String.class, (PageContext) getJspContext(), null, false));
			out.write("\"/>\n");
			out.write("\n");
			out.write("<script type=\"text/javascript\">\n");
			out.write("\t$(document).ready(function() {\n");
			out.write("\t\tvar orderBy = $(\"#");
			out.write((String) PageContextImpl.proprietaryEvaluate("${id}", String.class, (PageContext) getJspContext(), null, false));
			out.write("\").val().split(\" \");\n");
			out.write("\t\t$(\".sort-column\").each(function(){\n");
			out.write("\t\t\t\t$(this).html($(this).html()+\" <i class=\\\"fa fa-sort\\\"></i>\");\n");
			out.write("\t\t});\n");
			out.write("\t\t$(\".sort-column\").each(function(){\n");
			out.write("\t\t\tif ($(this).hasClass(orderBy[0])){\n");
			out.write("\t\t\t\torderBy[1] = orderBy[1]&&orderBy[1].toUpperCase()==\"DESC\"?\"down\":\"up\";\n");
			out.write("\t\t\t\t$(this).find(\"i\").remove();\n");
			out.write("\t\t\t\t$(this).html($(this).html()+\" <i class=\\\"fa fa-sort-\"+orderBy[1]+\"\\\"></i>\");\n");
			out.write("\t\t\t}\n");
			out.write("\t\t});\n");
			out.write("\t\t$(\".sort-column\").click(function(){\n");
			out.write("\t\t\tvar order = $(this).attr(\"class\").split(\" \");\n");
			out.write("\t\t\tvar sort = $(\"#");
			out.write((String) PageContextImpl.proprietaryEvaluate("${id}", String.class, (PageContext) getJspContext(), null, false));
			out.write("\").val().split(\" \");\n");
			out.write("\t\t\tfor(var i=0; i<order.length; i++){\n");
			out.write("\t\t\t\tif (order[i] == \"sort-column\"){order = order[i+1]; break;}\n");
			out.write("\t\t\t}\n");
			out.write("\t\t\tif (order == sort[0]){\n");
			out.write("\t\t\t\tsort = (sort[1]&&sort[1].toUpperCase()==\"DESC\"?\"ASC\":\"DESC\");\n");
			out.write("\t\t\t\t$(\"#");
			out.write((String) PageContextImpl.proprietaryEvaluate("${id}", String.class, (PageContext) getJspContext(), null, false));
			out.write("\").val(order+\" DESC\"!=order+\" \"+sort?\"\":order+\" \"+sort);\n");
			out.write("\t\t\t}else{\n");
			out.write("\t\t\t\t$(\"#");
			out.write((String) PageContextImpl.proprietaryEvaluate("${id}", String.class, (PageContext) getJspContext(), null, false));
			out.write("\").val(order+\" ASC\");\n");
			out.write("\t\t\t}\n");
			out.write("\t\t\t");
			out.write((String) PageContextImpl.proprietaryEvaluate("${callback}", String.class, (PageContext) getJspContext(), null, false));
			out.write("\n");
			out.write("\t\t});\n");
			out.write("\t});\n");
			out.write("</script>");
		} catch (Throwable t) {
			if (t instanceof SkipPageException)
				throw ((SkipPageException) t);
			if (t instanceof IOException)
				throw ((IOException) t);
			if (t instanceof IllegalStateException)
				;
			throw new JspException(t);
		} finally {
			this.jspContext.getELContext().putContext(JspContext.class, super.getJspContext());
			((JspContextWrapper) this.jspContext).syncEndTagFile();
			_jspDestroy();
		}
	}

	private boolean _jspx_meth_c_005fset_005f0(PageContext _jspx_page_context) throws Throwable {

		SetTag _jspx_th_c_005fset_005f0 = (SetTag) this._005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.get(SetTag.class);
		_jspx_th_c_005fset_005f0.setPageContext(_jspx_page_context);
		_jspx_th_c_005fset_005f0.setParent(new TagAdapter(this));
		_jspx_th_c_005fset_005f0.setVar("ctx");

		_jspx_th_c_005fset_005f0.setValue(PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}${fns:getAdminPath()}", Object.class, (PageContext) getJspContext(), _jspx_fnmap_0, false));
		_jspx_th_c_005fset_005f0.doStartTag();
		if (_jspx_th_c_005fset_005f0.doEndTag() == 5) {
			this._005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f0);
			throw new SkipPageException();
		}
		this._005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f0);
		return false;
	}

	private boolean _jspx_meth_c_005fset_005f1(PageContext _jspx_page_context) throws Throwable {

		SetTag _jspx_th_c_005fset_005f1 = (SetTag) this._005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.get(SetTag.class);
		_jspx_th_c_005fset_005f1.setPageContext(_jspx_page_context);
		_jspx_th_c_005fset_005f1.setParent(new TagAdapter(this));
		_jspx_th_c_005fset_005f1.setVar("ctxStatic");

		_jspx_th_c_005fset_005f1.setValue(PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}/static", Object.class, (PageContext) getJspContext(), null, false));
		_jspx_th_c_005fset_005f1.doStartTag();
		if (_jspx_th_c_005fset_005f1.doEndTag() == 5) {
			this._005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f1);
			throw new SkipPageException();
		}
		this._005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f1);
		return false;
	}
}