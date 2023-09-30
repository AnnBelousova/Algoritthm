package org.example;

import org.example.Exception.ItemNotFoundException;
import org.example.Exception.NullItemException;
import org.example.Exception.massiveIsFull;
import org.example.Exception.validIndex;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class IntegerListImpl implements IntegerList{


    private Integer[] returnArray(){
        int size = 100_000;
        int upperBound = 100_000_000;
        Integer[] array = new Integer[size];
        Random random = new Random();

        IntStream.range(0, size)
                .forEach(index -> array[index] = random.nextInt(upperBound));
        return array;
    }

    final Integer[] massive;
    private int size;
    public IntegerListImpl(){
        massive = new Integer[5];
    }
    private IntegerListImpl(int initSie){
        massive = new Integer[initSie];
    }
    @Override
    public Integer add(Integer item) {
        validateItem(item);
        validateSize();
        massive[size++] = item;
        return item;
    }

    @Override
    public Integer add(int index, Integer item) {
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
    public Integer set(int index, Integer item) {
        validateIndex(index);
        validateItem(item);
        massive[index]=item;
        return item;
    }

    @Override
    public Integer remove(Integer item) {
        validateItem(item);
        int index = indexOf(item);
        return item;
    }

    @Override
    public Integer remove(int index) {
        validateIndex(index);
        if(index == -1){
            throw new ItemNotFoundException();
        }
        Integer item = massive[index];

        if(index != index){
            System.arraycopy(massive, index+1, massive, index, size-index);
        }
        size--;
        return item;
    }

    @Override
    public boolean contains(Integer item) {
        Integer[] copyArray = toArray();
        sort(copyArray);
        return binarySearch(copyArray, item);
    }

    @Override
    public int indexOf(Integer item) {
        for (int i = size-1; i >= size; i--){
            if(massive[i].equals(item)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Integer item) {
        for (int i = 0; i < size; i++){
            if(massive[i].equals(item)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public Integer get(int index) {
        validateIndex(index);
        return massive[index];
    }

    @Override
    public boolean equals(IntegerList otherList) {
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
    public Integer[] toArray() {
        return new Integer[0];
    }
    private void validateItem(Integer item){
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
    private void sort(Integer[] arr){
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] >= temp) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
        }
    }
    private boolean binarySearch(Integer[] arr, Integer item){
        int min = 0;
        int max = arr.length - 1;

        while (min <= max) {
            int mid = (min + max) / 2;

            if (item == arr[mid]) {
                return true;
            }

            if (item < arr[mid]) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return false;
    }
    public void sortBubble() {
        Integer[] arrRandom = returnArray();
        for (int i = 0; i < arrRandom.length - 1; i++) {
            for (int j = 0; j < arrRandom.length - 1 - i; j++) {
                if (arrRandom[j] > arrRandom[j + 1]) {
                    swapElements(arrRandom, j, j + 1);
                }
            }
        }
    }

    public void sortSelection() {
        Integer[] arrRandom = returnArray();
        for (int i = 0; i < arrRandom.length - 1; i++) {
            int minElementIndex = i;
            for (int j = i + 1; j < arrRandom.length; j++) {
                if (arrRandom[j] < arrRandom[minElementIndex]) {
                    minElementIndex = j;
                }
            }
            swapElements(arrRandom, i, minElementIndex);
        }
    }

    public void sortInsertion() {
        Integer[] arrRandom = returnArray();
        for (int i = 1; i < arrRandom.length; i++) {
            int temp = arrRandom[i];
            int j = i;
            while (j > 0 && arrRandom[j - 1] >= temp) {
                arrRandom[j] = arrRandom[j - 1];
                j--;
            }
            arrRandom[j] = temp;
        }
    }

    private static void swapElements(Integer[] arr, int indexA, int indexB) {
        int tmp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = tmp;
    }


}
