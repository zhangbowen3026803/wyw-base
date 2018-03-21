package org.apache.jsp.tag.web.table;

import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.el.ExpressionFactory;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspFactory;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.SkipPageException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import javax.servlet.jsp.tagext.Tag;
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

public final class addRow_tag extends SimpleTagSupport implements JspSourceDependent {

	private static ProtectedFunctionMapper _jspx_fnmap_0 = ProtectedFunctionMapper.getMapForFunction("fns:getAdminPath", Global.class, "getAdminPath", new Class[0]);

	private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

	private static Map<String, Long> _jspx_dependants = new HashMap<String, Long>();
	private static final Set<String> _jspx_imports_packages;
	private JspContext jspContext;
	private Writer _jspx_sout;
	private TagHandlerPool _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody;
	private ExpressionFactory _el_expressionfactory;
	private InstanceManager _jsp_instancemanager;
	private String url;
	private String title;
	private String width;
	private String height;
	private String target;
	private String label;

	static {
		_jspx_dependants.put("/WEB-INF/tlds/shiros.tld", Long.valueOf(0x15470f5683bL));
		_jspx_dependants.put("/WEB-INF/tlds/fns.tld", Long.valueOf(0x15448763d3bL));
		_jspx_dependants.put("/webpage/include/taglib.jsp", Long.valueOf(0x15470fd8000L));
		_jspx_dependants.put("/WEB-INF/tlds/menu.tld", Long.valueOf(0x15470f56827L));
		_jspx_imports_packages = new HashSet<String>();
		_jspx_imports_packages.add("javax.servlet");
		_jspx_imports_packages.add("javax.servlet.jsp");
		_jspx_imports_packages.add("javax.servlet.http");
	}

	public void setJspContext(JspContext ctx) {
		super.setJspContext(ctx);
		java.util.ArrayList _jspx_nested = null;
		java.util.ArrayList _jspx_at_begin = null;
		java.util.ArrayList _jspx_at_end = null;
		this.jspContext = new JspContextWrapper(ctx, _jspx_nested, _jspx_at_begin, _jspx_at_end, null);
	}

	public JspContext getJspContext() {
		return jspContext;
	}

	@Override
	public Map<String, Long> getDependants() {
		return _jspx_dependants;
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

		if (getUrl() != null)
			_jspx_page_context.setAttribute("url", getUrl());
		if (getTitle() != null)
			_jspx_page_context.setAttribute("title", getTitle());
		if (getWidth() != null)
			_jspx_page_context.setAttribute("width", getWidth());
		if (getHeight() != null)
			_jspx_page_context.setAttribute("height", getHeight());
		if (getTarget() != null)
			_jspx_page_context.setAttribute("target", getTarget());
		if (getLabel() != null)
			_jspx_page_context.setAttribute("label", getLabel());

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
			out.write("\n");
			out.write("\n");
			out.write("<button class=\"btn btn-white btn-sm\" data-toggle=\"tooltip\" data-placement=\"left\" onclick=\"add()\" title=\"添加\"><i class=\"fa fa-plus\"></i> ");
			out.write((String) PageContextImpl.proprietaryEvaluate("${label==null?'添加':label}", String.class, (PageContext) getJspContext(), null, false));
			out.write("</button>\n");
			out.write("\n");
			out.write("<script type=\"text/javascript\">\n");
			out.write("\tfunction add(){\n");
			out.write("\t\topenDialog(\"新增\"+'");
			out.write((String) PageContextImpl.proprietaryEvaluate("${title}", String.class, (PageContext) getJspContext(), null, false));
			out.write(39);
			out.write(44);
			out.write(34);
			out.write((String) PageContextImpl.proprietaryEvaluate("${url}", String.class, (PageContext) getJspContext(), null, false));
			out.write(34);
			out.write(44);
			out.write(34);
			out.write((String) PageContextImpl.proprietaryEvaluate("${width==null?'800px':width}", String.class, (PageContext) getJspContext(), null, false));
			out.write("\", \"");
			out.write((String) PageContextImpl.proprietaryEvaluate("${height==null?'500px':height}", String.class, (PageContext) getJspContext(), null, false));
			out.write(34);
			out.write(44);
			out.write(34);
			out.write((String) PageContextImpl.proprietaryEvaluate("${target}", String.class, (PageContext) getJspContext(), null, false));
			out.write("\");\n");
			out.write("\t}\n");
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
		_jspx_page_context.getOut();

		SetTag _jspx_th_c_005fset_005f0 = (SetTag) this._005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.get(SetTag.class);
		_jspx_th_c_005fset_005f0.setPageContext(_jspx_page_context);
		_jspx_th_c_005fset_005f0.setParent(new TagAdapter(this));
		_jspx_th_c_005fset_005f0.setVar("ctx");

		_jspx_th_c_005fset_005f0.setValue(PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}${fns:getAdminPath()}", Object.class, (PageContext) getJspContext(), _jspx_fnmap_0, false));
		_jspx_th_c_005fset_005f0.doStartTag();
		if (_jspx_th_c_005fset_005f0.doEndTag() == Tag.SKIP_PAGE) {
			this._005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f0);
			throw new SkipPageException();
		} else {
			this._005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f0);
			return false;
		}
	}

	private boolean _jspx_meth_c_005fset_005f1(PageContext _jspx_page_context) throws Throwable {
		_jspx_page_context.getOut();

		SetTag _jspx_th_c_005fset_005f1 = (SetTag) this._005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.get(SetTag.class);
		_jspx_th_c_005fset_005f1.setPageContext(_jspx_page_context);
		_jspx_th_c_005fset_005f1.setParent(new TagAdapter(this));
		_jspx_th_c_005fset_005f1.setVar("ctxStatic");

		_jspx_th_c_005fset_005f1.setValue(PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}/static", Object.class, (PageContext) getJspContext(), null, false));
		_jspx_th_c_005fset_005f1.doStartTag();
		if (_jspx_th_c_005fset_005f1.doEndTag() == 5) {
			this._005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f1);
			throw new SkipPageException();
		} else {
			this._005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f1);
			return false;
		}
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
		this.jspContext.setAttribute("url", url);
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
		this.jspContext.setAttribute("title", title);
	}

	public String getWidth() {
		return this.width;
	}

	public void setWidth(String width) {
		this.width = width;
		this.jspContext.setAttribute("width", width);
	}

	public String getHeight() {
		return this.height;
	}

	public void setHeight(String height) {
		this.height = height;
		this.jspContext.setAttribute("height", height);
	}

	public String getTarget() {
		return this.target;
	}

	public void setTarget(String target) {
		this.target = target;
		this.jspContext.setAttribute("target", target);
	}

	public String getLabel() {
		return this.label;
	}

	public void setLabel(String label) {
		this.label = label;
		this.jspContext.setAttribute("label", label);
	}
}