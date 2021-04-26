package control;

import model.BinarySearchTree;
import model.Worker;

public class WorkerHandler {

    private BinarySearchTree<Worker> allWorker;

    public WorkerHandler(){
        allWorker = new BinarySearchTree<>();
    }

    /**
     * Diese Methode fügt einen Auftrag mit entsprechender id zum entsprechenden Arbeiter in die Warteschlange hinzu.
     * Falls der Arbeiter nicht existiert, so wird er zunächst erstellt und dem Baum hinzugefügt.
     * @param name
     * @param id
     */
    public void addTaskAndWorker(String name, int id){
        //TODO 03: Setzen Sie die Methode gemäß obiger Beschreibung um.
        Worker tmp = allWorker.search(new Worker(name));
        if(tmp == null){
            tmp = new Worker(name);
            allWorker.insert(tmp);
        }
        tmp.addTask(id);
    }

    /**
     * Diese Methode entfernt alle Arbeitsaufträge aus dem Baum.
     * Dabei werden alle Arbeitsaufträge sortiert nach ihrem Arbeiter als großer, vollständiger String in der Systemkonsole ausgegeben.
     * Nach Aufruf dieser Methode befinden sich alle Arbeiter immernoch im Baum, jedoch hat keiner mehr einen Arbeitsauftrag.
     */
    public void releaseAllTasksAndShowWorker(){
        System.out.println(releaseAllTasksAndShowWorker(allWorker));
    }

    /**
     * Rekursive Methode, die am Ende einen String liefert. Dieser hat folgenden Aufbau: 1.Name:1.id-2.id-3.id#2.Name:1.id-2.id#3.Name:1.id etc.
     * Die Namen sind alphabetisch sortiert.
     * Nach Aufruf dieser Methode befindet sich kein Auftrag mehr im Baum. Die Arbeiter werden nicht gelöscht.
     * @param tree
     * @return String bestehend aus Arbeiternamen und deren IDs.
     */
    private String releaseAllTasksAndShowWorker(BinarySearchTree<Worker> tree){
        String output = "";
        //TODO 04a: Stellen Sie handschriftlich die gewünschte Ausgabe gemäß des vorhanden Baums dar (siehe MainController ab Zeile 13). Hierbei genügen die ersten drei Arbeiter und ihre IDs, die von dieser Methode ausgegeben werden.
        //TODO 04b: Setzen Sie anschließend diese Methode gemäß obiger Beschreibung um.
        return output;
    }
    public void showTree(){
        showTree(allWorker, 0);
    }
    private void showTree(BinarySearchTree<Worker> yeetTree, int depth){
        if(!yeetTree.isEmpty()){
            showTree(yeetTree.getRightTree(), depth + 1);
            System.out.printf("%" + (depth * 10 + 1)+"s %n", yeetTree.getContent().getName());      //+1 ist wichtig, da sonst null Pointer
            System.out.printf("%" + (depth * 10 + 6)+ "s %n", "--Task: " + yeetTree.getContent().getTaskName());
            showTree(yeetTree.getLeftTree(), depth + 1);
        }
    }
}