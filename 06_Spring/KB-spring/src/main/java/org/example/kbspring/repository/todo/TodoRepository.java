package org.example.kbspring.repository.todo;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.kbspring.domain.todo.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
@Slf4j
@RequiredArgsConstructor
public class TodoRepository {
    private final EntityManager em;

    public List<Todo> findAll(){
        String jpql="SELECT t FROM Todo t";
        return em.createQuery(jpql, Todo.class).getResultList();
    }

    public void save(Todo todo){
        em.persist(todo);
    }

    public void delete(Integer id){
        Todo todo=em.find(Todo.class,id);
        if(todo!=null) em.remove(todo);
    }

    public Todo findById(Integer id){
        return em.find(Todo.class,id);
    }

    public void updateDone(Todo todo){
        todo.setDone(!todo.getDone());

//        em.merge(todo);
    }

    // Todo일수도 null일수도 있따
    public Optional<Todo> findById2(Integer id){
        return Optional.ofNullable(em.find(Todo.class,id));
    }



}
