import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import javax.swing.JComponent;
import javax.swing.JFrame;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.Timer;

import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.Rectangle;
import java.awt.geom.RoundRectangle2D;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class StopContagionDisplay{
    //Graph Subclass
    static class Graph{
        int numNodes; //Total number of nodes
        boolean[][] adjMatrix; //adjacency matrix representation

        public Graph(int numNodes){ //Constructor
            this.numNodes = numNodes;
            this.adjMatrix = new boolean[numNodes + 1][numNodes + 1];
        }

        public Graph(int numNodes, boolean[][] adjMatrix){ //Constructor
            this.numNodes = numNodes;
            this.adjMatrix = adjMatrix;
        }

        public void addEdge(int i, int j){ //Adds edge
            adjMatrix[i][j] = true;
            adjMatrix[j][i] = true;
        }

        public void removeEdge(int i, int j){ //Removes edge
            adjMatrix[i][j] = false;
            adjMatrix[j][i] = false;
        }

        public ArrayList<Integer> adj(int Node){
            ArrayList<Integer> adj = new ArrayList<Integer>();
            for (int i = 1; i <= numNodes; i++){
                if (adjMatrix[Node][i] == true){
                    adj.add(i);
                    // System.out.println(Node + " is adjacent to " + i);
                }
            }
            // System.out.println(adj); 
            return adj;
        }

        public int degree(int Node){
            int degree = 0;
            for (int i = 0; i < numNodes; i++){
                if (adjMatrix[Node][i] == true){
                    degree += 1;
                }
            }
            return degree;
        }

        public void removeNode(int Node){
            for (int i = 0; i < numNodes; i++){
                removeEdge(Node, i);
            }
        }
    }

    public static ArrayList<Integer> Ball(int s, Graph graph, int r){ //Check nodes within a ball of radius r
        boolean[] visited = new boolean[graph.numNodes + 1];
        int[] distance = new int[graph.numNodes + 1];
        ArrayList<Integer> inBall = new ArrayList<Integer>();
        Queue<Integer> Q = new LinkedList<Integer>();
        visited[s] = true;
        distance[s] = 0;
        Q.add(s);

        while (Q.size() != 0){
            s = Q.poll();
            for (int i : graph.adj(s)){
                if (visited[i] == false){
                    visited[i] = true;
                    distance[i] = distance[s] + 1;
                    Q.add(i);
                    if (distance[i] <= r){
                        inBall.add(i);
                    }
                }
            }
        }
        return inBall;
    }

    public static ArrayList<Integer> deltaBall(int s, Graph graph, int r){ //Check nodes on perimeter of ball of radius r
        boolean[] visited = new boolean[graph.numNodes + 1];
        int[] distance = new int[graph.numNodes + 1];
        ArrayList<Integer> onBall = new ArrayList<Integer>();
        Queue<Integer> Q = new LinkedList<Integer>();
        visited[s] = true;
        distance[s] = 0;
        Q.add(s);

        while (Q.size() != 0){
            //System.out.println("In while loop for Q.");
            s = Q.poll();
            for (int i : graph.adj(s)){
                //System.out.println("In for loop for Q.");
                if (visited[i] == false){
                    visited[i] = true;
                    distance[i] = distance[s] + 1;
                    Q.add(i);
                    //System.out.println("Distance of" + i + " :" + d);
                    if (distance[i] == r){
                        onBall.add(i);
                    }
                }
            }
        }
        //System.out.println("OnBall Size:" + onBall.size());
        return onBall;
    }

    public static int collectiveInt(int i, int r, Graph graph){
        int sum = 0;
        for (int j : deltaBall(i, graph, r)){
            //System.out.println("Degree: " + graph.degree(j));
            sum += (graph.degree(j) - 1);
        }
        //System.out.println("In collectiveInt method:" + sum);

        return (graph.degree(i) - 1)*sum;
    }

    public static ArrayList<Integer> collectiveInt(int r, Graph graph){
        //System.out.println("In collectiveInt method r, graph:");
        ArrayList<Integer> collectiveInt = new ArrayList<Integer>();
        for (int i = 0; i <= graph.numNodes; i++){
            if (i == 0) {
                collectiveInt.add(0);
            } else{
                collectiveInt.add(collectiveInt(i, r, graph));
            }
            //System.out.println("CollectiveInt:" + i + " " + collectiveInt(i, r, graph));
        }
        //System.out.println("Finished making collectiveInt array.");
        return collectiveInt;
    }

    public static int max(ArrayList<Integer> a){
        int max = 0;
        for (int i = 0; i < a.size(); i++){
            if (a.get(i) > max){
                max = a.get(i);
            }
        }
        return max;
    }

    public static Graph dismantle(Graph graph, int r, ArrayList<Integer> collectiveInt){
        collectiveInt = collectiveInt(r , graph);
        int max = max(collectiveInt);
        int maxNode = collectiveInt.indexOf(max);
        System.out.println(maxNode + " " + max);

        graph.removeNode(maxNode);

        for (int i: Ball(maxNode, graph, r)){
            collectiveInt.set(i, collectiveInt(i, r, graph));
        }
        return graph;
    }

    public static Graph dismantle(Graph graph, int r, int numNodesRem){
        //System.out.println("In dismantle:");
        ArrayList<Integer> collectiveInt = collectiveInt(r, graph);
        //System.out.println("Formed collectiveInt.");
        for (int i = 0; i < numNodesRem; i++){
            //System.out.println("In for loop:");
            graph = dismantle(graph, r, collectiveInt);
            //System.out.println("Reset graph.");
        }
        return graph;
    }

    public static Graph removeHighDeg(Graph graph){
        ArrayList<Integer> degrees = new ArrayList<Integer>();
        for (int i = 0; i < graph.numNodes; i++){
            if (i == 0){
                degrees.add(0);
            } else{
                degrees.add(graph.degree(i));
            }
        }
        int highDeg = max(degrees);
        int indOfNode = degrees.indexOf(highDeg);
        System.out.println(indOfNode + " " + highDeg);

        graph.removeNode(indOfNode);
        return graph;
    }

    public static Graph removeHighDeg(Graph graph, int numNodesRem){
        for (int i = 0; i < numNodesRem; i++){
            graph = removeHighDeg(graph);
        }
        return graph;
    }

    public static void main(String[] args) throws FileNotFoundException{
        //Check if d is first argument
        int r = 2;
        int num_nodes;
        String inputFile = "";

        if (args[0].equals("-d")){
            //TODO
            num_nodes = Integer.valueOf(args[1]);
            inputFile = args[2];
        } else if (args[0].equals("-r")){
            r = Integer.valueOf(args[1]);
            num_nodes = Integer.valueOf(args[2]);
            inputFile = args[3];
        } else {
            num_nodes = Integer.valueOf(args[0]);
            inputFile = args[1];
        }

        int graphSize = 0;
        FileInputStream fis = new FileInputStream(inputFile);
        Scanner sc = new Scanner(fis);
        while(sc.hasNextLine()){
            sc.nextLine();
            graphSize += 1;
        }
        Graph graph = new Graph(graphSize);
        // System.out.println("Num of nodes in graph:" + graph.numNodes);
        //graphics
        JFrame frame = new JFrame("Stop the Contagion");
        frame.setSize(1500,1500);
        // make a grid for graph.numNodes 


		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

        FileInputStream fis1 = new FileInputStream(inputFile);
        Scanner s = new Scanner(fis1);

        while (s.hasNextLine()){
            String nodes = s.nextLine();
            int indOfSpace = nodes.indexOf(" ");
            int i = Integer.parseInt(nodes.substring(0, indOfSpace));
            int j = Integer.parseInt(nodes.substring(indOfSpace + 1, nodes.length()));
            //System.out.println(i + " " + j);
            graph.addEdge(i,j);
        }

        if (args[0].equals("-d")){
            removeHighDeg(graph, num_nodes);
        } else {
            dismantle(graph, r, num_nodes);
        }
    }
}