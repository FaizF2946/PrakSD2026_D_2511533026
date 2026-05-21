package Pekan7_2511533026;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class SortingMahasiswaGUI_2511533026 extends JFrame {
    
    private ArrayList<Mahasiswa_2511533026> daftarMahasiswa_3026 = new ArrayList<>();
    private DefaultTableModel tableModel_3026;
    private JTextArea txtProses_3026;
    private JComboBox<String> comboAlgoritma_3026;

    public SortingMahasiswaGUI_2511533026() {
        setTitle("Pengurutan Mahasiswa - NIM 2511533026");
        setSize(950, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // Panel Input
        JPanel panelInput_3026 = new JPanel(new GridLayout(4, 2, 5, 5));
        panelInput_3026.setBorder(BorderFactory.createTitledBorder("Input Data Mahasiswa"));

        JTextField txtNama_3026 = new JTextField(20);
        JTextField txtNIM_3026 = new JTextField(20);
        JTextField txtProdi_3026 = new JTextField(20);

        panelInput_3026.add(new JLabel("Nama Mahasiswa:"));
        panelInput_3026.add(txtNama_3026);
        panelInput_3026.add(new JLabel("NIM:"));
        panelInput_3026.add(txtNIM_3026);
        panelInput_3026.add(new JLabel("Program Studi:"));
        panelInput_3026.add(txtProdi_3026);

        JButton btnTambah_3026 = new JButton("Tambah Data");
        JButton btnHapus_3026 = new JButton("Hapus Data Terpilih");
        JButton btnSorting_3026 = new JButton("Mulai Sorting");
        JButton btnClear_3026 = new JButton("Clear Semua");

        panelInput_3026.add(btnTambah_3026);
        panelInput_3026.add(btnHapus_3026);

        // ComboBox Algoritma
        comboAlgoritma_3026 = new JComboBox<>(new String[]{"Insertion Sort", "Selection Sort", "Bubble Sort"});
        JPanel panelSort_3026 = new JPanel();
        panelSort_3026.add(new JLabel("Pilih Algoritma: "));
        panelSort_3026.add(comboAlgoritma_3026);
        panelSort_3026.add(btnSorting_3026);
        panelSort_3026.add(btnClear_3026);

        // Tabel Data
        String[] kolom_3026 = {"No", "Nama", "NIM", "Program Studi"};
        tableModel_3026 = new DefaultTableModel(kolom_3026, 0);
        JTable table_3026 = new JTable(tableModel_3026);
        JScrollPane scrollTable_3026 = new JScrollPane(table_3026);

        // Area Proses Sorting
        txtProses_3026 = new JTextArea();
        txtProses_3026.setEditable(false);
        txtProses_3026.setFont(new Font("Monospaced", Font.PLAIN, 13));
        JScrollPane scrollProses_3026 = new JScrollPane(txtProses_3026);
        scrollProses_3026.setBorder(BorderFactory.createTitledBorder("Visualisasi Proses Sorting"));

        // Layout
        add(panelInput_3026, BorderLayout.NORTH);
        add(scrollTable_3026, BorderLayout.CENTER);
        add(scrollProses_3026, BorderLayout.SOUTH);
        add(panelSort_3026, BorderLayout.WEST);

        // Action Listeners
        btnTambah_3026.addActionListener(e -> {
            if (!txtNama_3026.getText().trim().isEmpty()) {
                daftarMahasiswa_3026.add(new Mahasiswa_2511533026(
                    txtNama_3026.getText().trim(), 
                    txtNIM_3026.getText().trim(), 
                    txtProdi_3026.getText().trim()));
                refreshTable_3026();
                txtNama_3026.setText("");
                txtNIM_3026.setText("");
                txtProdi_3026.setText("");
            }
        });

        btnHapus_3026.addActionListener(e -> {
            int row = table_3026.getSelectedRow();
            if (row >= 0) {
                daftarMahasiswa_3026.remove(row);
                refreshTable_3026();
            }
        });

        btnSorting_3026.addActionListener(e -> mulaiSorting_3026());

        btnClear_3026.addActionListener(e -> {
            daftarMahasiswa_3026.clear();
            refreshTable_3026();
            txtProses_3026.setText("");
        });
    }

    private void refreshTable_3026() {
        tableModel_3026.setRowCount(0);
        for (int i = 0; i < daftarMahasiswa_3026.size(); i++) {
            Mahasiswa_2511533026 m = daftarMahasiswa_3026.get(i);
            tableModel_3026.addRow(new Object[]{i+1, m.getNama_3026(), m.getNim_3026(), m.getProdi_3026()});
        }
    }

    private void mulaiSorting_3026() {
        if (daftarMahasiswa_3026.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Data masih kosong!");
            return;
        }

        String algoritma = (String) comboAlgoritma_3026.getSelectedItem();
        txtProses_3026.setText("=== " + algoritma.toUpperCase() + " ===\n\n");

        ArrayList<Mahasiswa_2511533026> data_3026 = new ArrayList<>(daftarMahasiswa_3026);

        try {
            switch (algoritma) {
                case "Insertion Sort":
                    insertionSort_3026(data_3026);
                    break;
                case "Selection Sort":
                    selectionSort_3026(data_3026);
                    break;
                case "Bubble Sort":
                    bubbleSort_3026(data_3026);
                    break;
            }

            txtProses_3026.append("\n=== HASIL AKHIR SORTING ===\n");
            for (Mahasiswa_2511533026 m : data_3026) {
                txtProses_3026.append(m.toString() + "\n");
            }

            daftarMahasiswa_3026 = data_3026;
            refreshTable_3026();

        } catch (Exception ex) {
            txtProses_3026.append("Error: " + ex.getMessage());
        }
    }

    // ================== INSERTION SORT ==================
    private void insertionSort_3026(ArrayList<Mahasiswa_2511533026> list) throws InterruptedException {
        for (int i = 1; i < list.size(); i++) {
            Mahasiswa_2511533026 key = list.get(i);
            int j = i - 1;

            while (j >= 0 && list.get(j).getNama_3026().compareToIgnoreCase(key.getNama_3026()) > 0) {
                list.set(j + 1, list.get(j));
                j--;
            }
            list.set(j + 1, key);

            txtProses_3026.append("Langkah " + i + " : ");
            printList_3026(list);
            Thread.sleep(800);
        }
    }

    // ================== SELECTION SORT ==================
    private void selectionSort_3026(ArrayList<Mahasiswa_2511533026> list) throws InterruptedException {
        for (int i = 0; i < list.size() - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(j).getNama_3026().compareToIgnoreCase(list.get(minIdx).getNama_3026()) < 0) {
                    minIdx = j;
                }
            }
            Mahasiswa_2511533026 temp = list.get(i);
            list.set(i, list.get(minIdx));
            list.set(minIdx, temp);

            txtProses_3026.append("Pass " + (i + 1) + " : ");
            printList_3026(list);
            Thread.sleep(1000);
        }
    }

    // ================== BUBBLE SORT ==================
    private void bubbleSort_3026(ArrayList<Mahasiswa_2511533026> list) throws InterruptedException {
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = 0; j < list.size() - i - 1; j++) {
                if (list.get(j).getNama_3026().compareToIgnoreCase(list.get(j + 1).getNama_3026()) > 0) {
                    Mahasiswa_2511533026 temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                }
            }
            txtProses_3026.append("Pass " + (i + 1) + " : ");
            printList_3026(list);
            Thread.sleep(900);
        }
    }

    private void printList_3026(ArrayList<Mahasiswa_2511533026> list) {
        txtProses_3026.append("[");
        for (int i = 0; i < list.size(); i++) {
            txtProses_3026.append(list.get(i).getNama_3026());
            if (i < list.size() - 1) txtProses_3026.append(", ");
        }
        txtProses_3026.append("]\n");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new SortingMahasiswaGUI_2511533026().setVisible(true);
        });
    }
}