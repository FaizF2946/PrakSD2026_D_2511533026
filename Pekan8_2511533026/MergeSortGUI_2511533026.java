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
import java.util.LinkedList;
import java.util.Queue;

public class MergeSortGUI_2511533026 extends JFrame {
    private static final long serialVersionUID = 1L;
    
    private int[] array_3026;
    private JLabel[] labelArray_3026;
    private JButton stepButton_3026, resetButton_3026, setButton_3026;
    private JTextField inputField_3026;
    private JPanel panelArray_3026;
    private JTextArea stepArea_3026;
    private Queue<int[]> mergeQueue_3026 = new LinkedList<>();
    private int stepCount_3026 = 1;
    private boolean isMerging_3026 = false;
    private boolean copying_3026 = false;
    private int[] temp_3026;
    private int left_3026, mid_3026, right_3026;
    private int i_3026, j_3026, k_3026;

    public MergeSortGUI_2511533026() {
        setTitle("Merge Sort Langkah per Langkah");
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
            JOptionPane.showMessageDialog(this, "Masukkan hanya angka dengan koma!",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        labelArray_3026 = new JLabel[array_3026.length];
        panelArray_3026.removeAll();
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

        mergeQueue_3026.clear();
        generateMergeSteps_3026(0, array_3026.length - 1);
        stepButton_3026.setEnabled(true);
        stepArea_3026.setText("");
        stepCount_3026 = 1;
        isMerging_3026 = false;

        panelArray_3026.revalidate();
        panelArray_3026.repaint();
    }

    private void generateMergeSteps_3026(int left, int right) {
        if (left >= right) return;
        int mid = (left + right) / 2;
        generateMergeSteps_3026(left, mid);
        generateMergeSteps_3026(mid + 1, right);
        mergeQueue_3026.add(new int[]{left, mid, right});
    }

    private void performStep_3026() {
        resetHighlights_3026();

        if (!isMerging_3026 && !mergeQueue_3026.isEmpty()) {
            int[] range_3026 = mergeQueue_3026.poll();
            left_3026 = range_3026[0];
            mid_3026 = range_3026[1];
            right_3026 = range_3026[2];
            temp_3026 = new int[right_3026 - left_3026 + 1];
            i_3026 = left_3026;
            j_3026 = mid_3026 + 1;
            k_3026 = 0;
            copying_3026 = false;
            isMerging_3026 = true;

            stepArea_3026.append("Langkah " + stepCount_3026++ +
                    ": Mulai merge dari " + left_3026 + " ke " + right_3026 + "\n");
            return;
        }

        if (isMerging_3026 && !copying_3026) {
            if (i_3026 <= mid_3026 && j_3026 <= right_3026) {
                labelArray_3026[i_3026].setBackground(Color.CYAN);
                labelArray_3026[j_3026].setBackground(Color.CYAN);

                if (array_3026[i_3026] <= array_3026[j_3026]) {
                    temp_3026[k_3026++] = array_3026[i_3026++];
                } else {
                    temp_3026[k_3026++] = array_3026[j_3026++];
                }
                stepArea_3026.append("Langkah " + stepCount_3026++ + ": Bandingkan dan salin elemen\n");
                return;
            } else if (i_3026 <= mid_3026) {
                temp_3026[k_3026++] = array_3026[i_3026++];
                stepArea_3026.append("Langkah " + stepCount_3026++ + ": Salin sisa kiri\n");
                return;
            } else if (j_3026 <= right_3026) {
                temp_3026[k_3026++] = array_3026[j_3026++];
                stepArea_3026.append("Langkah " + stepCount_3026++ + ": Salin sisa kanan\n");
                return;
            } else {
                copying_3026 = true;
                k_3026 = 0;
                return;
            }
        }

        if (copying_3026 && k_3026 < temp_3026.length) {
            array_3026[left_3026 + k_3026] = temp_3026[k_3026];
            labelArray_3026[left_3026 + k_3026].setText(String.valueOf(temp_3026[k_3026]));
            labelArray_3026[left_3026 + k_3026].setBackground(Color.GREEN);
            k_3026++;
            stepArea_3026.append("Langkah " + stepCount_3026++ + ": Tempelkan ke array utama\n");
            return;
        }

        if (copying_3026 && k_3026 == temp_3026.length) {
            isMerging_3026 = false;
            copying_3026 = false;
        }

        if (mergeQueue_3026.isEmpty() && !isMerging_3026) {
            stepArea_3026.append("Selesai.\n");
            stepButton_3026.setEnabled(false);
            JOptionPane.showMessageDialog(this, "Merge Sort selesai!");
        }
    }

    private void resetHighlights_3026() {
        if (labelArray_3026 == null) return;
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
        mergeQueue_3026.clear();
        isMerging_3026 = false;
        stepCount_3026 = 1;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MergeSortGUI_2511533026 gui = new MergeSortGUI_2511533026();
            gui.setVisible(true);
        });
    }
}