package sample;

import javafx.application.Platform;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class MainEvent {
    //  新建功能
    public void newWindow(MenuItem menuItem) {
        menuItem.setOnAction(event -> {
            Main main = new Main();
            Stage stage = new Stage();
            try {
                main.start(stage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    //  打开功能
    public void open(MenuItem menuItem, Stage stage, TextArea textArea) {
        menuItem.setOnAction(event -> { // 设置按钮的单击事件
            FileChooser chooser = new FileChooser(); // 创建一个文件对话框
            chooser.setTitle("打开文件"); // 设置文件对话框的标题
            chooser.setInitialDirectory(new File("D:\\")); // 设置文件对话框的初始目录
            // 给文件对话框添加多个文件类型的过滤器
            chooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("所有文件", "*.*"));
            File file = chooser.showOpenDialog(stage); // 显示文件保存对话框
            FileInputStream fileInputStream;
            try {
                fileInputStream = new FileInputStream(file.getAbsolutePath());
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream, StandardCharsets.UTF_8));
                StringBuilder s = new StringBuilder();
                int i;
                while (true) {
                    i = bufferedReader.read();
                    if (i == -1)
                        break;
                    s.append((char) i);
                }
                textArea.setText(s.toString());
                System.out.println(s);
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    //  保存功能
    public void save(MenuItem menuItem, Stage stage, TextArea textArea) {
        menuItem.setOnAction(event -> { // 设置按钮的单击事件
            FileChooser chooser = new FileChooser(); // 创建一个文件对话框
            chooser.setTitle("保存文件"); // 设置文件对话框的标题
            chooser.setInitialDirectory(new File("D:\\")); // 设置文件对话框的初始目录
            // 创建一个文件类型过滤器
            FileChooser.ExtensionFilter filter = new FileChooser.ExtensionFilter("文本文件(*.txt)", "*.txt");
            // 给文件对话框添加文件类型过滤器
            chooser.getExtensionFilters().add(filter);
            File file = chooser.showSaveDialog(stage); // 显示文件保存对话框
            FileOutputStream fileOutputStream;
            try {
                fileOutputStream = new FileOutputStream(file.getAbsolutePath(), false);
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream, StandardCharsets.UTF_8));
                bufferedWriter.write(textArea.getText(), 0, textArea.getText().length());
                System.out.println(textArea.getText());
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    //    退出功能
    public void exit(MenuItem menuItem) {
        menuItem.setOnAction(event -> Platform.exit());
    }
}
