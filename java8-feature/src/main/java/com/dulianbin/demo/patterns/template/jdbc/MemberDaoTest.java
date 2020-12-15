package com.dulianbin.demo.patterns.template.jdbc;

import com.dulianbin.demo.patterns.template.jdbc.dao.MemberDao;

import java.util.List;

/**
 * Created by Tom.
 */
public class MemberDaoTest {

    public static void main(String[] args) {

        MemberDao memberDao = new MemberDao(null);
        List<?> result = memberDao.selectAll();
        System.out.println(result);
    }
}
