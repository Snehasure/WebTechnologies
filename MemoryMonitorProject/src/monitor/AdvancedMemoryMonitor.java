package monitor;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.time.Second;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;

import javax.swing.*;
import javax.swing.SwingUtilities;  // ✅ Add this line

import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;
import java.util.Timer;
import java.util.TimerTask;


public class AdvancedMemoryMonitor extends JFrame {
    private JProgressBar memoryBar;
    private JLabel memoryLabel;
    private TimeSeries memorySeries;
    private Timer timer;
    private static final int THRESHOLD = 80; // Alert at 80% usage

    public AdvancedMemoryMonitor() {
        setTitle("Advanced Memory Monitor");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        memoryLabel = new JLabel("Memory Usage: ", SwingConstants.CENTER);
        memoryBar = new JProgressBar(0, 100);
        memoryBar.setStringPainted(true);

        add(memoryLabel, BorderLayout.NORTH);
        add(memoryBar, BorderLayout.CENTER);

        // Initialize memory usage trend chart
        memorySeries = new TimeSeries("Memory Usage");
        TimeSeriesCollection dataset = new TimeSeriesCollection(memorySeries);
        JFreeChart chart = ChartFactory.createTimeSeriesChart(
                "Memory Usage Trend", "Time", "Usage (%)",
                dataset, true, true, false);
        ChartPanel chartPanel = new ChartPanel(chart);
        add(chartPanel, BorderLayout.SOUTH);

        startMonitoring();

        setVisible(true);
    }

    private void startMonitoring() {
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                updateMemoryUsage();
            }
        }, 0, 2000); // Updates every 2 seconds
    }

    private void updateMemoryUsage() {
        MemoryMXBean memoryBean = ManagementFactory.getMemoryMXBean();
        MemoryUsage heapMemoryUsage = memoryBean.getHeapMemoryUsage();
        long usedMemory = heapMemoryUsage.getUsed();
        long maxMemory = heapMemoryUsage.getMax();
        int usagePercentage = (int) ((usedMemory * 100) / maxMemory);

        SwingUtilities.invokeLater(() -> {
            memoryBar.setValue(usagePercentage);
            memoryLabel.setText("Memory Usage: " + usagePercentage + "%");

            memorySeries.addOrUpdate(new Second(), usagePercentage);
            logMemoryUsage(usagePercentage);

            if (usagePercentage > THRESHOLD) {
                JOptionPane.showMessageDialog(this, "Warning: High Memory Usage!", "Alert", JOptionPane.WARNING_MESSAGE);
            }
        });
    }

    private void logMemoryUsage(int usage) {
        try (FileWriter writer = new FileWriter("memory_log.txt", true)) {
            writer.write("Memory Usage: " + usage + "% at " + new java.util.Date() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(AdvancedMemoryMonitor::new);
    }
}
