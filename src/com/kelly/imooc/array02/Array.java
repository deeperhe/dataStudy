package com.kelly.imooc.array02;

/**
 * Created by 贺望香 on 2019/2/14.
 * 增 删 改 查：研究数据结构的脉络
 */
public class Array {
    private int[] data;
    private int size;

    // 传入数组的容量capacity构造Array
    public Array(int capacity) {
        data = new int[capacity];
        size = 0;
    }

    public Array() {
        this(10);
    }

    // 获取数组中的元素个数
    public int getSize() {
        return size;
    }

    // 获取数组的容量
    public int getCapacity() {
        return data.length;
    }

    // 返回数组是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    // 向所有元素后添加一个新元素
    public void addLast(int e) {
//        if (size == data.length){
//            throw new IllegalArgumentException("addLast failed.Array is full");
//        }
//        data[size] = e;
//        size ++;
        add(size, e);
    }

    // 向第一个位置添加元素
    public void addFirst(int e) {
        add(0, e);
    }

    // 向指定位置添加一个新元素  在index处插入元素e
    public void add(int index, int e) {
        if (size == data.length) {
            throw new IllegalArgumentException("add failed.Array is full");
        }
        // index必须满足合法
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("add failed.index >= 0 || index <= size");
        }
        // 从最后一个位置开始挪
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        // 此时index就空出来了，就将e 插入到index的位置
        data[index] = e;
        size++;
    }

    // 获取index 索引位置的元素
    public int get(int index) {
        if(index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed.Index is illegal");
        }
        return data[index];
    }

    // 修改index索引位置的元素为e
    public void set(int index,int e){
        if (index < 0 || index >= size){
            throw new IllegalArgumentException("Set failed，Index is illegal");
        }
        data[index] = e;
    }

    // 是否包含  查找数组中是否有元素e
    public boolean contains(int e){
        for(int i = 0; i <size;i++){
            if(data[i] == e)
                return true;
        }
        return false;
    }

    // 查找数组中元素e所在的索引，如果不存在元素e，则返回-1
    public int find(int e){
        for(int i = 0; i <size;i++){
            if(data[i] == e)
                return i;
        }
        return -1;
    }

    // 从数组中删除index位置的元素 【将删除的数是什么返回给用户】
    public int remove(int index) {
        if (index < 0 || index >= size){
            throw new IllegalArgumentException("Set failed，Index is illegal");
        }
        // 要删除的值
        int ret = data[index];
        // 将后面的值赋值给前面的值
        for(int i = index + 1;i < size; i++){
            data[i-1] = data[i];
        }
        size --;
        return ret;
    }
    // 复用remove方法  实现一些便捷的操作
    public int removeFirst(){
        return remove(0);
    }

    public int removeLast(){
        return remove(size - 1);
    }

    // 从数组中删除e
    public void removeElement(int e){
        int index = find(e);
        if(index != -1)
            remove(index);
    }


        @Override
        public String toString() {
            StringBuilder res = new StringBuilder();
            res.append(String.format("Array:size = %d , capacity = %d\n",size,data.length));
            res.append('[');
            for(int i = 0; i < size; i++){
                res.append(data[i]);
                if(i != size - 1)
                    res.append(",");
            }
            res.append(']');
            return res.toString();
        }
}
