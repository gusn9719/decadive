package kr.ac.kopo.mybatis;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyConfig {

	private SqlSession session;

	public MyConfig() {

		String resource = "mybatis/config/mybatis-config.xml";
		try (InputStream inputStream = Resources.getResourceAsStream(resource)) {
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

			session = sqlSessionFactory.openSession();
		} catch (Exception e) {
			// 에러 어디서 나는지 확인용...
			throw new RuntimeException("MyBatis 초기화 실패", e);
		}
	}

	public SqlSession getSession() {
		return session;
	}
}
