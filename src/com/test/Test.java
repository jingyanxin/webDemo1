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
	
	//����
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
				System.out.println("��ӳɹ�");
			}else{
				System.out.println("���ʧ��");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(session!=null)session.close();
		}
	}
	
	//��ѯ����
		public static void findById(){
			try {
				
				Reader reader =Resources.getResourceAsReader("config.xml");
				
				SqlSessionFactory sessionFacotry = new SqlSessionFactoryBuilder().build(reader) ;
				SqlSession session = sessionFacotry.openSession() ;
				
				IBooksMapper bookmapper= session.getMapper(IBooksMapper.class);
				Books book=bookmapper.findById(9);
				System.out.println("��ѯ���:"+book.toString());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//ɾ��
		public static void delById(){
			try {
				
				Reader reader =Resources.getResourceAsReader("config.xml");
				
				SqlSessionFactory sessionFacotry = new SqlSessionFactoryBuilder().build(reader) ;
				SqlSession session = sessionFacotry.openSession() ;
				
				IBooksMapper bookmapper= session.getMapper(IBooksMapper.class);
				int rows=bookmapper.delById(10);
				if(rows>0){
					session.commit();
					System.out.println("ɾ���ɹ�");
				}else{
					System.out.println("ɾ��ʧ��");
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//�޸�
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
					System.out.println("�޸ĳɹ�");
				}else{
					System.out.println("�޸�ʧ��");
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				if(session!=null)session.close();
			}
		}
		
		//��ѯȫ��
		public static void findAll(){
			try {
				
				Reader reader =Resources.getResourceAsReader("config.xml");
				
				SqlSessionFactory sessionFacotry = new SqlSessionFactoryBuilder().build(reader) ;
				SqlSession session = sessionFacotry.openSession() ;
				
				IBooksMapper bookmapper= session.getMapper(IBooksMapper.class);
				List<Books> bklist=bookmapper.findAll();
				//System.out.println("bklist:"+bklist.size());
				for(Books book : bklist)
				System.out.println("��ѯ���:"+book.toString());
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
