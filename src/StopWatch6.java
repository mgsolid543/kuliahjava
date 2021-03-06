
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author irpan
 */
public class StopWatch6 extends JFrame implements ActionListener {

    JLabel lbCounter = new JLabel();
    Timer timer = new Timer(1000, this);
    JButton bStart = new JButton("Start");
    JButton bEnd = new JButton("End");
    JButton bSetTime = new JButton("Set Time");

    int detik = 0;
    int menit = 0;
    boolean onOff = false; //petunjuk aktif/tidak nya stopwatch
    int setTime;//batas waktu dalam satuan menit

    public void actionPerformed(ActionEvent e) {
        if (onOff == true) {
            if (e.getSource() == timer) {

                if (detik < 59) {
                    detik++;
                } else {
                    detik = 0;
                    menit++;
                }
                lbCounter.setText(change2Digit(menit) + ":" + change2Digit(detik));
            }

            if (menit != 0 && menit == setTime) {
                JOptionPane.showMessageDialog(this, "TIME IS UP...");
                onOff = false;
            }
        }

        if (e.getSource() == bStart) {
            onOff = true;
            detik = 0;
            menit = 0;
            lbCounter.setText("00:00");
        }

        if (e.getSource() == bEnd) {
            onOff = false;
            detik = 0;
            menit = 0;
        }

        if (e.getSource() == bSetTime) {
            String set = JOptionPane.showInputDialog("Set berapa menit");
            if (!set.isEmpty()) {
                setTime = Integer.parseInt(set);
                detik = 0;
                menit = 0;
                onOff = true;
                lbCounter.setText("00:00");
            }
        }
    }

    public StopWatch6() {
        this.setLayout(null);
        this.setSize(310, 250);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        lbCounter.setText("00:00");
        lbCounter.setBounds(10, 40, 270, 80);
        lbCounter.setFont(new Font("Arial", 0, 100));
        lbCounter.setHorizontalAlignment(JLabel.CENTER);
        this.add(lbCounter);

        timer.start();

        bStart.setBounds(10, 140, 80, 20);
        this.add(bStart);
        bStart.addActionListener(this);

        bEnd.setBounds(100, 140, 80, 20);
        this.add(bEnd);
        bEnd.addActionListener(this);

        bSetTime.setBounds(190, 140, 90, 20);
        this.add(bSetTime);
        bSetTime.addActionListener(this);
    }

    public String change2Digit(int c) {
        String digit;
        if (c < 10) {
            digit = "0" + c;
        } else {
            digit = "" + c;
        }

        return digit;
    }

    public static void main(String[] args) {
        new StopWatch6();
    }
}
