package br.com.rodrigofeitosa.dao;

import br.com.rodrigofeitosa.conexoes.HibernateUtil;
import br.com.rodrigofeitosa.entity.Pessoa;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class PessoaDAO {
    public int salvarPessoaDAO(Pessoa pessoa) {
        Session session = null;
        var idPessoaInserido = 0;
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        try {
            session = sessionFactory.openSession();

            Transaction transaction = session.beginTransaction();
            session.persist(pessoa);
            transaction.commit();
            idPessoaInserido = pessoa.getId();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return idPessoaInserido;
    }

    public boolean atualizarPessoaDAO(Pessoa pessoa) {
        Session session = null;
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        try {
            session = sessionFactory.openSession();

            Transaction transaction = session.beginTransaction();
            session.merge(pessoa);
            transaction.commit();
            //idPessoaInserido = pessoa.getId();
        } catch (HibernateException e) {
            e.printStackTrace();
            return false;
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return true;
    }

    public List<Pessoa> getTodasPessoas() {
        List<Pessoa> listaPessoas = null;

        Session session = null;
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        try {
            session = sessionFactory.openSession();

            CriteriaBuilder builder = sessionFactory.getCriteriaBuilder();

            CriteriaQuery<Pessoa> criteriaQuery = builder.createQuery(Pessoa.class);

            criteriaQuery.from(Pessoa.class);

            listaPessoas = session.createQuery(criteriaQuery).getResultList();

        } catch (HibernateException e) {
            e.printStackTrace();;
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return listaPessoas;
    }

    public boolean deletarPessoaDao(Pessoa pessoa) {
        Session session = null;
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        try {
            session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            session.remove(pessoa);
            transaction.commit();

        } catch (HibernateException e) {
            e.printStackTrace();
            return false;
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return true;
    }

    public Pessoa getPessoaDao(int idPessoa) {
        Pessoa pessoa = null;
        Session session = null;
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        try {
            session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            pessoa = (Pessoa) session.get(Pessoa.class, idPessoa);
            transaction.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return pessoa;
    }
}
