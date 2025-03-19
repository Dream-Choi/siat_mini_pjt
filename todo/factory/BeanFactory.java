package todo.factory;

import java.util.HashMap;
import java.util.Map;

import todo.ctrl.TodoDeleteController;
import todo.ctrl.TodoInsertController;
import todo.ctrl.TodoListController;
import todo.ctrl.TodoReadController;
import todo.ctrl.TodoUpdateController;
import todo.service.TodoService;

public class BeanFactory {
    private static BeanFactory instance;
    public Map<String, Object> map;
    private BeanFactory(){
        map=new HashMap<>();
        TodoService service=new TodoService();
        map.put("list", new TodoListController(service));
        map.put("register", new TodoInsertController(service));
        map.put("update", new TodoUpdateController(service));
        map.put("delete", new TodoDeleteController(service));
        map.put("read",new TodoReadController(service));
    }
    public static BeanFactory getInstance(){
        if(instance==null){
            instance= new BeanFactory();
        }
        return instance;
    }
    public Object getCtrl(String key){
        return map.get(key);
    }
}
