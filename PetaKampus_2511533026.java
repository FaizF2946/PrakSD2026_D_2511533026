package Pekan9_2511533026;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;

	public class PetaKampus_2511533026 extends JFrame {

	    private Map<String, List<String>> adjList3026;
	    private Map<String, Point> positions3026; 
	    
	    private List<String> visitedOrder3026;
	    private List<String> pathFound3026;
	    private Set<String> visitedSet3026;

	    private JComboBox<String> cmbStart3026; 
	    private JComboBox<String> cmbGoal3026;  
	    private JButton btnBFS3026;             
	    private JButton btnDFS3026;             
	    private JButton btnReset3026;           
	    private JTextArea txtResult3026;        
	    private GraphPanel canvas3026;          

	    public PetaKampus_2511533026() {
	        setTitle("PENCARIAN JALUR MENGGUNAKAN BFS DAN DFS");
	        setSize(900, 650);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setLocationRelativeTo(null);
	        setLayout(new BorderLayout());

	        // Inisialisasi Graph
	        initGraph3026();

	        visitedOrder3026 = new ArrayList<>();
	        pathFound3026 = new ArrayList<>();
	        visitedSet3026 = new HashSet<>();

	        // Membuat Panel Kontrol Atas
	        JPanel pnlControl3026 = new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 10));
	        
	        pnlControl3026.add(new JLabel("Lokasi Awal :"));
	        String[] nodes3026 = adjList3026.keySet().toArray(new String[0]);
	        cmbStart3026 = new JComboBox<>(nodes3026);
	        pnlControl3026.add(cmbStart3026);

	        pnlControl3026.add(new JLabel("Lokasi Tujuan :"));
	        cmbGoal3026 = new JComboBox<>(nodes3026);
	        pnlControl3026.add(cmbGoal3026);

	        btnBFS3026 = new JButton("BFS");
	        btnBFS3026.setBackground(new Color(144, 238, 144)); 
	        pnlControl3026.add(btnBFS3026);

	        btnDFS3026 = new JButton("DFS");
	        btnDFS3026.setBackground(new Color(255, 218, 121)); 
	        pnlControl3026.add(btnDFS3026);

	        btnReset3026 = new JButton("RESET");
	        btnReset3026.setBackground(new Color(255, 121, 121)); 
	        pnlControl3026.add(btnReset3026);

	        add(pnlControl3026, BorderLayout.NORTH);

	        // Panel Visualisasi Graph
	        canvas3026 = new GraphPanel();
	        add(canvas3026, BorderLayout.CENTER);

	        // Area Hasil Pencarian
	        txtResult3026 = new JTextArea(5, 50);
	        txtResult3026.setEditable(false);
	        txtResult3026.setFont(new Font("Monospaced", Font.PLAIN, 13));
	        resetGraph(); 
	        
	        JScrollPane scroll3026 = new JScrollPane(txtResult3026);
	        add(scroll3026, BorderLayout.SOUTH);

	        // Action Listeners
	        btnBFS3026.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                BFS();
	            }
	        });

	        btnDFS3026.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                DFS();
	            }
	        });

	        btnReset3026.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                resetGraph();
	            }
	        });
	    }

	    private void initGraph3026() {
	        adjList3026 = new LinkedHashMap<>();
	        positions3026 = new HashMap<>();

	        // 10 Simpul/Vertex Lokasi Kampus
	        String[] lokasi3026 = {
	            "Gerbang", "Rektorat", "Masjid", "Perpus", "PKM", 
	            "FTI", "Labor_AI", "Lab_Jaringan", "Kantin", "Auditorium"
	        };

	        for (String loc3026 : lokasi3026) {
	            adjList3026.put(loc3026, new ArrayList<>());
	        }

	        // Penentuan Koordinat Posisi untuk Gambar Node
	        positions3026.put("Gerbang", new Point(50, 250));
	        positions3026.put("Rektorat", new Point(200, 250));
	        positions3026.put("Masjid", new Point(200, 410));
	        positions3026.put("Perpus", new Point(200, 90));
	        positions3026.put("PKM", new Point(400, 250));
	        positions3026.put("FTI", new Point(600, 90));
	        positions3026.put("Lab_Jaringan", new Point(600, 250));
	        positions3026.put("Labor_AI", new Point(600, 410));
	        positions3026.put("Kantin", new Point(400, 410));
	        positions3026.put("Auditorium", new Point(400, 90));

	        // 15 Sisi/Edge penghubung antar lokasi
	        addEdge3026("Gerbang", "Rektorat");
	        addEdge3026("Rektorat", "Perpus");
	        addEdge3026("Rektorat", "PKM");
	        addEdge3026("Rektorat", "Masjid");
	        addEdge3026("Perpus", "FTI");
	        addEdge3026("Perpus", "Auditorium");
	        addEdge3026("PKM", "Lab_Jaringan");
	        addEdge3026("PKM", "Kantin");
	        addEdge3026("Masjid", "Labor_AI");
	        addEdge3026("Masjid", "Kantin");
	        addEdge3026("FTI", "Lab_Jaringan");
	        addEdge3026("Lab_Jaringan", "Labor_AI");
	        addEdge3026("Auditorium", "FTI");
	        addEdge3026("Kantin", "Labor_AI");
	        addEdge3026("Auditorium", "PKM"); 
	    }

	    private void addEdge3026(String u3026, String v3026) {
	        adjList3026.get(u3026).add(v3026);
	        adjList3026.get(v3026).add(u3026);
	    }

	    // Method BFS() wajib ada
	    public void BFS() {
	        String start3026 = (String) cmbStart3026.getSelectedItem();
	        String goal3026 = (String) cmbGoal3026.getSelectedItem();
	        
	        visitedOrder3026.clear();
	        pathFound3026.clear();
	        visitedSet3026.clear();

	        Queue<String> queue3026 = new LinkedList<>();
	        Map<String, String> parentMap3026 = new HashMap<>();

	        queue3026.add(start3026);
	        visitedSet3026.add(start3026);

	        boolean found3026 = false;

	        while (!queue3026.isEmpty()) {
	            String current3026 = queue3026.poll();
	            visitedOrder3026.add(current3026);

	            if (current3026.equals(goal3026)) {
	                found3026 = true;
	                break;
	            }

	            for (String neighbor3026 : adjList3026.get(current3026)) {
	                if (!visitedSet3026.contains(neighbor3026)) {
	                    visitedSet3026.add(neighbor3026);
	                    parentMap3026.put(neighbor3026, current3026);
	                    queue3026.add(neighbor3026);
	                }
	            }
	        }

	        if (found3026) {
	            displayPath(parentMap3026, start3026, goal3026); 
	        }
	        displayGraph(); 
	        updateResultText3026("BFS");
	    }

	    // Method DFS()
	    public void DFS() {
	        String start3026 = (String) cmbStart3026.getSelectedItem();
	        String goal3026 = (String) cmbGoal3026.getSelectedItem();

	        visitedOrder3026.clear();
	        pathFound3026.clear();
	        visitedSet3026.clear();

	        Stack<String> stack3026 = new Stack<>();
	        Map<String, String> parentMap3026 = new HashMap<>();

	        stack3026.push(start3026);

	        boolean found3026 = false;

	        while (!stack3026.isEmpty()) {
	            String current3026 = stack3026.pop();

	            if (!visitedSet3026.contains(current3026)) {
	                visitedSet3026.add(current3026);
	                visitedOrder3026.add(current3026);

	                if (current3026.equals(goal3026)) {
	                    found3026 = true;
	                    break;
	                }

	                List<String> neighbors3026 = new ArrayList<>(adjList3026.get(current3026));
	                Collections.reverse(neighbors3026);

	                for (String neighbor3026 : neighbors3026) {
	                    if (!visitedSet3026.contains(neighbor3026)) {
	                        parentMap3026.put(neighbor3026, current3026);
	                        stack3026.push(neighbor3026);
	                    }
	                }
	            }
	        }

	        if (found3026) {
	            displayPath(parentMap3026, start3026, goal3026); 
	        }
	        displayGraph(); 
	        updateResultText3026("DFS");
	    }

	    // Method displayGraph()
	    public void displayGraph() {
	        canvas3026.repaint();
	    }

	    // Method displayPath()
	    public void displayPath(Map<String, String> parentMap3026, String start3026, String goal3026) {
	        String curr3026 = goal3026;
	        while (curr3026 != null) {
	            pathFound3026.add(0, curr3026);
	            curr3026 = parentMap3026.get(curr3026);
	        }
	    }

	    // Method resetGraph()
	    public void resetGraph() {
	        visitedOrder3026.clear();
	        pathFound3026.clear();
	        visitedSet3026.clear();
	        displayGraph(); 
	        
	        txtResult3026.setText("Hasil Pencarian :\n" +
	                "Jalur : -\n" +
	                "Node Dikunjungi : -\n" +
	                "Jumlah Node Dieksplorasi : 0"); 
	    }

	    private void updateResultText3026(String method3026) {
	        String pathStr3026 = String.join(" -> ", pathFound3026);
	        String visitedStr3026 = String.join(", ", visitedOrder3026);
	        
	        txtResult3026.setText("Hasil Pencarian (" + method3026 + ") :\n" +
	                "Jalur : " + (pathFound3026.isEmpty() ? "Tidak ditemukan" : pathStr3026) + "\n" +
	                "Node Dikunjungi : " + visitedStr3026 + "\n" +
	                "Jumlah Node Dieksplorasi : " + visitedOrder3026.size()); 
	    }

	    private class GraphPanel extends JPanel {
	        public GraphPanel() {
	            setBackground(Color.WHITE);
	            setBorder(BorderFactory.createTitledBorder("VISUALISASI GRAPH")); 
	        }

	        @Override
	        protected void paintComponent(Graphics g) {
	            super.paintComponent(g);
	            Graphics2D g2_3026 = (Graphics2D) g;
	            g2_3026.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

	            // Menggambar Sisi/Garis Hubung (Edges)
	            g2_3026.setColor(Color.GRAY);
	            g2_3026.setStroke(new BasicStroke(2));
	            Set<String> drawnEdges3026 = new HashSet<>();

	            for (String node3026 : adjList3026.keySet()) {
	                Point p1_3026 = positions3026.get(node3026);
	                for (String neighbor3026 : adjList3026.get(node3026)) {
	                    String edgeKey3026 = node3026 + "-" + neighbor3026;
	                    String edgeKeyAlt3026 = neighbor3026 + "-" + node3026;
	                    
	                    if (!drawnEdges3026.contains(edgeKey3026) && !drawnEdges3026.contains(edgeKeyAlt3026)) {
	                        Point p2_3026 = positions3026.get(neighbor3026);

	                        if (pathFound3026.contains(node3026) && pathFound3026.contains(neighbor3026) &&
	                            Math.abs(pathFound3026.indexOf(node3026) - pathFound3026.indexOf(neighbor3026)) == 1) {
	                            g2_3026.setColor(Color.BLUE);
	                            g2_3026.setStroke(new BasicStroke(4));
	                            g2_3026.drawLine(p1_3026.x, p1_3026.y, p2_3026.x, p2_3026.y);
	                            g2_3026.setColor(Color.GRAY); 
	                            g2_3026.setStroke(new BasicStroke(2));
	                        } else {
	                            g2_3026.drawLine(p1_3026.x, p1_3026.y, p2_3026.x, p2_3026.y);
	                        }
	                        drawnEdges3026.add(edgeKey3026);
	                    }
	                }
	            }

	            // Menggambar Simpul Lingkaran (Vertex)
	            int radius3026 = 25;
	            for (String node3026 : adjList3026.keySet()) {
	                Point p3026 = positions3026.get(node3026);

	                if (pathFound3026.contains(node3026)) {
	                    g2_3026.setColor(new Color(30, 144, 255)); 
	                } else if (visitedSet3026.contains(node3026)) {
	                    g2_3026.setColor(Color.LIGHT_GRAY); 
	                } else {
	                    g2_3026.setColor(new Color(240, 240, 240)); 
	                }

	                g2_3026.fillOval(p3026.x - radius3026, p3026.y - radius3026, radius3026 * 2, radius3026 * 2);
	                g2_3026.setColor(Color.BLACK);
	                g2_3026.drawOval(p3026.x - radius3026, p3026.y - radius3026, radius3026 * 2, radius3026 * 2);

	                g2_3026.setFont(new Font("Arial", Font.BOLD, 12));
	                FontMetrics fm3026 = g2_3026.getFontMetrics();
	                int textX3026 = p3026.x - fm3026.stringWidth(node3026) / 2;
	                int textY3026 = p3026.y + fm3026.getAscent() / 2 - 2;
	                g2_3026.drawString(node3026, textX3026, textY3026);
	            }
	        }
	    }

	    public static void main(String[] args) {
	        SwingUtilities.invokeLater(new Runnable() {
	            @Override
	            public void run() {
	                new PetaKampus_2511533026().setVisible(true);
	            }
	        });
	    }
	}