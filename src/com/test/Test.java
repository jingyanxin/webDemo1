package com.test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.mapper.IBooksMapper;
import com.pojo.Books;

public class Test {
	
	//增加
	public static void save(){
		 SqlSessionFactory sessionFactory=null;
		  SqlSession session=null;
		 try {
			Reader reader = Resources.getResourceAsReader("config.xml") ;
			sessionFactory=new SqlSessionFactoryBuilder().build(reader);
			
			session=sessionFactory.openSession();
			IBooksMapper bookmapper=session.getMapper(IBooksMapper.class);
			Books book =new Books("55","55","55",44.4f,5,55,"555");
			int rows=bookmapper.save(book);
			if(rows>0){
				session.commit();
				System.out.println("添加成功");
			}else{
				System.out.println("添加失败");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(session!=null)session.close();
		}
	}
	
	//查询单个
		public static void findById(){
			try {
				
				Reader reader =Resources.getResourceAsReader("config.xml");
				
				SqlSessionFactory sessionFacotry = new SqlSessionFactoryBuilder().build(reader) ;
				SqlSession session = sessionFacotry.openSession() ;
				
				IBooksMapper bookmapper= session.getMapper(IBooksMapper.class);
				Books book=bookmapper.findById(9);
				System.out.println("查询结果:"+book.toString());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//删除
		public static void delById(){
			try {
				
				Reader reader =Resources.getResourceAsReader("config.xml");
				
				SqlSessionFactory sessionFacotry = new SqlSessionFactoryBuilder().build(reader) ;
				SqlSession session = sessionFacotry.openSession() ;
				
				IBooksMapper bookmapper= session.getMapper(IBooksMapper.class);
				int rows=bookmapper.delById(10);
				if(rows>0){
					session.commit();
					System.out.println("删除成功");
				}else{
					System.out.println("删除失败");
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//修改
		public static void update(){
			 SqlSessionFactory sessionFactory=null;
			  SqlSession session=null;
			 try {
				Reader reader = Resources.getResourceAsReader("config.xml") ;
				sessionFactory=new SqlSessionFactoryBuilder().build(reader);
				
				session=sessionFactory.openSession();
				IBooksMapper bookmapper=session.getMapper(IBooksMapper.class);
				Books book =new Books(11, "55","55","55",44.4f,5,55,"555");
				int rows=bookmapper.update(book);
				if(rows>0){
					session.commit();
					System.out.println("修改成功");
				}else{
					System.out.println("修改失败");
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				if(session!=null)session.close();
			}
		}
		
		//查询全部
		public static void findAll(){
			try {
				
				Reader reader =Resources.getResourceAsReader("config.xml");
				
				SqlSessionFactory sessionFacotry = new SqlSessionFactoryBuilder().build(reader) ;
				SqlSession session = sessionFacotry.openSession() ;
				
				IBooksMapper bookmapper= session.getMapper(IBooksMapper.class);
				List<Books> bklist=bookmapper.findAll();
				//System.out.println("bklist:"+bklist.size());
				for(Books book : bklist)
				System.out.println("查询结果:"+book.toString());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
	public static void main(String[] args) {
		//save();
		findById();
		//delById();
		//update();
		//findAll();	
	}
}
