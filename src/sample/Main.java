package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.control.MenuBar;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;

public class Main extends Application {

    TextArea textArea = new TextArea();

    @Override
    public void start(Stage primaryStage) {
        BorderPane rootBP = new BorderPane();
//        设置文本区域
        textArea.setWrapText(true);
//        设置菜单工具栏
        MenuBar menuBar = new MenuBar();
//        文件
        Menu menu_file = new Menu("文件(F)");
        MenuItem menuItem_new = new MenuItem("新建");
        MenuItem menuItem_open = new MenuItem("打开");
        MenuItem menuItem_save = new MenuItem("保存");
        MenuItem menuItem_saveAs = new MenuItem("另存为");
        MenuItem menuItem_exit = new MenuItem("退出");
//        编辑
        Menu menu_edit = new Menu("编辑(E)");
        MenuItem menuItem_rado = new MenuItem("撤销");
        MenuItem menuItem_shear = new MenuItem("剪切");
        MenuItem menuItem_copy = new MenuItem("复制");
        MenuItem menuItem_paste = new MenuItem("粘贴");
        MenuItem menuItem_delete = new MenuItem("删除");
        MenuItem menuItem_bing = new MenuItem("使用Bing搜索");
        MenuItem menuItem_search = new MenuItem("查找");
        MenuItem menuItem_searchNext = new MenuItem("查找下一个");
        MenuItem menuItem_searchPrevious = new MenuItem("查找上一个");
        MenuItem menuItem_replace = new MenuItem("替换");
        MenuItem menuItem_complete = new MenuItem("全选");
        MenuItem menuItem_time = new MenuItem("时间/日期");
//        格式
        Menu menu_format = new Menu("格式(O)");
        MenuItem menuItem_changeLine = new MenuItem("自动换行");
        MenuItem menuItem_font = new MenuItem("字体");
//        格式
        Menu menu_view = new Menu("查看(V)");
        MenuItem menuItem_zoom = new MenuItem("缩放");
        MenuItem menuItem_statusBar = new MenuItem("状态栏");
//        帮助
        Menu menu_help = new Menu("帮助(H)");
        MenuItem menuItem_viewHelp = new MenuItem("查看帮助");
        MenuItem menuItem_sendFeedback = new MenuItem("发送反馈");
        MenuItem menuItem_about = new MenuItem("关于记事本");
//        设置菜单选项事件及快捷键
        MainEvent mainEvent = new MainEvent();
        mainEvent.newWindow(menuItem_new);
        mainEvent.open(menuItem_open, primaryStage, textArea);
        mainEvent.save(menuItem_save, primaryStage, textArea);
        mainEvent.exit(menuItem_exit);
        menuItem_new.setAccelerator(KeyCombination.keyCombination("Ctrl + N"));
        menuItem_open.setAccelerator(KeyCombination.keyCombination("Ctrl + O"));
        menuItem_save.setAccelerator(KeyCombination.keyCombination("Ctrl + S"));
        menuItem_exit.setAccelerator(KeyCombination.keyCombination("Ctrl + X"));// 设置快捷键
        menu_file.getItems().addAll(menuItem_new, menuItem_open, menuItem_save, menuItem_saveAs, menuItem_exit);
        menu_edit.getItems().addAll(menuItem_rado, menuItem_shear, menuItem_copy, menuItem_paste, menuItem_delete, menuItem_bing, menuItem_search, menuItem_searchNext, menuItem_searchPrevious, menuItem_replace, menuItem_complete, menuItem_time);
        menu_format.getItems().addAll(menuItem_changeLine, menuItem_font);
        menu_view.getItems().addAll(menuItem_zoom, menuItem_statusBar);
        menu_help.getItems().addAll(menuItem_viewHelp, menuItem_sendFeedback, menuItem_about);
        menuBar.getMenus().addAll(menu_file, menu_edit, menu_format, menu_view, menu_help);
        rootBP.setCenter(textArea);
        rootBP.setTop(menuBar);
        Scene scene = new Scene(rootBP, 700, 500);
        primaryStage.setTitle("记事本    Author: Chris  QQ: 1986985788");
        primaryStage.getIcons().add(new Image("file:src/res/notebook.png"));
        primaryStage.setScene(scene);
        scene.getStylesheets().add(
                getClass().getResource("Main.css")
                        .toExternalForm());
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
