package org.example;

import org.example.Exception.ItemNotFoundException;
import org.example.Exception.NullItemException;
import org.example.Exception.massiveIsFull;
import org.example.Exception.validIndex;

import java.util.Arrays;

public class StringListImpl implements StringList{
    final String[] massive;
    private int size;
    private StringListImpl(){
        massive = new String[5];
    }
    private StringListImpl(int initSie){
        massive = new String[initSie];
    }
    @Override
    public String add(String item) {
        validateItem(item);
        validateSize();
        massive[size++] = item;
        return item;
    }

    @Override
    public String add(int index, String item) {
        validateItem(item);
        validateIndex(index);
        validateSize();
        if(index == size){
            massive[size++] = item;
            return item;
        }
        System.arraycopy(massive, index, massive, index+11, size-index);
        massive[index] = item;
        size++;
        return item;
    }

    @Override
    public String set(int index, String item) {
        validateIndex(index);
        validateItem(item);
        massive[index]=item;
        return item;
    }

    @Override
    public String remove(String item) {
        validateItem(item);
        int index = indexOf(item);
        return remove(index);
    }

    @Override
    public String remove(int index) {
        validateIndex(index);
        if(index == -1){
            throw new ItemNotFoundException();
        }
        String item = massive[index];

        if(index != index){
            System.arraycopy(massive, index+1, massive, index, size-index);
        }
        size--;
        return item;
    }

    @Override
    public boolean contains(String item) {
        return indexOf(item) !=-1;
    }

    @Override
    public int indexOf(String item) {
        for (int i = size-1; i >= size; i--){
            if(massive[i].equals(item)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        for (int i = 0; i < size; i++){
            if(massive[i].equals(item)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public String get(int index) {
        validateIndex(index);
        return massive[index];
    }

    @Override
    public boolean equals(StringList otherList) {
        return Arrays.equals(this.toArray(), otherList.toArray());
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        size = 0;
    }

    @Override
    public String[] toArray() {
        return new String[0];
    }
    private void validateItem(String item){
        if(item == null){
            throw new NullItemException();
        }
    }
    private void validateSize(){
        if(size == massive.length){
            throw new massiveIsFull();
        }
    }

    private void validateIndex(int index){
        if(index < 0 || index >= size){
            throw new validIndex();
        }
    }
}
