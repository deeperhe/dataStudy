package com.kelly.imooc.stackANDqueue03;

/**
 * Created by 贺望香 on 2019/2/14.
 * 增 删 改 查：研究数据结构的脉络
 *  对Array进行原始的更新：1、<E>存放的数据类型是E：任意取名
 */
public class UpdateArray<E>{
    private E[] data;
    private int size;

    //传入数组的容量capacity构造Array
    public UpdateArray(int capacity) {
        // JAVA不支持 泛型实例化  用Object
        data = (E[]) new Object[capacity];
        size = 0;

    }

    public UpdateArray() {
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
    public void addLast(E e) {
//        if (size == data.length){
//            throw new IllegalArgumentException("addLast failed.Array is full");
//        }
//        data[size] = e;
//        size ++;
        add(size, e);
    }

    // 向第一个位置添加元素
    public void addFirst(E e) {
        add(0, e);
    }

    // 向指定位置添加一个新元素  在index处插入元素e
    public void add(int index, E e) {

        // index必须满足合法
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("add failed.index >= 0 || index <= size");
        }
        // 动态数组的变化 扩容
        if (size == data.length) {
            // 2 * data.length：使得扩容更加高效，性能更能效率 Collection中的扩容【参数选的是1.5】  和当前数组的量连接
             resize(2 * data.length);
        }
        // 从最后一个位置开始挪
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    // 获取index 索引位置的元素
    public E get(int index) {
        if(index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed.Index is illegal");
        }
        return data[index];
    }

    // 为【栈】创建的函数  得到最后一个元素
    public E getLast(){
        return get(size - 1);
        // return data[size - 1]  不写这个，因为size = 0时，数组new一个对象为0会报错
    }

    // 为【栈】创建的函数  得到第一个元素
    public E getFirst(){
        return get(0);
    }

    // 修改index索引位置的元素为e
    public void set(int index,E e){
        if (index < 0 || index >= size){
            throw new IllegalArgumentException("Set failed，Index is illegal");
        }
        data[index] = e;
    }

    // 是否包含  查找数组中是否有元素e
    public boolean contains(E e){
        for(int i = 0; i <size;i++){
            if(data[i].equals(e))
                return true;
        }
        return false;
    }

    // 查找数组中元素e所在的索引，如果不存在元素e，则返回-1
    public int find(E e){
        for(int i = 0; i <size;i++){
//            if(data[i] == e)  因为是对象比较，用equals()判断
            if(data[i].equals(e))
                return i;
        }
        return -1;
    }

    // 从数组中删除index位置的元素 【将删除的数是什么返回给用户】
    // 通过这个函数后  我们的size其实还指着一个值，只不过我们的用户访问不到
    // 当我们改成泛型后，data数组中存的就是类对象的引用，删除一个元素后，我们的data[size]还指着一个引用，对于一个引用，本来就有空间释放的问题。我们可以把他设为空
    // 那么java的jvm回收机制就会自动将其回收  加一句data[size] = null;
    public E remove(int index) {
        if (index < 0 || index >= size){
            throw new IllegalArgumentException("Set failed，Index is illegal");
        }
        // 要删除的值 用来返回给用户看
        E ret = data[index];
        // 将后面的值赋值给前面的值
        for(int i = index + 1;i < size; i++){
            data[i-1] = data[i];
        }
        size --;
        // 原来data[size]指的对象就会被jvm回收
        data[size] = null;  // 术语：loitering objects != memory leak  只是为了优化机制

        // 动态数组-- 如果我看到我当前的元素个数已经小到一定程度了，小到了数组的1/2时
        // 将当前数组容量减小为原来的一半
        if (size == data.length / 4 && data.length / 2 != 0){
            resize (data.length / 2);
        }
        return ret;
    }
    // 复用remove方法  实现一些便捷的操作
    public E removeFirst(){
        return remove(0);
    }

    public E removeLast(){
        return remove(size - 1);
    }

    // 从数组中删除e
    public void removeElement(E e){
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

        private void resize(int newCapacity){
         // 1、声明一个新数组
            E[] newData = (E[])new Object[newCapacity];
        //  2、将data中的数据转移到新数组中
            for (int i = 0; i < size; i++){
                newData[i] = data[i];
            }
            // 3、让我们的data数组指向newData数组[他将被jvm回收]
            data = newData;
        }
}
