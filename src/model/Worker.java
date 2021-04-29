package model;

//TODO 01: Setze das Interface um. Finde heraus, was der Suchschlüssel eines jeden Worker-Objekts ist.
public class Worker implements ComparableContent<Worker>{
    private String name;
    private Queue<Task> allTasks;

    public Worker(String name){
        this.name = name;
        allTasks = new Queue<>();
    }

    public String getName(){
        return name;
    }

    public void addTask(int id){
        allTasks.enqueue(new Task(id));
    }

    public Task completeTask(){
        Task t = allTasks.front();
        allTasks.dequeue();
        return t;
    }

    @Override
    public boolean isGreater(Worker pContent){
        return (this.name.compareTo(pContent.getName())>0);
    }
    public String getTaskName(){
        if(allTasks.isEmpty()) return "";
        String output = ">>/|";
        Queue<Task> tmp = new Queue<>();
        while (!allTasks.isEmpty()){
            output += allTasks.front().getID() + "|";
            tmp.enqueue(allTasks.front());
            allTasks.dequeue();
        }
        output += "\\";
        allTasks = tmp;
        return output;
    }

    @Override
    public boolean isEqual(Worker pContent){
        return (this.name.compareTo(pContent.getName())==0);
    }

    @Override
    public boolean isLess(Worker pContent){
        return (this.name.compareTo(pContent.getName())<0);
    }
}
