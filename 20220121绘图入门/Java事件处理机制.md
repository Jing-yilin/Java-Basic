# Java实践处理机制

Java事件处理机制采用“委派事件模型”。

```java
public class BallMove extends JFrame{
    MyPanel mp = null;
    public static void main(String[] args) {
        new BallMove();
    }

    public BallMove(){
        mp = new MyPanel();
        this.add(mp);
        this.setSize(400, 300);
        this.addKeyListener(mp);//增加事件的监听 addKeyListener(KeyListener l)
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}

//实现KeyListener,是个监听器
class MyPanel extends JPanel implements KeyListener {

    private int x = 10;
    private int y = 10;
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillOval(x, y, 20, 20);//默认黑色
    }

    //有字符输出时，该方法就会触发
    @Override
    public void keyTyped(KeyEvent e) {

    }

    //某个键按下去，该方法会被触发
    @Override
    public void keyPressed(KeyEvent e) {
//        System.out.println((char)e.getKeyCode() + "被按下了!");

        //根据用户按下的不同键来处理小球的移动
        //每一个键都有一个值
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {// public static final int VK_DOWN           = 0x28;
            y++;
        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
            y--;
        }else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            x++;
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            x--;
        }

        //让面板重绘
        this.repaint();
    }

    //某个键松开了，该方法会触发
    @Override
    public void keyReleased(KeyEvent e) {
//        System.out.println((char)e.getKeyCode() + "被松开了!");
    }
}
```

Java将所有组件可能发生的事件进行分类，具有共同特征的事件被抽象为一个事件类AWTEvent，其中包括[ActionEvent](https://so.csdn.net/so/search?q=ActionEvent&spm=1001.2101.3001.7020)类(动作事件)、MouseEvent类(鼠标事件)、KeyEvent类(键盘事件)等。表10.17列出了常用Java事件类、处理该事件的接口及接口中的方法。

常用Java事件类、处理该事件的接口及接口中的方法

| 事件类/接口名称                                 | 接口方法及说明                                               |
| ----------------------------------------------- | ------------------------------------------------------------ |
| ActionEvent动作事件类ActionListener接口         | actionPerformed(ActionEvent e)单击按钮、选择菜单项或在文本框中按回车时 |
| AdjustmentEvent调整事件类AdjustmentListener接口 | adjustmentValueChanged(AdjustmentEvent e)当改变滚动条滑块位置时 |
| ComponentEvent组件事件类ComponentListener接口   | componentMoved(ComponentEvent e)组件移动时componentHidden(ComponentEvent e)组件隐藏时componentResized(ComponentEvent e)组件缩放时componentShown(ComponentEvent e)组件显示时 |
| ContainerEvent容器事件类ContainerListener接口   | componentAdded(ContainerEvent e)添加组件时componentRemoved(ContainerEvent e) 移除组件时 |
| FocusEvent焦点事件类FocusListener接口           | focusGained(FocusEvent e)组件获得焦点时focusLost(FocusEvent e)组件失去焦点时 |
| ItemEvent选择事件类ItemListener接口             | itemStateChanged(ItemEvent e)选择复选框、选项框、单击列表框、选中带复选框菜单时 |
| KeyEvent键盘事件类KeyListener接口               | keyPressed(KeyEvent e)键按下时keyReleased(KeyEvent e) 键释放时keyTyped(KeyEvent e)击键时 |
| MouseEvent鼠标事件类MouseListener接口           | mouseClicked(MouseEvent e) 单击鼠标时mouseEntered(MouseEvent e)鼠标进入时mouseExited(MouseEvent e)鼠标离开时mousePressed(MouseEvent e)鼠标键按下时mouseReleased(MouseEvent e) 鼠标键释放时 |
| MouseEvent鼠标移动事件类MouseMotionListener接口 | mouseDragged(MouseEvent e)鼠标拖放时mouseMoved(MouseEvent e)鼠标移动时 |
| TextEvent文本事件类TextListener接口             | textValueChanged(TextEvent e)文本框、多行文本框内容修改时    |
| WindowEvent窗口事件类WindowListener接口         | windowOpened(WindowEvent e)窗口打开后windowClosed(WindowEvent e)窗口关闭后windowClosing(WindowEvent e)窗口关闭时windowActivated(WindowEvent e)窗口激活时windowDeactivated(WindowEvent e) 窗口失去焦点时windowIconified(WindowEvent e)窗口最小化时windowDeiconified(WindowEvent e) 最小化窗口还原时 |

每个事件类都提供下面常用的方法：

① public int getID()，返回事件的类型；

② public Object getSource()，返回事件源的引用。

当多个事件源触发的事件由一个共同的监听器处理时，我们可以通过getSource方法判断当前的事件源是哪一个组件。

