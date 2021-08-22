package Repository;

import Model.Customer;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;
@Transactional
public class CustomerRepository implements ICustomerRepository{
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<Customer> findAll() {
        String hql="select c from Customer c";
        TypedQuery<Customer> query=entityManager.createQuery(hql,Customer.class);
        return query.getResultList();
    }

    @Override
    public Customer findById(Long id) {
        String hql="select c from Customer c where c.id=:id";
        TypedQuery<Customer> query=entityManager.createQuery(hql,Customer.class);
        query.setParameter("id",id);
        return query.getSingleResult();
    }

    @Override
    public void save(Customer customer) {
        if(customer.getId().equals(findById(customer.getId()))){
            entityManager.persist(customer);
        }else entityManager.merge(customer);
    }

    @Override
    public void remove(Long id) {
        entityManager.remove(findById(id));
    }
}
