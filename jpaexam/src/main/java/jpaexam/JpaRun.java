package jpaexam;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaRun {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaexam");
		EntityManager em = emf.createEntityManager(); // 엔티티 매니저가 생성될 때 영속성 컨텍스트가 생성된다.
		EntityTransaction tx = em.getTransaction();

		tx.begin();

		try {
			
//등록
//
//			Product product = new Product();
////			product.setId(3L);
//			product.setName("car");
//			product.setPrice(3000); // 여기까지는 비영속 상태!!
//			
//			System.out.println("비영속상태... persist() 실행전!! ");
//			em.persist(product); // 영속 상태 -- DB에 바로 적용되는 것은 아님!!
//			System.out.println("비영속상태... persist() 실행 후!!!! ");
			
			
//수정 
			Product findProduct = em.find(Product.class, 34L);
			findProduct.setName("testtest");
			findProduct.setPrice(30000);
			
			
			System.out.println("kdjfkdjf");
			
			Product findProduct2 = em.find(Product.class, 34L);
			
			findProduct2.setName("notebook22");
			findProduct2.setPrice(3000000);
			
			if(findProduct == findProduct2) {
				System.out.println("같다");
			}else {
				System.out.println("달라요");
			}
			
			//삭제
			
//			Product delProduct = em.find(Product.class, 33L);
//			em.remove(delProduct);
			
			
					
			System.out.println("commit() 전!!");
			tx.commit();
			System.out.println("commit() 후!!");
			
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}finally {
			em.close();
			emf.close();
		}
	}

}
