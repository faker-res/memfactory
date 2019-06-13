/**
 * 
 */
package com.memfactory.article.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author zhairp createDate: 2018-11-20
 */
@Component
public class ArticleJob {
	private Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Scheduled(fixedDelay = 1000 * 60 * 60 * 24)
	public void updateArticles() {
		log.info("执行更新任务开始");
		long startTime = System.currentTimeMillis();
		/*
		 * StringBuffer taskSQL = new StringBuffer(" merge into mf_article_essay a ");
		 * taskSQL.
		 * append(" using (select essay_id,count(*) as cnt from mf_article_comment group by essay_id)  b on a.id=b.essay_id "
		 * ); taskSQL.append(" when matched then update set a.comment_cnt=b.cnt; ");
		 * log.info("SQL:{}", taskSQL.toString());
		 * jdbcTemplate.execute(taskSQL.toString());
		 */
		log.info("执行更新任务耗时:{} 毫秒", (System.currentTimeMillis() - startTime));
	}

}
