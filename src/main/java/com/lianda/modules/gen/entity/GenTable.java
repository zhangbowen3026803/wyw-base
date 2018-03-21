package com.lianda.modules.gen.entity;


import java.util.Iterator;
import java.util.List;

import org.hibernate.validator.constraints.Length;

import com.google.common.collect.Lists;
import com.lianda.common.persistence.DataEntity;
import com.lianda.common.utils.StringUtils;

public class GenTable extends DataEntity<GenTable>
{
  private static final long serialVersionUID = 1L;
  private String name;
  private String comments;
  private String tableType;
  private String className;
  private String parentTable;
  private String parentTableFk;
  private String isSync;
  private List<GenTableColumn> columnList = (List)Lists.newArrayList();
  private String nameLike;
  private List<String> pkList;
  private GenTable parent;
  private List<GenTable> childList = (List)Lists.newArrayList();

  public GenTable()
  {
  }

  public GenTable(String id)
  {
    super(id);
  }

  @Length(min=1, max=200)
  public String getName() {
    return StringUtils.lowerCase(this.name);
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getComments() {
    return this.comments;
  }

  public void setComments(String comments) {
    this.comments = comments;
  }

  public String getClassName() {
    return this.className;
  }

  public void setClassName(String className) {
    this.className = className;
  }

  public String getParentTable() {
    return StringUtils.lowerCase(this.parentTable);
  }

  public void setParentTable(String parentTable) {
    this.parentTable = parentTable;
  }

  public String getParentTableFk() {
    return StringUtils.lowerCase(this.parentTableFk);
  }

  public void setParentTableFk(String parentTableFk) {
    this.parentTableFk = parentTableFk;
  }

  public List<String> getPkList() {
    return this.pkList;
  }

  public void setPkList(List<String> pkList) {
    this.pkList = pkList;
  }

  public String getNameLike() {
    return this.nameLike;
  }

  public void setNameLike(String nameLike) {
    this.nameLike = nameLike;
  }

  public GenTable getParent() {
    return this.parent;
  }

  public void setParent(GenTable parent) {
    this.parent = parent;
  }

  public List<GenTableColumn> getColumnList() {
    return this.columnList;
  }

  public void setColumnList(List<GenTableColumn> columnList) {
    this.columnList = columnList;
  }

  public List<GenTable> getChildList() {
    return this.childList;
  }

  public void setChildList(List<GenTable> childList) {
    this.childList = childList;
  }

  public String getNameAndComments()
  {
    return getName() + ((this.comments == null) ? "" : new StringBuilder("  :  ").append(this.comments).toString());
  }

  public List<String> getImportList()
  {
    List importList = (List)Lists.newArrayList();
    for (Iterator localIterator1 = getColumnList().iterator(); localIterator1.hasNext(); )
    {
      GenTableColumn column;
      if (((((
        column = (GenTableColumn)localIterator1.next())
        .getIsNotBaseField().booleanValue()) || (("1".equals(column.getIsQuery())) && ("between".equals(column.getQueryType())) && ((
        ("createDate".equals(column.getSimpleJavaField())) || ("updateDate".equals(column.getSimpleJavaField()))))))) && 
        (StringUtils.indexOf(column.getJavaType(), ".") != -1) && (!importList.contains(column.getJavaType()))) {
        importList.add(column.getJavaType());
      }

      if (!column.getIsNotBaseField().booleanValue())
        continue;
      for (String ann : column.getAnnotationList()) {
        if (!importList.contains(StringUtils.substringBeforeLast(ann, "("))) {
          importList.add(StringUtils.substringBeforeLast(ann, "("));
        }
      }

    }

    if ((getChildList() != null) && (getChildList().size() > 0)) {
      if (!importList.contains("java.util.List")) {
        importList.add("java.util.List");
      }
      if (!importList.contains("com.google.common.collect.Lists")) {
        importList.add("com.google.common.collect.Lists");
      }
    }
    return importList;
  }

  public List<String> getImportGridJavaList()
  {
    List importList = (List)Lists.newArrayList();
    for (Iterator localIterator = getColumnList().iterator(); localIterator.hasNext(); )
    {
      GenTableColumn column;
      if (((
        column = (GenTableColumn)localIterator.next())
        .getTableName() == null) || (column.getTableName().equals("")) || 
        (StringUtils.indexOf(column.getJavaType(), ".") == -1) || (importList.contains(column.getJavaType()))) continue;
      importList.add(column.getJavaType());
    }

    return importList;
  }

  public List<String> getImportGridJavaDaoList() {
    boolean isNeedList = false;
    List importList = (List)Lists.newArrayList();
    for (Iterator localIterator = getColumnList().iterator(); localIterator.hasNext(); )
    {
      GenTableColumn column;
      if (((
        column = (GenTableColumn)localIterator.next())
        .getTableName() == null) || (column.getTableName().equals("")) || 
        (StringUtils.indexOf(column.getJavaType(), ".") == -1) || (importList.contains(column.getJavaType()))) continue;
      importList.add(column.getJavaType());
      isNeedList = true;
    }

    if ((isNeedList) && 
      (!importList.contains("java.util.List"))) {
      importList.add("java.util.List");
    }

    return importList;
  }

  public Boolean getParentExists()
  {
    if ((this.parent != null) && (StringUtils.isNotBlank(this.parentTable)) && (StringUtils.isNotBlank(this.parentTableFk))) return Boolean.valueOf(true); return Boolean.valueOf(false);
  }

  public Boolean getCreateDateExists()
  {
    for (GenTableColumn c : this.columnList) {
      if ("create_date".equals(c.getName())) {
        return Boolean.valueOf(true);
      }
    }
    return Boolean.valueOf(false);
  }

  public Boolean getUpdateDateExists()
  {
    for (GenTableColumn c : this.columnList) {
      if ("update_date".equals(c.getName())) {
        return Boolean.valueOf(true);
      }
    }
    return Boolean.valueOf(false);
  }

  public Boolean getDelFlagExists()
  {
    for (GenTableColumn c : this.columnList) {
      if ("del_flag".equals(c.getName())) {
        return Boolean.valueOf(true);
      }
    }
    return Boolean.valueOf(false);
  }

  public void setIsSync(String isSync) {
    this.isSync = isSync;
  }

  public String getIsSync() {
    return this.isSync;
  }

  public void setTableType(String tableType) {
    this.tableType = tableType;
  }

  public String getTableType() {
    return this.tableType;
  }
}