package dmit.repository;

import common.jpa.AbstractJpaRepository;
import dmit.entity.TodoItem;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class TodoItemRepository extends AbstractJpaRepository<TodoItem, Long> {

    public TodoItemRepository() {
        super(TodoItem.class);
    }

}

