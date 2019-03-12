package com.zuoxiaolong.thread;

import org.apache.log4j.Logger;

import com.zuoxiaolong.dao.ArticleDao;
import com.zuoxiaolong.dao.ArticleIdVisitorIpDao;
import com.zuoxiaolong.dao.QuestionDao;
import com.zuoxiaolong.dao.RecordDao;
import com.zuoxiaolong.generator.Generators;
import com.zuoxiaolong.orm.DaoFactory;

public class DoCounter implements Runnable {

	private static final Logger logger = Logger.getLogger(BaiduPushTask.class);
	private String musername;
	private Integer mtype;
	private Integer mrecordId ;
	private Integer mquestionId ;
	private Integer marticleId ;
	private String mcolumn ;
	private String mip ;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		//Integer type = Integer.valueOf(mrequest.getParameter("type"));
		if (mtype == 1) {
			updateArticle(marticleId,mcolumn,mip);
		} else if (mtype == 2) {
			updateQuestion(mquestionId);
		}  else if (mtype == 3) {
            updateRecord(mrecordId);
        } 
	}
	
	public void setMusername(String musername) {
		this.musername = musername;
	}
	
	public void setMtype(Integer mtype) {
		this.mtype = mtype;
	}

	public void setMrecordId(Integer mrecordId) {
		this.mrecordId = mrecordId;
	}

	public void setMquestionId(Integer mquestionId) {
		this.mquestionId = mquestionId;
	}

	public void setMarticleId(Integer marticleId) {
		this.marticleId = marticleId;
	}

	public void setMcolumn(String mcolumn) {
		this.mcolumn = mcolumn;
	}

	public void setMip(String mip) {
		this.mip = mip;
	}

	
	
	private void updateRecord(Integer recordId) {
        DaoFactory.getDao(RecordDao.class).updateCount(recordId);
        //writeText("success");
    }

	private void updateQuestion(Integer questionId) {
		DaoFactory.getDao(QuestionDao.class).updateCount(questionId);
		//writeText("success");
	}

	private void updateArticle(Integer articleId, String column ,String ip) {
		if (logger.isInfoEnabled()) {
			logger.info("counter param : articleId = " + articleId + "   , column = " + column);
		}
		if (!column.equals("access_times")) {
			if (logger.isInfoEnabled()) {
				logger.info("there is someone remarking...");
			}
			
			if (DaoFactory.getDao(ArticleIdVisitorIpDao.class).exists(articleId, ip, musername)) {
				//writeText("exists");
				if (logger.isInfoEnabled()) {
					logger.info(ip + " has remarked...");
				}
				return ;
			} else {
				DaoFactory.getDao(ArticleIdVisitorIpDao.class).save(articleId, ip, musername);
			}
		}
		boolean result = DaoFactory.getDao(ArticleDao.class).updateCount(articleId, column);
		if (!result) {
			logger.error("updateCount error!");
			return;
		}
		if (result && logger.isInfoEnabled()) {
			logger.info("updateCount success!");
		}
		//writeText("success");
		Generators.generateArticle(articleId);
	}
}
