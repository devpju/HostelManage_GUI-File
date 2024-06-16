package controller.dao;

import controller.manager.HostelManager;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.JOptionPane;
import model.Hostel;

public class HostelDAO {

    private static File hostelFile = new File("hostel.dat");

    public static void writeHostel(Hostel hostel) {
        try (FileOutputStream fos = new FileOutputStream(hostelFile); ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(hostel);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Lưu hostel vào file " + hostelFile + " thất bại!\nLỗi: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static Hostel readHostel() {
        Hostel hostel = null;
        try (FileInputStream fis = new FileInputStream(hostelFile); ObjectInputStream ois = new ObjectInputStream(fis)) {
            hostel = (Hostel) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Đọc hostel từ file " + hostelFile + " thất bại!\nLỗi: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return hostel;
    }

    public static void updateHostel() {
        writeHostel(HostelManager.getInstance().getHostel());
    }
}
