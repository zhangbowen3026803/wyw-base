package org.apache.jsp.tag.web.sys;

import java.io.IOException;
import java.io.Writer;
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
import org.apache.taglibs.standard.functions.Functions;
import org.apache.taglibs.standard.tag.rt.core.IfTag;
import org.apache.taglibs.standard.tag.rt.core.SetTag;
import org.apache.tomcat.InstanceManager;

import com.lianda.common.config.Global;

public final class treeselect_tag extends SimpleTagSupport implements JspSourceDependent {

	private static ProtectedFunctionMapper _jspx_fnmap_0 = ProtectedFunctionMapper.getMapForFunction("fns:getAdminPath", Global.class, "getAdminPath", new Class[0]);
	private static ProtectedFunctionMapper _jspx_fnmap_1 = ProtectedFunctionMapper.getMapForFunction("fn:contains", Functions.class, "contains", new Class[] { String.class, String.class });

	private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

	private static Map<String, Long> _jspx_dependants = new HashMap<String, Long>();
	private static final Set<String> _jspx_imports_packages;
	private JspContext jspContext;
	private Writer _jspx_sout;
	private TagHandlerPool _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody;
	private TagHandlerPool _005fjspx_005ftagPool_005fc_005fif_0026_005ftest;
	private ExpressionFactory _el_expressionfactory;
	private InstanceManager _jsp_instancemanager;
	private String id;
	private String name;
	private String value;
	private String labelName;
	private String labelValue;
	private String title;
	private String url;
	private Boolean checked;
	private String extId;
	private Boolean isAll;
	private Boolean notAllowSelectRoot;
	private Boolean notAllowSelectParent;
	private String module;
	private Boolean selectScopeModule;
	private Boolean allowClear;
	private Boolean allowInput;
	private String cssClass;
	private String cssStyle;
	private Boolean smallBtn;
	private Boolean hideBtn;
	private String disabled;
	private String dataMsgRequired;

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

	public String getLabelName() {
		return this.labelName;
	}

	public void setLabelName(String labelName) {
		this.labelName = labelName;
		this.jspContext.setAttribute("labelName", labelName);
	}

	public String getLabelValue() {
		return this.labelValue;
	}

	public void setLabelValue(String labelValue) {
		this.labelValue = labelValue;
		this.jspContext.setAttribute("labelValue", labelValue);
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
		this.jspContext.setAttribute("title", title);
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
		this.jspContext.setAttribute("url", url);
	}

	public Boolean getChecked() {
		return this.checked;
	}

	public void setChecked(Boolean checked) {
		this.checked = checked;
		this.jspContext.setAttribute("checked", checked);
	}

	public String getExtId() {
		return this.extId;
	}

	public void setExtId(String extId) {
		this.extId = extId;
		this.jspContext.setAttribute("extId", extId);
	}

	public Boolean getIsAll() {
		return this.isAll;
	}

	public void setIsAll(Boolean isAll) {
		this.isAll = isAll;
		this.jspContext.setAttribute("isAll", isAll);
	}

	public Boolean getNotAllowSelectRoot() {
		return this.notAllowSelectRoot;
	}

	public void setNotAllowSelectRoot(Boolean notAllowSelectRoot) {
		this.notAllowSelectRoot = notAllowSelectRoot;
		this.jspContext.setAttribute("notAllowSelectRoot", notAllowSelectRoot);
	}

	public Boolean getNotAllowSelectParent() {
		return this.notAllowSelectParent;
	}

	public void setNotAllowSelectParent(Boolean notAllowSelectParent) {
		this.notAllowSelectParent = notAllowSelectParent;
		this.jspContext.setAttribute("notAllowSelectParent", notAllowSelectParent);
	}

	public String getModule() {
		return this.module;
	}

	public void setModule(String module) {
		this.module = module;
		this.jspContext.setAttribute("module", module);
	}

	public Boolean getSelectScopeModule() {
		return this.selectScopeModule;
	}

	public void setSelectScopeModule(Boolean selectScopeModule) {
		this.selectScopeModule = selectScopeModule;
		this.jspContext.setAttribute("selectScopeModule", selectScopeModule);
	}

	public Boolean getAllowClear() {
		return this.allowClear;
	}

	public void setAllowClear(Boolean allowClear) {
		this.allowClear = allowClear;
		this.jspContext.setAttribute("allowClear", allowClear);
	}

	public Boolean getAllowInput() {
		return this.allowInput;
	}

	public void setAllowInput(Boolean allowInput) {
		this.allowInput = allowInput;
		this.jspContext.setAttribute("allowInput", allowInput);
	}

	public String getCssClass() {
		return this.cssClass;
	}

	public void setCssClass(String cssClass) {
		this.cssClass = cssClass;
		this.jspContext.setAttribute("cssClass", cssClass);
	}

	public String getCssStyle() {
		return this.cssStyle;
	}

	public void setCssStyle(String cssStyle) {
		this.cssStyle = cssStyle;
		this.jspContext.setAttribute("cssStyle", cssStyle);
	}

	public Boolean getSmallBtn() {
		return this.smallBtn;
	}

	public void setSmallBtn(Boolean smallBtn) {
		this.smallBtn = smallBtn;
		this.jspContext.setAttribute("smallBtn", smallBtn);
	}

	public Boolean getHideBtn() {
		return this.hideBtn;
	}

	public void setHideBtn(Boolean hideBtn) {
		this.hideBtn = hideBtn;
		this.jspContext.setAttribute("hideBtn", hideBtn);
	}

	public String getDisabled() {
		return this.disabled;
	}

	public void setDisabled(String disabled) {
		this.disabled = disabled;
		this.jspContext.setAttribute("disabled", disabled);
	}

	public String getDataMsgRequired() {
		return this.dataMsgRequired;
	}

	public void setDataMsgRequired(String dataMsgRequired) {
		this.dataMsgRequired = dataMsgRequired;
		this.jspContext.setAttribute("dataMsgRequired", dataMsgRequired);
	}

	public Map<String, Long> getDependants() {
		return _jspx_dependants;
	}

	public Set<String> getPackageImports() {
		return _jspx_imports_packages;
	}

	private void _jspInit(ServletConfig config) {
		this._005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody = TagHandlerPool.getTagHandlerPool(config);
		this._005fjspx_005ftagPool_005fc_005fif_0026_005ftest = TagHandlerPool.getTagHandlerPool(config);
		this._el_expressionfactory = _jspxFactory.getJspApplicationContext(config.getServletContext()).getExpressionFactory();
		this._jsp_instancemanager = InstanceManagerFactory.getInstanceManager(config);
	}

	public void _jspDestroy() {
		this._005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.release();
		this._005fjspx_005ftagPool_005fc_005fif_0026_005ftest.release();
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
		if (getLabelName() != null)
			_jspx_page_context.setAttribute("labelName", getLabelName());
		if (getLabelValue() != null)
			_jspx_page_context.setAttribute("labelValue", getLabelValue());
		if (getTitle() != null)
			_jspx_page_context.setAttribute("title", getTitle());
		if (getUrl() != null)
			_jspx_page_context.setAttribute("url", getUrl());
		if (getChecked() != null)
			_jspx_page_context.setAttribute("checked", getChecked());
		if (getExtId() != null)
			_jspx_page_context.setAttribute("extId", getExtId());
		if (getIsAll() != null)
			_jspx_page_context.setAttribute("isAll", getIsAll());
		if (getNotAllowSelectRoot() != null)
			_jspx_page_context.setAttribute("notAllowSelectRoot", getNotAllowSelectRoot());
		if (getNotAllowSelectParent() != null)
			_jspx_page_context.setAttribute("notAllowSelectParent", getNotAllowSelectParent());
		if (getModule() != null)
			_jspx_page_context.setAttribute("module", getModule());
		if (getSelectScopeModule() != null)
			_jspx_page_context.setAttribute("selectScopeModule", getSelectScopeModule());
		if (getAllowClear() != null)
			_jspx_page_context.setAttribute("allowClear", getAllowClear());
		if (getAllowInput() != null)
			_jspx_page_context.setAttribute("allowInput", getAllowInput());
		if (getCssClass() != null)
			_jspx_page_context.setAttribute("cssClass", getCssClass());
		if (getCssStyle() != null)
			_jspx_page_context.setAttribute("cssStyle", getCssStyle());
		if (getSmallBtn() != null)
			_jspx_page_context.setAttribute("smallBtn", getSmallBtn());
		if (getHideBtn() != null)
			_jspx_page_context.setAttribute("hideBtn", getHideBtn());
		if (getDisabled() != null)
			_jspx_page_context.setAttribute("disabled", getDisabled());
		if (getDataMsgRequired() != null)
			_jspx_page_context.setAttribute("dataMsgRequired", getDataMsgRequired());
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
			out.write("\n");
			out.write("\n");
			out.write("\n");
			out.write("\n");
			out.write("\n");
			out.write("\t<input id=\"");
			out.write((String) PageContextImpl.proprietaryEvaluate("${id}", String.class, (PageContext) getJspContext(), null, false));
			out.write("Id\" name=\"");
			out.write((String) PageContextImpl.proprietaryEvaluate("${name}", String.class, (PageContext) getJspContext(), null, false));
			out.write("\" class=\"");
			out.write((String) PageContextImpl.proprietaryEvaluate("${cssClass}", String.class, (PageContext) getJspContext(), null, false));
			out.write("\" type=\"hidden\" value=\"");
			out.write((String) PageContextImpl.proprietaryEvaluate("${value}", String.class, (PageContext) getJspContext(), null, false));
			out.write("\"/>\n");
			out.write("\t<div class=\"input-group\">\n");
			out.write("\t\t<input id=\"");
			out.write((String) PageContextImpl.proprietaryEvaluate("${id}", String.class, (PageContext) getJspContext(), null, false));
			out.write("Name\" name=\"");
			out.write((String) PageContextImpl.proprietaryEvaluate("${labelName}", String.class, (PageContext) getJspContext(), null, false));
			out.write(34);
			out.write(32);
			out.write((String) PageContextImpl.proprietaryEvaluate("${allowInput?'':'readonly=\"readonly\"'}", String.class, (PageContext) getJspContext(), null, false));
			out.write("  type=\"text\" value=\"");
			out.write((String) PageContextImpl.proprietaryEvaluate("${labelValue}", String.class, (PageContext) getJspContext(), null, false));
			out.write("\" data-msg-required=\"");
			out.write((String) PageContextImpl.proprietaryEvaluate("${dataMsgRequired}", String.class, (PageContext) getJspContext(), null, false));
			out.write("\"\n");
			out.write("\t\tclass=\"");
			out.write((String) PageContextImpl.proprietaryEvaluate("${cssClass}", String.class, (PageContext) getJspContext(), null, false));
			out.write("\" style=\"");
			out.write((String) PageContextImpl.proprietaryEvaluate("${cssStyle}", String.class, (PageContext) getJspContext(), null, false));
			out.write("\"/>\n");
			out.write("       \t\t <span class=\"input-group-btn\">\n");
			out.write("\t       \t\t <button type=\"button\"  id=\"");
			out.write((String) PageContextImpl.proprietaryEvaluate("${id}", String.class, (PageContext) getJspContext(), null, false));
			out.write("Button\" class=\"btn ");
			if (_jspx_meth_c_005fif_005f0(_jspx_page_context))
				return;
			if (_jspx_meth_c_005fif_005f1(_jspx_page_context))
				return;
			out.write("  btn-primary ");
			out.write((String) PageContextImpl.proprietaryEvaluate("${disabled}", String.class, (PageContext) getJspContext(), null, false));
			out.write(32);
			out.write((String) PageContextImpl.proprietaryEvaluate("${hideBtn ? 'hide' : ''}", String.class, (PageContext) getJspContext(), null, false));
			out.write("\"><i class=\"fa fa-search\"></i>\n");
			out.write("\t             </button> \n");
			out.write("       \t\t </span>\n");
			out.write("       \t\t\n");
			out.write("    </div>\n");
			out.write("\t <label id=\"");
			out.write((String) PageContextImpl.proprietaryEvaluate("${id}", String.class, (PageContext) getJspContext(), null, false));
			out.write("Name-error\" class=\"error\" for=\"");
			out.write((String) PageContextImpl.proprietaryEvaluate("${id}", String.class, (PageContext) getJspContext(), null, false));
			out.write("Name\" style=\"display:none\"></label>\n");
			out.write("<script type=\"text/javascript\">\n");
			out.write("\t$(\"#");
			out.write((String) PageContextImpl.proprietaryEvaluate("${id}", String.class, (PageContext) getJspContext(), null, false));
			out.write("Button, #");
			out.write((String) PageContextImpl.proprietaryEvaluate("${id}", String.class, (PageContext) getJspContext(), null, false));
			out.write("Name\").click(function(){\n");
			out.write("\t\t// 是否限制选择，如果限制，设置为disabled\n");
			out.write("\t\tif ($(\"#");
			out.write((String) PageContextImpl.proprietaryEvaluate("${id}", String.class, (PageContext) getJspContext(), null, false));
			out.write("Button\").hasClass(\"disabled\")){\n");
			out.write("\t\t\treturn true;\n");
			out.write("\t\t}\n");
			out.write("\t\t// 正常打开\t\n");
			out.write("\t\ttop.layer.open({\n");
			out.write("\t\t    type: 2, \n");
			out.write("\t\t    area: ['300px', '420px'],\n");
			out.write("\t\t    title:\"选择");
			out.write((String) PageContextImpl.proprietaryEvaluate("${title}", String.class, (PageContext) getJspContext(), null, false));
			out.write("\",\n");
			out.write("\t\t    ajaxData:{selectIds: $(\"#");
			out.write((String) PageContextImpl.proprietaryEvaluate("${id}", String.class, (PageContext) getJspContext(), null, false));
			out.write("Id\").val()},\n");
			out.write("\t\t    content: \"");
			out.write((String) PageContextImpl.proprietaryEvaluate("${ctx}", String.class, (PageContext) getJspContext(), null, false));
			out.write("/tag/treeselect?url=\"+encodeURIComponent(\"");
			out.write((String) PageContextImpl.proprietaryEvaluate("${url}", String.class, (PageContext) getJspContext(), null, false));
			out.write("\")+\"&module=");
			out.write((String) PageContextImpl.proprietaryEvaluate("${module}", String.class, (PageContext) getJspContext(), null, false));
			out.write("&checked=");
			out.write((String) PageContextImpl.proprietaryEvaluate("${checked}", String.class, (PageContext) getJspContext(), null, false));
			out.write("&extId=");
			out.write((String) PageContextImpl.proprietaryEvaluate("${extId}", String.class, (PageContext) getJspContext(), null, false));
			out.write("&isAll=");
			out.write((String) PageContextImpl.proprietaryEvaluate("${isAll}", String.class, (PageContext) getJspContext(), null, false));
			out.write("\" ,\n");
			out.write("\t\t    btn: ['确定', '关闭']\n");
			out.write("    \t       ,yes: function(index, layero){ //或者使用btn1\n");
			out.write("\t\t\t\t\t\tvar tree = layero.find(\"iframe\")[0].contentWindow.tree;//h.find(\"iframe\").contents();\n");
			out.write("\t\t\t\t\t\tvar ids = [], names = [], nodes = [];\n");
			out.write("\t\t\t\t\t\tif (\"");
			out.write((String) PageContextImpl.proprietaryEvaluate("${checked}", String.class, (PageContext) getJspContext(), null, false));
			out.write("\" == \"true\"){\n");
			out.write("\t\t\t\t\t\t\tnodes = tree.getCheckedNodes(true);\n");
			out.write("\t\t\t\t\t\t}else{\n");
			out.write("\t\t\t\t\t\t\tnodes = tree.getSelectedNodes();\n");
			out.write("\t\t\t\t\t\t}\n");
			out.write("\t\t\t\t\t\tfor(var i=0; i<nodes.length; i++) {//");
			if (_jspx_meth_c_005fif_005f2(_jspx_page_context))
				return;
			if (_jspx_meth_c_005fif_005f3(_jspx_page_context))
				return;
			if (_jspx_meth_c_005fif_005f4(_jspx_page_context))
				return;
			if (_jspx_meth_c_005fif_005f5(_jspx_page_context))
				return;
			out.write("\n");
			out.write("\t\t\t\t\t\t\tids.push(nodes[i].id);\n");
			out.write("\t\t\t\t\t\t\tnames.push(nodes[i].name);//");
			if (_jspx_meth_c_005fif_005f6(_jspx_page_context))
				return;
			out.write("\n");
			out.write("\t\t\t\t\t\t}\n");
			out.write("\t\t\t\t\t\t$(\"#");
			out.write((String) PageContextImpl.proprietaryEvaluate("${id}", String.class, (PageContext) getJspContext(), null, false));
			out.write("Id\").val(ids.join(\",\").replace(/u_/ig,\"\"));\n");
			out.write("\t\t\t\t\t\t$(\"#");
			out.write((String) PageContextImpl.proprietaryEvaluate("${id}", String.class, (PageContext) getJspContext(), null, false));
			out.write("Name\").val(names.join(\",\"));\n");
			out.write("\t\t\t\t\t\t$(\"#");
			out.write((String) PageContextImpl.proprietaryEvaluate("${id}", String.class, (PageContext) getJspContext(), null, false));
			out.write("Name\").focus();\n");
			out.write("\t\t\t\t\t\ttop.layer.close(index);\n");
			out.write("\t\t\t\t    \t       },\n");
			out.write("    \tcancel: function(index){ //或者使用btn2\n");
			out.write("    \t           //按钮【按钮二】的回调\n");
			out.write("    \t       }\n");
			out.write("\t\t}); \n");
			out.write("\t\n");
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
		_jspx_page_context.getOut();

		SetTag _jspx_th_c_005fset_005f0 = (SetTag) this._005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.get(SetTag.class);
		_jspx_th_c_005fset_005f0.setPageContext(_jspx_page_context);
		_jspx_th_c_005fset_005f0.setParent(new TagAdapter(this));
		_jspx_th_c_005fset_005f0.setVar("ctx");

		_jspx_th_c_005fset_005f0.setValue(PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}${fns:getAdminPath()}", Object.class, (PageContext) getJspContext(), _jspx_fnmap_0, false));
		_jspx_th_c_005fset_005f0.doStartTag();
		if (_jspx_th_c_005fset_005f0.doEndTag() == 5) {
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

	private boolean _jspx_meth_c_005fif_005f0(PageContext _jspx_page_context) throws Throwable {
		JspWriter out = _jspx_page_context.getOut();

		IfTag _jspx_th_c_005fif_005f0 = (IfTag) this._005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(IfTag.class);
		_jspx_th_c_005fif_005f0.setPageContext(_jspx_page_context);
		_jspx_th_c_005fif_005f0.setParent(new TagAdapter(this));
		_jspx_th_c_005fif_005f0.setTest(((Boolean) PageContextImpl.proprietaryEvaluate("${fn:contains(cssClass, 'input-sm')}", Boolean.TYPE, (PageContext) getJspContext(), _jspx_fnmap_1, false)).booleanValue());
		int _jspx_eval_c_005fif_005f0 = _jspx_th_c_005fif_005f0.doStartTag();
		if (_jspx_eval_c_005fif_005f0 != 0) {
			int evalDoAfterBody;
			do {
				out.write(" btn-sm ");
				evalDoAfterBody = _jspx_th_c_005fif_005f0.doAfterBody();
			} while (evalDoAfterBody == 2);
		}

		if (_jspx_th_c_005fif_005f0.doEndTag() == 5) {
			this._005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
			throw new SkipPageException();
		} else {
			this._005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
			return false;
		}
	}

	private boolean _jspx_meth_c_005fif_005f1(PageContext _jspx_page_context) throws Throwable {
		JspWriter out = _jspx_page_context.getOut();

		IfTag _jspx_th_c_005fif_005f1 = (IfTag) this._005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(IfTag.class);
		_jspx_th_c_005fif_005f1.setPageContext(_jspx_page_context);
		_jspx_th_c_005fif_005f1.setParent(new TagAdapter(this));
		_jspx_th_c_005fif_005f1.setTest(((Boolean) PageContextImpl.proprietaryEvaluate("${fn:contains(cssClass, 'input-lg')}", Boolean.TYPE, (PageContext) getJspContext(), _jspx_fnmap_1, false)).booleanValue());
		int _jspx_eval_c_005fif_005f1 = _jspx_th_c_005fif_005f1.doStartTag();
		if (_jspx_eval_c_005fif_005f1 != 0) {
			int evalDoAfterBody;
			do {
				out.write(" btn-lg ");
				evalDoAfterBody = _jspx_th_c_005fif_005f1.doAfterBody();
			} while (evalDoAfterBody == 2);
		}

		if (_jspx_th_c_005fif_005f1.doEndTag() == 5) {
			this._005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f1);
			throw new SkipPageException();
		} else {
			this._005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f1);
			return false;
		}
	}

	private boolean _jspx_meth_c_005fif_005f2(PageContext _jspx_page_context) throws Throwable {
		JspWriter out = _jspx_page_context.getOut();

		IfTag _jspx_th_c_005fif_005f2 = (IfTag) this._005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(IfTag.class);
		_jspx_th_c_005fif_005f2.setPageContext(_jspx_page_context);
		_jspx_th_c_005fif_005f2.setParent(new TagAdapter(this));
		_jspx_th_c_005fif_005f2.setTest(((Boolean) PageContextImpl.proprietaryEvaluate("${checked && notAllowSelectParent}", Boolean.TYPE, (PageContext) getJspContext(), null, false)).booleanValue());
		int _jspx_eval_c_005fif_005f2 = _jspx_th_c_005fif_005f2.doStartTag();
		if (_jspx_eval_c_005fif_005f2 != 0) {
			int evalDoAfterBody;
			do {
				out.write("\n");
				out.write("\t\t\t\t\t\t\tif (nodes[i].isParent){\n");
				out.write("\t\t\t\t\t\t\t\tcontinue; // 如果为复选框选择，则过滤掉父节点\n");
				out.write("\t\t\t\t\t\t\t}//");
				evalDoAfterBody = _jspx_th_c_005fif_005f2.doAfterBody();
			} while (evalDoAfterBody == 2);
		}

		if (_jspx_th_c_005fif_005f2.doEndTag() == 5) {
			this._005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f2);
			throw new SkipPageException();
		} else {
			this._005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f2);
			return false;
		}
	}

	private boolean _jspx_meth_c_005fif_005f3(PageContext _jspx_page_context) throws Throwable {
		JspWriter out = _jspx_page_context.getOut();

		IfTag _jspx_th_c_005fif_005f3 = (IfTag) this._005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(IfTag.class);
		_jspx_th_c_005fif_005f3.setPageContext(_jspx_page_context);
		_jspx_th_c_005fif_005f3.setParent(new TagAdapter(this));
		_jspx_th_c_005fif_005f3.setTest(((Boolean) PageContextImpl.proprietaryEvaluate("${notAllowSelectRoot}", Boolean.TYPE, (PageContext) getJspContext(), null, false)).booleanValue());
		int _jspx_eval_c_005fif_005f3 = _jspx_th_c_005fif_005f3.doStartTag();
		if (_jspx_eval_c_005fif_005f3 != 0) {
			int evalDoAfterBody;
			do {
				out.write("\n");
				out.write("\t\t\t\t\t\t\tif (nodes[i].level == 0){\n");
				out.write("\t\t\t\t\t\t\t\t//top.$.jBox.tip(\"不能选择根节点（\"+nodes[i].name+\"）请重新选择。\");\n");
				out.write("\t\t\t\t\t\t\t\ttop.layer.msg(\"不能选择根节点（\"+nodes[i].name+\"）请重新选择。\", {icon: 0});\n");
				out.write("\t\t\t\t\t\t\t\treturn false;\n");
				out.write("\t\t\t\t\t\t\t}//");
				evalDoAfterBody = _jspx_th_c_005fif_005f3.doAfterBody();
			} while (evalDoAfterBody == 2);
		}

		if (_jspx_th_c_005fif_005f3.doEndTag() == 5) {
			this._005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f3);
			throw new SkipPageException();
		} else {
			this._005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f3);
			return false;
		}
	}

	private boolean _jspx_meth_c_005fif_005f4(PageContext _jspx_page_context) throws Throwable {
		JspWriter out = _jspx_page_context.getOut();

		IfTag _jspx_th_c_005fif_005f4 = (IfTag) this._005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(IfTag.class);
		_jspx_th_c_005fif_005f4.setPageContext(_jspx_page_context);
		_jspx_th_c_005fif_005f4.setParent(new TagAdapter(this));
		_jspx_th_c_005fif_005f4.setTest(((Boolean) PageContextImpl.proprietaryEvaluate("${notAllowSelectParent}", Boolean.TYPE, (PageContext) getJspContext(), null, false)).booleanValue());
		int _jspx_eval_c_005fif_005f4 = _jspx_th_c_005fif_005f4.doStartTag();
		if (_jspx_eval_c_005fif_005f4 != 0) {
			int evalDoAfterBody;
			do {
				out.write("\n");
				out.write("\t\t\t\t\t\t\tif (nodes[i].isParent){\n");
				out.write("\t\t\t\t\t\t\t\t//top.$.jBox.tip(\"不能选择父节点（\"+nodes[i].name+\"）请重新选择。\");\n");
				out.write("\t\t\t\t\t\t\t\t//layer.msg('有表情地提示');\n");
				out.write("\t\t\t\t\t\t\t\ttop.layer.msg(\"不能选择父节点（\"+nodes[i].name+\"）请重新选择。\", {icon: 0});\n");
				out.write("\t\t\t\t\t\t\t\treturn false;\n");
				out.write("\t\t\t\t\t\t\t}//");
				evalDoAfterBody = _jspx_th_c_005fif_005f4.doAfterBody();
			} while (evalDoAfterBody == 2);
		}

		if (_jspx_th_c_005fif_005f4.doEndTag() == 5) {
			this._005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f4);
			throw new SkipPageException();
		} else {
			this._005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f4);
			return false;
		}
	}

	private boolean _jspx_meth_c_005fif_005f5(PageContext _jspx_page_context) throws Throwable {
		JspWriter out = _jspx_page_context.getOut();

		IfTag _jspx_th_c_005fif_005f5 = (IfTag) this._005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(IfTag.class);
		_jspx_th_c_005fif_005f5.setPageContext(_jspx_page_context);
		_jspx_th_c_005fif_005f5.setParent(new TagAdapter(this));
		_jspx_th_c_005fif_005f5.setTest(((Boolean) PageContextImpl.proprietaryEvaluate("${not empty module && selectScopeModule}", Boolean.TYPE, (PageContext) getJspContext(), null, false)).booleanValue());
		int _jspx_eval_c_005fif_005f5 = _jspx_th_c_005fif_005f5.doStartTag();
		if (_jspx_eval_c_005fif_005f5 != 0) {
			int evalDoAfterBody;
			do {
				out.write("\n");
				out.write("\t\t\t\t\t\t\tif (nodes[i].module == \"\"){\n");
				out.write("\t\t\t\t\t\t\t\t//top.$.jBox.tip(\"不能选择公共模型（\"+nodes[i].name+\"）请重新选择。\");\n");
				out.write("\t\t\t\t\t\t\t\ttop.layer.msg(\"不能选择公共模型（\"+nodes[i].name+\"）请重新选择。\", {icon: 0});\n");
				out.write("\t\t\t\t\t\t\t\treturn false;\n");
				out.write("\t\t\t\t\t\t\t}else if (nodes[i].module != \"");
				out.write((String) PageContextImpl.proprietaryEvaluate("${module}", String.class, (PageContext) getJspContext(), null, false));
				out.write("\"){\n");
				out.write("\t\t\t\t\t\t\t\t//top.$.jBox.tip(\"不能选择当前栏目以外的栏目模型，请重新选择。\");\n");
				out.write("\t\t\t\t\t\t\t\ttop.layer.msg(\"不能选择当前栏目以外的栏目模型，请重新选择。\", {icon: 0});\n");
				out.write("\t\t\t\t\t\t\t\treturn false;\n");
				out.write("\t\t\t\t\t\t\t}//");
				evalDoAfterBody = _jspx_th_c_005fif_005f5.doAfterBody();
			} while (evalDoAfterBody == 2);
		}

		if (_jspx_th_c_005fif_005f5.doEndTag() == 5) {
			this._005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f5);
			throw new SkipPageException();
		} else {
			this._005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f5);
			return false;
		}
	}

	private boolean _jspx_meth_c_005fif_005f6(PageContext _jspx_page_context) throws Throwable {
		JspWriter out = _jspx_page_context.getOut();

		IfTag _jspx_th_c_005fif_005f6 = (IfTag) this._005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(IfTag.class);
		_jspx_th_c_005fif_005f6.setPageContext(_jspx_page_context);
		_jspx_th_c_005fif_005f6.setParent(new TagAdapter(this));
		_jspx_th_c_005fif_005f6.setTest(((Boolean) PageContextImpl.proprietaryEvaluate("${!checked}", Boolean.TYPE, (PageContext) getJspContext(), null, false)).booleanValue());
		int _jspx_eval_c_005fif_005f6 = _jspx_th_c_005fif_005f6.doStartTag();
		if (_jspx_eval_c_005fif_005f6 != 0) {
			int evalDoAfterBody;
			do {
				out.write("\n");
				out.write("\t\t\t\t\t\t\tbreak; // 如果为非复选框选择，则返回第一个选择  ");
				evalDoAfterBody = _jspx_th_c_005fif_005f6.doAfterBody();
			} while (evalDoAfterBody == 2);
		}

		if (_jspx_th_c_005fif_005f6.doEndTag() == 5) {
			this._005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f6);
			throw new SkipPageException();
		} else {
			this._005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f6);
			return false;
		}
	}

}