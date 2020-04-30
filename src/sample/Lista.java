package sample;

import java.util.*;

public class Lista<T> {
    private List<T> array1;
    private Set<T> array2;
    private Map<Integer, T> array3;
    private int i;

    public Lista(int i){
        this.i = i;
        if(this.i == 1){this.array1 = new ArrayList<T>();}
        else if(this.i == 2){this.array2 = new HashSet<T>();}
        else{this.array3 = new HashMap<Integer, T>();}
    }

    public List<T> getArray() {
        return this.array1;
    }

    public Set<T> getHashSet(){
        return this.array2;
    }

    public Map<Integer,T> getHashMap(){
        return this.array3;
    }

    public void añadir(T nuevo) {
        if(this.i == 1){
            this.array1.add(nuevo);
        }else if(this.i == 2){
            this.array2.add(nuevo);
        }else {
            this.array3.put(i-2, nuevo);
            this.i++;
        }
    }

    public void eliminar(int i){
        if(this.i == 1){
            this.array1.remove(i);
        }else if(this.i == 2){
            this.array2.remove(i);
        }else{
            this.array3.remove(i);
        }
    }

    public T get(int j){
        if(this.i == 1){
            return this.array1.get(j);
        }else if(this.i == 2){
            int x = 0;
            T w = null;
            for(T t : this.array2){
                if(j == x){
                    w = t;
                }
                x++;
            }
            return w;
        }else{
            return this.array3.get(j);
        }
    }

    @Override
    public String toString() {
        if(this.i == 1){
            return "Lista{" + this.array1.toString() + '}';
        }else if(this.i == 2){
            return "Lista{" + this.array2.toString() + '}';
        }else{
            return "Lista{" + this.array3.toString() + '}';
        }
    }

}
