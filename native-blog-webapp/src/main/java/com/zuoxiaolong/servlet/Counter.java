package com.zuoxiaolong.servlet;

/*
 * Copyright 2002-2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.zuoxiaolong.util.HttpUtil;
import com.zuoxiaolong.thread.DoCounter;
/**
 * @author 3wwang
 * @since 5/8/2015 4:12 PM
 */
public class Counter extends AbstractServlet {

	private static final Logger logger = Logger.getLogger(Counter.class);
	
    @Override
    protected void service() throws IOException {
    	HttpServletRequest request = getRequest();
		Integer type = Integer.valueOf(request.getParameter("type"));
		
		
		Integer recordId = 1;
		Integer questionId = 1;
		Integer articleId = 1;
		String column = "";
		String ip = HttpUtil.getVisitorIp(request);
		String username = getUsername();
    	if(request.getParameter("recordId") != null)
    		recordId = Integer.valueOf(request.getParameter("recordId"));
    	if(request.getParameter("questionId") != null)
    		questionId = Integer.valueOf(request.getParameter("questionId"));
    	if(request.getParameter("column") != null)
    		column =  request.getParameter("column");
    	if(request.getParameter("articleId") != null)
    		articleId =  Integer.valueOf(request.getParameter("articleId"));
    	
    	DoCounter counterTask = new DoCounter();
    	counterTask.setMarticleId(articleId);
    	counterTask.setMcolumn(column);
    	counterTask.setMip(ip);
    	counterTask.setMquestionId(questionId);
    	counterTask.setMrecordId(recordId);
    	counterTask.setMtype(type);
    	counterTask.setMusername(username);
    	Thread thread = new Thread(counterTask);
		thread.start();

//		if (type == 1) {
//			updateArticle(request);
//		} else if (type == 2) {
//			updateQuestion(request);
//		}  else if (type == 3) {
//            updateRecord(request);
//        } else {
//			throw new RuntimeException("unknown type.");
//		}
		writeText("success");
    }

//    private void updateRecord(HttpServletRequest request) {
//        Integer recordId = Integer.valueOf(request.getParameter("recordId"));
//        DaoFactory.getDao(RecordDao.class).updateCount(recordId);
//        writeText("success");
//    }
//
//	private void updateQuestion(HttpServletRequest request) {
//		Integer questionId = Integer.valueOf(request.getParameter("questionId"));
//		DaoFactory.getDao(QuestionDao.class).updateCount(questionId);
//		writeText("success");
//	}
//
//	private void updateArticle(HttpServletRequest request) {
//		Integer articleId = Integer.valueOf(request.getParameter("articleId"));
//		String column = request.getParameter("column");
//		if (logger.isInfoEnabled()) {
//			logger.info("counter param : articleId = " + articleId + "   , column = " + column);
//		}
//		if (!column.equals("access_times")) {
//			if (logger.isInfoEnabled()) {
//				logger.info("there is someone remarking...");
//			}
//			String username = getUsername();
//			String ip = HttpUtil.getVisitorIp(request);
//			if (DaoFactory.getDao(ArticleIdVisitorIpDao.class).exists(articleId, ip, username)) {
//				writeText("exists");
//				if (logger.isInfoEnabled()) {
//					logger.info(ip + " has remarked...");
//				}
//				return ;
//			} else {
//				DaoFactory.getDao(ArticleIdVisitorIpDao.class).save(articleId, ip, username);
//			}
//		}
//		boolean result = DaoFactory.getDao(ArticleDao.class).updateCount(articleId, column);
//		if (!result) {
//			logger.error("updateCount error!");
//			return;
//		}
//		if (result && logger.isInfoEnabled()) {
//			logger.info("updateCount success!");
//		}
//		writeText("success");
//		Generators.generateArticle(articleId);
//	}

}
