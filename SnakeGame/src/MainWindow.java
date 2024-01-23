import javax.swing.*;

public class MainWindow extends JFrame {
    public MainWindow(){
        setTitle("SnakeGame");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(345,345);
        setLocation(400,400);
        add(new GameField());
        setVisible(true);
    }


}
