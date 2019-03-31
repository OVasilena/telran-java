package webinar.bus.driver.autopark.controller;

import webinar.bus.driver.autopark.dao.Trip;

/**
 * class for List of trip
 */
public class TripList {
    private Node first = null;
    private Node last = null;
    private int size = 0;

    /**
     * Method for add trip to the list
     * @param element Trip
     */
    public void add(Trip element) {
        Node node = new Node();
        node.setTrip(element);

        // if Node first
        if (first == null) {
            first = node;
            node.setNext(null);
            node.setPrev(null);
        } else {
            // add Node last
            node.setPrev(last);
            node.setNext(null);
            last.setNext(node);
        }
        last = node;
        size++;
    }

    /**
     * Method for add trip to the list
     * @param element Trip
     * @param pos int
     */
    public void add(Trip element, int pos) {
        if (pos >= size) add(element);
        else {
            Node elementTrip = new Node();
            elementTrip.setTrip(element);
            Node curNode = findTrip(pos);

            // check NullPointerException in findTrip for return null
            if (curNode != null) {
                //[] [prev|elementTrip|next][prev|curNode|next][]
                curNode.getPrev().setNext(elementTrip);
                elementTrip.setPrev(curNode.getPrev());
                elementTrip.setNext(curNode);
                curNode.setPrev(elementTrip);
                size++;
            }
        }
    }

    /**
     * Method for find trip on position
     * @param pos int for 0 - n
     * @return node
     */
    public Node findTrip(int pos) {
        if (pos == 0) return first;
        // for counter
        Node node = first;
        int i = 0;

        while (node != null && i < pos) {
            node = node.getNext();
            i++;
        }
        return node;
    }

    /**
     * Method to print all trips
     */
    public void printTrip() {
        // for counter
        Node node = first;
        while (node != null) {
            System.out.println(node.getTrip().toString());
            node = node.getNext();
        }
        System.out.println("---" + size + " trips");
    }

    /**
     * Methode remove trip object
     * @param element Trip
     * @return node
     */
    public Node remove(Trip element) {
        Node node = first;
        Node findNode = null;
        while (node != null) {
            if (node.getTrip().equals(element)) {
                findNode = remove(node);
                return findNode;
            }
            node = node.getNext();
        }
        return null;
    }

    /**
     * Method to remove first element
     * @return node
     */
    public Node removeFirst() {
        Node node = first;
        if (node != null) {
            first = node.getNext();
            first.setPrev(null);
            size--;
        }
        return node;
    }

    /**
     * Method to remove last element
     * @return node
     */
    public Node removeLast() {
        Node node = last;
        if (last != null) {
            last = node.getPrev();
            last.setNext(null);
            size--;
        }
        return node;
    }

    /**
     * Method remove trip on position
     * @param pos int
     * @return node
     */
    public Node remove(int pos) {
        Node curNode = findTrip(pos);
        if (curNode != null) {
            curNode = remove(curNode);
        }
        return curNode;
    }

    /**
     * Methode remove node
     * @param node Node
     * @return node
     */
    public Node remove(Node node) {
        Node curNode = null;
        // first trip
        if (node == first) {
            curNode = removeFirst();
        }
        // last trip
        else if (node == last) {
            curNode = removeLast();
        } else {
            curNode = node.getPrev();
            curNode.setNext(node.getNext());
            curNode = node.getNext();
            curNode.setPrev(node.getPrev());
            size--;
        }
        return curNode;
    }
}

/**
 * class Node
 */
class Node {
    private Trip trip = null;
    private Node next = null;
    private Node prev = null;
    // [trip] [adress trip] [adress prev] [adress next]

    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }
}