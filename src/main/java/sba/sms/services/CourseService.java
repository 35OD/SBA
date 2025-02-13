package sba.sms.services;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import sba.sms.dao.CourseI;
import sba.sms.models.Course;
import sba.sms.utils.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * CourseService is a concrete class. This class implements the
 * CourseI interface, overrides all abstract service methods and
 * provides implementation for each method.
 */
public class CourseService implements CourseI{

   @Override
   public void createCourse(Course course){
      Transaction tx = null;
      try(Session session = HibernateUtil.getSessionFactory().openSession()){
         tx = session.beginTransaction();
         session.persist(course);
         tx.commit();
      }catch (HibernateException e){
         if(tx != null){
            tx.rollback();
         }
         e.printStackTrace();
      }
   }

   @Override
   public List<Course> getAllCourses(){
      try(Session session = HibernateUtil.getSessionFactory().openSession()){
         return session.createQuery("FROM Course", Course.class).getResultList();
      }catch(HibernateException e ){
         e.printStackTrace();
         return new ArrayList<>();
      }
   }

   @Override
   public Course getCourseById(int courseId){
      try(Session session = HibernateUtil.getSessionFactory().openSession()){
         return session.get(Course.class, courseId);
      }catch(HibernateException e){
         e.printStackTrace();
         return null;
      }
   }



}
