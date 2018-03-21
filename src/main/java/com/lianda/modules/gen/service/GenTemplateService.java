package com.lianda.modules.gen.service;

import org.apache.commons.lang3.StringEscapeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lianda.common.persistence.Page;
import com.lianda.common.service.BaseService;
import com.lianda.common.utils.StringUtils;
import com.lianda.modules.gen.dao.GenTemplateDao;
import com.lianda.modules.gen.entity.GenTemplate;

@Service
@Transactional(readOnly=true)
public class GenTemplateService extends BaseService
{

  @Autowired
  private GenTemplateDao genTemplateDao;

  public GenTemplate get(String id)
  {
    return (GenTemplate)this.genTemplateDao.get(id);
  }

  public Page<GenTemplate> find(Page<GenTemplate> page, GenTemplate genTemplate) {
    genTemplate.setPage(page);
    page.setList(this.genTemplateDao.findList(genTemplate));
    return page;
  }

  @Transactional(readOnly=false)
  public void save(GenTemplate genTemplate) {
    if (genTemplate.getContent() != null) {
      genTemplate.setContent(StringEscapeUtils.unescapeHtml4(genTemplate.getContent()));
    }
    if (StringUtils.isBlank(genTemplate.getId())) {
      genTemplate.preInsert();
      this.genTemplateDao.insert(genTemplate); return;
    }
    genTemplate.preUpdate();
    this.genTemplateDao.update(genTemplate);
  }

  @Transactional(readOnly=false)
  public void delete(GenTemplate genTemplate)
  {
    this.genTemplateDao.delete(genTemplate);
  }
}