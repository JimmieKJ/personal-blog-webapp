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

import com.zuoxiaolong.dao.ArticleDao;
import com.zuoxiaolong.dao.RecordDao;
import com.zuoxiaolong.mvc.RequestMapping;
import com.zuoxiaolong.orm.DaoFactory;
import com.zuoxiaolong.util.JsoupUtil;
import org.jsoup.Jsoup;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * @author 3wwang
 * @since 2015年6月18日 上午2:28:03
 */
@RequestMapping("/admin/updateRecord.do")
public class AdminUpdateRecord extends AbstractServlet {

	@Override
	protected void service() throws ServletException, IOException {
		String id = getRequest().getParameter("id");
		String title = getRequest().getParameter("title");
		String html = getRequest().getParameter("content");
		html = handleQuote(html);
		
		StringBuffer stringBuffer = new StringBuffer();
		JsoupUtil.appendText(Jsoup.parse(html), stringBuffer);
		DaoFactory.getDao(RecordDao.class).saveOrUpdate(id, title, "3wwang", html, stringBuffer.toString());
		writeText("success");
	}

}
