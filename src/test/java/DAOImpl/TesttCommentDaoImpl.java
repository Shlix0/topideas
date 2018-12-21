package DAOImpl;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.junit.Before;
import org.junit.Test;

import com.cgi.dao.CommentDaoImpl;
import com.cgi.dao.IdeaDaoImpl;
import com.cgi.model.Category;
import com.cgi.model.Comment;
import com.cgi.model.Idea;
import com.cgi.utils.ContextDB;

public class TesttCommentDaoImpl {

	EntityManagerFactory emf = null;
	CommentDaoImpl cDaoI = new CommentDaoImpl();
	Comment com;
	Comment com1;
	Comment com2;
	Comment com3;

	@Before
	public void init() {
		ContextDB.stop();
		EntityManager em = ContextDB.getInstance().getEmf().createEntityManager();

		com1 = new Comment();
		com2 = new Comment();
		com3 = new Comment();

		em.getTransaction().begin();

		em.persist(com1);
		em.persist(com2);
		em.persist(com3);

		em.getTransaction().commit();
	}

	@Test
	public void testFindAll() {

		List<Comment> comments = new ArrayList<Comment>();

		comments = cDaoI.findAll();

		org.junit.Assert.assertTrue("fail to findAll", comments.size() == 3);
	}


	@Test
	public void testFindByKey() {

	}

	@Test
	public void testAdd() {
	}

	@Test
	public void testUpdate() {
	}

	@Test
	public void testDelete() {
	}

	@Test
	public void testDeleteByKey() {
	}

}
