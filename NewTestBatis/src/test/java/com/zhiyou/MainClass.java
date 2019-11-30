package com.zhiyou;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.zhiyou.mapper.UserMapper;
import com.zhiyou.model.User;

public class MainClass {

	@Test
	public void add() throws Exception {
		Reader reader = Resources.getResourceAsReader("MyBatisConf.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = factory.openSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		mapper.add(new User(666, "yyyyyyy", "mmmmmmm", 4));
		session.commit();
		session.close();
		reader.close();
	}

	@Test
	public void update() throws Exception {
		Reader reader = Resources.getResourceAsReader("MyBatisConf.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = factory.openSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		mapper.update(new User(666, "TTTTTTT", "tttttttt", 4));
		session.commit();
		session.close();
		reader.close();
	}

	@Test
	public void delete() throws Exception {
		Reader reader = Resources.getResourceAsReader("MyBatisConf.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = factory.openSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
//		mapper.add(new User(666, "yyyyyyy", "mmmmmmm", 4));
		mapper.delete(666);
		session.commit();
		session.close();
		reader.close();
	}

	@Test
	public void selectAll() throws Exception {
		Reader reader = Resources.getResourceAsReader("MyBatisConf.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = factory.openSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		List<User> list = mapper.selectAll();
		for (User user : list) {
			System.out.println(user);
		}
		session.commit();
		session.close();
		reader.close();
	}

	@Test
	public void selectByEvery() throws Exception {
		Reader reader = Resources.getResourceAsReader("MyBatisConf.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = factory.openSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		List<User> list = mapper.selectByEvery(new User(0, null, null, 0));
		for (User user : list) {
			System.out.println(user);
		}
		session.commit();
		session.close();
		reader.close();
	}

	@Test
	public void selectLike() throws Exception {

		Reader reader = Resources.getResourceAsReader("MyBatisConf.xml");

		SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(reader);

		SqlSession session = sf.openSession();

		UserMapper mapper = session.getMapper(UserMapper.class);

		List<User> list = mapper.selectLike(new User(0, "3", null, 0));

		for (User user : list) {
			System.out.println(user);
		}
		session.close();
		reader.close();
	}

	@Test
	public void deleteAll() throws Exception {

		Reader reader = Resources.getResourceAsReader("MyBatisConf.xml");

		SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(reader);

		SqlSession session = sf.openSession();

		UserMapper mapper = session.getMapper(UserMapper.class);
		int[] id = new int[] { 99, 110, 969 };

		mapper.deleteAll(id);
		session.commit();
		session.close();
		reader.close();
	}

}
