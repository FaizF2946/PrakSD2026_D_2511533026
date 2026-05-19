package Pekan7_2511533026;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.JOptionPane;
import javax.swing.BorderFactory;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.SwingConstants;

public class InsertionSortGUI_2511533026 extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane_3026;
   
    // Deklarasi semua variabel di sini (level class) dengan akhiran _3026
    private int[] array_3026;
    private JLabel[] labelArray_3026;
    private JButton stepButton_3026, resetButton_3026, setButton_3026;
    private JTextField inputField_3026;
    private JPanel panelArray_3026;
    private JTextArea stepArea_3026;
   
    private int i_3026 = 1, j_3026;
    private boolean sorting_3026 = false;
    private int stepCount_3026 = 1;

    /**
     * Create the frame.
     */
    public InsertionSortGUI_2511533026() {
        setTitle("Insertion Sort Langkah per Langkah");
        setSize(750, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Panel input
        JPanel inputPanel_3026 = new JPanel(new FlowLayout());
        inputField_3026 = new JTextField(30);
        setButton_3026 = new JButton("Set Array");
        inputPanel_3026.add(new JLabel("Masukkan angka (pisahkan dengan koma):"));
        inputPanel_3026.add(inputField_3026);
        inputPanel_3026.add(setButton_3026);

        // Panel array visual
        panelArray_3026 = new JPanel();
        panelArray_3026.setLayout(new FlowLayout());

        // Panel kontrol
        JPanel controlPanel_3026 = new JPanel();
        stepButton_3026 = new JButton("Langkah Selanjutnya");
        resetButton_3026 = new JButton("Reset");
        stepButton_3026.setEnabled(false);
        controlPanel_3026.add(stepButton_3026);
        controlPanel_3026.add(resetButton_3026);
       
        // Area teks untuk log langkah-langkah
        stepArea_3026 = new JTextArea(8, 60);
        stepArea_3026.setEditable(false);
        stepArea_3026.setFont(new Font("Monospaced", Font.PLAIN, 14));
        JScrollPane scrollPane_3026 = new JScrollPane(stepArea_3026);

        // Tambahkan panel ke frame
        add(inputPanel_3026, BorderLayout.NORTH);
        add(panelArray_3026, BorderLayout.CENTER);
        add(controlPanel_3026, BorderLayout.SOUTH);
        add(scrollPane_3026, BorderLayout.EAST);

        // Event Listener
        setButton_3026.addActionListener(e -> setArrayFromInput_3026());
        stepButton_3026.addActionListener(e -> performStep_3026());
        resetButton_3026.addActionListener(e -> reset_3026());
    }
   
    private void setArrayFromInput_3026() {
        String text_3026 = inputField_3026.getText().trim();
        if (text_3026.isEmpty()) return;
       
        String[] parts_3026 = text_3026.split(",");
        array_3026 = new int[parts_3026.length];
       
        try {
            for (int k_3026 = 0; k_3026 < parts_3026.length; k_3026++) {
                array_3026[k_3026] = Integer.parseInt(parts_3026[k_3026].trim());
            }
        } catch (NumberFormatException e_3026) {
            JOptionPane.showMessageDialog(this,
                "Masukkan hanya angka yang dipisahkan dengan koma\nContoh: 1, 2, 2354, 12, 24254, 55",
                "Error",
                JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        stepCount_3026 = 1;
        sorting_3026 = true;
        i_3026 = 1;
        stepButton_3026.setEnabled(true);
        stepArea_3026.setText("");
        
        // Bersihkan panel array sebelum menambahkan yang baru
        panelArray_3026.removeAll();
       
        labelArray_3026 = new JLabel[array_3026.length];
        for (int k_3026 = 0; k_3026 < array_3026.length; k_3026++) {
            labelArray_3026[k_3026] = new JLabel(String.valueOf(array_3026[k_3026]));
            labelArray_3026[k_3026].setFont(new Font("Arial", Font.BOLD, 24));
            labelArray_3026[k_3026].setBorder(BorderFactory.createLineBorder(Color.BLACK));
            labelArray_3026[k_3026].setPreferredSize(new Dimension(50, 50));
            labelArray_3026[k_3026].setHorizontalAlignment(SwingConstants.CENTER);
            panelArray_3026.add(labelArray_3026[k_3026]);
        }
        
        panelArray_3026.revalidate();
        panelArray_3026.repaint();
       
        // Tampilkan array awal di log
        stepArea_3026.append("Array awal: " + arrayToString_3026(array_3026) + "\n\n");
    }
   
    private void performStep_3026() {
        if (i_3026 < array_3026.length && i_3026 > 0) {
            int key_3026 = array_3026[i_3026];
            j_3026 = i_3026 - 1;
           
            StringBuilder stepLog_3026 = new StringBuilder();
            stepLog_3026.append("Langkah ").append(stepCount_3026).append("\n");
            stepLog_3026.append("Memasukkan ").append(key_3026).append("\n");
           
            while (j_3026 >= 0 && array_3026[j_3026] > key_3026) {
                array_3026[j_3026 + 1] = array_3026[j_3026];
                j_3026--;
            }
            array_3026[j_3026 + 1] = key_3026;
           
            updateLabels_3026();
            stepLog_3026.append("Hasil: ").append(arrayToString_3026(array_3026)).append("\n\n");
            stepArea_3026.append(stepLog_3026.toString());
            
            i_3026++;
            stepCount_3026++;
        }
        
        if (i_3026 >= array_3026.length) {
            sorting_3026 = false;
            stepButton_3026.setEnabled(false);
            stepArea_3026.append("Sorting selesai!\n");
            JOptionPane.showMessageDialog(this, "Sorting selesai!");
        }
    }
   
    private void updateLabels_3026() {
        for (int k_3026 = 0; k_3026 < array_3026.length; k_3026++) {
            labelArray_3026[k_3026].setText(String.valueOf(array_3026[k_3026]));
        }
    }
    
    private void reset_3026() {
        inputField_3026.setText("");
        panelArray_3026.removeAll();
        panelArray_3026.revalidate();
        panelArray_3026.repaint();
        stepArea_3026.setText("");
        stepButton_3026.setEnabled(false);
        sorting_3026 = false;
        i_3026 = 1;
        j_3026 = 0;
        stepCount_3026 = 1;
        array_3026 = null;
        labelArray_3026 = null;
    }
    
    private String arrayToString_3026(int[] arr_3026) {
        StringBuilder sb_3026 = new StringBuilder();
        for (int k_3026 = 0; k_3026 < arr_3026.length; k_3026++) {
            sb_3026.append(arr_3026[k_3026]);
            if (k_3026 < arr_3026.length - 1) {
                sb_3026.append(", ");
            }
        }
        return sb_3026.toString();
    }
    
    public static void main(String[] args_3026) {
        SwingUtilities.invokeLater(() -> {
            InsertionSortGUI_2511533026 gui_3026 = new InsertionSortGUI_2511533026();
            gui_3026.setVisible(true);
        });
    }
}