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

import com.zuoxiaolong.dao.QuestionDao;
import com.zuoxiaolong.orm.DaoFactory;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * @author 3wwang
 * @since 15/7/1 21:40
 */
public class Solution extends AbstractServlet {

    @Override
    protected void service() throws ServletException, IOException {
        Integer questionId = Integer.valueOf(getRequest().getParameter("questionId"));
        Integer answerId = Integer.valueOf(getRequest().getParameter("answerId"));
        if (DaoFactory.getDao(QuestionDao.class).updateIsResolved(questionId, answerId)) {
            writeText("success");
        }
    }

}
