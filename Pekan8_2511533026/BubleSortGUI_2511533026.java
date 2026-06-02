package Pekan8_2511533026;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class BubleSortGUI_2511533026 extends JFrame {
    private static final long serialVersionUID = 1L;
    
    private int[] array_3026;
    private JLabel[] labelArray_3026;
    private JButton stepButton_3026, resetButton_3026, setButton_3026;
    private JTextField inputField_3026;
    private JPanel panelArray_3026;
    private JTextArea stepArea_3026;
    private int i_3026 = 0, j_3026 = 0;
    private boolean sorting_3026 = false;
    private int stepCount_3026 = 1;

    public BubleSortGUI_2511533026() {
        setTitle("Buble Sort Langkah per Langkah");
        setSize(750, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // panel input
        JPanel inputPanel_3026 = new JPanel(new FlowLayout());
        inputField_3026 = new JTextField(30);
        setButton_3026 = new JButton("Set Array");
        inputPanel_3026.add(new JLabel("Masukan angka (pisahkan dengan koma)"));
        inputPanel_3026.add(inputField_3026);
        inputPanel_3026.add(setButton_3026);

        // panel array visual
        panelArray_3026 = new JPanel();
        panelArray_3026.setLayout(new FlowLayout());

        // panel kontrol
        JPanel controlPanel_3026 = new JPanel();
        stepButton_3026 = new JButton("Langkah selanjutnya");
        resetButton_3026 = new JButton("Reset");
        controlPanel_3026.add(stepButton_3026);
        controlPanel_3026.add(resetButton_3026);

        // area text untuk log langkah langkah
        stepArea_3026 = new JTextArea(8, 60);
        stepArea_3026.setEditable(false);
        stepArea_3026.setFont(new Font("Monospaced", Font.PLAIN, 14));
        JScrollPane scrollPane_3026 = new JScrollPane(stepArea_3026);

        // tambahkan panel ke frame
        add(inputPanel_3026, BorderLayout.NORTH);
        add(panelArray_3026, BorderLayout.CENTER);
        add(controlPanel_3026, BorderLayout.SOUTH);
        add(scrollPane_3026, BorderLayout.EAST);

        // event set array
        setButton_3026.addActionListener(e -> setArrayFromInput_3026());
        // event selanjutnya
        stepButton_3026.addActionListener(e -> performStep_3026());
        // event reset
        resetButton_3026.addActionListener(e -> reset_3026());
    }

    private void setArrayFromInput_3026() {
        String text_3026 = inputField_3026.getText().trim();
        if (text_3026.isEmpty()) return;

        String[] parts_3026 = text_3026.split(",");
        array_3026 = new int[parts_3026.length];

        try {
            for (int k = 0; k < parts_3026.length; k++) {
                array_3026[k] = Integer.parseInt(parts_3026[k].trim());
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Masukkan hanya angka "
                    + "yang dipisahkan koma!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        i_3026 = 0;
        j_3026 = 0;
        stepCount_3026 = 1;
        sorting_3026 = true;
        stepButton_3026.setEnabled(true);
        stepArea_3026.setText("");

        panelArray_3026.removeAll();
        labelArray_3026 = new JLabel[array_3026.length];

        for (int k = 0; k < array_3026.length; k++) {
            labelArray_3026[k] = new JLabel(String.valueOf(array_3026[k]));
            labelArray_3026[k].setFont(new Font("Arial", Font.BOLD, 24));
            labelArray_3026[k].setOpaque(true);
            labelArray_3026[k].setBackground(Color.WHITE);
            labelArray_3026[k].setBorder(BorderFactory.createLineBorder(Color.BLACK));
            labelArray_3026[k].setPreferredSize(new Dimension(50, 50));
            labelArray_3026[k].setHorizontalAlignment(SwingConstants.CENTER);
            panelArray_3026.add(labelArray_3026[k]);
        }
        panelArray_3026.revalidate();
        panelArray_3026.repaint();
    }

    private void performStep_3026() {
        if (!sorting_3026 || i_3026 >= array_3026.length - 1) {
            sorting_3026 = false;
            stepButton_3026.setEnabled(false);
            JOptionPane.showMessageDialog(this, "Sorting selesai!");
            return;
        }

        resetHighlights_3026();

        StringBuilder stepLog_3026 = new StringBuilder();
        labelArray_3026[j_3026].setBackground(Color.CYAN);
        labelArray_3026[j_3026 + 1].setBackground(Color.CYAN);

        if (array_3026[j_3026] > array_3026[j_3026 + 1]) {
            // Swap
            int temp_3026 = array_3026[j_3026];
            array_3026[j_3026] = array_3026[j_3026 + 1];
            array_3026[j_3026 + 1] = temp_3026;

            labelArray_3026[j_3026].setBackground(Color.RED);
            labelArray_3026[j_3026 + 1].setBackground(Color.RED);

            stepLog_3026.append("Langkah ").append(stepCount_3026).append(": Menukar elemen ke-")
                    .append(j_3026).append(" (").append(array_3026[j_3026 + 1]).append(") dengan ke-")
                    .append(j_3026 + 1).append(" (").append(array_3026[j_3026]).append(")\n");
        } else {
            stepLog_3026.append("Langkah ").append(stepCount_3026).append(": Tidak ada pertukaran antara ke-")
                    .append(j_3026).append(" dan ke-").append(j_3026 + 1).append("\n");
        }

        stepLog_3026.append("Hasil: ").append(arrayToString_3026(array_3026)).append("\n\n");
        stepArea_3026.append(stepLog_3026.toString());

        updateLabels_3026();

        j_3026++;
        if (j_3026 >= array_3026.length - i_3026 - 1) {
            j_3026 = 0;
            i_3026++;
        }
        stepCount_3026++;

        if (i_3026 >= array_3026.length - 1) {
            sorting_3026 = false;
            stepButton_3026.setEnabled(false);
            JOptionPane.showMessageDialog(this, "Sorting selesai!");
        }
    }

    private void updateLabels_3026() {
        for (int k = 0; k < array_3026.length; k++) {
            labelArray_3026[k].setText(String.valueOf(array_3026[k]));
        }
    }

    private void resetHighlights_3026() {
        for (JLabel label : labelArray_3026) {
            label.setBackground(Color.WHITE);
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
        i_3026 = 0;
        j_3026 = 0;
        stepCount_3026 = 1;
    }

    private String arrayToString_3026(int[] arr) {
        StringBuilder sb_3026 = new StringBuilder();
        for (int k = 0; k < arr.length; k++) {
            sb_3026.append(arr[k]);
            if (k < arr.length - 1) sb_3026.append(", ");
        }
        return sb_3026.toString();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            BubleSortGUI_2511533026 gui = new BubleSortGUI_2511533026();
            gui.setVisible(true);
        });
    }
}