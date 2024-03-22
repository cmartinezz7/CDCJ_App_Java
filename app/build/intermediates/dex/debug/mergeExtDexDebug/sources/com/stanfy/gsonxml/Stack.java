package com.stanfy.gsonxml;

import kotlin.text.Typography;

final class Stack<T> {
    private Object[] array = new Object[32];
    private int size = 0;

    Stack() {
    }

    public T peek() {
        return this.array[this.size - 1];
    }

    public int size() {
        return this.size;
    }

    public T get(int pos) {
        return this.array[pos];
    }

    public void drop() {
        this.size--;
    }

    public int cleanup(int count) {
        return cleanup(count, this.size);
    }

    public int cleanup(int count, int oldStackSize) {
        int curStackSize = this.size;
        if (oldStackSize < curStackSize) {
            for (int i = oldStackSize; i < curStackSize; i++) {
                Object[] objArr = this.array;
                objArr[i - count] = objArr[i];
            }
            this.size -= count;
        } else {
            this.size -= (count - oldStackSize) + curStackSize;
        }
        if (this.size < 0) {
            this.size = 0;
        }
        return oldStackSize - count;
    }

    public void fix(T check) {
        int i = this.size - 1;
        this.size = i;
        if (i > 0 && this.array[i - 1] == check) {
            this.size = i - 1;
        }
    }

    private void ensureStack() {
        int i = this.size;
        Object[] objArr = this.array;
        if (i == objArr.length) {
            Object[] newStack = new Object[(i * 2)];
            System.arraycopy(objArr, 0, newStack, 0, i);
            this.array = newStack;
        }
    }

    public void push(T value) {
        ensureStack();
        Object[] objArr = this.array;
        int i = this.size;
        this.size = i + 1;
        objArr[i] = value;
    }

    public void pushAt(int position, T scope) {
        int pos = position;
        if (pos < 0) {
            pos = 0;
        }
        ensureStack();
        for (int i = this.size - 1; i >= pos; i--) {
            Object[] objArr = this.array;
            objArr[i + 1] = objArr[i];
        }
        this.array[pos] = scope;
        this.size++;
    }

    public String toString() {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < this.size; i++) {
            res.append(this.array[i]).append(Typography.greater);
        }
        if (res.length() > 0) {
            res.delete(res.length() - 1, res.length());
        }
        return res.toString();
    }
}
