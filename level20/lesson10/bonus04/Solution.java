package com.javarush.test.level20.lesson10.bonus04;

import java.io.*;
import java.util.*;

/* Свой список
Посмотреть, как реализован LinkedList.
Элементы следуют так: 1->2->3->4  и так 4->3->2->1
По образу и подобию создать Solution.
Элементы должны следовать так:
1->3->7->15
    ->8...
 ->4->9
    ->10
2->5->11
    ->12
 ->6->13
    ->14
Удалили 2 и 9
1->3->7->15
    ->8
 ->4->10
Добавили 16,17,18,19,20 (всегда добавляются на самый последний уровень к тем элементам, которые есть)
1->3->7->15
       ->16
    ->8->17
       ->18
 ->4->10->19
        ->20
Удалили 18 и 20
1->3->7->15
       ->16
    ->8->17
 ->4->10->19
Добавили 21 и 22 (всегда добавляются на самый последний уровень к тем элементам, которые есть.
Последний уровень состоит из 15, 16, 17, 19. 19 последний добавленный элемент, 10 - его родитель.
На данный момент 10 не содержит оба дочерних элемента, поэтому 21 добавился к 10. 22 добавляется в следующий уровень.)
1->3->7->15->22
       ->16
    ->8->17
 ->4->10->19
        ->21

Во внутренней реализации элементы должны добавляться по 2 на каждый уровень
Метод getParent должен возвращать элемент, который на него ссылается.
Например, 3 ссылается на 7 и на 8, т.е.  getParent("8")=="3", а getParent("13")=="6"
Строки могут быть любыми.
При удалении элемента должна удаляться вся ветка. Например, list.remove("5") должен удалить "5", "11", "12"
Итерироваться элементы должны в порядке добавления
Доступ по индексу запрещен, воспользуйтесь при необходимости UnsupportedOperationException
Должно быть наследование AbstractList<String>, List<String>, Cloneable, Serializable
Метод main в тестировании не участвует
*/
public class Solution extends AbstractList<String> implements List<String>, Cloneable, Serializable {
    public static void main(String[] args) throws IOException, ClassNotFoundException, CloneNotSupportedException {
    }

    private int size = 0;
    private Node last;
    private Node first;
    private ArrayList<String> parentList = new ArrayList<>();

    private String getParent(String value) {
        if (first != null) {
            for (Node node = first; node != null; node = node.next) {
                if (node.s.equals(value)) {
                    return node.parent.s;
                }
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    public boolean add(String s) {
        linkLast(s);
        return true;
    }

    private void linkLast(String s) {
        Node newNode = null;
        final Node l = last;
        if (size >= 2) {
            for (Node parentNode = first; parentNode != null; parentNode = parentNode.next) {
                if (parentNode.countChild == 0 && (parentNode.prev == null || parentNode.prev.child2 != null && parentNode.prev.child2.equals(last)) || (parentNode.child1 != null && parentNode.child1.equals(last))) {
                    newNode = new Node(l, null, s, parentNode);
                    if (parentNode.child1 == null) {
                        parentNode.child1 = newNode;
                    } else {
                        parentNode.child2 = newNode;
                    }
                    parentNode.countChild++;
                    break;
                }
            }
        } else {
            newNode = new Node(l, null, s, null);
        }
        last = newNode;
        if (l == null)
            first = newNode;
        else
            l.next = newNode;
        size++;
    }

    private static class Node implements Serializable {
        String s;
        Node next;
        Node prev;
        Node parent;
        Node child1;
        Node child2;
        int countChild;

        Node(Node prev, Node next, String s, Node parent) {
            this.prev = prev;
            this.next = next;
            this.s = s;
            this.parent = parent;
        }
    }

    public boolean remove(Object o) {
        if (o == null) {
            for (Node x = first; x != null; x = x.next) {
                if (x.s == null) {
                    unlink(x);
                    return true;
                }
            }
        } else {
            for (Node x = first; x != null; x = x.next) {
                if (o.equals(x.s)) {
                    if (x.countChild > 0) {
                        parentList.add(x.s);
                        Node node = x.child1 != null ? x.child1 : x.child2;
                        for (int i = 0; i < parentList.size(); i++) {
                            int j = 0;
                            while (node != null) {
                                int parentCountChild = node.parent.countChild;
                                Node next = node.next;
                                if (parentList.get(i).equals(node.parent.s)) {
                                    if (node.countChild > 0) {
                                        parentList.add(node.s);
                                    } else {
                                        unlink(node);
                                    }
                                    j++;
                                }
                                node = next;
                                if (j >= parentCountChild) {
                                    break;
                                }
                            }
                        }
                        if (x.parent != null) {
                            if (x.parent.child1 != null && x.parent.child1.s.equals(x.s)) {
                                x.parent.child1 = null;
                            } else {
                                x.parent.child2 = null;
                            }
                            x.parent.countChild--;
                        }
                        for (String s : parentList) {
                            for (node = x; node != null; node = node.next) {
                                if (node.s.equals(s)) {
                                    x = node.next;
                                    unlink(node);
                                }
                            }
                        }
                        parentList.clear();
                    } else {
                        if (x.parent != null) {
                            if (x.parent.child1 != null && x.parent.child1.s.equals(x.s)) {
                                x.parent.child1 = null;
                            } else {
                                x.parent.child2 = null;
                            }
                            x.parent.countChild--;
                        }
                        unlink(x);
                    }
                    return true;
                }
            }
        }
        return false;
    }

    private String unlink(Node x) {
        final String element = x.s;
        final Node next = x.next;
        final Node prev = x.prev;

        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
            x.prev = null;
        }

        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
            x.next = null;
        }

        x.s = null;
        x.parent = null;
        x.child1 = null;
        x.child2 = null;
        x.countChild = 0;
        size--;
        return element;
    }

    @Override
    public String get(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void add(int index, String element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String set(int index, String element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String remove(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int indexOf(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int lastIndexOf(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void clear() {
        for (Node x = first; x != null; ) {
            Node next = x.next;
            x.s = null;
            x.next = null;
            x.prev = null;
            x.child1 = null;
            x.child2 = null;
            x.countChild = 0;
            x.parent = null;
            x = next;
        }
        first = last = null;
        size = 0;
    }

    @Override
    public boolean addAll(int index, Collection<? extends String> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public ListIterator<String> listIterator() {
        return super.listIterator();
    }

    @Override
    public ListIterator<String> listIterator(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<String> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void removeRange(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected Solution clone() throws CloneNotSupportedException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = null;
        try {
            objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(this);
            byteArrayOutputStream.close();
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        ObjectInputStream objectInputStream = null;
        try {
            objectInputStream = new ObjectInputStream(byteArrayInputStream);
            Object object = objectInputStream.readObject();
            byteArrayInputStream.close();
            objectInputStream.close();
            return (Solution) object;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this.size() != ((Solution) o).size)
            return false;
        Iterator<String> iterator1 = this.iterator();
        Iterator<String> iterator2 = ((Solution) o).iterator();
        while (iterator1.hasNext()) {
            if (!iterator1.next().equals(iterator2.next()))
                return false;
        }
        return true;
    }

    @Override
    public Iterator<String> iterator() {
        return new ListItr();
    }

    private class ListItr implements Iterator {
        private Node lastReturned;
        private Node next;
        private int nextIndex;

        public ListItr() {
            next = first;
            nextIndex = 0;
        }

        @Override
        public boolean hasNext() {
            return nextIndex < size;
        }

        @Override
        public Object next() {
            if (!hasNext())
                throw new NoSuchElementException();
            lastReturned = next;
            next = next.next;
            nextIndex++;
            return lastReturned.s;
        }

        @Override
        public void remove() {
            if (lastReturned == null)
                throw new IllegalStateException();

            Node lastNext = lastReturned.next;
            unlink(lastReturned);
            if (next == lastReturned)
                next = lastNext;
            else
                nextIndex--;
            lastReturned = null;
        }
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean contains(Object o) {
        for (Node node = first; node != null; node = node.next)
            if (node.s.equals(o)) {
                return true;
            }
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return super.retainAll(c);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
